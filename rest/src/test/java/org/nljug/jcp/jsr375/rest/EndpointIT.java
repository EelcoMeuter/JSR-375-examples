package org.nljug.jcp.jsr375.rest;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.nljug.jcp.jsr375.rest.Endpoint.URL;
import static org.nljug.jcp.jsr375.rest.RestApplication.REST_ROOT;
import static org.nljug.jcp.jsr375.test.util.HttpConnectionWrapper.getResponseCode;
import static org.nljug.jcp.jsr375.test.util.MavenShrinkWrapper.wrap;

@RunWith(Arquillian.class)
public class EndpointIT {

    @ArquillianResource
    private URL base;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return wrap(Endpoint.class, RestApplication.class);
    }

    @Test
    public void should_unauthenticate_endpoint() throws Exception {
        URL testPath = new URL(base.toExternalForm() + REST_ROOT.substring(1) + URL);
        int statusCode = getResponseCode(testPath, "GET");
        assertEquals(401, statusCode);
    }

    @Test
    public void should_access_endpoint() throws Exception {
        URL testPath = new URL(base.toExternalForm() + REST_ROOT.substring(1) + URL + "?username=admin&password=admin");
        int statusCode = getResponseCode(testPath, "GET");
        assertEquals(200, statusCode);
    }


}
