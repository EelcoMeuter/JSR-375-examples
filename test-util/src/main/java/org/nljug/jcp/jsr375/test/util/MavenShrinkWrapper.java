package org.nljug.jcp.jsr375.test.util;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class MavenShrinkWrapper {

    private static final String WEB_PATH = "src/main/webapp/";

    public static WebArchive wrap(Class... classes) {
        File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
                            .withTransitivity().asFile();
        WebArchive war = ShrinkWrap.create(WebArchive.class, "jsr375.war").addClasses(classes).addAsLibraries(files)
                                   .addAsWebInfResource(Paths.get(WEB_PATH, "WEB-INF/beans.xml").toFile())
                                   .addAsWebInfResource(Paths.get(WEB_PATH, "WEB-INF/jboss-web.xml").toFile());
        return war;
    }

    public static WebArchive wrap(String[] facelets, Class... classes) {
        File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
                            .withTransitivity().asFile();
        WebArchive war = ShrinkWrap.create(WebArchive.class, "jsr375.war").addClasses(classes).addAsLibraries(files)
                                   .addAsWebInfResource(Paths.get(WEB_PATH, "WEB-INF/beans.xml").toFile())
                                   .addAsWebInfResource(Paths.get(WEB_PATH, "WEB-INF/jboss-web.xml").toFile())
                                   .addAsWebInfResource(Paths.get(WEB_PATH, "WEB-INF/web.xml").toFile())
                                   .addAsWebInfResource(Paths.get(WEB_PATH, "WEB-INF/jboss-web.xml").toFile());
        Arrays.stream(facelets).forEach(
                facelet -> war.addAsWebResource(Paths.get(WEB_PATH, facelet).toFile(), facelet));
        return war;
    }
}
