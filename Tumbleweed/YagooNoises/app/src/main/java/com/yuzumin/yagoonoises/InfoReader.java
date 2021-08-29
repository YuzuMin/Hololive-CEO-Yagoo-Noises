package com.yuzumin.yagoonoises;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoReader extends AppCompatActivity {

    int value;
    ImageView back_btn;
    TextView title;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader);
        getSupportActionBar().hide();

        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        value = extras.getInt("Value");

        title=findViewById(R.id.reader_title);
        text=findViewById(R.id.reader_text);
        displaystuff();
    }

    private void displaystuff(){

        switch(value){
            case 0:
                title.setText("Instruction Manual");
                text.setText("1. HOW TO USE APP\n"+
                        "Simply follow the on screen instructions and click on the character.\n" +
                        "\n" +
                        "2. AUTOCLICK\n" +
                        "Tap the the words \"Press Yagoo\" and the text will become \"Sit Back & Chill\". This will allow the app to autoplay random noises continously\n" +
                        "\n" +
                        "3. Download Audio\n" +
                        "Go to the App Menu and you will see a button that says Downloads, this would bring you to a Google Drive Folder with 3 subfolders, Audio, Image and Video. You can find the audio clips and images used in this app in those folders\n" +
                        "\n" +
                        "4. DEVELOPER MODE\n" +
                        "To unlock Developer mode, Goto Settings tap Version at least 7 times, developer mode merely unlocks unstable features that are currently in development\n" +
                        "\n" +
                        "\n");
                break;
            case 1:
                title.setText("License");
                text.setText("MIT License\n" +
                        "\n" +
                        "Copyright (c) 2021 YuzuMin\n" +
                        "\n" +
                        "Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:\n" +
                        "\n" +
                        "The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.\n" +
                        "\n" +
                        "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.");
                break;
            case 2:
                title.setText("Release Notes" );
                text.setText(
                        "/***NEW FEATURES***/\n" +
                                "•Developer Mode\n" +
                                "•Google Drive Download\n" +
                                "•Button Bar\n" +
                                "•Auto Click Mode\n" +
                                "\n" +
                                "\n" +
                                "/***FIXES***/\n" +
                                "•New Randomizer\n" +
                                "•Popup Text Error\n" +
                                "\n" +
                                "\n");
                break;
            default:
                title.setText("Error" );
                text.setText("Oops Something must've went wrong");
        }
    }
}