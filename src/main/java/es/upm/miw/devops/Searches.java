package es.upm.miw.devops;

import java.util.Objects;

public class Searches {

    // search e
    public Fraction findFractionAdditionByUserId(String id) {
        return new UserDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .filter(Objects::nonNull)
                .reduce(new Fraction(0, 1), Fraction::add);
    }




}
