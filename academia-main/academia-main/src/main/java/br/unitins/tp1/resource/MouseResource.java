package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.model.Mouse;
import br.unitins.tp1.service.MouseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Mouse")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MouseResource {

    @Inject
    MouseService service;

    @GET
    public List<Mouse> listar() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Mouse buscarPorId(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/marca/{marca}")
    public List<Mouse> buscarPorfindByMarca(@PathParam("marca") String marca) {
        return service.findByMarca(marca);
    }

    @GET
    @Path("/modelo/{modelo}")
    public List<Mouse> buscarPorfindByModelo(@PathParam("modelo") String modelo) {
        return service.findByModelo(modelo);
    }

    @POST
    public Mouse inserir(Mouse mouse) {
        return service.create(mouse);
    } 

    @PUT
    @Path("/{id}")
    public void atualizar(@PathParam("id") Long id, Mouse mouse) {
       service.update(id, mouse);
    } 

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") Long id) {
        service.delete(id);
    }


}
