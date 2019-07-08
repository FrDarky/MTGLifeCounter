package fr.darky.mtglifecounter.twoPlayers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.darky.mtglifecounter.R;
import fr.darky.mtglifecounter.utils.CoinDiceDisplay;
import fr.darky.mtglifecounter.utils.ValueCalculation;

public class TwoPlayersCounter extends AppCompatActivity {

    //////////////
    //  SYSTEM  //
    //////////////

    public Button coinDice;

    //////////////
    // PLAYER 1 //
    //////////////

    // Keys
    public static final String PLAYER1_NAME = "PLAYER 1 NAME";
    public static final String PLAYER1_LIFE = "PLAYER 1 LIFE";

    // Values
    public String p1Name;
    public int p1Life;

    // View
    public TextView p1NameView;
    public TextView p1LifeView;
    public ImageView p1Minus;
    public ImageView p1Plus;

    //////////////
    // PLAYER 2 //
    //////////////

    // Keys
    public static final String PLAYER2_NAME = "PLAYER 2 NAME";
    public static final String PLAYER2_LIFE = "PLAYER 2 LIFE";

    // Values
    public String p2Name;
    public int p2Life;

    // View
    public TextView p2NameView;
    public TextView p2LifeView;
    public ImageView p2Minus;
    public ImageView p2Plus;

    // CREATE VIEW
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        // Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_two_players_counter);

        // Set players values and views
        setPlayer1();
        setPlayer2();
    }

    // SAVE VIEW
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        // Player 1
        outState.putString(PLAYER1_NAME, p1Name);
        outState.putString(PLAYER1_LIFE, Integer.toString(p1Life));

        // Player 2
        outState.putString(PLAYER2_NAME, p2Name);
        outState.putString(PLAYER2_LIFE, Integer.toString(p2Life));

        super.onSaveInstanceState(outState);
    }

    // LOAD VIEW
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Player 1
        p1Name = savedInstanceState.getString(PLAYER1_NAME);
        p1NameView.setText(p1Name);

        p1Life = Integer.parseInt(savedInstanceState.getString(PLAYER1_LIFE));
        p1LifeView.setText(Integer.toString(p1Life));

        // Player 2
        p2Name = savedInstanceState.getString(PLAYER2_NAME);
        p2NameView.setText(p2Name);

        p2Life = Integer.parseInt(savedInstanceState.getString(PLAYER2_LIFE));
        p2LifeView.setText(Integer.toString(p2Life));
    }

    public void coinFlipDiceRoll(View view) {
        new CoinDiceDisplay(this);
    }

    // SET PLAYER VALUES AND VIEWS
    public void setPlayer1() {
        // Set values
        p1Name = getIntent().getStringExtra(PLAYER1_NAME);
        try {
            p1Life = Integer.parseInt(getIntent().getStringExtra(PLAYER1_LIFE));
        } catch (NumberFormatException e) {
            p1Life = 20; // If entered life is not a number
        }

        // Set view
        p1NameView = (TextView) findViewById(R.id.twoPlayerParams_p1Name);
        p1NameView.setText(p1Name);

        p1LifeView = (TextView) findViewById(R.id.twoPlayerParams_p1Life);
        p1LifeView.setText(Integer.toString(p1Life));

        // Add life
        p1Plus = (ImageView) findViewById(R.id.twoPlayers_p1Plus);

        p1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1Life = ValueCalculation.addShort(p1Life);
                p1LifeView.setText(Integer.toString(p1Life));
            }
        });

        p1Plus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                p1Life = ValueCalculation.addLong(p1Life);
                p1LifeView.setText(Integer.toString(p1Life));
                return true; // Don't trigger onClick if onLongClick is enabled
            }
        });

        // Remove life
        p1Minus = (ImageView) findViewById(R.id.twoPlayers_p1Minus);

        p1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1Life = ValueCalculation.removeShort(p1Life);
                p1LifeView.setText(Integer.toString(p1Life));
            }
        });

        p1Minus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                p1Life = ValueCalculation.removeLong(p1Life);
                p1LifeView.setText(Integer.toString(p1Life));
                return true; // Don't trigger onClick if onLongClick is enabled
            }
        });
    }

    public void setPlayer2() {
        // Set values
        p2Name = getIntent().getStringExtra(PLAYER2_NAME);
        try {
            p2Life = Integer.parseInt(getIntent().getStringExtra(PLAYER2_LIFE));
        } catch (NumberFormatException e) {
            p2Life = 20; // If entered life is not a number
        }

        // Set view
        p2NameView = (TextView) findViewById(R.id.twoPlayerParams_p2Name);
        p2NameView.setText(p2Name);

        p2LifeView = (TextView) findViewById(R.id.twoPlayerParams_p2Life);
        p2LifeView.setText(Integer.toString(p2Life));

        // Add life
        p2Plus = (ImageView) findViewById(R.id.twoPlayers_p2Plus);

        p2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2Life = ValueCalculation.addShort(p2Life);
                p2LifeView.setText(Integer.toString(p2Life));
            }
        });

        p2Plus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                p2Life = ValueCalculation.addLong(p2Life);
                p2LifeView.setText(Integer.toString(p2Life));
                return true; // Don't trigger onClick if onLongClick is enabled
            }
        });

        // Remove life
        p2Minus = (ImageView) findViewById(R.id.twoPlayers_p2Minus);

        p2Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2Life = ValueCalculation.removeShort(p2Life);
                p2LifeView.setText(Integer.toString(p2Life));
            }
        });

        p2Minus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                p2Life = ValueCalculation.removeLong(p2Life);
                p2LifeView.setText(Integer.toString(p2Life));
                return true; // Don't trigger onClick if onLongClick is enabled
            }
        });
    }
}
