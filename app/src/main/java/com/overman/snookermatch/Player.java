package com.overman.snookermatch;

/**
 * Created by overm on 3/5/2016.
 */
public class Player {
    private String mName;
    private int mScore;
    private int mFramesWon;
    private int mBreakScore;

    public Player(String name) {
        mName = name;
        mScore = 0;
        mFramesWon = 0;
        mBreakScore = 0;
    }

    public String getName() {
        return mName;
    }

//    public void setName(String name) {
//        mName = name;
//    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public int getFramesWon() {
        return mFramesWon;
    }

    public void setFramesWon(int framesWon) {
        mFramesWon = framesWon;
    }

    public int getBreakScore() {
        return mBreakScore;
    }

    public void setBreakScore(int breakScore) {
        mBreakScore = breakScore;
    }

    public void incrementScore(int score) {
        mScore += score;
        mBreakScore += score;
    }

    public void zeroBreakScore() {
        mBreakScore = 0;
    }
}
