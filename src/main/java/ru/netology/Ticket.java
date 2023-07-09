package ru.netology;

public class Ticket implements Comparable<Ticket>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int flight_time;




    public Ticket(int id, int price, String from, String to, int flight_time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.flight_time = flight_time;

    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getFlight_time() {
        return flight_time;
    }

    @Override
    public int compareTo(Ticket anotherTicket) {
        return (int) (price - anotherTicket.getPrice());
    }
}
