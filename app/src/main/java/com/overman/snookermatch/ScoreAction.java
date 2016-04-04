package com.overman.snookermatch;

/**
 * Created by Michael on 4/3/2016.
 */
public class ScoreAction {
    private int mPlayer;
    private int mPoints;

    public ScoreAction(int player, int score) {
        mPlayer = player;
        mPoints = score;
    }
    public int getPlayer() {
        return mPlayer;
    }

    public void setPlayer(int player) {
        this.mPlayer = player;
    }

    public int getPoints() {
        return mPoints;
    }

    public void setPoints(int points) {
        this.mPoints = points;
    }
}
