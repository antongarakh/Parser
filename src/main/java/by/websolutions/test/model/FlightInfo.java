package by.websolutions.test.model;

/**
 * Created by Anton on 16.03.2016.
 */
public class FlightInfo {
    private String departTime;
    private String departDate;
    private String departPlace;
    private String departCode;
    private String arriveTime;
    private String arriveDate;
    private String arrivePlace;
    private String arriveCode;
    private String travelTime;
    private String flightNumber;
    private String airLineCompany;
    private String aircraft;
    private String meal;
    private String id;
    private String layoverTime;

    public FlightInfo(String departTime, String departDate, String departPlace, String departCode,
                      String arriveTime, String arriveDate, String arrivePlace, String arriveCode,
                      String travelTime, String flightNumber, String airLineCompany, String aircraft,
                      String meal, String id, String layoverTime) {
        this.departTime = departTime;
        this.departDate = departDate;
        this.departPlace = departPlace;
        this.departCode = departCode;
        this.arriveTime = arriveTime;
        this.arriveDate = arriveDate;
        this.arrivePlace = arrivePlace;
        this.arriveCode = arriveCode;
        this.travelTime = travelTime;
        this.flightNumber = flightNumber;
        this.airLineCompany = airLineCompany;
        this.aircraft = aircraft;
        this.meal = meal;
        this.id = id;
        this.layoverTime = layoverTime;
    }

    public String getDepartTime() {

        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getArrivePlace() {
        return arrivePlace;
    }

    public void setArrivePlace(String arrivePlace) {
        this.arrivePlace = arrivePlace;
    }

    public String getArriveCode() {
        return arriveCode;
    }

    public void setArriveCode(String arriveCode) {
        this.arriveCode = arriveCode;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirLineCompany() {
        return airLineCompany;
    }

    public void setAirLineCompany(String airLineCompany) {
        this.airLineCompany = airLineCompany;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLayoverTime() {
        return layoverTime;
    }

    public void setLayoverTime(String layoverTime) {
        this.layoverTime = layoverTime;
    }
}
