package org.nljug.jcp.jsr375.web;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
 
@Path("/")
public class MyCtrl {
 
    @GET
    @Path("/")
    public Response test() {
        return Response.status(200).entity("test page ok").build();
    }
 
}