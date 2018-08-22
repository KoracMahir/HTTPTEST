package com.mop.korac.testappp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) this.findViewById(R.id.textView);

        HttpCall httpCall = new HttpCall();
        httpCall.setMethodtype(HttpCall.GET);
        httpCall.setUrl("https://api.myjson.com/bins/uakzc");
        HashMap<String,String> params = new HashMap<>();
        httpCall.setParams(params);
        new HttpRequest(){
            @Override
            public void onResponse(String response) {
                super.onResponse(response);
                textView.setText("Get:"+response);
            }
        }.execute(httpCall);

        HttpCall httpCallPost = new HttpCall();
        httpCallPost.setMethodtype(HttpCall.POST);
        httpCallPost.setUrl("http://mentorship-api.ministryofprogramming.com/api/auth/login");
        HashMap<String,String> paramsPost = new HashMap<>();
        paramsPost.put("username","dinosmajovic");
        paramsPost.put("password","password");
        Toast.makeText(MainActivity.this, "Welcome to POST", Toast.LENGTH_SHORT).show();
        httpCallPost.setParams(paramsPost);
        new HttpRequest(){
            @Override
            public void onResponse(String response) {
                super.onResponse(response);
                textView.setText(textView.getText()+"\nPost:"+response);
            }
        }.execute(httpCallPost);
    }
}

