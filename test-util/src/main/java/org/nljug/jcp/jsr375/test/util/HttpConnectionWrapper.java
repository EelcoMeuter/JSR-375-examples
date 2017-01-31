package org.nljug.jcp.jsr375.test.util;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpConnectionWrapper {

    public static int getResponseCode(URL url, String method) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.connect();
        int statusCode = connection.getResponseCode();
        connection.disconnect();
        return statusCode;
    }

    public static int getResponseCode(URL url, String method, PasswordAuthentication authentication)
            throws IOException {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        });
        return getResponseCode(url, method);
    }

    public static Map<String, List<String>> getResponseHeaders(URL url, String method, PasswordAuthentication
            authentication)
            throws IOException {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        });
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        connection.connect();
        Map<String, List<String>> headers = connection.getHeaderFields();
        connection.disconnect();
        return headers;

    }

}
