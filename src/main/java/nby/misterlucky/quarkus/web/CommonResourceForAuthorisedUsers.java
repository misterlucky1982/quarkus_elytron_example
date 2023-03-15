package nby.misterlucky.quarkus.web;


import nby.misterlucky.quarkus.auth.IAuthenticationContext;
import nby.misterlucky.quarkus.identity.User;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/common")
public class CommonResourceForAuthorisedUsers {

    /*
     * fixme not sure if it is the best implementation of this logic
     *  there might be more correct way to get access to User`s data
     */
    @Inject
    IAuthenticationContext authenticationContext;

    @GET
    @PermitAll
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String publicResource(@Context SecurityContext context) {
        User user = authenticationContext.getCurrentUser(context);
        return "HELLO, " + user.firstName + " " + user.lastName.toUpperCase() + "!!!";
    }
}