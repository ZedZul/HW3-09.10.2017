package com.zedzul.github.hw3_09102017.gson;

import com.zedzul.github.hw3_09102017.IUser;

import java.util.List;

public interface IUsersListGson {
    List<UserWrapperGson> getUsersList() throws Exception;
}
