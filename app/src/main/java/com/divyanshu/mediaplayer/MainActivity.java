package com.divyanshu.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);

        Button play = findViewById(R.id.play);
        Button pause = findViewById(R.id.pause);

        mediaPlayer = MediaPlayer.create(this, R.raw.sample);



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.start(); // no need to call prepare(); create() does that for you
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.v("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity", "onResume");

    }

    @Override
    protected  void onPause(){
        super.onPause();
        Log.v("MainActivity", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", "onStop");

        if(mediaPlayer != null){
            mediaPlayer.release();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "onDestroy");

    }
}
