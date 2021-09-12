package models;

//import org.junit.After;
//import org.junit.Before;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithDescription_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("Mow the lawn", hero.getDescription());
    }

    @Test
    public void isCompletedPropertyIsFalseAfterInstantiation() throws Exception {
       Hero hero = setupNewHero();
        assertEquals(false, hero.getCompleted()); //should never start as completed
    }

    @Test
    public void getCreatedAtInstantiatesWithCurrentTimeToday() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(), hero.getCreatedAt().getDayOfWeek());
    }

    //helper methods
    public Hero setupNewHero(){
        return new Hero("Mow the lawn", 1);
    }
}