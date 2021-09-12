package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Hero {

    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private int id;
    private int squadId;

    public Hero(String description, int squadId){
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.squadId = squadId;
    }


    public int getSquadId() {
        return squadId;
    }

    public void setCategoryId(int squadId) {
        this.squadId = squadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return completed == hero.completed &&
                id == hero.id &&
                Objects.equals(description, hero.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, completed, id);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted(){
        return this.completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

}