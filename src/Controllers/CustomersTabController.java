/*
 * Author: Bing He (Carol)
 * Date: May 8, 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP264 Java, JavaFX
 * Purpose: This file is CustomersTabController.java,
 * which defines all the methods which will be used in Customer Tab and make Customer Tab functional
 */

package Controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import Classes.Customer;
import Main.DBConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static java.lang.Integer.parseInt;

public class CustomersTabController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lvCustomers"
    private ListView<Customer> lvCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="etCustomer"
    private TextArea etCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddCustomer"
    private Button btnAddCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteCustomer"
    private Button btnDeleteCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditCustomer"
    private Button btnEditCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveCustomer"
    private Button btnSaveCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustomerId"
    private TextField tfCustomerId; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustFirstName"
    private TextField tfCustFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustAddress"
    private TextField tfCustAddress; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustLastName"
    private TextField tfCustLastName; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustCity"
    private TextField tfCustCity; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustProv"
    private TextField tfCustProv; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustCountry"
    private TextField tfCustCountry; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustPostal"
    private TextField tfCustPostal; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustHomePhone"
    private TextField tfCustHomePhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustBusPhone"
    private TextField tfCustBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentId"
    private TextField tfAgentId; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustEmail"
    private TextField tfCustEmail; // Value injected by FXMLLoader

    @FXML // fx:id="lbToastCustomer"
    private Label lbToastCustomer; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lvCustomers != null : "fx:id=\"lvCustomers\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert etCustomer != null : "fx:id=\"etCustomer\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert btnAddCustomer != null : "fx:id=\"btnAddCustomer\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert btnDeleteCustomer != null : "fx:id=\"btnDeleteCustomer\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert btnEditCustomer != null : "fx:id=\"btnEditCustomer\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert btnSaveCustomer != null : "fx:id=\"btnSaveCustomer\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustomerId != null : "fx:id=\"tfCustomerId\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustFirstName != null : "fx:id=\"tfCustFirstName\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustAddress != null : "fx:id=\"tfCustAddress\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustLastName != null : "fx:id=\"tfCustLastName\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustCity != null : "fx:id=\"tfCustCity\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustProv != null : "fx:id=\"tfCustProv\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustCountry != null : "fx:id=\"tfCustCountry\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustPostal != null : "fx:id=\"tfCustPostal\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustHomePhone != null : "fx:id=\"tfCustHomePhone\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustBusPhone != null : "fx:id=\"tfCustBusPhone\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        assert lbToastCustomer != null : "fx:id=\"lbToastCustomer\" was not injected: check your FXML file 'CustomersTab.fxml'.";
        //- List and display all Customers from the customers table in the list view named lvCustomers in Customers tab -//
        listCustomers();
        //------------- initiate array variable "mode" for future use for "Edit" and "Insert" operations -------------//
        final String[] mode = {"none"};

        //------------- when a row in the list vew lvCustomers is clicked, display the data for the selected Customer --//
        //------------- in the fields on the right hand side of the window -----------------------------------------//
        lvCustomers.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                displayCustomer();

                tfCustomerId.setEditable(false);
                tfCustFirstName.setEditable(false);
                tfCustLastName.setEditable(false);
                tfCustAddress.setEditable(false);
                tfCustCity.setEditable(false);
                tfCustProv.setEditable(false);
                tfCustPostal.setEditable(false);
                tfCustCountry.setEditable(false);
                tfCustHomePhone.setEditable(false);
                tfCustBusPhone.setEditable(false);
                tfCustEmail.setEditable(false);
                tfAgentId.setEditable(false);

                btnEditCustomer.setDisable(false);
                btnSaveCustomer.setDisable(true);
            }
        });

        //----------------- when the "Edit" button is clicked, allow the data in the fields being edited  --------------//
        //----------------- for the current selected Customer in the fields on the right hand side of the window -------//
        //----------------- Set mode[0] to "edit" for "Save" button event -------------------------------------//
        btnEditCustomer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (lvCustomers.getSelectionModel().getSelectedItem()!=null){
                    tfCustomerId.setStyle("-fx-background-color :#e6eaeb");
                    tfCustomerId.setEditable(false);
                    tfCustFirstName.setEditable(true);
                    tfCustLastName.setEditable(true);
                    tfCustAddress.setEditable(true);
                    tfCustCity.setEditable(true);
                    tfCustProv.setEditable(true);
                    tfCustPostal.setEditable(true);
                    tfCustCountry.setEditable(true);
                    tfCustHomePhone.setEditable(true);
                    tfCustBusPhone.setEditable(true);
                    tfCustEmail.setEditable(true);
                    tfAgentId.setEditable(true);
                    btnEditCustomer.setDisable(true);
                    btnSaveCustomer.setDisable(false);
                    lbToastCustomer.setText("You are in edit mode !");
                    lbToastCustomer.setStyle("-fx-background-color :#e6eaeb");
                    mode[0] = "edit";
                } else {
                    lbToastCustomer.setText("Please select the row you want to edit !");
                    lbToastCustomer.setStyle("-fx-background-color :#e6eaeb");
                    mode[0] = "none";
                }
            }
        });

        //When mode[0] is "edit", clicking "Save" button will allow data for selected Customer being saved --------------//
        //When mode[0] is "add", clicking "Save" button will allow input data for new Customer being inserted -----------//
        btnSaveCustomer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if ( mode[0] == "none" | tfCustFirstName.getText() == null | tfCustLastName.getText() == null |tfCustAddress.getText() == null
                        |tfCustCity.getText() == null | tfCustProv.getText() == null | tfCustCountry.getText() == null
                        |tfCustPostal.getText() == null| tfCustHomePhone.getText() == null
                        | tfCustBusPhone.getText() == null | tfCustEmail.getText() == null | tfAgentId.getText() == null) {
                    System.out.println("edit or insert not clicked");
                    lbToastCustomer.setText("Click 'Edit' to edit. Click 'Insert' to insert. All fields are required!");
                    lbToastCustomer.setStyle("-fx-background-color :#e6eaeb");
                } else {
                    Connection conn = new DBConnectionManager().getConnection();
                    switch (mode[0]){
                        case "edit":

                            String sql_edit = "UPDATE `customers` SET `CustFirstName`=?,`CustLastName`=?,`CustAddress`=?,`CustCity`=?,"
                                    + "`CustProv`=?,`CustPostal`=?,`CustCountry`=?,`CustHomePhone`=?,`CustBusPhone`=?,`CustEmail`=?,"
                                    + "`AgentId`=? WHERE CustomerId=?";
                            try {
                                PreparedStatement stmt_edit = conn.prepareStatement(sql_edit);
                                stmt_edit.setString(1, tfCustFirstName.getText());
                                stmt_edit.setString(2, tfCustLastName.getText());
                                stmt_edit.setString(3, tfCustAddress.getText());
                                stmt_edit.setString(4, tfCustCity.getText());
                                stmt_edit.setString(5, tfCustProv.getText());
                                stmt_edit.setString(6, tfCustPostal.getText());
                                stmt_edit.setString(7, tfCustCountry.getText());
                                stmt_edit.setString(8, tfCustHomePhone.getText());
                                stmt_edit.setString(9, tfCustBusPhone.getText());
                                stmt_edit.setString(10, tfCustEmail.getText());
                                stmt_edit.setInt(11, parseInt(tfAgentId.getText()));
                                stmt_edit.setInt(12, parseInt(tfCustomerId.getText()));
                                int rowsAffected_Update = stmt_edit.executeUpdate();
                                if (rowsAffected_Update == 1)
                                {
                                    System.out.println("update worked");
                                    lbToastCustomer.setText("Update Succeeded !");
                                }
                                else
                                {
                                    System.out.println("update failed");
                                    lbToastCustomer.setText("Update Failed !");
                                }
                                lbToastCustomer.setStyle("-fx-background-color :#e6eaeb");

                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            clearCustomer();
                            listCustomers();
                            break;
    //----- When mode[0] is "add", clicking "Save" button will allow input data for new Customer being inserted ----//
                        case "add":

                            String sql_add = "INSERT INTO `customers` (`CustFirstName`,`CustLastName`,`CustAddress`,`CustCity`,"
                                    + "`CustProv`,`CustPostal`,`CustCountry`,`CustHomePhone`,`CustBusPhone`,`CustEmail`,"
                                    + "`AgentId`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";
                            try {
                                PreparedStatement stmt_insert = conn.prepareStatement(sql_add);
                                stmt_insert.setString(1, tfCustFirstName.getText());
                                stmt_insert.setString(2, tfCustLastName.getText());
                                stmt_insert.setString(3, tfCustAddress.getText());
                                stmt_insert.setString(4, tfCustCity.getText());
                                stmt_insert.setString(5, tfCustProv.getText());
                                stmt_insert.setString(6, tfCustPostal.getText());
                                stmt_insert.setString(7, tfCustCountry.getText());
                                stmt_insert.setString(8, tfCustHomePhone.getText());
                                stmt_insert.setString(9, tfCustBusPhone.getText());
                                stmt_insert.setString(10, tfCustEmail.getText());
                                stmt_insert.setInt(11, parseInt(tfAgentId.getText()));
                                //stmt.setInt(12, Integer.parseInt(tfCustomerId.getText()));
                                long rowsAffected_Insert = stmt_insert.executeUpdate();
                                if (rowsAffected_Insert == 1) {
                                    System.out.println("insert worked");
                                    lbToastCustomer.setText("Insert Succeeded !");
                                } else {
                                    System.out.println("insert failed");
                                    lbToastCustomer.setText("Insert failed !");
                                }
                                lbToastCustomer.setStyle("-fx-background-color :#e6eaeb");

                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            clearCustomer();
                            listCustomers();
                    }
                }
            }
        });

    //-- Set all fields editable to allow data insert for new Customer when Insert button is clicked in Customers tab --//
    //-- Set mode to "add" to allow data to be saved when "Save" button is clicked ----------------------------//
        btnAddCustomer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clearCustomer();
                //btnEditCustomer.setDisable(false);
                //btnSaveCustomer.setDisable(true);
                lbToastCustomer.setText("Please input data for new Customer. All fields are required.");
                lbToastCustomer.setStyle("-fx-background-color :#e6eaeb");
                tfCustomerId.setStyle("-fx-background-color :#e6eaeb");
                tfCustomerId.setEditable(false);
                tfCustFirstName.setEditable(true);
                tfCustLastName.setEditable(true);
                tfCustAddress.setEditable(true);
                tfCustCity.setEditable(true);
                tfCustProv.setEditable(true);
                tfCustPostal.setEditable(true);
                tfCustCountry.setEditable(true);
                tfCustHomePhone.setEditable(true);
                tfCustBusPhone.setEditable(true);
                tfCustEmail.setEditable(true);
                tfAgentId.setEditable(true);
                btnEditCustomer.setDisable(true);
                btnSaveCustomer.setDisable(false);
                mode[0] = "add";

            }
        });

        //--- Delete the selected Customer in list view lvCustomers when "Delete" button is clicked in Customers tab ----//
        btnDeleteCustomer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (lvCustomers.getSelectionModel().getSelectedItem()!=null) {
                    Customer customer = lvCustomers.getSelectionModel().getSelectedItem();
                    String sql = "DELETE FROM `customers` " + "WHERE CustomerId=" + customer.getCustomerId();
                    Connection conn = new DBConnectionManager().getConnection();

                    try {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.execute();
                        lbToastCustomer.setText("delete succeeded!");  // pop up feedback in label in GUI
                        lbToastCustomer.setStyle("-fx-background-color :#e6eaeb"); // set label background color
                        // to allow label visible
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    clearCustomer();
                    listCustomers();
                } else {
                    lbToastCustomer.setText("Please select the row you want to delete !");
                    lbToastCustomer.setStyle("-fx-background-color :#e6eaeb");

                }
            }
        });

    } // end of initialize

    //------ Display data for individual Customer on the right hand side of the window in Customers tab ----------//
    private void displayCustomer(){

        tfCustomerId.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustomerId() + "");
        tfCustFirstName.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustFirstName());
        tfCustLastName.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustLastName());
        tfCustAddress.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustAddress());
        tfCustCity.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustCity());
        tfCustProv.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustProv());
        tfCustPostal.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustPostal());
        tfCustCountry.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustCountry());
        tfCustHomePhone.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustHomePhone());
        tfCustBusPhone.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustBusPhone());
        tfCustEmail.setText(lvCustomers.getSelectionModel().getSelectedItem().getCustEmail());
        tfAgentId.setText(lvCustomers.getSelectionModel().getSelectedItem().getAgentId() + "");
    }

    //- List and display all Customers from the customers table in the list view named lvCustomers in Customers tab -//
    private void listCustomers(){
        try {
            Connection conn = new DBConnectionManager().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Customers");
            ObservableList<Customer> list = FXCollections.observableArrayList();

            while (rs.next())
            {
                list.add(new Customer(rs.getInt("CustomerId"), rs.getString("CustFirstName"),
                        rs.getString("CustLastName"), rs.getString("CustAddress"),
                        rs.getString("CustCity"), rs.getString("CustProv"),
                        rs.getString("CustPostal"), rs.getString("CustCountry"),
                        rs.getString("CustHomePhone"), rs.getString("CustBusPhone"),
                        rs.getString("CustEmail"), rs.getInt("AgentId")));
            }
            lvCustomers.setItems(list);
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //----- Clear fields in Customer data fields for new entry in Customers tab ----------------------------------//
    private void clearCustomer(){
        tfCustomerId.setText("");
        tfCustFirstName.setText(null);
        tfCustLastName.setText(null);
        tfCustAddress.setText(null);
        tfCustCity.setText(null);
        tfCustProv.setText(null);
        tfCustPostal.setText(null);
        tfCustCountry.setText(null);
        tfCustHomePhone.setText(null);
        tfCustBusPhone.setText(null);
        tfCustEmail.setText(null);
        tfAgentId.setText(null);
    }

} // end of class
