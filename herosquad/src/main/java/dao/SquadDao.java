package dao;

import models.Squad;
import models.Hero;
import java.util.List;

public interface SquadDao {

    //LIST squads
    List<Squad> getAll();
    List<Hero> getAllHeroesBySquad(int squadId);

    //CREATE squads
    void add(Squad squad);

    //READ
   Squad findById(int id);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllSquads();
}
