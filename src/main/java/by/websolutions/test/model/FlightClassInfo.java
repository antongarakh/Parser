package by.websolutions.test.model;

public class FlightClassInfo {
    private String name;
    private String status;
    private String mileague;
    private String tax;
    private String id;

    public FlightClassInfo(String name, String status, String mileague, String tax, String id) {
        this.name = name;
        this.status = status;
        this.mileague = mileague;
        this.tax = tax;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMileague() {
        return mileague;
    }

    public void setMileague(String mileague) {
        this.mileague = mileague;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
