package com.zedzul.github.hw3_09102017.json;

import org.json.JSONArray;

public class UsersListParserJsonArray implements IUsersListParser {

    private JSONArray mJSONArray;

    public UsersListParserJsonArray(final String pSource) throws Exception{
        mJSONArray = new JSONArray(pSource);
    }

    @Override
    public IUsersList parse() throws Exception{
        return new UsersListWrapperJson(mJSONArray);
    }
}
