package be.intecbrussel.enums;

public enum JobTitle {

    PRESIDENT("President"),
    SALES_MANAGER_APAC("Sales Manager (APAC)"),
    SALES_MANAGER_EMEA("Sales Manager (EMEA)"),
    SALES_MANAGER_NA("Sales Manager (NA)"),
    SALES_REP("Sales Rep"),
    VP_MARKETING("Vp Marketing"),
    VP_SALES("VP sales");

    private String title;

    JobTitle(String title) {
        this.title = title;
    }

    public String getJobTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }



}
