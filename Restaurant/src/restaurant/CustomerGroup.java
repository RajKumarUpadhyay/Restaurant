package restaurant;

public class CustomerGroup {

    private final int size;
    private Table assignedTable;

    public CustomerGroup(int size) {
        if (size < 1 || size > 6) {
            throw new IllegalArgumentException("Customer groups are only for less than 6 people");
        }

        this.size = size;
        this.assignedTable = null;
    }

    public int getSize() {
        return size;
    }

    public Table getAssignedTable() {
        return assignedTable;
    }

    public void setAssignedTable(Table assignedTable) {
        synchronized (this) {
            this.assignedTable = assignedTable;
        }
    }

    public void leaveTable() {
        if (assignedTable == null) {
            throw new IllegalStateException("Unable to leave a non assigned table");
        }
        synchronized (this) {
            assignedTable.leaveSeats(this.getSize());
            assignedTable = null;
        }
    }
}
