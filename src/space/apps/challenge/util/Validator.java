/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.util;

import android.widget.EditText;

/**
 * Contains all the validation functionality required by
 * the application.
 * 
 * @author samuel
 */
public class Validator {

    public Validator() {
    }    
    /**
     * Checks whether a certain field is empty.
     *
     * @param tf - Text Area to be checked.
     * @return
     */
    public boolean isEmpty(EditText et) {
        return (et.getText().toString().trim().equals("") || et.getText().toString() == null)
                ? true
                : false;
    }
       
}
