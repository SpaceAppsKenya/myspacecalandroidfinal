/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 *
 * @author samuel
 */
public class CustomSimpleDialog {

    String message, title, buttonText;
    static Context context;

    public CustomSimpleDialog(Context context, String title, String message, String buttonText) {
        this.context = context;
        this.title = title;
        this.message = message;
        this.buttonText = buttonText;
        createDialogue();
    }

    private void createDialogue() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.context);

        // set title
        alertDialogBuilder.setTitle(this.title);

        // set dialog message
        alertDialogBuilder.setMessage(message);       
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton(this.buttonText, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                arg0.cancel();                
            }
        });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
