package com.moudy.farfasha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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
    char[] ch;
    private MediaPlayer mp1, mp2, mp3, mp4, mp5, mp6, mp7, mp_correct, mp_wrong;
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
        btn_answersting("م", "ؤ", "ر", "س", "ز", "ع", "و", "خ", "ب", "ش", "ط", "ا", "ل", "ق");

        addquestions(1, R.drawable.banana, "ما اسم الفاكهة", "موزق");
    }

    //to add questions
    private void addquestions(int qnumber, int drawablepic, String question, String answer) {
        questions.add(new questions(qnumber, drawablepic, question, answer));
        Iterator itr = questions.iterator();
        //traversing elements of ArrayList object
        while (itr.hasNext()) {
            questions q = (questions) itr.next();
            tv_questions.setText(q.getQuestion());
            photo.setImageResource(q.getQuestion_image());
            answersize = q.getCorrect_answer().length();
            tv_answersize(answersize);
            ch = new char[answersize];

            for (int i = 0; i < answersize; i++) {
                ch[i] = q.getCorrect_answer().charAt(i);

            }

            btn_answersting_onclick(btn_answer1, answersize, answer);
            btn_answersting_onclick(btn_answer2, answersize, answer);
            btn_answersting_onclick(btn_answer3, answersize, answer);
            btn_answersting_onclick(btn_answer4, answersize, answer);
            btn_answersting_onclick(btn_answer5, answersize, answer);
            btn_answersting_onclick(btn_answer6, answersize, answer);
            btn_answersting_onclick(btn_answer7, answersize, answer);
            btn_answersting_onclick(btn_answer8, answersize, answer);
            btn_answersting_onclick(btn_answer9, answersize, answer);
            btn_answersting_onclick(btn_answer10, answersize, answer);
            btn_answersting_onclick(btn_answer11, answersize, answer);
            btn_answersting_onclick(btn_answer12, answersize, answer);
            btn_answersting_onclick(btn_answer13, answersize, answer);
            btn_answersting_onclick(btn_answer14, answersize, answer);
            tvanswer_onclick(tv_answer1);
            tvanswer_onclick(tv_answer2);
            tvanswer_onclick(tv_answer3);
            tvanswer_onclick(tv_answer4);
            tvanswer_onclick(tv_answer5);
            tvanswer_onclick(tv_answer6);

        }


    }

    private void tvanswer_onclick(TextView tv) {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_tv_text= tv.getText().toString();
                tv.setText(" ");

                if (btn_answer1.getText().toString().equals(current_tv_text)){
                    answer_isfull1 = false;
                    btn_answer1.setVisibility(View.VISIBLE);
                }else if (btn_answer2.getText().toString().equals(current_tv_text)){
                    answer_isfull2 = false;
                    btn_answer2.setVisibility(View.VISIBLE);
                }else if (btn_answer3.getText().toString().equals(current_tv_text)){
                    answer_isfull3 = false;
                    btn_answer3.setVisibility(View.VISIBLE);
                }else if (btn_answer4.getText().toString().equals(current_tv_text)){
                    answer_isfull4 = false;

                    btn_answer4.setVisibility(View.VISIBLE);
                }else if (btn_answer5.getText().toString().equals(current_tv_text)){
                    answer_isfull5 = false;

                    btn_answer5.setVisibility(View.VISIBLE);
                }else if (btn_answer6.getText().toString().equals(current_tv_text)){
                    answer_isfull6 = false;

                    btn_answer6.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    // to create views
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
        mp_correct = MediaPlayer.create(this, R.raw.correctanswer);
        mp_wrong = MediaPlayer.create(this, R.raw.wronganswer);
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

    // to set letters to answers text view
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

    //btn answer text view when on click (1-add the letter 2-hide btn 3- add sound when click 4- check if the answer is right
    //you pass 3 value 1:text view keys 2:correct word length  3:correct word
    public void btn_answersting_onclick(TextView btn, int answersize, String answerkey) {
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
                    if (answersize == 3) {
                        String getanswerfromtv;
                        getanswerfromtv = tv_answer1.getText().toString() + tv_answer2.getText().toString()
                                + tv_answer3.getText().toString();
                        if (getanswerfromtv.equals(answerkey)) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_correct.start();

                                }
                            }, 0500);
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_wrong.start();
                                }
                            }, 0500);
                        }

                    }

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == false && answer_isfull5 == false && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull4 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer4.setText(btn.getText().toString());
                    if (answersize == 4) {
                        String getanswerfromtv;
                        getanswerfromtv = tv_answer1.getText().toString() + tv_answer2.getText().toString()
                                + tv_answer3.getText().toString() + tv_answer4.getText().toString();
                        if (getanswerfromtv.equals(answerkey)) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_correct.start();

                                }
                            }, 0500);
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_wrong.start();
                                }
                            }, 0500);
                        }

                    }

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == true && answer_isfull5 == false && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull5 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer5.setText(btn.getText().toString());
                    if (answersize == 5) {
                        String getanswerfromtv;
                        getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                                +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                                tv_answer5.getText().toString();
                        if (getanswerfromtv.equals(answerkey)) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_correct.start();

                                }
                            },0500);
                        }else{
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_wrong.start();
                                }
                            },0500);
                        }

                    }

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == true && answer_isfull5 == true && answer_isfull6 == false && answer_isfull7 == false) {
                    answer_isfull6 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer6.setText(btn.getText().toString());
                    if (answersize == 6) {
                        String getanswerfromtv;
                        getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                                +tv_answer3.getText().toString()+tv_answer4.getText().toString()
                                +tv_answer5.getText().toString()+tv_answer6.getText().toString();
                        if (getanswerfromtv.equals(answerkey)) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_correct.start();

                                }
                            },0500);
                        }else{
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_wrong.start();
                                }
                            },0500);
                        }

                    }

                } else if (answer_isfull1 == true && answer_isfull2 == true && answer_isfull3 == true &&
                        answer_isfull4 == true && answer_isfull5 == true && answer_isfull6 == true && answer_isfull7 == false) {
                    answer_isfull7 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer7.setText(btn.getText().toString());
                    if (answersize == 7) {
                        String getanswerfromtv;
                        getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                                +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                                tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                        if (getanswerfromtv.equals(answerkey)) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_correct.start();

                                }
                            },0500);
                        }else{
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_wrong.start();
                                }
                            },0500);
                        }

                    }
