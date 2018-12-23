package restaurant;

/**
 * Table seat (non thread safe)
 *
 * Carlos Saltos 29/10/12 15:36
 *
 *
 */
public class Table {

    private final int size;
    private int availableSeats;

    public Table(int size) {
        if (size < 2 || size > 6) {
            throw new IllegalArgumentException("Tables are only for 2, 3, 4, 5 or 6 people");
        }
        this.size = size;
        this.availableSeats = size;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getSize() {
        return size;
    }

    public boolean hasAvailableSeats(int seats) {
        if (availableSeats < seats) {
            return false;
        }
        return true;
    }

    public void assignSeats(int seats) {
        availableSeats -= seats;
    }

    public void leaveSeats(int seats) {
        availableSeats += seats;
    }
}
