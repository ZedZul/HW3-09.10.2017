package com.zedzul.github.hw3_09102017;

import java.util.Date;

public interface IUser {

    long getId();

    String getName();

    Date getDateOfBirth() throws Exception;

    String getAvatarUrl();

}
