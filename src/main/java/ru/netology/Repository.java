package ru.netology;
public class Repository {

    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {                          //  Получить все билеты
        return tickets;
    }

    public void add(Ticket ticket) {                     // Добавить
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket findById(int id) {                    // Найти по id
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }


    public void removeById(int removeId) {              // Удалить по id
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != removeId) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;

    }

}
