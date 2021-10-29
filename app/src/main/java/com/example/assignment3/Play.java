package com.example.assignment3;

import java.util.ArrayList;
import java.util.List;

public class Play {

    private List<Questions> questions;
    private int totalQuestions;
    private int score;
    private Questions currentQuestion;

    public Play(){
        totalQuestions = 0;
        currentQuestion = new Questions(12);
        questions = new ArrayList<Questions>();
    }

    public void makeNewQuestion(){
        currentQuestion = new Questions(totalQuestions * 2 + 5);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if (currentQuestion.getAnswer() == submittedAnswer){
            isCorrect = true;
        }else{
            isCorrect = false;
        }
        return isCorrect;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Questions getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Questions currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
