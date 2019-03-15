package com.example.lat_bai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private Button play;
    private ImageView image1,image2,image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setControl(){
        result = findViewById(R.id.edtResult);
        play = findViewById(R.id.btnPlay);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
    }

    private void setEvent() {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rd = new Random();
                int dem = 0;
                int r1 = rd.nextInt(52) +1;
                int r2 = rd.nextInt(52) +1;
                int r3 = rd.nextInt(52) +1;
                int score = 0;
                random(image1, r1);
                random(image2, r2);
                random(image3, r3);
                while(r1 > 13) r1 = r1 - 13;
                while(r2 > 13) r2 = r2 - 13;
                while(r3 > 13) r3 = r3 - 13;

                if(r1 < 10)
                    score = score + r1;
                else if(r1 > 10) {
                    dem++;
                    score = score + 10;
                }
                else score = score + 10;

                if(r2 < 10)
                    score = score + r2;
                else if(r2 > 10){
                    dem++;
                    score = score + 10;
                }
                else score = score + 10;

                if(r3 < 10)
                    score = score + r3;
                else if(r3 > 10){
                    dem++;
                    score = score + 10;
                }
                else score = score + 10;

                if(dem == 3)
                    result.setText("Ba Tiên!!!");
                else {
                    while(score > 9) score = score - 10;
                    result.setText(String.valueOf(score));
                }
            }
        });
    }

    private void random(ImageView image, int r){
        switch(r){
            case 1:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic1);
                break;
            case 2:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic2);
                break;
            case 3:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic3);
                break;
            case 4:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic4);
                break;
            case 5:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic5);
                break;
            case 6:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic6);
                break;
            case 7:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic7);
                break;
            case 8:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic8);
                break;
            case 9:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic9);
                break;
            case 10:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic10);
                break;
            case 11:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic11);
                break;
            case 12:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic12);
                break;
            case 13:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic13);
                break;
            case 14:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic14);
                break;
            case 15:
                image.setImageResource(android.R.color.transparent);
                image.setImageResource(R.drawable.ic15);
                break;
            case 16:
                image.setImageResource(R.drawable.ic16);
                break;
            case 17:
                image.setImageResource(R.drawable.ic17);
                break;
            case 18:
                image.setImageResource(R.drawable.ic18);
                break;
            case 19:
                image.setImageResource(R.drawable.ic19);
                break;
            case 20:
                image.setImageResource(R.drawable.ic20);
                break;
            case 21:
                image.setImageResource(R.drawable.ic21);
                break;
            case 22:
                image.setImageResource(R.drawable.ic22);
                break;
            case 23:
                image.setImageResource(R.drawable.ic23);
                break;
            case 24:
                image.setImageResource(R.drawable.ic24);
                break;
            case 25:
                image.setImageResource(R.drawable.ic25);
                break;
            case 26:
                image.setImageResource(R.drawable.ic26);
                break;
            case 27:
                image.setImageResource(R.drawable.ic27);
                break;
            case 28:
                image.setImageResource(R.drawable.ic28);
                break;
            case 29:
                image.setImageResource(R.drawable.ic29);
                break;
            case 30:
                image.setImageResource(R.drawable.ic30);
                break;
            case 31:
                image.setImageResource(R.drawable.ic31);
                break;
            case 32:
                image.setImageResource(R.drawable.ic32);
                break;
            case 33:
                image.setImageResource(R.drawable.ic33);
                break;
            case 34:
                image.setImageResource(R.drawable.ic34);
                break;
            case 35:
                image.setImageResource(R.drawable.ic35);
                break;
            case 36:
                image.setImageResource(R.drawable.ic36);
                break;
            case 37:
                image.setImageResource(R.drawable.ic37);
                break;
            case 38:
                image.setImageResource(R.drawable.ic38);
                break;
            case 39:
                image.setImageResource(R.drawable.ic39);
                break;
            case 40:
                image.setImageResource(R.drawable.ic40);
                break;
            case 41:
                image.setImageResource(R.drawable.ic41);
                break;
            case 42:
                image.setImageResource(R.drawable.ic42);
                break;
            case 43:
                image.setImageResource(R.drawable.ic43);
                break;
            case 44:
                image.setImageResource(R.drawable.ic44);
                break;
            case 45:
                image.setImageResource(R.drawable.ic45);
                break;
            case 46:
                image.setImageResource(R.drawable.ic46);
                break;
            case 47:
                image.setImageResource(R.drawable.ic47);
                break;
            case 48:
                image.setImageResource(R.drawable.ic48);
                break;
            case 49:
                image.setImageResource(R.drawable.ic49);
                break;
            case 50:
                image.setImageResource(R.drawable.ic50);
                break;
            case 51:
                image.setImageResource(R.drawable.ic51);
                break;
            case 52:
                image.setImageResource(R.drawable.ic52);
                break;
        }
    }
}
