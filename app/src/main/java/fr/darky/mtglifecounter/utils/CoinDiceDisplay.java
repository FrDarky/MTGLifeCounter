package fr.darky.mtglifecounter.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class CoinDiceDisplay {

    // Context
    private Context ctx;

    // Dialog
    private AlertDialog dialog;

    // RNG Values
    private String coin = "Heads";
    private int d4 = 1;
    private int d6 = 1;
    private int d20 = 1;

    public CoinDiceDisplay(Context context) {
        ctx = context;
        displayWindow();
    }

    private void displayWindow() {
        setValues();

        final AlertDialog.Builder alertDialogBuilder =
                new AlertDialog.Builder(ctx)
                        .setTitle("Coin flip and dice rolls:")
                        .setMessage("Coin: "+ coin +"\nD4: "+ d4 +"\nD6: "+ d6 +"\nD20: "+ d20)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        // Display the AlertDialog
        dialog = alertDialogBuilder.show();
    }

    private void setValues() {
        // Coin
        if((int)(Math.random() * 2) == 0) {
            coin = "Heads";
        } else {
            coin = "Tails";
        }

        // Dices
        d4  = (int)(Math.random() * 4  + 1);
        d6  = (int)(Math.random() * 6  + 1);
        d20 = (int)(Math.random() * 20 + 1);
    }
}
