package org.nljug.jcp.jsr375.test.util;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;
import java.nio.file.Paths;

public class MavenShrinkWrapper {

    private static final String WEBINF_PATH = "src/main/webapp/WEB-INF";

    public static WebArchive wrap(Class... classes) {
        File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
                            .withTransitivity().asFile();
        WebArchive war = ShrinkWrap.create(WebArchive.class, "jsr375.war").addClasses(classes).addAsLibraries(files)
                                   .addAsWebInfResource(Paths.get(WEBINF_PATH, "beans.xml").toFile())
                                   .addAsWebInfResource(Paths.get(WEBINF_PATH, "jboss-web.xml").toFile());
        return war;
    }

}
