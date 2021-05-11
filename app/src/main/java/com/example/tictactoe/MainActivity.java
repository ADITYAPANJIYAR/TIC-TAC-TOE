package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0-x
    //1-o
    //2-NULL

    int activePlayer = 0;
    boolean gameActive=true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPoisitions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {1, 4, 7}, {2, 5, 8}, {0, 3, 6},
            {0, 4, 8}, {2, 4, 6}};

    public void PlayerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.cross);
                activePlayer = 1;
                TextView Status = findViewById(R.id.Status);
                Status.setText("O's turn-Tap to play");

            } else {
                img.setImageResource(R.drawable.zero);
                activePlayer = 0;
                TextView Status = findViewById(R.id.Status);
                Status.setText("X's turn-Tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(200);
        }
        for(int []winPosition: winPoisitions){
            if(gameState[winPosition[0]]==gameState [winPosition[1]] &&
                    gameState[winPosition[1]]==gameState [winPosition[2]] &&
                    gameState[winPosition[0]]!=2){
                //somebody has won
                gameActive=false;
                String winnerStr;
                if(gameState[winPosition[0]]==0){
                    winnerStr="X has won";
                    TextView Status = findViewById(R.id.Status);
                    Status.setText(winnerStr);
                }
                else {
                    winnerStr="O has won";
                    TextView Status = findViewById(R.id.Status);
                    Status.setText(winnerStr);
                }
                //update status

            }

        }


        }
    public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView Status = findViewById(R.id.Status);
        Status.setText("x's turn-Tap to play");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}