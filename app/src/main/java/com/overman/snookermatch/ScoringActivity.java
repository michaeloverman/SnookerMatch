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
    private static final int RED = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;
    public static final int BROWN = 4;
    public static final int BLUE = 5;
    public static final int PINK = 6;
    public static final int BLACK = 7;
    private int mBallOn = RED;
    private Boolean mRedBallOn = true;
    private static final float FADED = 0.5f;
    private static final float SOLID = 1.0f;


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
        int frames = intent.getIntExtra("frames", 1);
        mActivePlayer = 1;

        mMatch = new Match(mPlayer1, mPlayer2, frames);
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

        mRedBallCount.setText("0");
        mRedBallCount.setVisibility(View.INVISIBLE);
        mYellowBallCount.setText("0");
        mYellowBallCount.setVisibility(View.INVISIBLE);
        mYellowBall.setAlpha(FADED);
        mGreenBallCount.setText("0");
        mGreenBallCount.setVisibility(View.INVISIBLE);
        mGreenBall.setAlpha(FADED);
        mBrownBallCount.setText("0");
        mBrownBallCount.setVisibility(View.INVISIBLE);
        mBrownBall.setAlpha(FADED);
        mBlueBallCount.setText("0");
        mBlueBallCount.setVisibility(View.INVISIBLE);
        mBlueBall.setAlpha(FADED);
        mPinkBallCount.setText("0");
        mPinkBallCount.setVisibility(View.INVISIBLE);
        mPinkBall.setAlpha(FADED);
        mBlackBallCount.setText("0");
        mBlackBallCount.setVisibility(View.INVISIBLE);
        mBlackBall.setAlpha(FADED);

        mRedBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRedBallOn) {
                    ballPotted(RED);
                }
            }
        });
        mYellowBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted(YELLOW);
            }
        });
        mGreenBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted(GREEN);
            }
        });
        mBrownBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted(BROWN);
            }
        });
        mBlueBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted(BLUE);
            }
        });
        mPinkBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted(PINK);
            }
        });
        mBlackBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mRedBallOn) ballPotted(BLACK);
            }
        });
        mPlayer1Label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mActivePlayer == 2) togglePlayer(1);
            }
        });
        mPlayer1Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mActivePlayer == 2) togglePlayer(1);
            }
        });
        mPlayer2Label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mActivePlayer == 1) togglePlayer(2);
            }
        });
        mPlayer2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mActivePlayer == 1) togglePlayer(2);
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
            mPlayer1BreakScore.setText(mPlayer1.getBreakScore() + "");
            mPlayer1BreakLabel.setVisibility(View.VISIBLE);
            mPlayer1BreakScore.setVisibility(View.VISIBLE);
            mPlayer2BreakLabel.setVisibility(View.INVISIBLE);
            mPlayer2BreakScore.setVisibility(View.INVISIBLE);
            mActivePlayer = 1;
        } else {
            mPlayer2Label.setTextColor(Color.RED);
            mPlayer1Label.setTextColor(Color.BLACK);
            mPlayer1.zeroBreakScore();
            mPlayer2BreakScore.setText(mPlayer2.getBreakScore() + "");
            mPlayer1BreakLabel.setVisibility(View.INVISIBLE);
            mPlayer1BreakScore.setVisibility(View.INVISIBLE);
            mPlayer2BreakLabel.setVisibility(View.VISIBLE);
            mPlayer2BreakScore.setVisibility(View.VISIBLE);
            mActivePlayer = 2;
        }

        mRedBallOn = true;
    }

    private void ballPotted(int color) {
        int score = 0;
        switch (color) {
            case RED:
                score += 1;
                mCurrentFrame.incrementRed();
                updateBallCount(mRedBallCount);
            //    mRedBallCount.setText(mCurrentFrame.getNumRed() + "");
                break;
            case BLACK:
                score += 7;
                mCurrentFrame.incrementBlack();
                updateBallCount(mBlackBallCount);
                break;
            case PINK:
                score += 6;
                mCurrentFrame.incrementPink();
                updateBallCount(mPinkBallCount);
                break;
            case BLUE:
                score += 5;
                mCurrentFrame.incrementBlue();
                updateBallCount(mBlueBallCount);
                break;
            case BROWN:
                score += 4;
                mCurrentFrame.incrementBrown();
                updateBallCount(mBrownBallCount);
                break;
            case GREEN:
                score += 3;
                mCurrentFrame.incrementGreen();
                updateBallCount(mGreenBallCount);
                break;
            case YELLOW:
                score += 2;
                mCurrentFrame.incrementYellow();
                updateBallCount(mYellowBallCount);
                break;

        }

        if (mActivePlayer == 1 ) {
            mPlayer1.incrementScore(score);
            mPlayer1Score.setText(mPlayer1.getScore() + "");
            mPlayer1BreakScore.setText(mPlayer1.getBreakScore() + "");
        } else {
            mPlayer2.incrementScore(score);
            mPlayer2Score.setText(mPlayer2.getScore() + "");
            mPlayer2BreakScore.setText(mPlayer2.getBreakScore() + "");
        }
 //       toastMe(color + " ball potted, " + score + " points");

        mRedBallOn = !mRedBallOn;
        fadeBalls();
    }

    private void fadeBalls() {
        if(mRedBallOn) {
            mRedBall.setAlpha(SOLID);
            mYellowBall.setAlpha(FADED);
            mGreenBall.setAlpha(FADED);
            mBrownBall.setAlpha(FADED);
            mBlueBall.setAlpha(FADED);
            mPinkBall.setAlpha(FADED);
            mBlackBall.setAlpha(FADED);
        } else {
            mRedBall.setAlpha(FADED);
            mYellowBall.setAlpha(SOLID);
            mGreenBall.setAlpha(SOLID);
            mBrownBall.setAlpha(SOLID);
            mBlueBall.setAlpha(SOLID);
            mPinkBall.setAlpha(SOLID);
            mBlackBall.setAlpha(SOLID);
        }

    }
    private void updateBallCount(TextView thisBall) {
        int count = Integer.parseInt(thisBall.getText().toString());
        if(count == 0) thisBall.setVisibility(View.VISIBLE);
        thisBall.setText(++count + "");
        if(mCurrentFrame.getNumColors() >= 15) {
            mBallOn = mCurrentFrame.getNumColors() - 13;
        }
    }

    /**
     * A primarily useless Toast method - helpful for debugging purposes
     * @param s
     */
    private void toastMe(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
