package com.yuzumin.yagoonoises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TableRow;

public class CharacterSettings extends AppCompatActivity {

    ImageView back_btn;

    TableRow YagooIMG0Row;
    TableRow YagooIMG1Row;
    RadioButton YagooIMG0;
    RadioButton YagooIMG1;

    Integer charavalue;


    SharedPreferences SoundSettings;
    SharedPreferences.Editor SoundSettingsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_settings);
        getSupportActionBar().hide();

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        YagooIMG0 = findViewById(R.id.yagoo0_img);
        YagooIMG0Row = findViewById(R.id.yagoo0_img_row);
        YagooIMG1 = findViewById(R.id.yagoo1_img);
        YagooIMG1Row = findViewById(R.id.yagoo1_img_row);


        YagooIMG0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue = 0;
                SoundSettingsEditor = getSharedPreferences("Chara", MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue", charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(true);
                YagooIMG1.setChecked(false);
            }
        });
        YagooIMG0Row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue = 0;
                SoundSettingsEditor = getSharedPreferences("Chara", MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue", charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(true);
                YagooIMG1.setChecked(false);
            }
        });
        YagooIMG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue = 1;
                SoundSettingsEditor = getSharedPreferences("Chara", MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue", charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(false);
                YagooIMG1.setChecked(true);
            }
        });
        YagooIMG1Row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charavalue = 1;
                SoundSettingsEditor = getSharedPreferences("Chara", MODE_PRIVATE).edit();
                SoundSettingsEditor.putInt("CharaValue", charavalue);
                SoundSettingsEditor.apply();
                YagooIMG0.setChecked(false);
                YagooIMG1.setChecked(true);
            }
        });

        retrievedata();
    }

    private void retrievedata() {
        SoundSettings = getSharedPreferences("Chara", MODE_PRIVATE);
        charavalue = SoundSettings.getInt("CharaValue", 0);

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