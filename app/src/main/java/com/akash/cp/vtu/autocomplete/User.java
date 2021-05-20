package com.akash.cp.vtu.autocomplete;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hendraanggrian.appcompat.widget.Mentionable;

public class User  {
    private int id;
    private String name;
    private String profileUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public User(int id, String name, String profileUrl) {
        this.id = id;
        this.name = name;
        this.profileUrl = profileUrl;
    }
    public User()
    {}


}
