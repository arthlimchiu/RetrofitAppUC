package com.example.clariceann.retrofitappuc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by clariceann on 08/10/16.
 */
public class User {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("location")
    @Expose
    public String location;

    @SerializedName("email")
    @Expose
    public String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
