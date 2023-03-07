package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    private static final String noDataAvailable = "Data not available";

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }


    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();  //need to call default constructor
        name = aName;
        employer = aEmployer;
        location = aLocation;
        positionType = aPositionType;
        coreCompetency = aCoreCompetency;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        if (this.getName() == null || name.equals("")) {
            this.setName(noDataAvailable);
        }
        if (String.valueOf(this.getEmployer()) == null || employer.getValue().equals("")) {
            employer.setValue(noDataAvailable);
        }
        if (String.valueOf(this.getLocation()) == null || location.getValue().equals("")) {
            location.setValue(noDataAvailable);
        }
        if (String.valueOf(this.getPositionType()) == null || positionType.getValue().equals("")) {
            positionType.setValue(noDataAvailable);
        }
        if (String.valueOf(this.getCoreCompetency()) == null || coreCompetency.getValue().equals("")) {
            coreCompetency.setValue(noDataAvailable);
        }
        // return "\n" + "ID: " + this.getId() + "\n" + "Name: " + this.getName() + "\n" + "Employer: " + this.getEmployer() + "\n" + "Location: " + this.getLocation() + "\n" + "Position Type: " + this.getPositionType() + "\n" + "Core Competency: " + this.getCoreCompetency() + "\n";
        String output = String.format("\nID: %d" +
                "\nName: %s" +
                "\nEmployer: %s" +
                "\nLocation: %s" +
                "\nPosition Type: %s" +
                "\nCore Competency: %s\n", id, name, employer, location, positionType, coreCompetency);

        return output;
    }

}