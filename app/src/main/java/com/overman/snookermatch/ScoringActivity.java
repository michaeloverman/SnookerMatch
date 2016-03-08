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
    @Bind(R.id.break1Label) TextView mPlayer1BreakLabel;
    @Bind(R.id.break2Label) TextView mPlayer2BreakLabel;
    @Bind(R.id.break1Score) TextView mPlayer1BreakScore;
    @Bind(R.id.break2Score) TextView mPlayer2BreakScore;
    @Bind(R.id.redBall) ImageView mRedBall;
    @Bind(R.id.redBallCount) TextView mRedBallCount;
    @Bind(R.id.yellowBall) ImageView mYellowBall;
    @Bind(R.id.yellowBallCount) TextView mYellowBallCount;
    @Bind(R.id.greenBall) ImageView mGreenBall;
    @Bind(R.id.greetBallCount) TextView mGreenBallCount;
    @Bind(R.id.brownBall) ImageView mBrownBall;
    @Bind(R.id.brownBallCount) TextView mBrownBallCount;
    @Bind(R.id.blueBall) ImageView mBlueBall;
    @Bind(R.id.blueBallCount) TextView mBlueBallCount;
    @Bind(R.id.pinkBall) ImageView mPinkBall;
    @Bind(R.id.pinkBallCount) TextView mPinkBallCount;
    @Bind(R.id.blackBall) ImageView mBlackBall;
    @Bind(R.id.blackBallCount) TextView mBlackBallCount;
    @Bind(R.id.ballsLayout) LinearLayout mBalls;
    private Frame mCurrentFrame;

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
        mCurrentFrame = new Frame();

        mPlayer1Label.setText(mPlayer1.getName());
        mPlayer1Label.setTextColor(Color.RED);
        mPlayer2Label.setText(mPlayer2.getName());
        mTotalFrames.setText("(" + mMatch.getFrames() + ")");
        mPlayer1FramesWon.setText(mPlayer1.getFramesWon() + "");
        mPlayer2FramesWon.setText(mPlayer2.getFramesWon() + "");
        mPlayer1Score.setText(mPlayer1.getScore() + "");
        mPlayer2Score.setText(mPlayer2.getScore() + "");

        mPlayer1BreakScore.setText(mPlayer1.getBreakScore() + "");
        mPlayer2BreakScore.setText(mPlayer2.getBreakScore() + "");
        mPlayer2BreakScore.setVisibility(View.INVISIBLE);
        mPlayer2BreakLabel.setVisibility(View.INVISIBLE);

        mRedBallCount.setText("");
        mYellowBallCount.setText("");
        mGreenBallCount.setText("");
        mBrownBallCount.setText("");
        mBlueBallCount.setText("");
        mPinkBallCount.setText("");
        mBlackBallCount.setText("");

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
            mPlayer2BreakScore.setText(mPlayer2.getBreakScore());
            mPlayer1BreakLabel.setVisibility(View.VISIBLE);
            mPlayer1BreakScore.setVisibility(View.VISIBLE);
            mPlayer2BreakLabel.setVisibility(View.INVISIBLE);
            mPlayer2BreakScore.setVisibility(View.INVISIBLE);
            mActivePlayer = 1;
        } else {
            mPlayer2Label.setTextColor(Color.RED);
            mPlayer1Label.setTextColor(Color.BLACK);
            mPlayer1.zeroBreakScore();
            mPlayer2BreakScore.setText(mPlayer1.getBreakScore());
            mPlayer1BreakLabel.setVisibility(View.INVISIBLE);
            mPlayer1BreakScore.setVisibility(View.INVISIBLE);
            mPlayer2BreakLabel.setVisibility(View.VISIBLE);
            mPlayer2BreakScore.setVisibility(View.VISIBLE);
            mActivePlayer = 2;
        }

        mRedBallOn = true;
        // change active player to red
    }

    private void ballPotted(String color) {
        int score = 0;
        switch (color) {
            case "red":
                score += 1;
                mCurrentFrame.incrementRed();
                mRedBallCount.setText(mCurrentFrame.getNumRed() + "");
                break;
            case "black":
                score += 7;
                mCurrentFrame.incrementBlack();
                mBlackBallCount.setText(mCurrentFrame.getNumBlack() + "");
                break;
            case "pink":
                score += 6;
                mCurrentFrame.incrementPink();
                mPinkBallCount.setText(mCurrentFrame.getNumPink() + "");
                break;
            case "blue":
                score += 5;
                mCurrentFrame.incrementBlue();
                mBlueBallCount.setText(mCurrentFrame.getNumBlue() + "");
                break;
            case "brown":
                score += 4;
                mCurrentFrame.incrementBrown();
                mBrownBallCount.setText(mCurrentFrame.getNumBrown() + "");
                break;
            case "green":
                score += 3;
                mCurrentFrame.incrementGreen();
                mGreenBallCount.setText(mCurrentFrame.getNumGreen() + "");
                break;
            case "yellow":
                score += 2;
                mCurrentFrame.incrementYellow();
                mYellowBallCount.setText(mCurrentFrame.getNumYellow() + "");
                break;

        }

        if (mActivePlayer == 1 ) {
            mPlayer1.incrementScore(score);
            mPlayer1Score.setText(mPlayer1.getScore() + "");
            mPlayer1BreakLabel.setText(mPlayer1.getBreakScore() + "");
        } else {
            mPlayer2.incrementScore(score);
            mPlayer2Score.setText(mPlayer2.getScore() + "");
            mPlayer2BreakScore.setText(mPlayer2.getBreakScore() + "");
        }
 //       toastMe(color + " ball potted, " + score + " points");

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
