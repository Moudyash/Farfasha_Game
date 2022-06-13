package com.moudy.farfasha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class fruit_game extends AppCompatActivity {
private int score =0;

    ArrayList<ImageView> fruits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_game);
        fruits = new ArrayList<ImageView>();
        fruits.add((ImageView) findViewById(R.id.ivApple));

    }
}