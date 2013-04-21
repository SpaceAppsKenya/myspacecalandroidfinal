/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import space.apps.challenge.entities.AgileMessage;
import space.apps.challenge.entities.SatelliteMessage;

/**
 *
 * @author samuel
 */
public class Assets {
    
    public static SatelliteMessage satellite_message;
    
    public static AgileMessage agile_messages;
    
    //Create on gson library to be accessed everywhere in project.
    public static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setDateFormat("yyyy-MM-dd HH:mm")
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    
    
    public Assets() {
    }
    
    
    //only one progress bar in the whole application.
    public static ProgressDialog progressDialog = null;
    
    //stores the contexts of the activity on the fore ground.
    public static Context context = null;
    
    //Initialize the validator
    public static Validator validator = new Validator();
    
    //implements the image downloader instance.
    public static ImageDownloader imageDownloader = setImageDownloader();

    //second implementation of the image downloader instance.
    public static DrawableManager drawableManager = new DrawableManager();
    
    //text to speech engine
    public static TextToSpeech talker = null;
    
    //thread used during the searches.
    public static Thread t = null;
    
    //global co-ordinates of this phone
    public static double longitude, latitude;
    
    static ImageDownloader setImageDownloader() {
        imageDownloader = new ImageDownloader();
        imageDownloader.setMode(ImageDownloader.Mode.NO_DOWNLOADED_DRAWABLE);
        return imageDownloader;
    }
}
