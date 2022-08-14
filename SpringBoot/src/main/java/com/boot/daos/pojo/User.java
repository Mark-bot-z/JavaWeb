package com.boot.daos.pojo;

public class User {
    private String name;
    private Pet pet;

    public User() {
    }

//    @Override
//    public String toString() {
//        return "User{" +
//               "name='" + name + '\'' +
//               ", pet=" + pet +
//               '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }
}
