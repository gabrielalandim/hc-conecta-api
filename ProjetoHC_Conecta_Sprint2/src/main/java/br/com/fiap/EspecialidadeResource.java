package br.com.fiap;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.bo.EspecialidadeBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/especialidade")
public class EspecialidadeResource {

    private EspecialidadeBO especialidadeBO = new EspecialidadeBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Especialidade> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Especialidade>) especialidadeBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Especialidade especialidade, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        especialidadeBO.inserirBo(especialidade);
        return Response.created(null).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Especialidade especialidade, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        especialidade.setId_especialidade(id);
        especialidadeBO.atualizarBo(especialidade);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        especialidadeBO.deletarBo(id);
        return Response.ok().build();
    }
}
