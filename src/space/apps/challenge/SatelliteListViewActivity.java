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
import space.apps.challenge.customui.CustomSimpleDialog;

import space.apps.challenge.entities.Satellite;
import space.apps.challenge.util.Assets;

public class SatelliteListViewActivity extends ListActivity implements Runnable {

    List<Satellite> satellites;

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

//        Assets.progressDialog = ProgressDialog.show(this, "", "Loading Results..", true, true);
        Thread t = new Thread(this);
        t.start();
    }

    private List<Satellite> getModel() {
        satellites = new ArrayList<Satellite>();
        //add notifications to the array adapter.
        for (Satellite s : Assets.satellite_message.getData()) {
            satellites.add(s);
        }
        return satellites;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        WAPod pod = pods.get(position);
//        new CustomSimpleDialog(this, pod.getType(), n.getText(), "Close");        
    }

    public void run() {

//        if (!Assets.satellite_message.getData().isEmpty()) {

//            new CustomSimpleDialog(this, "", "List is not empty", "Okay");
            ArrayAdapter<Satellite> adapter = new SatellitesArrayAdapter(this, Assets.satellite_message.getData());
            setListAdapter(adapter);
//            Assets.progressDialog.dismiss();
//        } else {
////            Assets.progressDialog.dismiss();
//            new CustomSimpleDialog(this, "", "Empty list", "Okay");
//        }
    }
}