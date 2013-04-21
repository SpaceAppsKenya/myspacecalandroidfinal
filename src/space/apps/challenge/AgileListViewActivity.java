/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import space.apps.challenge.entities.Agile;
import space.apps.challenge.util.Assets;

public class AgileListViewActivity extends ListActivity implements Runnable {

    List<Agile> Agiles;

    @Override
    public void onCreate(Bundle icicle) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(icicle);
        Assets.context = this;
        setContentView(R.layout.main);
        LinearLayout linear = (LinearLayout) findViewById(R.id.layout);
        linear.setBackgroundColor(Color.WHITE);

        Assets.progressDialog = ProgressDialog.show(this, "", "Loading Results..", true, true);
        Thread t = new Thread(this);
        t.start();
    }

    private List<Agile> getModel() {
        Agiles = new ArrayList<Agile>();
        //add notifications to the array adapter.
        for (Agile s : Assets.agile_messages.getData()) {
            Agiles.add(s);
        }
        return Agiles;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        WAPod pod = pods.get(position);
//        new CustomSimpleDialog(this, pod.getType(), n.getText(), "Close");        
    }

    public void run() {
        ArrayAdapter<Agile> adapter = new AgileArrayAdapter(this, getModel());
        setListAdapter(adapter);
        Assets.progressDialog.dismiss();
    }
}