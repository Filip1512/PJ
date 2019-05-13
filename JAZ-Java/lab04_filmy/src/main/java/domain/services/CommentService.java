package domain.services;

import domain.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentService {

    private static List<Comment> comments = new ArrayList<>();
    private static int currentId = 1;
    public List<Comment> getAll(){
        return comments;
    }

    public Comment get(int id)
    {
        for (Comment c : comments)
        {
            if(c.getId() == id)
                return c;
        }
        return null;
    }

    public void add(Comment c)
    {
        c.setId(+currentId);
        comments.add(c);
    }

    public void update(Comment comment)
    {
        for (Comment c : comments)
        {
            if(c.getId()== comment.getId())
            {
                c.setComment(comment.getComment());
            }
        }
    }

    public void delete(Comment m)
    {
        comments.remove(m);
    }

}
