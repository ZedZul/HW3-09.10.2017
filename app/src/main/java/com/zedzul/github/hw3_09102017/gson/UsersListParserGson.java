package com.zedzul.github.hw3_09102017.gson;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class UsersListParserGson implements IUsersListParserGson {

    private final InputStream mIntputStream;

    public UsersListParserGson(final InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUsersListGson parse() throws Exception {
        final Reader reader = new InputStreamReader(mIntputStream);
        final UserWrapperGson[] result = new Gson().fromJson(reader, UserWrapperGson[].class);
        return new UsersListWrapperGson(Arrays.asList(result));
    }
}
