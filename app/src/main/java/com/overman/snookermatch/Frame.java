package com.overman.snookermatch;

/**
 * Created by overm on 3/7/2016.
 */
public class Frame {
    private int mNumRed;
    private int mNumYellow;
    private int mNumGreen;
    private int mNumBrown;
    private int mNumBlue;
    private int mNumPink;
    private int mNumBlack;
    private int mPointsOn;
    private int mNeedToWin;
    private Player mWinner;

    public Frame() {
        reset();
    }

    public void reset() {
        mNumRed = 0;
        mNumGreen = 0;
        mNumGreen = 0;
        mNumBrown = 0;
        mNumBlue = 0;
        mNumPink = 0;
        mNumBlack = 0;
        mPointsOn = 147;
        mNeedToWin = 74;
    }

    public Player getWinner() {
        return mWinner;
    }

    public void setWinner(Player winner) {
        mWinner = winner;
    }

    public int getNumRed() {
        return mNumRed;
    }

    public int getNumYellow() {
        return mNumYellow;
    }

    public int getNumGreen() {
        return mNumGreen;
    }

    public int getNumBrown() {
        return mNumBrown;
    }

    public int getNumBlue() {
        return mNumBlue;
    }

    public int getNumPink() {
        return mNumPink;
    }

    public int getNumBlack() {
        return mNumBlack;
    }

    public int getPointsOn() {
        return mPointsOn;
    }

    public int getNeedToWin() {
        return mNeedToWin;
    }

    public int getNumColors() {
        return mNumYellow + mNumGreen + mNumBrown + mNumBlue
                + mNumPink + mNumBlack;
    }

    public void incrementRed() {
        mNumRed += 1;
    }

    public void incrementBlack() {
        mNumBlack += 1;
    }

    public void incrementPink() {
        mNumPink += 1;
    }

    public void incrementBlue() {
        mNumBlue += 1;
    }

    public void incrementBrown() {
        mNumBrown += 1;
    }

    public void incrementGreen() {
        mNumGreen += 1;
    }

    public void incrementYellow() {
        mNumYellow += 1;
    }
}
