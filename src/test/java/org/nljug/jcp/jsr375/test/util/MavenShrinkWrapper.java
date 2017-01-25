package org.nljug.jcp.jsr375.test.util;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;

public class MavenShrinkWrapper {

    public static WebArchive wrap(Class... classes) {
        File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
                            .withTransitivity().asFile();
        return ShrinkWrap.create(WebArchive.class).addClasses(classes).addAsLibraries(files)
                         .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
