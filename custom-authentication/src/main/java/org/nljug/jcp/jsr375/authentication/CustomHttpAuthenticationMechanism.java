package org.nljug.jcp.jsr375.authentication;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.AuthStatus;
import javax.security.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestScoped
public class CustomHttpAuthenticationMechanism implements HttpAuthenticationMechanism {

    @Inject
    //FIXME

    /**
     * This method gets the username and password request parameters and validates them against the injected handler.
     * The container is notified about the login via the httpMessageContext upon success.
     * @param request
     * @param response
     * @param httpMessageContext
     * @return
     * @throws AuthException thrown when the authentication fails
     */
    @Override
    public AuthStatus validateRequest(HttpServletRequest request, HttpServletResponse response,
            HttpMessageContext httpMessageContext) throws AuthException {
        //FIXME
    }
}
