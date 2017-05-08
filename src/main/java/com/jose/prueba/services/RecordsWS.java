package com.jose.prueba.services;

/**
 * Created by optimus-desarrollo on 07/05/17.
 */

import com.jose.prueba.entities.Record;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.jose.prueba.controllers.RecordController;
import org.postgresql.util.PGmoney;

@Path("/records")
public class RecordsWS {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Record> getRecordsBrowser() {
        List<Record> records = new ArrayList<Record>();
        RecordController recordController = new RecordController();
        records.addAll(recordController.getAll());
        return records;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newTodo(@FormParam("name") String name,
                        @FormParam("amount") BigDecimal amount,
                        @Context HttpServletResponse servletResponse) throws IOException {
        RecordController recordController = new RecordController();
        recordController.requestMoney(name, amount);
        servletResponse.sendRedirect("../");
    }

    @GET @Path("/deliver/{param}")
    public void update(@PathParam("param") String id, @Context HttpServletResponse servletResponse) throws IOException {
        RecordController recordController = new RecordController();
        recordController.deliver(Integer.parseInt(id));
        servletResponse.sendRedirect("../");
    }
}
