package br.com.fiap;

import br.com.fiap.api.Endereco; // Importar Endereco
import br.com.fiap.beans.Paciente;
import br.com.fiap.bo.PacienteBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException; // Necessário para o novo endpoint
import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/paciente")
public class PacienteResource {

    private PacienteBO pacienteBO = new PacienteBO();

    // GET (Listar todos)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Paciente> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Paciente>) pacienteBO.selecionarBo();
    }

    // --- NOVO ENDPOINT ---
    // GET (Buscar Endereço do Paciente pelo ID)
    @GET
    @Path("/{id}/endereco") // Rota: /paciente/1/endereco
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco selecionarEnderecoPorIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
        Endereco endereco = pacienteBO.selecionarEnderecoPorIdBo(id);

        if (endereco == null) {
            // Lança uma exceção "Not Found" (404) se o paciente ou o CEP não forem encontrados
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return endereco;
    }

    // POST (Simplificado - sem IOException)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        pacienteBO.inserirBo(paciente);
        return Response.created(null).build();
    }

    // PUT (Simplificado - sem IOException)
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Paciente paciente, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        paciente.setId_paciente(id);
        pacienteBO.atualizarBo(paciente);
        return Response.ok().build();
    }

    // DELETE (Permanece igual)
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        pacienteBO.deletarBo(id);
        return Response.ok().build();
    }
}