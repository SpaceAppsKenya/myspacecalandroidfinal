/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.io;

import android.content.Context;
import android.widget.Toast;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 * Create a custom Http Client.
 *
 * @author samuel
 */
public class CustomHTTP<T> {

    Class<T> entityClass;
    private String url;
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    HttpClient httpclient;
    HttpPost httppost;
    private byte[] result;
    private HttpResponse response;

    Context context;
    public CustomHTTP(Context context,String url) {
        this.url = url;
        httpclient = new DefaultHttpClient();
        httppost = new HttpPost(this.url);
        this.context = context;
    }

    public void addParameter(String key, String object) {
        nameValuePairs.add(new BasicNameValuePair(key, object));
    }

    /**
     * Connect to the world.
     */
    public void connect() {
        try {
            //set Entity
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            // Execute HTTP Post Request
            response = httpclient.execute(httppost);
            ByteArrayOutputStream outstream = new ByteArrayOutputStream();
            response.getEntity().writeTo(outstream);
            result = outstream.toByteArray();
        } catch (ClientProtocolException e) {
            Toast.makeText(context,"Client Protocol exception", Toast.LENGTH_LONG).show();
        } catch (IOException e) {     
            Toast.makeText(context,"IO error occured", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Return the result in the form of a byte array
     *
     * @return
     */
    public byte[] getResult() {
        return result;
    }

    /**
     * Return the result in form of a String.
     *
     * @return
     */
    @Override
    public String toString() {
        return new String(getResult());
    }

    /**
     * Constructs a class from the serialized JSON
     *
     * @param T - Class to be constructed
     * @return
     */
    public T getNamedClass() {
        Gson gson = new Gson();
        return gson.fromJson(this.toString(), entityClass);
    }

    /**
     * Help bind a custom Output Stream.
     */
    public OutputStream bindtoOutPutStream(OutputStream out) {
        try {
            response.getEntity().writeTo(out);
            return out;
        } catch (IOException ex) {
            return null;
        }
    }
}
