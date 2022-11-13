package com.example.newsio;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailedNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);

        TextView title1;
        TextView contents,desc;
        ImageView image;
        Button btn;
        String title,content,ImageUrl,url,des;


        title1 =(TextView) findViewById(R.id.Title);
        desc = (TextView) findViewById(R.id.descr);
        contents =(TextView) findViewById(R.id.Contents);
        image = (ImageView) findViewById(R.id.image1);
        btn = (Button) findViewById(R.id.ReadFullNews);

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        url = getIntent().getStringExtra("url");
        ImageUrl = getIntent().getStringExtra("urltoimage");
        des = getIntent().getStringExtra("desc");


        title1.setText(title);
        desc.setText(des);
        contents.setText(content);
        Glide.with(getApplicationContext()).load(ImageUrl).into(image);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });





    }
}