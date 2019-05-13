package rest;

import domain.Actor;
import domain.Comment;
import domain.Movie;
import domain.services.ActorService;
import domain.services.CommentService;
import domain.services.MovieService;

import javax.websocket.server.PathParam;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import java.util.List;

@Path("/")
public class MovieResources extends Application {

    private MovieService db = new MovieService();
    private CommentService dbComments = new CommentService();
    private ActorService dbActors = new ActorService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAllMovies() {
        return db.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Movie movie)
    {
        db.add(movie);
        return Response.ok(movie.getId()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovie(@PathParam("id") int id)
    {
        Movie result = db.get(id);
        if(result == null)
        {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMovie(@PathParam("id") int id, Movie m)
    {
        Movie result = db.get(id);
        if(result == null)
            return Response.status(404).build();
        m.setId(id);
        db.update(m);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") int id)
    {
        Movie result = db.get(id);
        if(result == null)
            return Response.status(404).build();
        db.delete(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllComments(@PathParam("id") int id) {
        return db.get(id).getComment();
    }

}
