package com.rawia.whatsup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImgProfile extends AppCompatActivity {
ImageView imageUser,back;
TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_profile);
        imageUser = findViewById(R.id.img);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        name = findViewById(R.id.name);
        Intent intent = getIntent();
        imageUser.setImageResource(intent.getIntExtra("image",0));
       name.setText(intent.getStringExtra("name_user"));
    }
}
