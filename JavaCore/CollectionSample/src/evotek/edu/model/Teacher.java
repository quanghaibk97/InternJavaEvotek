package evotek.edu.model;

public class Teacher {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
