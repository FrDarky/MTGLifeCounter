package fr.darky.mtglifecounter.twoPlayers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import fr.darky.mtglifecounter.R;
import fr.darky.mtglifecounter.onePlayer.OnePlayerCounter;

public class TwoPlayersParametersActivity extends AppCompatActivity {

    // Player 1
    public EditText p1Name;
    public EditText p1Life;

    // Player 2
    public EditText p2Name;
    public EditText p2Life;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        // Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_two_players_parameters);

        // Player 1
        p1Name = (EditText) findViewById(R.id.twoPlayerParams_p1Name);
        p1Life = (EditText) findViewById(R.id.twoPlayerParams_p1Life);

        // Player 2
        p2Name = (EditText) findViewById(R.id.twoPlayerParams_p2Name);
        p2Life = (EditText) findViewById(R.id.twoPlayerParams_p2Life);
    }

    public void startCounter(View view) {
        Intent counter = new Intent(this, TwoPlayersCounter.class);

        // Player 1 values
        counter.putExtra(TwoPlayersCounter.PLAYER1_NAME, p1Name.getText().toString());
        counter.putExtra(TwoPlayersCounter.PLAYER1_LIFE, p1Life.getText().toString());

        // Player 2 values
        counter.putExtra(TwoPlayersCounter.PLAYER2_NAME, p2Name.getText().toString());
        counter.putExtra(TwoPlayersCounter.PLAYER2_LIFE, p2Life.getText().toString());

        startActivity(counter);
    }
}
