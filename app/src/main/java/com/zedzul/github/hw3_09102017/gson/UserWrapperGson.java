package com.zedzul.github.hw3_09102017.gson;

import com.zedzul.github.hw3_09102017.IUser;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

class UserWrapperGson implements IUser {

    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("avatar_url")
    private String mAvatar_url;
    @SerializedName("dob")
    private long mDateOfBirth;



    @Override
    public long getId() {
        return mId;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public Date getDateOfBirth() throws Exception {
        return new Date(mDateOfBirth);
    }

    @Override
    public String getAvatarUrl() {
        return mAvatar_url;
    }
}
