/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.entities;

import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 * Bean containing the agile satellite data.
 *
 * @author samuel
 */
public class Agile {

    @Expose
    String id;
    @Expose
    String satellite_id;
    @Expose
    String target;
    @Expose
    String target_name;
    @Expose
    String observation_id;
    @Expose
    String revolution;
    @Expose
    String ra;
    @Expose
    String dec;
    @Expose
    Date start_time;
    @Expose
    Date end_time;    
    Date created_at;    
    Date updated_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObservation_id() {
        return observation_id;
    }

    public void setObservation_id(String observation_id) {
        this.observation_id = observation_id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getRevolution() {
        return revolution;
    }

    public void setRevolution(String revolution) {
        this.revolution = revolution;
    }

    public String getSatellite_id() {
        return satellite_id;
    }

    public void setSatellite_id(String satellite_id) {
        this.satellite_id = satellite_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getTarget_name() {
        return target_name;
    }

    public void setTarget_name(String target_name) {
        this.target_name = target_name;
    }
    /**
     * {
     * "code": 200, "messages": [ "Retrieval Successful" ], "data": [ { "id":
     * "1", "satellite_id": "1", "target": "VELA PSR ", "target_name": null,
     * "observation_id": "OB100 ", "revolution": null, "ra": "128.489", "dec":
     * "-45.192", "start_time": "2007-05-24 12:00", "end_time": "2007-06-04
     * 12:00", "created_at": "2013-04-20 12:29:56", "updated_at": "2013-04-20
     * 12:29:56" }, { "id": "2", "satellite_id": "1", "target": "SA "Empty"
     * Field", "target_name": null, "observation_id": "OB300,310,320",
     * "revolution": null, "ra": "162.26", "dec": "0.66", "start_time":
     * "2007-06-04 12:00", "end_time": "2007-06-28 12:00", "created_at":
     * "2013-04-20 12:29:57", "updated_at": "2013-04-20 12:29:57" } 15:43 Larry
     * Githaiga
     *
     * ]
     * }
     */
}
