package br.com.fiap;

import br.com.fiap.beans.Anamnese;
import br.com.fiap.bo.AnamneseBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/anamnese")
public class AnamneseResource {

    private AnamneseBO anamneseBO = new AnamneseBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Anamnese> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Anamnese>) anamneseBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Anamnese anamnese, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        anamneseBO.inserirBo(anamnese);
        return Response.created(null).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Anamnese anamnese, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        anamnese.setId_anamnese(id);
        anamneseBO.atualizarBo(anamnese);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        anamneseBO.deletarBo(id);
        return Response.ok().build();
    }
}
