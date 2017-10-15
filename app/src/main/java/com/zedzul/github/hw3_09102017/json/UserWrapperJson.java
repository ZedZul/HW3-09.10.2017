package com.zedzul.github.hw3_09102017.json;

import com.zedzul.github.hw3_09102017.IUser;

import org.json.JSONObject;

import java.util.Date;

class UserWrapperJson implements IUser {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String AVATAR_URl = "avatar_url";
    private static final String DATE_OF_BIRTH = "dob";

    private final JSONObject mJsonObject;

    UserWrapperJson(final JSONObject pJsonObject) {
        mJsonObject = pJsonObject;
    }

    @Override
    public long getId() {
        return mJsonObject.optLong(ID);
    }

    @Override
    public String getName() {
        return mJsonObject.optString(NAME);
    }

    @Override
    public Date getDateOfBirth() {
        return new Date(mJsonObject.optLong(DATE_OF_BIRTH));
    }

    @Override
    public String getAvatarUrl() {
        return mJsonObject.optString(AVATAR_URl);
    }
}
