package com.jose.prueba.services;

/**
 * Created by optimus-desarrollo on 06/05/17.
 */
import com.jose.prueba.controllers.TestUser;
import com.jose.prueba.entities.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Example {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;
        TestUser test = new TestUser();
        test.testUser();
        return Response.status(200).entity(output).build();

    }

}
