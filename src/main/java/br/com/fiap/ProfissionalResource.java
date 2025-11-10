package br.com.fiap;

import br.com.fiap.beans.Profissional;
import br.com.fiap.bo.ProfissionalBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/profissional")
public class ProfissionalResource {

    private ProfissionalBO profissionalBO = new ProfissionalBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Profissional> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Profissional>) profissionalBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Profissional profissional, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        profissionalBO.inserirBo(profissional);
        return Response.created(null).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Profissional profissional, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        profissional.setId_profissional(id);
        profissionalBO.atualizarBo(profissional);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        profissionalBO.deletarBo(id);
        return Response.ok().build();
    }
}
