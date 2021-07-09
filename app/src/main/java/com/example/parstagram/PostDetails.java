package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.Date;

public class PostDetails extends AppCompatActivity {

    Post post;
    private TextView tvUsernamePD;
    private ImageView ivImage;
    private TextView tvDescription;
    private TextView tvUsernameDescriptionPD;
    private TextView tvCreatedAt;
    private ImageView profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        post = Parcels.unwrap(getIntent().getParcelableExtra("Post"));

        tvUsernamePD = findViewById(R.id.tvUsernamePD);
        ivImage = findViewById(R.id.ivImagePD);
        tvDescription = findViewById(R.id.tvDescriptionPD);
        tvCreatedAt = findViewById(R.id.tvCreatedAtPD);
        tvUsernameDescriptionPD = findViewById(R.id.tvUsernameDescriptionPD);
        profilePic = findViewById(R.id.profilePic);

        tvUsernamePD.setText("@" + post.getUser().getUsername());
        tvDescription.setText(post.getDescription());
        tvUsernameDescriptionPD.setText(post.getUser().getUsername());
        Date createdAt = post.getCreatedAt();
        String timeAgo = Post.calculateTimeAgo(createdAt);
        tvCreatedAt.setText(timeAgo);



        ParseFile prof = post.getUser().getParseFile("ProfilePic");
        if(prof != null) {
            Glide.with(this).load(prof.getUrl()).into(profilePic);
        }


        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivImage);
        }

    }

}