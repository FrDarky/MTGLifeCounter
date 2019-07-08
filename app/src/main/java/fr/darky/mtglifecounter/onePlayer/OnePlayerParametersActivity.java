package fr.darky.mtglifecounter.onePlayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import fr.darky.mtglifecounter.R;

public class OnePlayerParametersActivity extends AppCompatActivity {

    // Player 1
    public EditText p1Name;
    public EditText p1Life;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        // Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_one_player_parameters);

        // Player 1
        p1Name = (EditText) findViewById(R.id.onePlayerParams_p1Name);
        p1Life = (EditText) findViewById(R.id.onePlayerParams_p1Life);
    }

    public void startCounter(View view) {
        Intent counter = new Intent(this, OnePlayerCounter.class);

        // Player 1 values
        counter.putExtra(OnePlayerCounter.PLAYER1_NAME, p1Name.getText().toString());
        counter.putExtra(OnePlayerCounter.PLAYER1_LIFE, p1Life.getText().toString());

        startActivity(counter);
    }
}
