package by.websolutions.test.model;


public class FlightsPropeties {
    private final String startDate;
    private final String endDate;
    private final String origin;
    private final String destination;
    private final int seats;
    private final String comfortClass;
    private final int requestID;
    private final int userID;
    private final String type;

    public FlightsPropeties(String startDate, String endDate, String origin, String destination,
                            int seats, String comfortClass, int requestID, int userID, String type){
        this.startDate = new String(startDate);
        this.endDate = new String(endDate);
        this.origin  = new String(origin);
        this.destination = new String(destination);
        this.seats = seats;
        this.comfortClass = comfortClass;
        this.requestID = requestID;
        this.userID = userID;
        this.type = new String(type);
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    public String getComfortClass() {
        return comfortClass;
    }

    public int getRequestID() {
        return requestID;
    }

    public int getUserID() {
        return userID;
    }


    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "FlightsPropeties{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", comfortClass=" + comfortClass +
                ", requestID=" + requestID +
                ", userID=" + userID +
                ", type='" + type + '\'' +
                '}';
    }
}
