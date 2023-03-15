package nby.misterlucky.quarkus.web;


import nby.misterlucky.quarkus.auth.IAuthenticationContext;
import nby.misterlucky.quarkus.identity.User;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/common")
public class GreetingResource {

    /*
     * fixme not sure if it is the best implementation of this logic
     *  there might be more correct way to get access to User`s data
     */
    @Inject
    IAuthenticationContext authenticationContext;

    @GET
    @Path("/open")
    @Produces(MediaType.TEXT_PLAIN)
    public String openResource() {
        return "HELLO!!!";
    }

    @GET
    @PermitAll
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String commonResource(@Context SecurityContext context) {
        String greeting;
        if (context.getUserPrincipal() != null) {
            User user = authenticationContext.getCurrentUser(context);
            greeting = "Hi, " + user.firstName + " " + user.lastName.toUpperCase() + "!";
        } else {
            greeting = "Hi! You are currently unauthorised.";
        }
        return greeting;
    }

    @GET
    @RolesAllowed("admin")
    @Path("/admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String adminResource(@Context SecurityContext context) {
        User user = authenticationContext.getCurrentUser(context);
        return "HELLO, " + user.firstName + " " + user.lastName.toUpperCase() + "!!!";
    }

    @GET
    @RolesAllowed("user")
    @Path("/user")
    @Produces(MediaType.TEXT_PLAIN)
    public String userResource(@Context SecurityContext context) {
        User user = authenticationContext.getCurrentUser(context);
        return "HELLO, " + user.firstName + " " + user.lastName.toUpperCase() + "!!!";
    }

    @GET
    @RolesAllowed("custom")
    @Path("/custom")
    @Produces(MediaType.TEXT_PLAIN)
    public String customResource(@Context SecurityContext context) {
        User user = authenticationContext.getCurrentUser(context);
        return "HELLO, " + user.firstName + " " + user.lastName.toUpperCase() + "!!!";
    }

    @GET
    @RolesAllowed({"admin", "custom"})
    @Path("/non_user")
    @Produces(MediaType.TEXT_PLAIN)
    public String nonUserResource(@Context SecurityContext context) {
        User user = authenticationContext.getCurrentUser(context);
        return "HELLO, " + user.firstName + " " + user.lastName.toUpperCase() + "!!!";
    }
}