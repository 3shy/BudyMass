package com.nocv.newapp.budymass.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.nocv.newapp.budymass.R;
import com.shinelw.library.ColorArcProgressBar;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.bar1) ColorArcProgressBar progressbar;
    @BindView(R.id.ganderImage) ImageView ganderImage;

    public static String gander = "";
    public static float heightF = 0, widthF = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Bundle extra = getIntent().getExtras();
        if (extra !=null){
            gander=extra.getString("gander");
            widthF= (extra.getFloat("width"));
            heightF=  (extra.getFloat("height"));
            if (gander.equals("man"))
                ganderImage.setImageResource(R.drawable.man_h);
            else
                ganderImage.setImageResource(R.drawable.woman_h);

        }

        float a = sum(heightF,widthF) ;

        progressbar.setCurrentValues(a);
        if (a <= 18.5){
            progressbar.setUnit("نحيف");

        }
        if (a  >= 18.5 && a < 24.9){
            progressbar.setUnit("عادي");

        }

        if (a  >= 24.9 && a < 29.9){
            progressbar.setUnit("وزن زائد");

        }
        if (a  >= 29.9 && a < 40){
            progressbar.setUnit("سمنة");

        }
        if (a  > 40){
            progressbar.setUnit("سمنة زائده");

        }


    }

    public float sum (float h , float w ){
        float s = h / 100;

        return  w / (s*s) ;
    }
}