package com.example.parstagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.Date;

public class PostDetails extends AppCompatActivity {

    Post post;
    private TextView tvUsername;
    private ImageView ivImage;
    private TextView tvDescription;
    private TextView tvCreatedAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        post = Parcels.unwrap(getIntent().getParcelableExtra("Post"));

        tvUsername = findViewById(R.id.tvUsernamePD);
        ivImage = findViewById(R.id.ivImagePD);
        tvDescription = findViewById(R.id.tvDescriptionPD);
        tvCreatedAt = findViewById(R.id.tvCreatedAtPD);

        tvDescription.setText(post.getDescription());
        tvUsername.setText(post.getUser().getUsername());
        Date createdAt = post.getCreatedAt();
        String timeAgo = Post.calculateTimeAgo(createdAt);
        tvCreatedAt.setText(timeAgo);

        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivImage);
        }

    }

}