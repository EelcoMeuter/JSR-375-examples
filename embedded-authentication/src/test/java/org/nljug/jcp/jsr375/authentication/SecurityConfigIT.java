package org.nljug.jcp.jsr375.authentication;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nljug.jcp.jsr375.web.TestServlet;

import java.net.PasswordAuthentication;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.nljug.jcp.jsr375.test.util.HttpConnectionWrapper.getResponseCode;
import static org.nljug.jcp.jsr375.test.util.MavenShrinkWrapper.wrap;

@RunWith(Arquillian.class)
public class SecurityConfigIT {

    @ArquillianResource
    private URL base;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return wrap(SecurityConfig.class, TestServlet.class);
    }

    @Test
    public void should_unauthenticate_servlet() throws Exception {
        URL testPath = new URL(base.toExternalForm() + TestServlet.URL.substring(1));
        int statusCode = getResponseCode(testPath, "GET");
        assertEquals(401, statusCode);
    }

    @Test
    public void should_access_servlet() throws Exception {
        URL testPath = new URL(base.toExternalForm() + TestServlet.URL.substring(1));
        int statusCode = getResponseCode(testPath, "GET", new PasswordAuthentication("admin", "admin".toCharArray()));
        assertEquals(200, statusCode);
    }
}
