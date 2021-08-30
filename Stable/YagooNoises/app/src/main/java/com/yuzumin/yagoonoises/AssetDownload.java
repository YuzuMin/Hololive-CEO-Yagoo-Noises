package com.yuzumin.yagoonoises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AssetDownload extends AppCompatActivity {

    ImageView back_btn;

    ImageView yagoo0;
    ImageView yagoo1;
    ImageView sbg;
    ImageView bg0;

    ImageView switch3;
    ImageView switch4;
    ImageView switch5;
    ImageView switch6;
    ImageView switch7;
    ImageView switch8;
    ImageView switch9;
    ImageView switch10;
    ImageView switch11;
    ImageView switch12;
    ImageView switch13;
    ImageView switch14;
    ImageView switch15;
    ImageView switch16;
    ImageView switch17;
    ImageView switch18;
    ImageView switch19;
    ImageView switch20;
    ImageView switch21;
    ImageView switch22;
    ImageView switch23;
    ImageView switch24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);
        getSupportActionBar().hide();

        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        yagoo0 =findViewById(R.id.yagoo0);
        yagoo0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Image/yagoo0.png"));
                startActivity(i);
            }
        });

        yagoo1 =findViewById(R.id.yagoo1);
        yagoo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Image/yagoo1.png"));
                startActivity(i);
            }
        });

        sbg =findViewById(R.id.sbg);
        sbg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Image/sbg.png"));
                startActivity(i);
            }
        });

        bg0 =findViewById(R.id.bg0);
        bg0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Image/bg0.png"));
                startActivity(i);
            }
        });


        switch3 =findViewById(R.id.switch3);
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/はい・・・.mp3"));
                startActivity(i);
            }
        });

        switch4 =findViewById(R.id.switch4);
        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/あのー.mp3"));
                startActivity(i);
            }
        });

        switch5 =findViewById(R.id.switch5);
        switch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/うちの子.mp3"));
                startActivity(i);
            }
        });

        switch6 =findViewById(R.id.switch6);
        switch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/Thank you for watching.mp3"));
                startActivity(i);
            }
        });

        switch7 =findViewById(R.id.switch7);
        switch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/Thank you(ver.1).mp3"));
                startActivity(i);
            }
        });

        switch8 =findViewById(R.id.switch8);
        switch8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/Thank you(ver.2).mp3"));
                startActivity(i);
            }
        });

        switch9 =findViewById(R.id.switch9);
        switch9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/えーっと、そうですね.mp3"));
                startActivity(i);
            }
        });

        switch10 =findViewById(R.id.switch10);
        switch10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/思いながら思ってるんですけれと.mp3"));
                startActivity(i);
            }
        });

        switch11 =findViewById(R.id.switch11);
        switch11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/そうですね、そんなかんじですね.mp3"));
                startActivity(i);
            }
        });

        switch12 =findViewById(R.id.switch12);
        switch12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/Cover株式会社の谷郷といいます.mp3"));
                startActivity(i);
            }
        });

        switch13 =findViewById(R.id.switch13);
        switch13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/よろしくおねがいします.mp3"));
                startActivity(i);
            }
        });

        switch14 =findViewById(R.id.switch14);
        switch14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/I'm Motoaki Tanigo Cover corp.mp3"));
                startActivity(i);
            }
        });

        switch15 =findViewById(R.id.switch15);
        switch15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/Hello Everyone.mp3"));
                startActivity(i);
            }
        });

        switch16 =findViewById(R.id.switch16);
        switch16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/Cover corp is Cutting Edge~.mp3"));
                startActivity(i);
            }
        });

        switch17 =findViewById(R.id.switch17);
        switch17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/look forward.mp3"));
                startActivity(i);
            }
        });

        switch18 =findViewById(R.id.switch18);
        switch18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/〜って思ってます.mp3"));
                startActivity(i);
            }
        });

        switch19 =findViewById(R.id.switch19);
        switch19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/ありえるんじゃないかな.mp3"));
                startActivity(i);
            }
        });

        switch20 =findViewById(R.id.switch20);
        switch20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/47ちゃいです。.mp3"));
                startActivity(i);
            }
        });

        switch21 =findViewById(R.id.switch21);
        switch21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/PC画面の見過ぎが原因だと思います.mp3"));
                startActivity(i);
            }
        });

        switch22 =findViewById(R.id.switch22);
        switch22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/ヘ ル シ ェ イ ク Y A G O O.mp3"));
                startActivity(i);
            }
        });

        switch23 =findViewById(R.id.switch23);
        switch23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/HI HONEY.mp3"));
                startActivity(i);
            }
        });

        switch24 =findViewById(R.id.switch24);
        switch24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/YuzuMin/Hololive-CEO-Yagoo-Noises/raw/main/Assets/Audio/mother fucker.mp3"));
                startActivity(i);
            }
        });
    }
}