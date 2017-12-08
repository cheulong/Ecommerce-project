package camt.cbsd.controller;

import camt.cbsd.entity.User;
import camt.cbsd.services.UserService;
import org.apache.commons.io.FilenameUtils;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response.ResponseBuilder;
import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

@Component
@Path("/user")
@ConfigurationProperties(prefix = "server")
public class UserController {
    UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() {

        List<User> users = userService.getStudents();
        return Response.ok(users).build();
    }



    @OPTIONS
    public Response checkOK(){
        return Response.ok().build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response uploadOnlyStudent(User user) {

        userService.addUser(user);
        return Response.ok().entity(user).build();

    }





    @POST
    @Path("/student")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadStudent(@FormDataParam("file") InputStream fileInputStream,
                                  @FormDataParam("file") FormDataContentDisposition cdh,
                                  @FormDataParam("student") FormDataBodyPart dataBodyPart) throws Exception {

        BufferedImage img = ImageIO.read(fileInputStream);

        dataBodyPart.setMediaType(MediaType.APPLICATION_JSON_TYPE);
        User user = dataBodyPart.getValueAs(User.class);
        userService.addUser(user,cdh.getFileName(),img);

        return Response.ok(user).build();
    }


}
