package org.nljug.jcp.jsr375.test.web;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static org.nljug.jcp.jsr375.test.web.TestServlet.URL;

@DeclareRoles({ "role1", "role2" })
@WebServlet(URL)
public class TestServlet extends HttpServlet {

    public static final String URL = "/test";

    private static final Logger log= Logger.getLogger(TestServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("SUCCESS!! Accessed test servlet. YEAH!");
    }
}
