package com.example.sharang.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivty extends AppCompatActivity implements View.OnClickListener {

    private  TicTacToeGame mgame = new TicTacToeGame(this);
    private TextView mGameStateTextView;
    private Button mTicTacToeButtons[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button newGameButton = (Button)findViewById(R.id.new_game_button);
        newGameButton.setOnClickListener(this);
        mGameStateTextView=(TextView)findViewById(R.id.game_state_text_view);
        mTicTacToeButtons = new Button[TicTacToeGame.NUM_ROWS][TicTacToeGame.NUM_COLUMNS];
        for(int row=0;row<TicTacToeGame.NUM_ROWS;row++){
            for(int col=0;col<TicTacToeGame.NUM_COLUMNS;col++){
                int id = getResources().getIdentifier("button"+row+col,"id",getPackageName());
                mTicTacToeButtons[row][col]=(Button)findViewById(id);
                mTicTacToeButtons[row][col].setOnClickListener(this);
            }
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.new_game_button) mgame.resetGame();

        for(int row=0;row<TicTacToeGame.NUM_ROWS;row++) {
            for (int col = 0; col < TicTacToeGame.NUM_COLUMNS; col++) {
                if(v.getId()==mTicTacToeButtons[row][col].getId()){
                    Log.d("TTT","Button pressed at row "+row +" and column "+ col);
                    mgame.pressedButtonAtLocation(row,col);
                }
                mTicTacToeButtons[row][col].setText(mgame.stringForButtonAtLocation(row,col));
            }
        }
        mGameStateTextView.setText(mgame.stringForGameState());

    }

}
