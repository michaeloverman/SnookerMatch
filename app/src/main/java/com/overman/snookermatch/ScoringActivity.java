package com.overman.snookermatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScoringActivity extends AppCompatActivity {

    public static final String TAG = ScoringActivity.class.getSimpleName();

    @Bind(R.id.player1Label) TextView mPlayer1Label;
    @Bind(R.id.player2Label)TextView mPlayer2Label;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        ButterKnife.bind(this);


    }
}
