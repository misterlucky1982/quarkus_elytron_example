package nby.misterlucky.quarkus.auth;

import nby.misterlucky.quarkus.identity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.SecurityContext;
import java.io.Serializable;

@ApplicationScoped
public class AuthenticationContextImpl implements IAuthenticationContext, Serializable {
    @Override
    public User getCurrentUser(SecurityContext context) {
        return User.findByLogin(context.getUserPrincipal().getName());
    }
}
