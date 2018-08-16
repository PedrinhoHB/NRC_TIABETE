package br.com.nrc.tiabete.resource;

import java.util.List;

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

import br.com.nrc.tiabete.bo.InsulinaDependenteBO;
import br.com.nrc.tiabete.entity.InsulinaDependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;

@Path("/insulina-dependente")
public class InsulinaDependenteResource {
	private InsulinaDependenteBO bo;

	public InsulinaDependenteResource() {
		bo = new InsulinaDependenteBO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Deprecated
	public List<InsulinaDependente> listar() {
		return bo.listar();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Deprecated
	public InsulinaDependente pesquisar(@PathParam("id") int codigo) {
		return bo.pesquisar(codigo);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Deprecated
	public Response cadastrar(InsulinaDependente insulina, @Context UriInfo uri) {
		try {
			bo.inserir(insulina);
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		UriBuilder builder = uri.getAbsolutePathBuilder();
		// TODO Verificar com o professor
		builder.path(String.valueOf(insulina.getInsulina().getCodigo() + insulina.getDependente().getCodigo()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("{idInsu}/{idDep}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Deprecated
	public Response atualizar(InsulinaDependente insulina, @PathParam("idInsu") int codInsu,
			@PathParam("idDep") int codDep) {
		try {
			bo.atualizar(insulina, codInsu, codDep);
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		return Response.ok().build();
	}

	@DELETE
	@Path("{id}")
	@Deprecated
	public void deletar(@PathParam("id") int codigo) {
		try {
			bo.remover(codigo);
		} catch (CommitException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
	}
}
