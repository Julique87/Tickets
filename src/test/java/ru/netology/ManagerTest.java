package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
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
    public void shouldSortTickets() {                                  // Сортировка билетов по запросу и цене
        Ticket[] expected = {ticket3, ticket1, ticket6};
        Ticket[] actual = manager.findAll("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketsBorder2() {                           // Сортировка билетов по запросу и цене, граничное значение
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("FRU", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSortTickets() {                               // Сортировка билетов не работает, тк запрос не найден
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("FRU", "GOJ");

        Assertions.assertArrayEquals(expected, actual);
    }

}