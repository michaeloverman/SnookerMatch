package com.overman.snookermatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
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
        Intent intent = new Intent(this, ScoringActivity.class);
        intent.putExtra("name1", mPlayer1Name.getText().toString());
        intent.putExtra("name2", mPlayer2Name.getText().toString());
        intent.putExtra("frames", Integer.parseInt(mFrames.getText().toString()));
        startActivity(intent);
    }
}
