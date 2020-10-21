package be.intecbrussel.enums;

public enum Status {

    SHIPPED("Shipped"),
    RESOLVED("Resolved"),
    CANCELLED("Cancelled"),
    ON_HOLD("On Hold"),
    DISPUTED("Disputed"),
    IN_PROCESS("In Process");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
