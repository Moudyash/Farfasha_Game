package com.moudy.farfasha;

import android.widget.ImageView;

public class questions {
    private int question_number,question_image;

    private String question,correct_answer;

    public questions(int question_number,int question_image, String question, String correct_answer ) {
        this.question = question;
        this.correct_answer = correct_answer;
        this.question_image = question_image;
        this.question_number = question_number;

    }

    public int getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(int question_number) {
        this.question_number = question_number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public int getQuestion_image() {
        return question_image;
    }

    public void setQuestion_image(int question_image) {
        this.question_image = question_image;
    }
}
