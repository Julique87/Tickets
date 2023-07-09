package ru.netology;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return (int) (o2.getFlight_time() - o1.getFlight_time());
    }

}
