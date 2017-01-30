package org.nljug.jcp.jsr375.rest;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.security.authentication.mechanism.http.annotation.BasicAuthenticationMechanismDefinition;
import javax.security.identitystore.annotation.Credentials;
import javax.security.identitystore.annotation.EmbeddedIdentityStoreDefinition;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.nljug.jcp.jsr375.rest.Endpoint.URL;

@Path(URL)
@DeclareRoles({"role1", "role2"})
@RolesAllowed({ "role1" })
public class Endpoint {

    public static final String URL = "/test";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        return Response.status(200).entity("test page ok").build();
    }


}
