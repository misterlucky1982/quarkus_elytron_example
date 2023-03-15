package nby.misterlucky.quarkus.auth;

import nby.misterlucky.quarkus.identity.User;

import javax.ws.rs.core.SecurityContext;

public interface IAuthenticationContext {
    User getCurrentUser(SecurityContext context);
}
