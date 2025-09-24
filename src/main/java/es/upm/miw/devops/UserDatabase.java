package es.upm.miw.devops;


import java.util.stream.Stream;

public class UserDatabase {

    public Stream<User> findAll() {


        return Stream.of(
                new User("1", "Oscar", "Fernandez", null),
                new User("2", "Ana", "Blanco", null),
                new User("3", "Oscar", "López", null),
                new User("4", "Paula", "Torres", null),
                new User("5", "Antonio", "Blanco", null),
                new User("6", "Paula", "Torres", null)
        );
    }
}