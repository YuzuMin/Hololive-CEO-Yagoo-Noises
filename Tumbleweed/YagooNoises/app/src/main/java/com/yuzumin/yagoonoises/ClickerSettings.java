package com.yuzumin.yagoonoises;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

public class ClickerSettings extends AppCompatActivity {

    ImageView back_btn;

    TableRow YagooIMG0Row;
    TableRow YagooIMG1Row;
    RadioButton YagooIMG0;
    RadioButton YagooIMG1;

    Integer charavalue;

    Switch switch0;
    Switch switch1;
    Switch switch2;


    SharedPreferences SoundSettings;
    SharedPreferences.Editor SoundSettingsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker_settings);
        getSupportActionBar().hide();

        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        YagooIMG0 =findViewById(R.id.yagoo0_img);
        YagooIMG0Row =findViewById(R.id.yagoo0_img_row);
        YagooIMG1 =findViewById(R.id.yagoo1_img);
        YagooIMG1Row =findViewById(R.id.yagoo1_img_row);


        YagooIMG0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue=0;
                SoundSettingsEditor =getSharedPreferences("Chara",MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue",charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(true);
                YagooIMG1.setChecked(false);
            }
        });
        YagooIMG0Row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue=0;
                SoundSettingsEditor =getSharedPreferences("Chara",MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue",charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(true);
                YagooIMG1.setChecked(false);
            }
        });
        YagooIMG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue=1;
                SoundSettingsEditor =getSharedPreferences("Chara",MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue",charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(false);
                YagooIMG1.setChecked(true);
            }
        });
        YagooIMG1Row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue=1;
                SoundSettingsEditor =getSharedPreferences("Chara",MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue",charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(false);
                YagooIMG1.setChecked(true);
            }
        });

        retrievedata();

        // for switch 0 to activate
        switch0=findViewById(R.id.switch0);
        SoundSettings =getSharedPreferences("save0",MODE_PRIVATE);
        switch0.setChecked(SoundSettings.getBoolean("value0",false));
        switch0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch0.isChecked()){
                    SoundSettingsEditor =getSharedPreferences("save0",MODE_PRIVATE).edit();
                    SoundSettingsEditor.putBoolean("value0",true);
                    SoundSettingsEditor.apply();
                    switch0.setChecked(true);
                }else{
                    SoundSettingsEditor =getSharedPreferences("save0",MODE_PRIVATE).edit();
                    SoundSettingsEditor.putBoolean("value0",false);
                    SoundSettingsEditor.apply();
                    switch0.setChecked(false);
                }
            }
        });

        // for switch 1 to activate
        switch1=findViewById(R.id.switch1);
        SoundSettings =getSharedPreferences("save1",MODE_PRIVATE);
        switch1.setChecked(SoundSettings.getBoolean("value1",true));
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch1.isChecked()){
                    SoundSettingsEditor =getSharedPreferences("save1",MODE_PRIVATE).edit();
                    SoundSettingsEditor.putBoolean("value1",true);
                    SoundSettingsEditor.apply();
                    switch1.setChecked(true);
                }else{
                    SoundSettingsEditor =getSharedPreferences("save1",MODE_PRIVATE).edit();
                    SoundSettingsEditor.putBoolean("value1",false);
                    SoundSettingsEditor.apply();
                    switch1.setChecked(false);
                }
            }
        });

        // for switch 2 to activate
        switch2=findViewById(R.id.switch2);
        SoundSettings =getSharedPreferences("save2",MODE_PRIVATE);
        switch2.setChecked(SoundSettings.getBoolean("value2",true));
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch2.isChecked()){
                    SoundSettingsEditor =getSharedPreferences("save2",MODE_PRIVATE).edit();
                    SoundSettingsEditor.putBoolean("value2",true);
                    SoundSettingsEditor.apply();
                    switch2.setChecked(true);
                }else{
                    SoundSettingsEditor =getSharedPreferences("save2",MODE_PRIVATE).edit();
                    SoundSettingsEditor.putBoolean("value2",false);
                    SoundSettingsEditor.apply();
                    switch2.setChecked(false);
                }
            }
        });
    }

    private void retrievedata(){
        SoundSettings=getSharedPreferences("Chara",MODE_PRIVATE);
        charavalue=SoundSettings.getInt("CharaValue",0);

        switch (charavalue) {
            case 0:
                YagooIMG0.setChecked(true);
                break;
            default:
                YagooIMG1.setChecked(true);
                break;
        }
    }
}