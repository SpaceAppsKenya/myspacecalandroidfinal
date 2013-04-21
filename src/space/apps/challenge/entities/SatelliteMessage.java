/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.entities;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samuel
 */
public class SatelliteMessage {
    
    @Expose
    int code;
    
    @Expose
    List <String> messages = new ArrayList<String>();
    
    @Expose
    List<Satellite> data = new ArrayList<Satellite>();

    public void setData(List<Satellite> data) {
        this.data = data;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Satellite> getData() {
        return data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}
