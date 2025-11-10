package br.com.fiap;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.bo.AgendamentoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/agendamento")
public class AgendamentoResource {

    private AgendamentoBO agendamentoBO = new AgendamentoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Agendamento> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Agendamento>) agendamentoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Agendamento agendamento, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        agendamentoBO.inserirBo(agendamento);
        return Response.created(null).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Agendamento agendamento, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        agendamento.setId_agendamento(id);
        agendamentoBO.atualizarBo(agendamento);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        agendamentoBO.deletarBo(id);
        return Response.ok().build();
    }
}
