package com.zedzul.github.hw3_09102017.gson;


import java.util.List;

class UsersListWrapperGson implements IUsersListGson {
    private final List<UserWrapperGson> mUsersList;

    UsersListWrapperGson(final List<UserWrapperGson> pUsersList) {
        mUsersList = pUsersList;
    }

    @Override
    public List<UserWrapperGson> getUsersList() throws Exception {
        return mUsersList;
    }
}
