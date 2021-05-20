package com.akash.cp.vtu.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tylersuehr.socialtextview.SocialTextView;

public class SocialMediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        String example = "Really neat stuff @tylersuehr7! #Android #GitHub";

        // Create an instance of the view and set the text above
        SocialTextView socialTextView=(SocialTextView)findViewById(R.id.social_text);
        socialTextView.setText(example);


    }
}