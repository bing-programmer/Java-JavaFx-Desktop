/**
 * Author: Gabriel Capobianco
 * Date: May 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP-264 Java, JavaFX
 */

package Classes;

public class Agent {

    private Integer AgentID;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Phone;
    private String Email;
    private String Position;
    private Integer AgencyID;

    // Agent constructor
    public Agent(Integer agentID, String firstName, String middleName, String lastName, String phone, String email, String position, Integer agencyID) {
        AgentID = agentID;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Position = position;
        AgencyID = agencyID;
    }

    // Getters and Setters for the whole class
    public Integer getAgentID() {
        return AgentID;
    }

    public void setAgentID(Integer agentID) {
        AgentID = agentID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Integer getAgencyID() {
        return AgencyID;
    }

    public void setAgencyID(Integer agencyID) {
        AgencyID = agencyID;
    }

    @Override
    public String toString() {
        return "ID " + AgentID + ": " + FirstName + " " + LastName;
    }
}
