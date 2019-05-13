package domain.services;

import java.util.ArrayList;
import java.util.List;
import domain.Actor;

import java.util.ArrayList;

public class ActorService {

    private static List<Actor> Actors = new ArrayList<>();
    private static int currentId = 1;
    public List<Actor> getAll(){
        return Actors;
    }

    public Actor get(int id)
    {
        for (Actor a : Actors)
        {
            if(a.getId() == id)
                return a;
        }
        return null;
    }

    public void add(Actor a)
    {
        a.setId(+currentId);
        Actors.add(a);
    }

    public void update(Actor Actor)
    {
        for (Actor a : Actors)
        {
            if(a.getId()== Actor.getId())
            {
                a.setName(Actor.getName());
                a.setSurname(Actor.getSurname());
            }
        }
    }

    public void delete(Actor a)
    {
        Actors.remove(a);
    }


}
