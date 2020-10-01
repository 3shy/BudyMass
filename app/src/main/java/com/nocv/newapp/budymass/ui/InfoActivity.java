package com.nocv.newapp.budymass.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nocv.newapp.budymass.R;

public class InfoActivity extends AppCompatActivity implements  View.OnClickListener {
    TextView height,width ;
    Intent intent;
    public static String gander = "";
    ImageView ganderImage ;
    SeekBar seekBarH  , seekBarW;
    private int progress;
    FloatingActionButton fab;
    float heightF, widthF ;


    private synchronized void handleSeekBars(SeekBar seekBar) {
        progress = seekBar.getProgress();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man);

        initView();
        Bundle extra = getIntent().getExtras();
        if (extra !=null){
            gander=extra.getString("gander");
            if (gander.equals("man"))
                ganderImage.setImageResource(R.drawable.man);
            else
                ganderImage.setImageResource(R.drawable.woman);

        }





        seekBarH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                handleSeekBars(seekBar);

                heightF = getConvertedValue(progress) *10 ;
                height.setText(" الطول "+ heightF);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        seekBarW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                handleSeekBars(seekBar);
                widthF = getConvertedValue(progress);

                width.setText( " الوزن "+ widthF);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public void back(View view) {

        startActivity(new Intent(this,SplashActivity.class));
        finish();

    }

    public void initView (){
        ganderImage =  findViewById(R.id.ganderImage);
        seekBarH =  findViewById(R.id.SeekBarH);
        seekBarW =  findViewById(R.id.seekBarW);
        height =  findViewById(R.id.height);
        width =  findViewById(R.id.width);
        fab =  findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    public float getConvertedValue(int intVal){
        float floatVal = (float) 0.0;
        floatVal = .5f * intVal;
        return floatVal;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab :
                Intent i = new Intent(InfoActivity.this,ResultActivity.class);
                i.putExtra("height",heightF);
                i.putExtra("width",widthF);
                i.putExtra("gander",gander);
                startActivity(i);

                break;
        }

    }
}


