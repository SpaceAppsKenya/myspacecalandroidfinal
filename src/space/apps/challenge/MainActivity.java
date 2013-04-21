package space.apps.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Runnable;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import space.apps.challenge.customui.CustomSimpleDialog;
import space.apps.challenge.entities.Agile;
import space.apps.challenge.entities.AgileMessage;
import space.apps.challenge.entities.SatelliteMessage;
import space.apps.challenge.io.CustomHttpGet;
import space.apps.challenge.util.Assets;

public class MainActivity extends Activity implements Runnable, View.OnClickListener {

//    CustomHTTP<String> http = null;
    CustomHttpGet httpGet = null;
    EditText result = null;
    Button satellites, schedule;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Assets.context = this;
        setContentView(init());

//        http = new CustomHTTP<String>(this, "http://sats.sapamatech.com/home/schedule/get/1?per_page=3&p/age=5");

        Toast.makeText(this, "Getting the text.", Toast.LENGTH_SHORT).show();

        //create a thread.
        Thread t = new Thread(this);

        //run on a separate thread.
        new android.os.Handler().post(t);

//        Assets.progressDialog = ProgressDialog.show(this, "", "Loading App details..", true);


    }

    public View init() {
        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        result = new EditText(this);
//        result.setHint("result will appear here..");
        schedule = new Button(this);
        schedule.setText("Schedule");
        schedule.setOnClickListener(this);

        layout.addView(schedule);

        satellites = new Button(this);
        satellites.setText("Satellites");
        satellites.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(Assets.context, SatelliteListViewActivity.class);
                startActivity(i);
//                new CustomSimpleDialog(Assets.context,"","Clicked!", "Okay");
            }
        });

        layout.addView(satellites);

        return layout;
    }

    public void run() {
        try {
            httpGet = new CustomHttpGet();

            String response = executeHttpGet("http://sats.sapamatech.com/home/schedule/2get/1");
            Assets.agile_messages = Assets.gson.fromJson(response, AgileMessage.class);


            response = executeHttpGet("http://sats.sapamatech.com/home/schedule/get/2");
            AgileMessage agile2 = Assets.gson.fromJson(response, AgileMessage.class);


            response = executeHttpGet("http://sats.sapamatech.com/home/satellite/details/");
            Assets.satellite_message = Assets.gson.fromJson(response, SatelliteMessage.class);

            //merge the satellite details
            for (Agile a : agile2.getData()) {
                Assets.agile_messages.getData().add(a);
            }

            if (Assets.agile_messages.getData().isEmpty()) {
                new CustomSimpleDialog(this, "Finished", "Agile is empty", "Okay");
            }

            if (Assets.satellite_message.getData().isEmpty()) {
                new CustomSimpleDialog(this, "Finished", "Satellite is empty", "Okay");
            }

            //stop the diaalogue.
//            Assets.progressDialog.dismiss();
        } catch (Exception ex) {
            Log.i("MainActivity", "Exception");
        }

    }

    public String executeHttpGet(String url) throws Exception {
        BufferedReader in = null;
        String page = "";
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            page = sb.toString();

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return page;
    }

    public void onClick(View arg0) {
        //start activity intent.
        if (arg0.equals(schedule)) {
            Intent i = new Intent(this, AgileListViewActivity.class);
            startActivity(i);
        }

        if (arg0.equals(satellites)) {
            Intent i = new Intent(this, SatelliteListViewActivity.class);
            startActivity(i);
        }
    }
}
