package com.rawia.whatsup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextChat, mTextCalls, mTextStatus;
    LinearLayout layoutUnderChat, layoutUnderCalls;
    ImageView mCamera;
    private int ACTION_PICK = 1;
    private int CAPTURE_REQ_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        initView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contain_frag, new ChatFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    private void initView() {
        mTextChat = findViewById(R.id.text_chat);
        mTextChat.setOnClickListener(this);
        mTextStatus = findViewById(R.id.text_status);
        mTextStatus.setOnClickListener(this);
        mTextCalls = findViewById(R.id.text_calls);
        mTextCalls.setOnClickListener(this);
        layoutUnderChat = findViewById(R.id.under_chats);
        layoutUnderCalls = findViewById(R.id.under_calls);
        mCamera = findViewById(R.id.camera);
        mCamera.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_chat:
                mTextCalls.setTextColor(Color.parseColor("#5FA39E"));
                mTextChat.setTextColor(Color.WHITE);
                layoutUnderChat.setBackgroundColor(Color.WHITE);
                layoutUnderCalls.setBackgroundColor(Color.parseColor("#00574B"));
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contain_frag, new ChatFragment()).commit();
                break;
            case R.id.camera:
                Intent intentCamera = new Intent();
                intentCamera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera, CAPTURE_REQ_CODE);
                break;
            case R.id.text_calls:
                mTextChat.setTextColor(Color.parseColor("#5FA39E"));
                mTextCalls.setTextColor(Color.WHITE);
                layoutUnderCalls.setBackgroundColor(Color.WHITE);
                layoutUnderChat.setBackgroundColor(Color.parseColor("#00574B"));
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(R.id.contain_frag, new CallsFragment()).commit();
                break;
        }
    }
}
