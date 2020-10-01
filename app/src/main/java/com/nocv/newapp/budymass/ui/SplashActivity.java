package com.nocv.newapp.budymass.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.nocv.newapp.budymass.R;

public class SplashActivity extends AppCompatActivity {

    RadioButton   male;
    RadioButton   Famale ;
    FloatingActionButton fab ;
    boolean nothing  = false ;
    public static String gander = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




     

























        initView();

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nothing = true ;
                gander = "man";

            }
        });

        Famale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nothing = true ;
                gander = "woman";
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!gander.equals("")){


                        Intent i = new Intent(SplashActivity.this, InfoActivity.class);
                        i.putExtra("gander",gander);
                        startActivity(i);
                        finish();



                }else {
                    Snackbar.make(view,"Chose Gander",Snackbar.LENGTH_LONG).show();
                }

            }
        });


    }

    public void  initView (){
        male =findViewById(R.id.male);
        Famale = findViewById(R.id.famale);
        fab = findViewById(R.id.fab);

    }



}