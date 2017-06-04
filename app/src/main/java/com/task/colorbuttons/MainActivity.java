package com.task.colorbuttons;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int red=0;int blue=0;
    int green=0;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //restore settings
        SharedPreferences settings1=getSharedPreferences("store1",0);
        SharedPreferences settings2=getSharedPreferences("store2",0);
        SharedPreferences settings3=getSharedPreferences("store3",0);
        red=settings1.getInt("redstore",0);
        blue=settings2.getInt("bluestore",0);
        green=settings3.getInt("greenstore",0);
        ChangeBackground();
    }

    protected void onStop(){
        super.onStop();
        SharedPreferences settings1=getSharedPreferences("store1",0);
        SharedPreferences.Editor editor1=settings1.edit();
        editor1.putInt("redstore",red);
        editor1.apply();
        SharedPreferences settings2=getSharedPreferences("store2",0);
        SharedPreferences.Editor editor2=settings2.edit();
        editor2.putInt("bluestore",blue);
        editor2.apply();
        SharedPreferences settings3=getSharedPreferences("store3",0);
        SharedPreferences.Editor editor3=settings3.edit();
        editor3.putInt("greenstore",green);
        editor3.apply();

    }
    public void ChangeBackground() {
        ConstraintLayout bg = (ConstraintLayout)findViewById(R.id.game);

        bg.setBackgroundColor(Color.rgb(red,green,blue));
        TextView textnumber=(TextView)findViewById(R.id.textelement);

            textnumber.setTextColor(Color.WHITE);
        textnumber.setText("Red - "+Integer.toString(red)+" Blue - "+Integer.toString(blue)+" Green - "+Integer.toString(green));
    }

    public void redpress(View view) {
        red += 10;
        if (red > 255)
            red = red % 255;
        ChangeBackground();


    }

    public void greenpress(View view) {
        green = green + 10;
        if (green > 255)
            green = green % 255;

        ChangeBackground();
    }

    public void bluepress(View view) {
        blue = blue + 10;
        if (blue > 255)
            blue = blue % 255;

        ChangeBackground();

    }

    public void resetpress(View view) {
        red = 0;
        green = 0;
        blue = 0;
        ChangeBackground();
    }



    }



