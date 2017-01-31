package org.nljug.jcp.jsr375.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import static org.nljug.jcp.jsr375.rest.RestApplication.REST_ROOT;

@ApplicationPath(REST_ROOT)
public class RestApplication extends Application {

    public static final String REST_ROOT = "/resources";

}
