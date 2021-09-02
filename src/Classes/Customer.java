/*
 * Author: Bing He (Carol)
 * Date: May 8, 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP264 Java, JavaFX
 * Purpose: This file is Customer.java, which is to define Customer class
 */


package Classes;

public class Customer
{
   //define member variables
    private Integer customerId;
    private String custFirstName;
    private String custLastName;
    private String custAddress;
    private String custCity;
    private String custProv;
    private String custPostal;
    private String custCountry;
    private String custHomePhone;
    private String custBusPhone;
    private String custEmail;
    private Integer agentId;
    //define constructor with all 12 parameters
    public Customer(int customerId, String custFirstName, String custLastName, String custAddress,
                    String custCity, String custProv, String custPostal, String custCountry,
                    String custHomePhone, String custBusPhone, String custEmail, int agentId) {
        this.customerId = customerId;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custAddress = custAddress;
        this.custCity = custCity;
        this.custProv = custProv;
        this.custPostal = custPostal;
        this.custCountry = custCountry;
        this.custHomePhone = custHomePhone;
        this.custBusPhone = custBusPhone;
        this.custEmail = custEmail;
        this.agentId = agentId;
    }
    //define constructor with 3 parameters
    public Customer(int customerId, String custFirstName, String custLastName) {
        this.customerId = customerId;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custAddress = null;
        this.custCity = null;
        this.custProv = null;
        this.custPostal = null;
        this.custCountry = null;
        this.custHomePhone = null;
        this.custBusPhone = null;
        this.custEmail = null;
        this.agentId = 0;
    }
    //getters and setters for all member variables
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getCustProv() {
        return custProv;
    }

    public void setCustProv(String custProv) {
        this.custProv = custProv;
    }

    public String getCustPostal() {
        return custPostal;
    }

    public void setCustPostal(String custPostal) {
        this.custPostal = custPostal;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getCustHomePhone() {
        return custHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        this.custHomePhone = custHomePhone;
    }

    public String getCustBusPhone() {
        return custBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        this.custBusPhone = custBusPhone;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
    //define toString() method
    @Override
    public String toString() {
        return customerId + " " + custFirstName + " " + custLastName + " " + custAddress + " " + custCity
                + " " + custProv + " " + custCountry;
    }
}
