package fr.polytech;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/city")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CityResource {

    @POST
    @Transactional
    public Response create(City city) {
        city.id = null;
        city.persist();
        return Response.status(Response.Status.CREATED).entity(city).build();
    }

    @GET
    public List<City> list() {
        return City.listAll();
    }

    @GET
    @Path("/count")
    public long count() {
        return City.count() - 1;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Integer id) {
        City city = City.findById(id);
        if (city == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        city.delete();
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        City city = City.findById(id);
        if (city == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(city).build();
    }
}
