package com.zedzul.github.hw3_09102017.json;

import com.zedzul.github.hw3_09102017.IUser;
import com.zedzul.github.hw3_09102017.IUsersList;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class UsersListParserJsonArray implements IUsersList {

    private JSONArray mJSONArray;

    public UsersListParserJsonArray(final String pSource) throws Exception{
        mJSONArray = new JSONArray(pSource);
    }

    @Override
    public List<IUser> getUsersList() throws Exception{
        final List<IUser> result = new ArrayList<>();
        for (int i = 0; i < mJSONArray.length(); i++) {
            result.add(new UserWrapperJson(mJSONArray.getJSONObject(i)));
        }
        return result;
    }
}
