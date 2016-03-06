package com.overman.snookermatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    @Bind(R.id.ballsLayout) LinearLayout mBalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "in ScoringActivity");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mPlayer1 = new Player(intent.getStringExtra("name1"));
        mPlayer2 = new Player(intent.getStringExtra("name2"));

        mMatch = new Match(mPlayer1, mPlayer2, intent.getIntExtra("frames", 1));
        Log.d(TAG, "Match created " + mMatch.getPlayer1().getName() + ", " + mMatch.getPlayer2().getName() + ", best of " + mMatch.getFrames());

        mPlayer1Label.setText(mPlayer1.getName());
        mPlayer2Label.setText(mPlayer2.getName());
        mPlayer1Score.setText(mPlayer1.getScore() + "");
        mPlayer2Score.setText(mPlayer2.getScore() + "");

        mRedBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballPotted("red");
            }
        });
        mYellowBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballPotted("yellow");
            }
        });
        mGreenBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballPotted("green");
            }
        });
        mBrownBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballPotted("brown");
            }
        });
        mBlueBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballPotted("blue");
            }
        });
        mPinkBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballPotted("pink");
            }
        });
        mBlackBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballPotted("black");
            }
        });
        mPlayer1Label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe("player 1 clicked");
            }
        });
        mPlayer2Label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe("player 2 clicked");
            }
        });
    }

    private void ballPotted(String color) {
        int score = 0;
        switch (color) {
            case "black":
                score += 1;
            case "pink":
                score += 1;
            case "blue":
                score += 1;
            case "brown":
                score += 1;
            case "green":
                score += 1;
            case "yellow":
                score += 1;
            case "red":
                score += 1;
        }
        toastMe(color + " ball potted, " + score + " points");
    }

    /**
     * A primarily useless Toast method - helpful for debugging purposes
     * @param s
     */
    private void toastMe(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
