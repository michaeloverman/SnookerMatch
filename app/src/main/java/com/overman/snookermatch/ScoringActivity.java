package com.overman.snookermatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScoringActivity extends AppCompatActivity {

    public static final String TAG = ScoringActivity.class.getSimpleName();
    private Player mPlayer1;
    private Player mPlayer2;
    private Match mMatch;

    @Bind(R.id.player1Name) TextView mPlayer1Label;
    @Bind(R.id.player2Name)TextView mPlayer2Label;
    @Bind(R.id.player1Score) TextView mPlayer1Score;
    @Bind(R.id.player2Score) TextView mPlayer2Score;
    @Bind(R.id.redBall) ImageView mRedBall;
    @Bind(R.id.yellowBall) ImageView mYellowBall;
    @Bind(R.id.greenBall) ImageView mGreenBall;
    @Bind(R.id.brownBall) ImageView mBrownBall;
    @Bind(R.id.blueBall) ImageView mBlueBall;
    @Bind(R.id.pinkBall) ImageView mPinkBall;
    @Bind(R.id.blackBall) ImageView mBlackBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "in ScoringActivity");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mPlayer1 = new Player(intent.getStringExtra("name1"));
//        Log.d(TAG, "mPlayer1 name: " + mPlayer1.getName());
        mPlayer2 = new Player(intent.getStringExtra("name2"));
//        Log.d(TAG, "mPlayer2 name: " + mPlayer2.getName());

        mMatch = new Match(mPlayer1, mPlayer2, intent.getIntExtra("frames", 1));
        Log.d(TAG, "Match created " + mMatch.getPlayer1().getName() + ", " + mMatch.getPlayer2().getName() + ", best of " + mMatch.getFrames());

        mPlayer1Label.setText(mPlayer1.getName());
        mPlayer2Label.setText(mPlayer2.getName());
        mPlayer1Score.setText(mPlayer1.getScore());
        mPlayer2Score.setText(mPlayer2.getScore());

    }
}
