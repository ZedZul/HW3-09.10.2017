package com.zedzul.github.hw3_09102017.Mocks;

import junit.framework.Assert;

import java.io.InputStream;

public class MockHttpClient {
    public InputStream mockRequest(final String pFileName){
        final InputStream result = this.getClass().getResourceAsStream(pFileName);
        Assert.assertNotNull("File not found", result);
        return result;
    }
}
