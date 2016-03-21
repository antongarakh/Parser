package by.websolutions.test.model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private List <Flight> flights;
    private List <ExtraData> extraDataList;
    private List <FlightClassInfo> flightClassInfoList;
    private String totalDuration;

    public Flight(List<Flight> flights, List<ExtraData> extraDataList, List<FlightClassInfo> flightClassInfoList, String totalDuration) {
        this.flights = flights;
        this.extraDataList = extraDataList;
        this.flightClassInfoList = flightClassInfoList;
        this.totalDuration = totalDuration;
    }

    public List<Flight> getFlights() {

        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<ExtraData> getExtraDataList() {
        return extraDataList;
    }

    public void setExtraDataList(List<ExtraData> extraDataList) {
        this.extraDataList = extraDataList;
    }

    public List<FlightClassInfo> getFlightClassInfoList() {
        return flightClassInfoList;
    }

    public void setFlightClassInfoList(List<FlightClassInfo> flightClassInfoList) {
        this.flightClassInfoList = flightClassInfoList;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }
}
