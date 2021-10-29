package com.example.assignment3;

import java.util.Random;

public class Questions {

    private int firstNumber;
    private int secondNumber;
    private int answer;
    //there will be 4 choices for the users to choose
    private int [] answerArray;
    //positions will be 0, 1, 2, or 3
    private int answerPoisition;
    private int upperLimit;
    private String question;

    public Questions(int upperLimit){
        this.upperLimit = upperLimit;
        Random randomNumber = new Random();

        this.firstNumber = randomNumber.nextInt(upperLimit);
        this.secondNumber = randomNumber.nextInt(upperLimit);
        this.answer = this.firstNumber + this.secondNumber;
        this.question = firstNumber + " + " + secondNumber + " = ";

        this.answerPoisition = randomNumber.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};

        this.answerArray[0] = answer + 1;
        this.answerArray[1] = answer + 15;
        this.answerArray[2] = answer - 5;
        this.answerArray[3] = answer - 2;

        this.answerArray = shuffleArray(this.answerArray);

        answerArray[answerPoisition] = answer;
    }

    private int[] shuffleArray(int[] array){
        int index, temp;
        Random randomNumberGen = new Random();

        for (int i = array.length - 1; i > 0; i--){
            index = randomNumberGen.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPoisition() {
        return answerPoisition;
    }

    public void setAnswerPoisition(int answerPoisition) {
        this.answerPoisition = answerPoisition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
