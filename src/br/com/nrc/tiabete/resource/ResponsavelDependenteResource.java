package br.com.nrc.tiabete.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.nrc.tiabete.dao.ResponsavelDependenteDAO;
import br.com.nrc.tiabete.dao.impl.ResponsavelDependenteDAOImpl;
import br.com.nrc.tiabete.entity.ResponsavelDependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

@Path("/responsavel-dependente")
public class ResponsavelDependenteResource {
	private ResponsavelDependenteDAO dao;

	public ResponsavelDependenteResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ResponsavelDependenteDAOImpl(em);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResponsavelDependente> listar() {
		return dao.listar();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponsavelDependente pesquisar(@PathParam("id") int codigo) {
		return dao.pesquisar(codigo);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ResponsavelDependente respDep, @Context UriInfo uri) {
		try {
			dao.inserir(respDep);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		UriBuilder builder = uri.getAbsolutePathBuilder();
		// TODO Verificar com o professor
		builder.path(String.valueOf(respDep.getResponsavel().getCodigo() + respDep.getDependente().getCodigo()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ResponsavelDependente respDep, @PathParam("id") int codigo) {
		// TODO Verificar com o professor
		respDep.getResponsavel().setCodigo(codigo);
		respDep.getDependente().setCodigo(codigo);
		dao.atualizar(respDep);
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		return Response.ok().build();
	}

	@DELETE
	@Path("{id}")
	public void deletar(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
	}
}
