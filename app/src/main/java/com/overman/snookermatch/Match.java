package com.overman.snookermatch;

/**
 * Created by overm on 3/5/2016.
 */
public class Match {
    private Player mPlayer1;
    private Player mPlayer2;
    private int mFrames;

    public Match(Player player1, Player player2, int numberOfFrames) {
        mPlayer1 = player1;
        mPlayer2 = player2;
        mFrames = numberOfFrames;
    }

    public Player getPlayer1() {
        return mPlayer1;
    }

    public void setPlayer1(Player player1) {
        mPlayer1 = player1;
    }

    public Player getPlayer2() {
        return mPlayer2;
    }

    public void setPlayer2(Player player2) {
        mPlayer2 = player2;
    }

    public int getFrames() {
        return mFrames;
    }

    public void setFrames(int frames) {
        mFrames = frames;
    }
}
