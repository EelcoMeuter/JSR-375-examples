package org.nljug.jcp.jsr375.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import static org.nljug.jcp.jsr375.rest.Endpoint.URL;

@Path(URL)
public class Endpoint {

    public static final String URL = "/test";

    @GET
    public Response test() {
        return Response.status(200).entity("test page ok").build();
    }


}
