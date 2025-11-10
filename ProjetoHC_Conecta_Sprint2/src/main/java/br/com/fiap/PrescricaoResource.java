package br.com.fiap;

import br.com.fiap.beans.Prescricao;
import br.com.fiap.bo.PrescricaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/prescricao")
public class PrescricaoResource {

    private PrescricaoBO prescricaoBO = new PrescricaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Prescricao> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Prescricao>) prescricaoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Prescricao prescricao, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        prescricaoBO.inserirBo(prescricao);
        return Response.created(null).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Prescricao prescricao, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        prescricao.setId_prescricao(id);
        prescricaoBO.atualizarBo(prescricao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        prescricaoBO.deletarBo(id);
        return Response.ok().build();
    }
}