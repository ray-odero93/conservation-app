package dao;

import java.util.List;
import models.Hero;

public interface HeroDao {

    // LIST
    List<Hero> getAll();

    // CREATE
    void add(Hero hero);

    // READ
    Hero findById(int id);

    // UPDATE
    void update(int id, String content, int squadId);

    // DELETE
    void deleteById(int id);
    void clearAllHeroes();
}


