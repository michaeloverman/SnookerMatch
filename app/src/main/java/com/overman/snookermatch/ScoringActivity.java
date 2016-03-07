package com.overman.snookermatch;

import android.content.Intent;
import android.graphics.Color;
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
    private int mActivePlayer;
    private Boolean mRedBallOn = true;

    @Bind(R.id.player1Name) TextView mPlayer1Label;
    @Bind(R.id.player2Name) TextView mPlayer2Label;
    @Bind(R.id.bestOfFrames) TextView mTotalFrames;
    @Bind(R.id.player1FramesWon) TextView mPlayer1FramesWon;
    @Bind(R.id.player2FramesWon) TextView mPlayer2FramesWon;
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
        mActivePlayer = 1;

        mMatch = new Match(mPlayer1, mPlayer2, intent.getIntExtra("frames", 1));
        Log.d(TAG, "Match created " + mMatch.getPlayer1().getName() + ", " + mMatch.getPlayer2().getName() + ", best of " + mMatch.getFrames());

        mPlayer1Label.setText(mPlayer1.getName());
        mPlayer1Label.setTextColor(Color.RED);
        mPlayer2Label.setText(mPlayer2.getName());
        mTotalFrames.setText("(" + mMatch.getFrames() + ")");
        mPlayer1FramesWon.setText(mPlayer1.getFramesWon() + "");
        mPlayer2FramesWon.setText(mPlayer2.getFramesWon() + "" );
        mPlayer1Score.setText(mPlayer1.getScore() + "");
        mPlayer2Score.setText(mPlayer2.getScore() + "");

        mRedBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRedBallOn) {
                    ballPotted("red");
                }
            }
        });
        mYellowBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) {
                    ballPotted("yellow");
                }
            }
        });
        mGreenBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted("green");
            }
        });
        mBrownBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted("brown");
            }
        });
        mBlueBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted("blue");
            }
        });
        mPinkBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted("pink");
            }
        });
        mBlackBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted("black");
            }
        });
        mPlayer1Label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayer(1);
            }
        });
        mPlayer2Label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayer(2);
            }
        });
    }

    private void togglePlayer(int playerNumber) {
        // change Active player to black

        // switch active player
        if(playerNumber == 1) {
            mPlayer1Label.setTextColor(Color.RED);
            mPlayer2Label.setTextColor(Color.BLACK);
            mPlayer2.zeroBreakScore();
            mActivePlayer = 1;
        } else {
            mPlayer2Label.setTextColor(Color.RED);
            mPlayer1Label.setTextColor(Color.BLACK);
            mPlayer1.zeroBreakScore();
            mActivePlayer = 2;
        }

        mRedBallOn = true;
        // change active player to red
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

        if (mActivePlayer == 1 ) {
            mPlayer1.incrementScore(score);
            mPlayer1Score.setText(mPlayer1.getScore() + "");
        } else {
            mPlayer2.incrementScore(score);
            mPlayer2Score.setText(mPlayer2.getScore() + "");
        }
        toastMe(color + " ball potted, " + score + " points");

        mRedBallOn = !mRedBallOn;
    }

    /**
     * A primarily useless Toast method - helpful for debugging purposes
     * @param s
     */
    private void toastMe(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
