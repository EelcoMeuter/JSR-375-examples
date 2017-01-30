package org.nljug.jcp.jsr375.test.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionWrapper {

    public static int getResponseCode(URL url, String method) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.connect();
        int statusCode = connection.getResponseCode();
        connection.disconnect();
        return statusCode;
    }
}
