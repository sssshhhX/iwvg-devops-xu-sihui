package es.upm.miw.devops;

import java.util.Objects;
import java.util.stream.Stream;
public class Searches {

    // search e
    public Fraction findFractionAdditionByUserId(String id) {
        return new UserDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .filter(Objects::nonNull)
                .reduce(new Fraction(0, 1), Fraction::add);
    }

    // search 1
    public Stream<String> findUserIdBySomeProperFraction() {
        return new UserDatabase().findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getId);
    }

    //search f
    public Fraction findFractionSubtractionByUserName(String name) {
        return new UserDatabase().findAll()
                .filter(user -> name.equalsIgnoreCase(user.getName()))
                .findFirst()
                .map(user -> user.getFractions().stream()
                        .filter(Objects::nonNull)
                        .reduce(Fraction::subtract)
                        .orElse(new Fraction(0, 1)))
                .orElse(new Fraction(0, 1));
    }
    //search c
    public Stream<Double> findDecimalFractionByUserName(String name) {
        return new UserDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(Objects::nonNull)
                )
                .map(Fraction::decimal);
    }


}



