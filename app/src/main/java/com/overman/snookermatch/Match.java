package com.overman.snookermatch;

/**
 * Created by overm on 3/5/2016.
 */
public class Match {
    private Player mPlayer1;
    private Player mPlayer2;
    private Frame[] mFrames;

    public Match(Player player1, Player player2, int numberOfFrames) {
        mPlayer1 = player1;
        mPlayer2 = player2;
        mFrames = new Frame[numberOfFrames];
        mFrames[0] = new Frame();
    }

    public Player getPlayer1() {
        return mPlayer1;
    }

    public Player getPlayer2() {
        return mPlayer2;
    }

    public int getFrames() {
        return mFrames.length;
    }

}
