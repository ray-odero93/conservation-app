package dao;

import java.util.List;
import models.Hero;

public interface HeroDao {

    // LIST Heroes
    List<Hero> getAll();

    // CREATE hero
    void add(Hero hero);

    // READ
    Hero findById(int id);

    // UPDATE hero
    void update(int id, String content, int squadId);

    // DELETE Hero
    void deleteById(int id);
    void clearAllHeroes();
}


