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
}
