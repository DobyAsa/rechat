package com.example.Rechat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment chatFragment =new WeChatFragment();
    private Fragment newsFragment =new NewsFragment();
    private Fragment friendFragment =new FriendFragment();
    private Fragment configFragment =new ConfigFragment();

    private FragmentManager fragmentManager;

    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    private TextView chat_text, news_text, friends_text, config_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

        chat_text = findViewById(R.id.textView1);
        news_text = findViewById(R.id.textView2);
        friends_text = findViewById(R.id.textView3);
        config_text = findViewById(R.id.textView4);

        InitFragment();
        showFragment(0);

    }
    
    
    //fragment的标准化
    private void InitFragment(){
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.id_content, chatFragment);
        transaction.add(R.id.id_content,newsFragment);
        transaction.add(R.id.id_content,friendFragment);
        transaction.add(R.id.id_content,configFragment);
        transaction.commit();
        HideFragment(transaction);
    }
    private void initView(){
        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);
    }

    private void HideFragment(FragmentTransaction transaction){
        transaction.hide(chatFragment);
        transaction.hide(newsFragment);
        transaction.hide(friendFragment);
        transaction.hide(configFragment);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.LinearLayout1:
                changeColor(0);
                showFragment(0);
                break;
            case R.id.LinearLayout2:
                changeColor(1);
                showFragment(1);
                break;
            case R.id.LinearLayout3:
                changeColor(2);
                showFragment(2);
                break;
            case R.id.LinearLayout4:
                changeColor(3);
                showFragment(3);
                break;
            default:
                break;
        }
    }

    private void showFragment(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(chatFragment);
                break;
            case 1:
                transaction.show(newsFragment);
                break;
            case 2:
                transaction.show(friendFragment);
                break;
            case 3:
                transaction.show(configFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void changeColor(int i) {
        chat_text.setTextColor(Color.rgb(255,255,255));
        news_text.setTextColor(Color.rgb(255,255,255));
        friends_text.setTextColor(Color.rgb(255,255,255));
        config_text.setTextColor(Color.rgb(255,255,255));
        switch (i) {
            case 0:
                chat_text.setTextColor(Color.rgb(0, 255, 0));
                break;
            case 1:
                news_text.setTextColor(Color.rgb(0, 255, 0));
                break;
            case 2:
                friends_text.setTextColor(Color.rgb(0, 255, 0));
                break;
            case 3:
                config_text.setTextColor(Color.rgb(0, 255, 0));
                break;
            default:
                break;

        }
    }
}