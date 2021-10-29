package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    Button playBtn, answer0Btn, answer1Btn, answer2Btn, answer3Btn;
    TextView scoreTxt, questionTxt, timerTxt, bottomTxt;
    ProgressBar timerBar;
    private int numberCorrect;

    Play game = new Play();

    int secondsRemaining = 25;

    CountDownTimer timer = new CountDownTimer(25000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            timerTxt.setText(Integer.toString(secondsRemaining) + "sec");
            timerBar.setProgress(25 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            answer0Btn.setEnabled(false);
            answer1Btn.setEnabled(false);
            answer2Btn.setEnabled(false);
            answer3Btn.setEnabled(false);
            bottomTxt.setText("Your score: " + numberCorrect + "/" + (game.getTotalQuestions() - 1));
            playBtn.setText("Play Again");
            playBtn.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        playBtn = findViewById(R.id.play);
        answer0Btn = findViewById(R.id.answer0);
        answer1Btn = findViewById(R.id.answer1);
        answer2Btn = findViewById(R.id.answer2);
        answer3Btn = findViewById(R.id.answer3);

        scoreTxt = findViewById(R.id.score);
        questionTxt = findViewById(R.id.questions);
        timerTxt = findViewById(R.id.timer);
        bottomTxt = findViewById(R.id.bottomText);

        timerBar = findViewById(R.id.timerBar);

        timerTxt.setText("0Sec");
        questionTxt.setText("");
        bottomTxt.setText("Press Play");
        scoreTxt.setText("0pts");
        numberCorrect = 0;

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button play_button = (Button)v;
                play_button.setVisibility(View.INVISIBLE);
                bottomTxt.setText("Start!");
                secondsRemaining = 25;
                scoreTxt.setText("0/0");
                numberCorrect = 0;
                game = new Play();
                nextTurn();
                timer.start();
            }
        };

        View.OnClickListener answerBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;

                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());

                if (game.checkAnswer(answerSelected))
                {
                    bottomTxt.setText("Correct!");
                    numberCorrect++;
                }else{
                    bottomTxt.setText("Incorrect!");
                }
                game.checkAnswer(answerSelected);
                scoreTxt.setText(numberCorrect + "/" + game.getTotalQuestions());
                nextTurn();
            }
        };

        playBtn.setOnClickListener(startButtonClickListener);

        answer0Btn.setOnClickListener(answerBtnClickListener);
        answer1Btn.setOnClickListener(answerBtnClickListener);
        answer2Btn.setOnClickListener(answerBtnClickListener);
        answer3Btn.setOnClickListener(answerBtnClickListener);
    }

    private void nextTurn(){
        game.makeNewQuestion();
        int [] answer = game.getCurrentQuestion().getAnswerArray();

        answer0Btn.setText(Integer.toString(answer[0]));
        answer1Btn.setText(Integer.toString(answer[1]));
        answer2Btn.setText(Integer.toString(answer[2]));
        answer3Btn.setText(Integer.toString(answer[3]));

        answer0Btn.setEnabled(true);
        answer1Btn.setEnabled(true);
        answer2Btn.setEnabled(true);
        answer3Btn.setEnabled(true);

        questionTxt.setText(game.getCurrentQuestion().getQuestion());
    }
}