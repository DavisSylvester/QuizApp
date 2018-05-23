package com.davissylvester.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean q1Answer = false;
    private String q2Answer = "";
    private String q4Answer = ""; //  this is used on line 169 and 179

    private boolean isQ1Correct = false;
    private boolean isQ2Correct = false;
    private boolean isQ3Correct = false;
    private boolean isQ4Correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveQuiz(View view) {

        getResponseFromQuestionTwo();
        getResponseFromQuestionThree();

        validateForm();
    }

    private void getResponseFromQuestionTwo() {

        TextView txtQ2 = findViewById(R.id.txtQ2);

        q2Answer = txtQ2.getText().toString();

        if (q2Answer.equals("12")) {
            isQ2Correct = true;
        }
    }

    private void getResponseFromQuestionThree() {

        CheckBox cb6 = findViewById(R.id.cb6);
        CheckBox cb10 = findViewById(R.id.cb10);
        CheckBox cb1 = findViewById(R.id.cb1);

        if (cb6.isChecked() && cb1.isChecked() && !cb10.isChecked()) {
            isQ3Correct = true;
        }
    }

    private void validateForm() {

        String msg = "";

        int score = 0; // Every time submit is press score / grade is reset!

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

        if (score == 100) {
            resetForm();
        }

        msg = "You Score is: " + score + "%";
        showToaster(msg);
    }

    private void resetForm(){

        RadioButton rb5 = findViewById(R.id.rb5);
        RadioButton rb7 = findViewById(R.id.rb7);
        RadioButton rb16 = findViewById(R.id.rb16);
        RadioButton rb8 = findViewById(R.id.rb8);

        CheckBox cb6 = findViewById(R.id.cb6);
        CheckBox cb1 = findViewById(R.id.cb1);
        CheckBox cb10 = findViewById(R.id.cb10);

        TextView txtQ2 = findViewById(R.id.txtQ2);

        isQ1Correct = false;
        isQ2Correct = false;
        isQ3Correct = false;
        isQ4Correct = false;

        rb5.setChecked(false);
        rb7.setChecked(false);
        rb16.setChecked(false);
        rb8.setChecked(false);

        cb1.setChecked(false);
        cb10.setChecked(false);
        cb6.setChecked(false);

        txtQ2.setText("");
    }

    private void showToaster(String msg) {
        toast(msg);
    }

    private void toast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void onQuestionOneRbChange(View view) {

        switch (view.getId()) {

            case R.id.rb5:
                q1Answer = false;
                isQ1Correct = false;
                break;

            case R.id.rb7:
                q1Answer = true;
                isQ1Correct = true;
                break;
        }
    }

    public void onImmediateStartChange(View view) {

        switch (view.getId()) {

            case R.id.rb8:
                q4Answer = "8";
                isQ4Correct = false;
                break;

            case R.id.rb16:
                q4Answer = "16";
                isQ4Correct = true;
                break;
        }
    }
}
