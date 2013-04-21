/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge.entities;

import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 *
 * @author samuel
 */
public class Satellite {

//    {
//        "code"
//        
//            :200,
//    "messages":["Retrieval Successful"],
//    "data":[{
//    "id"
//        
//        :"1",
//    "name":"Agile",
//    "image_url":"img\/satimgs\/wdO1rLFTRw4dmH2kKMmAGFUxGoX4nvZt.jpeg",
//    "companies":"ASI",
//    "orbit_height":"340 miles",
//    "type":"X-ray and Gamma ray ",
//    "description":"AGILE (Astro\u2010rivelatore Gamma a Immagini LEggero) is an X-ray and Gamma ray astronomical satellite of the Italian Space Agency (ASI). AGILE mission is aimed to the observation of the Gamma-Ray sources in the universe. The AGILE\u2019s instrumentation combines a gamma-ray imager (GRID) (sensitive in the energy range 30 MeV-50 GeV), a hard X-ray imager and monitor: Super- AGILE (sensitive in the range 18-60 KeV), a calorimeter (sensitive in the range 350 KeV-100 MeV) (MCAL), and an anticoincidence system (AC), based on plastic scintillator.",
//    "website":"http:\/\/agile.rm.iasf.cnr.it\/",
//    "launch_date":" 23 April 2007",
//    "launch_location":" SDSC",
//    "created_at":"2013-04-20 19:52:57",
//    "updated_at":"2013-04-20 19:52:57"}
//    ]}
    @Expose
    String id;
    @Expose
    String name;
    @Expose
    String image_url;
    @Expose
    String companies;
    @Expose
    String orbit_height;
    @Expose
    String type;
    @Expose
    String description;
    @Expose
    String website;
    @Expose
    String launch_date;
    @Expose
    String launch_location;
    @Expose
    String created_at;
    @Expose
    String updated_at;

    public String getCompanies() {
        return companies;
    }

    public void setCompanies(String companies) {
        this.companies = companies;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public String getLaunch_location() {
        return launch_location;
    }

    public void setLaunch_location(String launch_location) {
        this.launch_location = launch_location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrbit_height() {
        return orbit_height;
    }

    public void setOrbit_height(String orbit_height) {
        this.orbit_height = orbit_height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
