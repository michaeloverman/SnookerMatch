package com.overman.snookermatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private Button mStartButton;
    private EditText mPlayer1Name;
    private EditText mPlayer2Name;
    private EditText mFrames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer1Name = (EditText)findViewById(R.id.editPlayer1);
        mPlayer2Name = (EditText)findViewById(R.id.editPlayer2);
        mFrames = (EditText)findViewById(R.id.numberOfFrames);
        mStartButton = (Button)findViewById(R.id.startMatchButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mPlayer1 = new Player();
//                mPlayer2 = new Player();
//                mNumberOfFrames = ;
//                mMatch = new Match(mPlayer1, mPlayer2, mNumberOfFrames);

                startScoring();
            }
        });
    }

    private void startScoring() {
        Log.d(TAG, "in startScoring()");

        String name1, name2;
        int frames;

        if (mPlayer1Name.getText().length() != 0) name1 = mPlayer1Name.getText().toString();
        else name1 = "Ronnie O'Sullivan";
        if (mPlayer2Name.getText().length() != 0) name2 = mPlayer2Name.getText().toString();
        else name2 = "Stuart Bingham";
        if (mFrames.getText().length() != 0) frames = Integer.parseInt(mFrames.getText().toString());
        else frames = 11;

        Intent intent = new Intent(this, ScoringActivity.class);



        intent.putExtra("name1", name1);
        intent.putExtra("name2", name2);
        intent.putExtra("frames", frames);
        startActivity(intent);
    }
}
