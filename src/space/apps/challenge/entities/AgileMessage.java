/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.entities;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the message class that will be used in strog
 * @author samuel
 */
public class AgileMessage {
    @Expose
    int code;
    @Expose
    List <String> messages = new ArrayList<String>();
    @Expose
    List<Agile> data = new ArrayList<Agile>();

    public void setData(List<Agile> data) {
        this.data = data;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Agile> getData() {
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
