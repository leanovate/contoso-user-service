package de.leanovate.contoso;

public class User {
    public String name;

    public User() {
        // ObjectMapper needs this
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
