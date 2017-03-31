package de.leanovate.contoso;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserStore {
    final Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return String.format(
                "UserStore users = [%s]",
                users.stream().map(User::toString).collect(Collectors.joining(","))
        );
    }
}
