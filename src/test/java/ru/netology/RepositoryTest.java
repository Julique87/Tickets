package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(1, 5000, "DME", "LED", 2);
    Ticket ticket2 = new Ticket(2, 10000, "SVO", "OGZ", 8);
    Ticket ticket3 = new Ticket(3, 4000, "DME", "LED", 4);
    Ticket ticket4 = new Ticket(4, 7000, "FRU", "LED", 4);
    Ticket ticket5 = new Ticket(5, 8000, "DME", "GOJ", 4);
    Ticket ticket6 = new Ticket(6, 8000, "DME", "LED", 2);
    Ticket ticket7 = new Ticket(7, 4000, "LED", "GOJ", 7);


    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }


    @Test
    public void shouldFindById() {                                       // Нахождение по id


        repo.findById(7);

        Ticket actual = repo.findById(7);
        Ticket expected = ticket7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {                                    // Нахождение по id не работет, тк такого билета нет


        repo.findById(10);

        Ticket actual = repo.findById(10);
        Ticket expected = null;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {                                   // Удаление по id


        repo.removeById(6);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }
}