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

import br.com.nrc.tiabete.dao.RefeicaoDAO;
import br.com.nrc.tiabete.dao.impl.RefeicaoDAOImpl;
import br.com.nrc.tiabete.entity.Refeicao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

@Path("/refeicao")
public class RefeicaoResource {
	private RefeicaoDAO dao;

	public RefeicaoResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new RefeicaoDAOImpl(em);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Refeicao> listar() {
		return dao.listar();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Refeicao pesquisar(@PathParam("id") int codigo) {
		return dao.pesquisar(codigo);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Refeicao refeicao, @Context UriInfo uri) {
		try {
			dao.inserir(refeicao);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		UriBuilder builder = uri.getAbsolutePathBuilder();
		builder.path(String.valueOf(refeicao.getCodigo()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Refeicao refeicao, @PathParam("id") int codigo) {
		refeicao.setCodigo(codigo);
		dao.atualizar(refeicao);
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
