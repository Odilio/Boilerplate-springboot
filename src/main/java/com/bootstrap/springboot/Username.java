package com.bootstrap.springboot;

public class Username {

    public int id;
    public String name;
    public String email;

    public Username() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
	System.out.println(String.format("Username: [id:%d, name:%s, email:%s]", id, name, email));
    }

}