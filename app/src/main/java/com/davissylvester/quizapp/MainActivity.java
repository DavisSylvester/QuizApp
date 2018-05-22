package com.davissylvester.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean q1Answer = false;
    private String q2Answer = "";
    private String q4Answer = "";

    private boolean isQ1Correct = false;
    private boolean isQ2Correct = false;
    private boolean isQ3Correct = false;
    private boolean isQ4Correct = false;

    private boolean hasError = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveQuiz(View view) {

        getResponseFromQuestionOne();
        getResponseFromQuestionTwo();
        getResponseFromQuestionThree();
        getResponseFromQuestionFour();

        validateForm();
    }

    private void getResponseFromQuestionOne() {

        if (q1Answer == false) {

        }
    }

    private void getResponseFromQuestionTwo() {

        TextView txtQ2Health = findViewById(R.id.txtQ2Health);

        q2Answer = txtQ2Health.getText().toString();

        if (q2Answer == "") {
        }

        if (q2Answer.equals("12")) {
            isQ2Correct = true;
        }
    }

    private void getResponseFromQuestionThree() {

        // ArrayList<Integer> days = new ArrayList<>();
        CheckBox cbMonday = findViewById(R.id.cbMonday);
        CheckBox cbWed = findViewById(R.id.cbWed);
        CheckBox cbSaturday = findViewById(R.id.cbSaturday);

        if (cbMonday.isChecked() && cbSaturday.isChecked() && !cbWed.isChecked()) {
            isQ3Correct = true;
        }


//        days.add(-1);
//        days.add(-1);
//        days.add(-1);
//
//
//
//        if (cbMonday.isChecked()) {
//            Integer answer = days.get(0);
//            answer = 1;
//            days.set(0, answer);
//
//        }
//
//        if (cbWed.isChecked()) {
//            Integer answer = days.get(1);
//            answer = 1;
//            days.set(1, answer);
//        }
//
//        if (cbSaturday.isChecked()) {
//            Integer answer = days.get(2);
//            answer = 1;
//            days.set(2, answer);
//        }



    }

    private void getResponseFromQuestionFour() {

    }

    private void validateForm() {

        String msg = "";

        if (!hasError) {

            resetForm();

        }
        int score = 0;

        if (isQ1Correct){
            score = score + 25;
        }

        if (isQ2Correct){
            score = score + 25;
        }

        if (isQ3Correct){
            score = score + 25;
        }

        if (isQ4Correct){
            score = score + 25;
        }

        msg = "You Score is: " + score + "%";
        showToaster(msg);
    }

    private void resetForm(){

    }

    private void showToaster(String msg) {
        toast(msg);
    }

    private void toast(String msg) {
        Toast toast = new Toast(this);

        toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void onQuestionOneRbChange(View view) {

        switch (view.getId()) {

            case R.id.rbLossWeight:
                q1Answer = false;
                break;

            case R.id.rbBeFit :
                q1Answer = true;
                isQ1Correct = true;
                break;
        }
    }

    public void onImmediateStartChange(View view) {

        switch (view.getId()) {

            case R.id.rbQ4No:
                q4Answer = "8";
                isQ4Correct = false;
                break;

            case R.id.rbQ4Yes:
                q4Answer = "16";
                isQ4Correct = true;
                break;

        }
    }
}
