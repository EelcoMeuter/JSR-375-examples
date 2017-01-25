package org.nljug.jcp.jsr375.authentication;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.security.identitystore.IdentityStore;

import static org.junit.Assert.assertNotNull;
import static org.nljug.jcp.jsr375.test.util.MavenShrinkWrapper.wrap;

@RunWith(Arquillian.class)
public class CustomIdentityStoreIT {

    @Deployment
    public static WebArchive createDeployment() {
        return wrap(CustomIdentityStore.class);
    }

    @Inject
    private IdentityStore store;

    @Test
    public void should_wire_correctly() {
        assertNotNull(store);
    }

}
