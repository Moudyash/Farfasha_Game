package com.moudy.farfasha;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fruit_game extends AppCompatActivity {
    TextView tv_questions, tv_answer1, tv_answer2, tv_answer3, tv_answer4, tv_answer5, tv_answer6, tv_answer7;
    TextView btn_answer1, btn_answer2, btn_answer3, btn_answer4, btn_answer5, btn_answer6, btn_answer7, btn_answer8, btn_answer9, btn_answer10, btn_answer11, btn_answer12, btn_answer13, btn_answer14;
    ImageView photo;
    List<questions> questions;
    int answersize = 0;
    String correct_answer[]=null;
    private MediaPlayer mp1, mp2, mp3, mp4, mp5, mp6, mp7;
    boolean answer_isfull1, answer_isfull2, answer_isfull3, answer_isfull4, answer_isfull5, answer_isfull6, answer_isfull7;
    int clickedtime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_game);
        tv_questions = findViewById(R.id.tv_question);
        initViews();

        photo = findViewById(R.id.photo);
        questions = new ArrayList<>();
        questions.add(new questions(1, R.drawable.banana, "ما اسم الفاكهة", "adserty"));
        btn_answersting("ق", "ض", "ر", "س", "ز", "ع", "و", "خ", "ب", "ش", "ط", "ا", "ل", "م");
        Iterator itr = questions.iterator();
        //traversing elements of ArrayList object
        while (itr.hasNext()) {
            questions q = (questions) itr.next();
            tv_questions.setText(q.getQuestion());
            photo.setImageResource(q.getQuestion_image());
            answersize = q.getCorrect_answer().length();
            tv_answersize(answersize);
            for (int i =0; i<=q.getCorrect_answer().length();i++){
                correct_answer[i]+=q.getCorrect_answer().indexOf(i);
            }
            btn_answersting_onclick(btn_answer1);
            btn_answersting_onclick(btn_answer2);
            btn_answersting_onclick(btn_answer3);
            btn_answersting_onclick(btn_answer4);
            btn_answersting_onclick(btn_answer5);
            btn_answersting_onclick(btn_answer6);
            btn_answersting_onclick(btn_answer7);
            btn_answersting_onclick(btn_answer8);
            btn_answersting_onclick(btn_answer9);
            btn_answersting_onclick(btn_answer10);
            btn_answersting_onclick(btn_answer11);
            btn_answersting_onclick(btn_answer12);
            btn_answersting_onclick(btn_answer13);
            btn_answersting_onclick(btn_answer14);
        }


    }

    private void initViews() {
        tv_answer1 = findViewById(R.id.tv_answer1);
        tv_answer2 = findViewById(R.id.tv_answer2);
        tv_answer3 = findViewById(R.id.tv_answer3);
        tv_answer4 = findViewById(R.id.tv_answer4);
        tv_answer5 = findViewById(R.id.tv_answer5);
        tv_answer6 = findViewById(R.id.tv_answer6);
        tv_answer7 = findViewById(R.id.tv_answer7);
        //btn
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        btn_answer4 = findViewById(R.id.btn_answer4);
        btn_answer5 = findViewById(R.id.btn_answer5);
        btn_answer6 = findViewById(R.id.btn_answer6);
        btn_answer7 = findViewById(R.id.btn_answer7);
        btn_answer8 = findViewById(R.id.btn_answer8);
        btn_answer9 = findViewById(R.id.btn_answer9);
        btn_answer10 = findViewById(R.id.btn_answer10);
        btn_answer11 = findViewById(R.id.btn_answer11);
        btn_answer12 = findViewById(R.id.btn_answer12);
        btn_answer13 = findViewById(R.id.btn_answer13);
        btn_answer14 = findViewById(R.id.btn_answer14);
        //Audio
        mp1 = MediaPlayer.create(this, R.raw.a1);
        mp2 = MediaPlayer.create(this, R.raw.a2);
        mp3 = MediaPlayer.create(this, R.raw.a3);
        mp4 = MediaPlayer.create(this, R.raw.a4);
        mp5 = MediaPlayer.create(this, R.raw.a5);
        mp6 = MediaPlayer.create(this, R.raw.a6);
        mp7 = MediaPlayer.create(this, R.raw.a7);
        //Boolean
        answer_isfull1 = false;
        answer_isfull2 = false;
        answer_isfull3 = false;
        answer_isfull4 = false;
        answer_isfull5 = false;
        answer_isfull6 = false;
        answer_isfull7 = false;
//array correct answers

    }

    public void btn_answersting(String s1, String s2, String s3, String s4, String s5, String s6,
                                String s7, String s8, String s9, String s10, String s11, String s12,
                                String s13, String s14) {
        btn_answer1.setText(s1);
        btn_answer2.setText(s2);
        btn_answer3.setText(s3);
        btn_answer4.setText(s4);
        btn_answer5.setText(s5);
        btn_answer6.setText(s6);
        btn_answer7.setText(s7);
        btn_answer8.setText(s8);
        btn_answer9.setText(s9);
        btn_answer10.setText(s10);
        btn_answer11.setText(s11);
        btn_answer12.setText(s12);
        btn_answer13.setText(s13);
        btn_answer14.setText(s14);


    }

    public void btn_answersting_onclick(TextView btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer_isfull1 == false && answer_isfull2 == false && answer_isfull3 == false &&
                        answer_isfull4 == false && answer_isfull5 == false && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull1 = true;
                    tv_answer1.setText(btn.getText().toString());
                    btn.setVisibility(View.INVISIBLE);

                } else if (answer_isfull1 == true && answer_isfull2 == false && answer_isfull3 == false &&
                        answer_isfull4 == false && answer_isfull5 == false && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull2 = true;
                    tv_answer2.setText(btn.getText().toString());
                    btn.setVisibility(View.INVISIBLE);


                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == false &&
                        answer_isfull4 == false && answer_isfull5 == false && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull3 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer3.setText(btn.getText().toString());

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == false && answer_isfull5 == false && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull4 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer4.setText(btn.getText().toString());

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == true && answer_isfull5 == false && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull5 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer5.setText(btn.getText().toString());

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == true && answer_isfull5 == true && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull6 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer6.setText(btn.getText().toString());

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == true && answer_isfull5 == true && answer_isfull6 == true && answer_isfull7 == false) {
                    answer_isfull7 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer7.setText(btn.getText().toString());

                }
