package com.example.rest.resource;

import com.example.rest.model.Product;
import com.example.rest.repository.ProductRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private static final ProductRepository repository = new ProductRepository();

    @GET
    public List<Product> findAll() {
        // TODO:
        // Controller task:
        // Return HTTP 200 with all products.
        return repository.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        // TODO:
        // Controller task:
        // 1. Read id from path.
        // 2. Call repository.findById(id).
        // 3. Return HTTP 404 if product does not exist.
        // 4. Return HTTP 200 with product if found.
        Product product = repository.findById(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @POST
    public Response create(Product product) {
        // TODO:
        // Controller task:
        // 1. Read JSON request body as Product.
        // 2. Validate request body.
        // 3. Return HTTP 400 if request body is invalid.
        // 4. Call repository.create(product).
        // 5. Return HTTP 201 with created product.
        if (!repository.isValid(product)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Product createdProduct = repository.create(product);
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Product product) {
        // TODO:
        // Controller task:
        // 1. Read id from path.
        // 2. Read JSON request body as Product.
        // 3. Validate request body.
        // 4. Return HTTP 400 if request body is invalid.
        // 5. Call repository.update(id, product).
        // 6. Return HTTP 404 if product does not exist.
        // 7. Return HTTP 200 with updated product.
        if (!repository.isValid(product)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Product updatedProduct = repository.update(id, product);
        if (updatedProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedProduct).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") int id) {
        // TODO:
        // Controller task:
        // 1. Read id from path.
        // 2. Call repository.deleteById(id).
        // 3. Return HTTP 404 if product does not exist.
        // 4. Return HTTP 204 if deleted.
        boolean deleted = repository.deleteById(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
