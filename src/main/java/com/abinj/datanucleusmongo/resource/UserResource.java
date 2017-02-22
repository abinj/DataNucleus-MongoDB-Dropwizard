package com.abinj.datanucleusmongo.resource;

import com.abinj.datanucleusmongo.dao.UserDAO;
import com.abinj.datanucleusmongo.model.User;
import com.abinj.datanucleusmongo.utilities.MongoUtil;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by dxuser on 8/2/17.
 */
@Path("/user")
public class UserResource {

    @Path("/insert")
    @PUT
    public Response insertUser() {
        UserDAO.addProduct();
        return Response.ok().status(Response.Status.OK).build();
    }

//    @Path("/get-user")
//    @POST
//    public Response getUser() {
//        MongoUtil.getPm().currentTransaction().begin();
//
//    }
}
