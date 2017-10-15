package com.zedzul.github.hw3_09102017.gson;

import com.google.gson.Gson;
import com.zedzul.github.hw3_09102017.IUser;
import com.zedzul.github.hw3_09102017.IUserParser;

public class UserParserGson implements IUserParser {

    private final String mSource;

    UserParserGson(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        return new Gson().fromJson(mSource, UserWrapperGson.class);
    }
}
