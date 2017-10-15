package com.zedzul.github.hw3_09102017.json;

import com.zedzul.github.hw3_09102017.IUser;
import com.zedzul.github.hw3_09102017.IUserParser;

import org.json.JSONObject;

public class UserParserJsonObject implements IUserParser {

    private final String mSource;

    public UserParserJsonObject(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(mSource);
        return new UserWrapperJson(jsonObject);
    }
}
