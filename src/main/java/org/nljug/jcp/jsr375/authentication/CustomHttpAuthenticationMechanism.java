package org.nljug.jcp.jsr375.authentication;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.AuthStatus;
import javax.security.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.authentication.mechanism.http.HttpMessageContext;
import javax.security.identitystore.CredentialValidationResult;
import javax.security.identitystore.IdentityStore;
import javax.security.identitystore.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;
import static javax.security.identitystore.CredentialValidationResult.Status.VALID;

@RequestScoped
public class CustomHttpAuthenticationMechanism implements HttpAuthenticationMechanism {

    @Inject
    private IdentityStore handler;

    @Override
    public AuthStatus validateRequest(HttpServletRequest request, HttpServletResponse response,
            HttpMessageContext httpMessageContext) throws AuthException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            return httpMessageContext.responseUnAuthorized();
        }

        CredentialValidationResult validationResult = handler
                .validate(new UsernamePasswordCredential(username, password));
        if (validationResult.getStatus() != (VALID)) {
            throw new AuthException(" authentication failed");
        }
        return httpMessageContext
                .notifyContainerAboutLogin(validationResult.getCallerPrincipal(), validationResult.getCallerGroups());
    }
}
