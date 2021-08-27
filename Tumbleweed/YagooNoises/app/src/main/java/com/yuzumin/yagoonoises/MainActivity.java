package com.yuzumin.yagoonoises;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Count.CountListener{
    ImageView image;
    TextView textCount;

    ImageView MenuBTN;
    ImageView AlarmBTN;

    MediaPlayer noise;
    MediaPlayer.OnCompletionListener listener;

    ObjectAnimator anim1, anim2, anim3;
    AnimatorSet set1, set2;

    SharedPreferences SavedSettings;

    TextView AppName;
    boolean isFullAuto;

    boolean switch0; //IMPORTANT : For Bottom Bar
    boolean switch1; //IMPORTANT : TO DISABLE TOAST POPUP
    boolean switch2; //TO DISABLE CLICKER

    LinearLayout ButtonBar;

    CardView SoundBTN1;
    CardView SoundBTN2;
    CardView SoundBTN3;
    CardView SoundBTN4;
    CardView SoundBTN5;
    CardView SoundBTN6;
    CardView SoundBTN7;
    CardView SoundBTN8;
    CardView SoundBTN9;
    CardView SoundBTN10;
    CardView SoundBTN11;
    CardView SoundBTN12;
    CardView SoundBTN13;
    CardView SoundBTN14;
    CardView SoundBTN15;
    CardView SoundBTN16;
    CardView SoundBTN17;
    CardView SoundBTN18;
    CardView SoundBTN19;
    CardView SoundBTN20;
    CardView SoundBTN21;
    CardView SoundBTN22;




    List<Integer> listofsounds;
    int charavalue;


    Integer DevCount=1;

    Count count;
    SharedPreferences sp;

    @Override
    public void OnUpdated(int count) {
        sp.edit().putInt("count", count).apply();
        textCount.setText(String.format("Count: %d", count));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // TO OPEN APP MENU
        MenuBTN=findViewById(R.id.menu_btn);
        MenuBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFullAuto){
                    isFullAuto =false;
                    AppName.setText(getString(R.string.press_vtuber));
                }
                Intent intent;
                intent = new Intent(MainActivity.this, AppMenu.class);
                startActivity(intent);
            }
        });
        AlarmBTN=findViewById(R.id.alarm_btn);
        /*
        // TO OPEN ALARM LIST ACTIVITY
        AlarmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DevCount==7){
                    if(isFullAuto){
                        isFullAuto =false;
                        AppName.setText(getString(R.string.press_vtuber));
                    }
                    Intent intent;
                    intent = new Intent(MainActivity.this, AlarmActivity.class);
                    startActivity(intent);
                }
            }
        });
         */

        listener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                cleanupMediaPlayer();
                if(isFullAuto){
                    startRandomSound();
                }
            }
        };
        image = findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRandomSound();
            }
        });

        ButtonBar=findViewById(R.id.buttonBar);
        ButtonBar.setVisibility(View.GONE);

        SoundBTN1=findViewById(R.id.sound1);
        SoundBTN1.setVisibility(View.GONE);
        SoundBTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(3);
            }
        });

        SoundBTN2=findViewById(R.id.sound2);
        SoundBTN2.setVisibility(View.GONE);
        SoundBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(4);
            }
        });

        SoundBTN3=findViewById(R.id.sound3);
        SoundBTN3.setVisibility(View.GONE);
        SoundBTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(5);
            }
        });

        SoundBTN4=findViewById(R.id.sound4);
        SoundBTN4.setVisibility(View.GONE);
        SoundBTN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(6);
            }
        });

        SoundBTN5=findViewById(R.id.sound5);
        SoundBTN5.setVisibility(View.GONE);
        SoundBTN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(7);
            }
        });

        SoundBTN6=findViewById(R.id.sound6);
        SoundBTN6.setVisibility(View.GONE);
        SoundBTN6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(8);
            }
        });

        SoundBTN7=findViewById(R.id.sound7);
        SoundBTN7.setVisibility(View.GONE);
        SoundBTN7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(9);
            }
        });

        SoundBTN8=findViewById(R.id.sound8);
        SoundBTN8.setVisibility(View.GONE);
        SoundBTN8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(10);
            }
        });

        SoundBTN9=findViewById(R.id.sound9);
        SoundBTN9.setVisibility(View.GONE);
        SoundBTN9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(11);
            }
        });

        SoundBTN10=findViewById(R.id.sound10);
        SoundBTN10.setVisibility(View.GONE);
        SoundBTN10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(12);
            }
        });

        SoundBTN11=findViewById(R.id.sound11);
        SoundBTN11.setVisibility(View.GONE);
        SoundBTN11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(13);
            }
        });

        SoundBTN12=findViewById(R.id.sound12);
        SoundBTN12.setVisibility(View.GONE);
        SoundBTN12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(14);
            }
        });

        SoundBTN13=findViewById(R.id.sound13);
        SoundBTN13.setVisibility(View.GONE);
        SoundBTN13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(15);
            }
        });

        SoundBTN14=findViewById(R.id.sound14);
        SoundBTN14.setVisibility(View.GONE);
        SoundBTN14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(16);
            }
        });

        SoundBTN15=findViewById(R.id.sound15);
        SoundBTN15.setVisibility(View.GONE);
        SoundBTN15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(17);
            }
        });

        SoundBTN16=findViewById(R.id.sound16);
        SoundBTN16.setVisibility(View.GONE);
        SoundBTN16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(18);
            }
        });

        SoundBTN17=findViewById(R.id.sound17);
        SoundBTN17.setVisibility(View.GONE);
        SoundBTN17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(19);
            }
        });

        SoundBTN18=findViewById(R.id.sound18);
        SoundBTN18.setVisibility(View.GONE);
        SoundBTN18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(20);
            }
        });

        SoundBTN19=findViewById(R.id.sound19);
        SoundBTN19.setVisibility(View.GONE);
        SoundBTN19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(21);
            }
        });

        SoundBTN20=findViewById(R.id.sound20);
        SoundBTN20.setVisibility(View.GONE);
        SoundBTN20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(22);
            }
        });

        SoundBTN21=findViewById(R.id.sound21);
        SoundBTN21.setVisibility(View.GONE);
        SoundBTN21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(23);
            }
        });

        SoundBTN22=findViewById(R.id.sound22);
        SoundBTN22.setVisibility(View.GONE);
        SoundBTN22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(24);
            }
        });


        isFullAuto=false;
        AppName=findViewById(R.id.FiringState);
        AppName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFullAuto){
                    isFullAuto =false;
                    AppName.setText(getString(R.string.press_vtuber));
                }else{
                    isFullAuto =true;
                    AppName.setText("Sit Back & Chill");
                    startRandomSound();
                }
            }
        });


        textCount = findViewById(R.id.count);

        anim1 = ObjectAnimator.ofFloat(image,"translationY", 0f,-50f, 50f, -50f, 50f, 0);
        anim1.setDuration(600);
        set1 = new AnimatorSet();
        ArrayList<Animator> setArray = new ArrayList<>();

        anim2 = ObjectAnimator.ofFloat(image,"translationY", 0f,-50f, 50f, -50f, 50f, -50f, 50f, -50f, 50f,0);
        anim2.setRepeatCount(ValueAnimator.INFINITE);
        setArray.add(anim2);
        anim2 = ObjectAnimator.ofFloat(image,"translationX", 0f,-70f, 70f, -70f, 70f, 0);
        anim2.setRepeatCount(ValueAnimator.INFINITE);
        setArray.add(anim2);
        set1.playTogether(setArray);
        set1.setDuration(2000);
        anim2 = null;

        set2 = new AnimatorSet();
        setArray = new ArrayList<>();
        anim3 = ObjectAnimator.ofFloat(image, "rotation", 0f, -90f, 0f, 90f, 180f, 270f, 360f);
        anim3.setRepeatCount(ValueAnimator.INFINITE);
        setArray.add(anim3);
        anim3 = ObjectAnimator.ofFloat(image, "scaleX", 1f,0.5f, 1.5f, 0.5f, 1.5f, 1f);
        anim3.setRepeatCount(ValueAnimator.INFINITE);
        setArray.add(anim3);
        anim3 = ObjectAnimator.ofFloat(image, "scaleY", 1f,.5f, 1.5f, 0.5f, 1.5f, 1f);
        anim3.setRepeatCount(ValueAnimator.INFINITE);
        setArray.add(anim3);
        set2.playTogether(setArray);
        set2.setDuration(2000);
        anim3 = null;
        count = new Count();
        count.setListener(this);

        sp = this.getSharedPreferences("count", MODE_PRIVATE);
        count.setCount(sp.getInt("count", 0));
        retrievedata();
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case(R.id.Alarm):
                Intent intent;
                intent = new Intent(MainActivity.this, AlarmActivity.class);
                startActivity(intent);
                break;
            case(R.id.menu_btn):
                Intent settingmenu;
                settingmenu = new Intent(MainActivity.this, AppMenu.class);
                startActivity(settingmenu);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
     */

    private void stopAnimations(){
        if (anim1.isRunning())
            anim1.end();
        if (set1.isRunning())
            set1.end();
        if (set2.isRunning())
            set2.end();
    }

    private void cleanupMediaPlayer(){
        stopAnimations();
        if(noise!=null) {
            if(noise.isPlaying())
                noise.stop();
            noise.release();
            noise = null;
        }
    }

    private void startRandomSound() {

        if(listofsounds.isEmpty()){
            Toast.makeText(this, "NO SOUND SELECTED", Toast.LENGTH_SHORT).show();

        }else{
            int value=(int)(Math.random()*(listofsounds.size()));
            int num = listofsounds.get(value);
            playSound(num);
        }
    }

    private void playSound(int num){
        cleanupMediaPlayer();
        if(switch2){
            count.increment();
            switch (num) {
                case 3:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise1);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise1_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 4:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise2);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise2_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 5:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise3);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise3_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 6:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise4);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise4_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 7:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise5);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise5_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 8:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise6);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise6_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 9:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise7);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise7_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 10:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise8);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise8_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 11:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise9);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise9_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 12:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise10);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise10_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 13:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise11);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise11_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 14:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise12);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise12_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 15:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise13);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise13_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 16:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise14);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise14_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 17:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise15);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise15_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 18:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise16);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise16_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 19:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise17);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise17_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 20:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise18);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise18_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 21:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise19);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise19_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 22:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise20);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise20_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 23:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise21);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise21_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                case 24:
                    noise = MediaPlayer.create(this, R.raw.yagoonoise22);
                    noise.setOnCompletionListener(listener);
                    noise.start();
                    if (switch1) {
                        Toast.makeText(this, getString(R.string.noise22_text), Toast.LENGTH_SHORT).show();
                    }
                    set1.start();
                    break;
                default:
                    Toast.makeText(this, "NO SOUND SELECTED", Toast.LENGTH_SHORT).show();
                    break;
            }
        }else{
            Toast.makeText(MainActivity.this, "NOT ACTIVE", Toast.LENGTH_SHORT).show();
        }
    }


    private void retrievedata(){

        SavedSettings =getSharedPreferences("Chara",MODE_PRIVATE);
        charavalue= SavedSettings.getInt("CharaValue",0);

        switch (charavalue) {
            case 0:
                image.setImageResource(R.drawable.coco0);
                break;
            case 1:
                image.setImageResource(R.drawable.coco1);
                break;
            case 2:
                image.setImageResource(R.drawable.coco2);
                break;
            default:
                image.setImageResource(R.drawable.coco3);
                break;
        }


        SavedSettings =getSharedPreferences("DevMode",MODE_PRIVATE);
        DevCount= SavedSettings.getInt("DevCount",0);
        if(DevCount==7){
            AlarmBTN.setVisibility(View.VISIBLE);
        }else {
            AlarmBTN.setVisibility(View.INVISIBLE);
        }


        listofsounds= new ArrayList<Integer>();


        SavedSettings =getSharedPreferences("save0",MODE_PRIVATE);
        switch0= SavedSettings.getBoolean("value0",false);
        if (SavedSettings.getBoolean("value0",false)) {
            ButtonBar.setVisibility(View.VISIBLE);
        }else{
            ButtonBar.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save1",MODE_PRIVATE);
        switch1= SavedSettings.getBoolean("value1",true);

        SavedSettings =getSharedPreferences("save2",MODE_PRIVATE);
        switch2= SavedSettings.getBoolean("value2",true);




        SavedSettings =getSharedPreferences("save3", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value3",true)) {
            listofsounds.add(3);
            SoundBTN1.setVisibility(View.VISIBLE);
        }else{
            SoundBTN1.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save4", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value4",false)) {
            listofsounds.add(4);
            SoundBTN2.setVisibility(View.VISIBLE);
        }else{
            SoundBTN2.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save5", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value5",false)) {
            listofsounds.add(5);
            SoundBTN3.setVisibility(View.VISIBLE);
        }else{
            SoundBTN3.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save6", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value6",false)) {
            listofsounds.add(6);
            SoundBTN4.setVisibility(View.VISIBLE);
        }else{
            SoundBTN4.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save7", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value7",false)) {
            listofsounds.add(7);
            SoundBTN5.setVisibility(View.VISIBLE);
        }else{
            SoundBTN5.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save8", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value8",false)) {
            listofsounds.add(8);
            SoundBTN6.setVisibility(View.VISIBLE);
        }else{
            SoundBTN6.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save9", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value9",false)) {
            listofsounds.add(9);
            SoundBTN7.setVisibility(View.VISIBLE);
        }else{
            SoundBTN7.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save10", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value10",false)) {
            listofsounds.add(10);
            SoundBTN8.setVisibility(View.VISIBLE);
        }else{
            SoundBTN8.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save11", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value11",false)) {
            listofsounds.add(11);
            SoundBTN9.setVisibility(View.VISIBLE);
        }else{
            SoundBTN9.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save12", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value12",false)) {
            listofsounds.add(12);
            SoundBTN10.setVisibility(View.VISIBLE);
        }else{
            SoundBTN10.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save13", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value13",false)) {
            listofsounds.add(13);
            SoundBTN11.setVisibility(View.VISIBLE);
        }else{
            SoundBTN11.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save14", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value14",false)) {
            listofsounds.add(14);
            SoundBTN12.setVisibility(View.VISIBLE);
        }else{
            SoundBTN12.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save15", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value15",false)) {
            listofsounds.add(15);
            SoundBTN13.setVisibility(View.VISIBLE);
        }else{
            SoundBTN13.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save16", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value16",false)) {
            listofsounds.add(16);
            SoundBTN14.setVisibility(View.VISIBLE);
        }else{
            SoundBTN14.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save17", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value17",false)) {
            listofsounds.add(17);
            SoundBTN15.setVisibility(View.VISIBLE);
        }else{
            SoundBTN15.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save18", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value18",false)) {
            listofsounds.add(18);
            SoundBTN16.setVisibility(View.VISIBLE);
        }else{
            SoundBTN16.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save19", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value19",false)) {
            listofsounds.add(19);
            SoundBTN17.setVisibility(View.VISIBLE);
        }else{
            SoundBTN17.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save20", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value20",false)) {
            listofsounds.add(20);
            SoundBTN18.setVisibility(View.VISIBLE);
        }else{
            SoundBTN18.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save21", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value21",false)) {
            listofsounds.add(21);
            SoundBTN19.setVisibility(View.VISIBLE);
        }else{
            SoundBTN19.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save22", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value22",false)) {
            listofsounds.add(22);
            SoundBTN20.setVisibility(View.VISIBLE);
        }else{
            SoundBTN20.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save23", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value23",false)) {
            listofsounds.add(23);
            SoundBTN21.setVisibility(View.VISIBLE);
        }else{
            SoundBTN21.setVisibility(View.GONE);
        }

        SavedSettings =getSharedPreferences("save24", MODE_PRIVATE);
        if (SavedSettings.getBoolean("value24",false)) {
            listofsounds.add(24);
            SoundBTN22.setVisibility(View.VISIBLE);
        }else{
            SoundBTN22.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        cleanupMediaPlayer();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        cleanupMediaPlayer();
        super.onStop();
    }

    @Override
    protected void onResume() {
        retrievedata();
        if(isFullAuto){
            startRandomSound();
        }
        super.onResume();
    }

}