//all to check if tv answer is empty and add answer to tv asnwer1
                }else if (answersize==3&&answer_isfull1 == false && answer_isfull2 == true && answer_isfull3 == true){
                    answer_isfull1 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer1.setText(btn.getText().toString());
                        String getanswerfromtv;
                        getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                                +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                                tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                        if (getanswerfromtv.equals(answerkey)) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_correct.start();

                                }
                            },0500);
                        }else{
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    mp_wrong.start();
                                }
                            },0500);


                    }

                }else if (answersize==3&&answer_isfull1 == false && answer_isfull2 == false && answer_isfull3 == true){
                    answer_isfull1 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer1.setText(btn.getText().toString());
                    String getanswerfromtv;
                    getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                            +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                            tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                    if (getanswerfromtv.equals(answerkey)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_correct.start();

                            }
                        },0500);
                    }else{
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_wrong.start();
                            }
                        },0500);


                    }

                }
                else if (answersize==3&&answer_isfull1 == false && answer_isfull2 == true && answer_isfull3 == false){
                    answer_isfull1 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer1.setText(btn.getText().toString());
                    String getanswerfromtv;
                    getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                            +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                            tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                    if (getanswerfromtv.equals(answerkey)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_correct.start();

                            }
                        },0500);
                    }else{
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_wrong.start();
                            }
                        },0500);


                    }

                }else if (answersize==4&&answer_isfull1 == false && answer_isfull2 == true && answer_isfull3 == true&&answer_isfull4==true){
                    answer_isfull1 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer1.setText(btn.getText().toString());
                    String getanswerfromtv;
                    getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                            +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                            tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                    if (getanswerfromtv.equals(answerkey)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_correct.start();

                            }
                        },0500);
                    }else{
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_wrong.start();
                            }
                        },0500);


                    }

                }else if (answersize==5&&answer_isfull1 == false && answer_isfull2 == true && answer_isfull3 == true&&answer_isfull4==true && answer_isfull5 == true){
                    answer_isfull1 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer1.setText(btn.getText().toString());
                    String getanswerfromtv;
                    getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                            +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                            tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                    if (getanswerfromtv.equals(answerkey)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_correct.start();

                            }
                        },0500);
                    }else{
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_wrong.start();
                            }
                        },0500);


                    }

                }else if (answersize==6&&answer_isfull1 == false && answer_isfull2 == true && answer_isfull3 == true&&answer_isfull4==true&&answer_isfull5==true&&answer_isfull6==true){
                    answer_isfull1 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer1.setText(btn.getText().toString());
                    String getanswerfromtv;
                    getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                            +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                            tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                    if (getanswerfromtv.equals(answerkey)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_correct.start();

                            }
                        },0500);
                    }else{
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_wrong.start();
                            }
                        },0500);


                    }

                }else if (answersize==7&&answer_isfull1 == false && answer_isfull2 == true && answer_isfull3 == true&&answer_isfull4==true&& answer_isfull5 == true && answer_isfull6 == true&&answer_isfull7==true){
                    answer_isfull1 = true;
                    btn.setVisibility(View.INVISIBLE);
                    tv_answer1.setText(btn.getText().toString());
                    String getanswerfromtv;
                    getanswerfromtv=tv_answer1.getText().toString()+tv_answer2.getText().toString()
                            +tv_answer3.getText().toString()+tv_answer4.getText().toString()+
                            tv_answer5.getText().toString()+tv_answer6.getText().toString()+tv_answer7.getText().toString();
                    if (getanswerfromtv.equals(answerkey)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_correct.start();

                            }
                        },0500);
                    }else{
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                mp_wrong.start();
                            }
                        },0500);


                    }

                }


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