package com.zedzul.github.hw3_09102017.http;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String url);
}
