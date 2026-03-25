package fr.polytech;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/_health")
public class HealthResource {

    @GET
    public Response health() {
        return Response.noContent().build(); // 204
    }
}
