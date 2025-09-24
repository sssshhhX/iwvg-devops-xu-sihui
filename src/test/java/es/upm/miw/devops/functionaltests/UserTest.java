package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.Fraction;
import es.upm.miw.devops.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("123", "John", "Doe", new ArrayList<>());
    }



    @Test
     void testAllArgsConstructor() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction());
        User user = new User("123", "Jane", "Smith", fractions);

        assertEquals("123", user.getId());
        assertEquals("Jane", user.getName());
        assertEquals("Smith", user.getFamilyName());
        assertEquals(fractions, user.getFractions());
    }

    @Test
     void testGettersAndSetters() {
        user.setName("Alice");
        user.setFamilyName("Johnson");

        List<Fraction> newFractions = new ArrayList<>();
        user.setFractions(newFractions);

        assertEquals("Alice", user.getName());
        assertEquals("Johnson", user.getFamilyName());
        assertEquals(newFractions, user.getFractions());
    }

     @Test
     void testNoArgsConstructorInitializesEmptyFractionList() {
         User emptyUser = new User();
         assertNotNull(emptyUser.getFractions());
         assertTrue(emptyUser.getFractions().isEmpty());
     }

    @Test
     void testAllArgsConstructorWithNullFractions() {
        User user = new User("1", "Alice", "Smith", null);
        assertEquals("1", user.getId());
        assertEquals("Alice", user.getName());
        assertEquals("Smith", user.getFamilyName());
        assertNull(user.getFractions());
    }

    @Test
     void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
     void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
     void testToString() {
        user.addFraction(new Fraction());
        String toStringResult = user.toString();

        assertTrue(toStringResult.contains("id='123'"));
        assertTrue(toStringResult.contains("name='John'"));
        assertTrue(toStringResult.contains("familyName='Doe'"));
        assertTrue(toStringResult.contains("fractions=["));
    }
}
