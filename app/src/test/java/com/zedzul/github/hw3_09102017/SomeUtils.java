package com.zedzul.github.hw3_09102017;

import java.io.InputStream;
import java.util.Scanner;

public final class SomeUtils {

    public static String inputStreamToString(final InputStream pInputStream) throws Exception {
        final Scanner s = new Scanner(pInputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
