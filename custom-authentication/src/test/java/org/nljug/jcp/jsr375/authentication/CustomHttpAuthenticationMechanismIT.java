package org.nljug.jcp.jsr375.authentication;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nljug.jcp.jsr375.test.web.TestServlet;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.nljug.jcp.jsr375.test.util.HttpConnectionWrapper.getResponseCode;
import static org.nljug.jcp.jsr375.test.util.MavenShrinkWrapper.wrap;
import static org.nljug.jcp.jsr375.test.web.TestServlet.*;

@RunWith(Arquillian.class)
public class CustomHttpAuthenticationMechanismIT {

    @ArquillianResource
    private URL base;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return wrap(CustomIdentityStore.class, CustomHttpAuthenticationMechanism.class, TestServlet.class);
    }

    @Test
    public void should_return_401_on_contextpath() throws Exception {
        int statusCode = getResponseCode(base, "GET");
        assertEquals(401, statusCode);
    }

    @Test
    public void should_return_401_on_testpath() throws Exception {
        URL testPath = new URL(base.toExternalForm() + URL.substring(1));
        int statusCode = getResponseCode(testPath, "GET");
        assertEquals(401, statusCode);
    }

    @Test
    public void should_return_200_on_testpath() throws Exception {
        String url = base.toExternalForm() + URL.substring(1) + "?username=admin&password=admin";
        URL testPath = new URL(url);
        int statusCode = getResponseCode(testPath, "GET");
        assertEquals(200, statusCode);
    }

    @Test
    public void should_return_401_on_invalid_credentials() throws Exception {
        String url = base.toExternalForm() + URL.substring(1) + "?username=evil&password=evil";
        URL testPath = new URL(url);
        int statusCode = getResponseCode(testPath, "GET");
        assertEquals(401, statusCode);
    }

}
