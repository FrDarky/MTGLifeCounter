package fr.darky.mtglifecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import fr.darky.mtglifecounter.onePlayer.OnePlayerParametersActivity;
import fr.darky.mtglifecounter.twoPlayers.TwoPlayersParametersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        // Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
    }

    // Select one player counter
    public void onePlayerSelect(View view) {
        Intent onePlayer = new Intent(this, OnePlayerParametersActivity.class);
        startActivity(onePlayer);
    }

    public void twoPlayersSelect(View view) {
        Intent twoPlayers = new Intent(this, TwoPlayersParametersActivity.class);
        startActivity(twoPlayers);
    }
}
