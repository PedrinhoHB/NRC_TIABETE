package br.com.nrc.tiabete.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.nrc.tiabete.bo.UsuarioBO;
import br.com.nrc.tiabete.entity.Usuario;

@Path("/usuario")
public class UsuarioResource {
	private UsuarioBO bo;

	public UsuarioResource() {
		bo = new UsuarioBO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() {
		return bo.listar();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario pesquisar(@PathParam("id") int codigo) {
		return bo.pesquisar(codigo);
	}

	// Método retirado porque a classe Usuario é abstrata
	/*
	 * @POST
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response cadastrar(Usuario
	 * usuario, @Context UriInfo uri) { try { bo.inserir(usuario); } catch
	 * (CommitException e) { e.printStackTrace(); return
	 * Response.serverError().build(); }
	 * 
	 * UriBuilder builder = uri.getAbsolutePathBuilder();
	 * builder.path(String.valueOf(usuario.getCodigo())); return
	 * Response.created(builder.build()).build(); }
	 */

	// Método retirado porque a classe Usuario é abstrata
	/*
	 * @PUT
	 * 
	 * @Path("{id}")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response atualizar(Usuario
	 * usuario, @PathParam("id") int codigo) { try { bo.atualizar(usuario, codigo);
	 * } catch (CommitException e) { e.printStackTrace(); return
	 * Response.serverError().build(); }
	 * 
	 * return Response.ok().build(); }
	 */

	// Método retirado porque a classe Usuario é abstrata
	/*
	 * @DELETE
	 * 
	 * @Path("{id}") public void deletar(@PathParam("id") int codigo) { try {
	 * bo.remover(codigo); } catch (CommitException e) { e.printStackTrace(); throw
	 * new WebApplicationException(Status.INTERNAL_SERVER_ERROR); } catch
	 * (KeyNotFoundException e) { e.printStackTrace(); throw new
	 * WebApplicationException(Status.BAD_REQUEST); } }
	 */
}
