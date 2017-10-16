package com.zedzul.github.hw3_09102017.mocks;

import junit.framework.Assert;

import java.io.FileInputStream;
import java.io.InputStream;

public final class MockHttpClient {

    public static InputStream mockRequest(final String pFileName) throws Exception {
        final InputStream result = new FileInputStream(pFileName);
        Assert.assertNotNull("File not found", result);
        return result;
    }
}