//                if (tv_answer1.getText()==" "){
//                }else{
//                    tv_answer1.setText(btn.getText().toString());
//
//                }
//                if (tv_answer2.getText()==" "){
//                }else{
//                    tv_answer2.setText(btn.getText().toString());
//
//                }
//                if (tv_answer3.getText()==" "){
//                } if (tv_answer4.getText()==" "){
//                    tv_answer4.setText(btn.getText().toString());
//                }
                switch (clickedtime) {
                    case 0:
                        mp1.start();
                        clickedtime++;


                        break;
                    case 1:
                        mp2.start();
                        clickedtime++;

                        break;
                    case 2:
                        mp3.start();
                        clickedtime++;

                        break;
                    case 3:
                        mp4.start();
                        clickedtime++;

                        break;
                    case 4:
                        mp5.start();
                        clickedtime++;

                        break;
                    case 5:
                        mp6.start();
                        clickedtime++;

                        break;
                    case 6:
                        mp7.start();
                        clickedtime++;

                        break;
                }
            }
        });
    }

    public void tv_answersize(int answersize) {
        switch (answersize) {
            case 6:
                tv_answer7.setVisibility(View.GONE);
                break;
            case 5:
                tv_answer7.setVisibility(View.GONE);
                tv_answer6.setVisibility(View.GONE);
                break;
            case 4:
                tv_answer7.setVisibility(View.GONE);
                tv_answer6.setVisibility(View.GONE);
                tv_answer5.setVisibility(View.GONE);
                break;
            case 3:
                tv_answer7.setVisibility(View.GONE);
                tv_answer6.setVisibility(View.GONE);
                tv_answer5.setVisibility(View.GONE);
                tv_answer4.setVisibility(View.GONE);
                break;
        }
    }
}