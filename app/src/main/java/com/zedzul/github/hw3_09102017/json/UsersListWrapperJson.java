package com.zedzul.github.hw3_09102017.json;

import com.zedzul.github.hw3_09102017.IUser;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

class UsersListWrapperJson implements IUsersList {

    private final JSONArray mJSONArray;

    UsersListWrapperJson(final JSONArray pJSONArray) {
        mJSONArray = pJSONArray;
    }

    @Override
    public List<IUser> getUsersList() throws Exception {
        final List<IUser> result = new ArrayList<>();
        for (int i = 0; i < mJSONArray.length(); i++) {
            result.add(new UserWrapperJson(mJSONArray.getJSONObject(i)));
        }
        return result;
    }
}
