/**
 * Author: Gabriel Capobianco
 * Date: May 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP-264 Java, JavaFX
 */

package Controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


import Classes.Agent;
import Classes.Packages;
import Main.DBConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import Classes.Agent;

public class AgentsTabController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnEditAgent"
    private Button btnEditAgent; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddAgent"
    private Button btnAddAgent; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveAgent"
    private Button btnSaveAgent; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteAgent"
    private Button btnDeleteAgent; // Value injected by FXMLLoader

    @FXML // fx:id="lvAgentInfo"
    private ListView<Agent> lvAgentInfo; // Value injected by FXMLLoader

    @FXML // fx:id="labelVbox"
    private VBox labelVbox; // Value injected by FXMLLoader

    @FXML // fx:id="label1"
    private Label label1; // Value injected by FXMLLoader

    @FXML // fx:id="label2"
    private Label label2; // Value injected by FXMLLoader

    @FXML // fx:id="label3"
    private Label label3; // Value injected by FXMLLoader

    @FXML // fx:id="label4"
    private Label label4; // Value injected by FXMLLoader

    @FXML // fx:id="label5"
    private Label label5; // Value injected by FXMLLoader

    @FXML // fx:id="label6"
    private Label label6; // Value injected by FXMLLoader

    @FXML // fx:id="label7"
    private Label label7; // Value injected by FXMLLoader

    @FXML // fx:id="label8"
    private Label label8; // Value injected by FXMLLoader

    @FXML // fx:id="tfVbox"
    private VBox tfVbox; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentAgentid"
    private TextField tfAgentAgentid; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentFname"
    private TextField tfAgentFname; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentMname"
    private TextField tfAgentMname; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentLname"
    private TextField tfAgentLname; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentPhone"
    private TextField tfAgentPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentEmail"
    private TextField tfAgentEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentPos"
    private TextField tfAgentPos; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentAgencyid"
    private TextField tfAgentAgencyid; // Value injected by FXMLLoader

    @FXML // fx:id="labelMessage"
    private Label labelMessage; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnEditAgent != null : "fx:id=\"btnEditAgent\" was not injected: check your FXML file 'AgentsTab.fxml'.";
        assert btnAddAgent != null : "fx:id=\"btnAddAgent\" was not injected: check your FXML file 'AgentsTab.fxml'.";
        assert btnSaveAgent != null : "fx:id=\"btnSaveAgent\" was not injected: check your FXML file 'AgentsTab.fxml'.";
        assert btnDeleteAgent != null : "fx:id=\"btnDeleteAgent\" was not injected: check your FXML file 'AgentsTab.fxml'.";
        assert lvAgentInfo != null : "fx:id=\"lvAgentInfo\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert labelVbox != null : "fx:id=\"labelVbox\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label3 != null : "fx:id=\"label3\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label4 != null : "fx:id=\"label4\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label5 != null : "fx:id=\"label5\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label6 != null : "fx:id=\"label6\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label7 != null : "fx:id=\"label7\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert label8 != null : "fx:id=\"label8\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfVbox != null : "fx:id=\"tfVbox\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentAgentid != null : "fx:id=\"tfAgentAgentid\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentFname != null : "fx:id=\"tfAgentFname\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentMname != null : "fx:id=\"tfAgentMname\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentLname != null : "fx:id=\"tfAgentLname\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentPhone != null : "fx:id=\"tfAgentPhone\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentEmail != null : "fx:id=\"tfAgentEmail\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentPos != null : "fx:id=\"tfAgentPos\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert tfAgentAgencyid != null : "fx:id=\"tfAgentAgencyid\" was not injected: check your FXML file 'AgentTab.fxml'.";
        assert labelMessage != null : "fx:id=\"labelMessage\" was not injected: check your FXML file 'AgentsTab.fxml'.";

        PopulateAgentListView();

        // Initialize of variable mode to use later in the switch
        final Integer[] mode = {null};

        // Set event handler for the List View when clicked
        lvAgentInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                labelVbox.setVisible(true);
                tfVbox.setVisible(true);
                label1.setVisible(true);
                tfAgentAgentid.setVisible(true);

                btnEditAgent.setDisable(false);
                btnSaveAgent.setDisable(true);
                btnDeleteAgent.setDisable(false);
                btnAddAgent.setDisable(false);

                labelMessage.setText("");

                DisplayAgentInfo();
            }
        });

        // Set event handler for the Edit button when clicked
        btnEditAgent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tfAgentFname.setEditable(true);
                tfAgentMname.setEditable(true);
                tfAgentLname.setEditable(true);
                tfAgentPhone.setEditable(true);
                tfAgentEmail.setEditable(true);
                tfAgentPos.setEditable(true);
                tfAgentAgencyid.setEditable(true);

                btnSaveAgent.setDisable(false);
                btnAddAgent.setDisable(true);
                btnDeleteAgent.setDisable(true);
                btnEditAgent.setDisable(true);
                mode[0] = 1;
            }
        });

        // Set event handler for the Add button when clicked
        btnAddAgent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mode[0] = 2;

                btnSaveAgent.setDisable(false);
                btnEditAgent.setDisable(true);
                btnAddAgent.setDisable(true);
                btnDeleteAgent.setDisable(true);

                tfAgentFname.setEditable(true);
                tfAgentMname.setEditable(true);
                tfAgentLname.setEditable(true);
                tfAgentPhone.setEditable(true);
                tfAgentEmail.setEditable(true);
                tfAgentPos.setEditable(true);
                tfAgentAgencyid.setEditable(true);

                labelVbox.setVisible(true);
                tfVbox.setVisible(true);
                label1.setVisible(false);
                tfAgentAgentid.setVisible(false);
                labelMessage.setText("");

                ClearTextFields();
            }
        });

        // Set event handler for the Delete button when clicked
        btnDeleteAgent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Agent ag = lvAgentInfo.getSelectionModel().getSelectedItem();
                String sql = "DELETE FROM `Agents` WHERE AgentId= " + ag.getAgentID();
                Connection conn = new DBConnectionManager().getConnection();

                try
                {
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.execute();

                }
                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                PopulateAgentListView();
                btnDeleteAgent.setDisable(true);
                btnEditAgent.setDisable(true);
                labelMessage.setText("");
                ClearTextFields();
            }
        });

        // Set event handler for the Save button when clicked
        btnSaveAgent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (tfAgentAgencyid.getText() == "")
                {
                    labelMessage.setText("Agency ID can not be empty. Please try edit again");
                    tfAgentAgencyid.setText("");
                }
                if (Integer.parseInt(tfAgentAgencyid.getText()) != 1 & Integer.parseInt(tfAgentAgencyid.getText()) != 2)
                {
                    labelMessage.setText("Agency ID can not be different than 1 or 2. Please try edit again");
                    tfAgentAgencyid.setText("");
                }
                else
                {
                switch (mode[0])
                {
                    case 1: // Mode is equal to 1 when the edit button is clicked so it goes in
                        try {
                            String sql = "UPDATE `agents` SET `AgtFirstName`=?,`AgtMiddleInitial`=?,`AgtLastName`=?,`AgtBusPhone`=?,"
                                    + "`AgtEmail`=?,`AgtPosition`=?,`AgencyId`=? WHERE AgentId=?";

                            Connection con = new DBConnectionManager().getConnection();

                            PreparedStatement statement = con.prepareStatement(sql);
                            statement.setString(1, tfAgentFname.getText());
                            statement.setString(2, tfAgentMname.getText());
                            statement.setString(3, tfAgentLname.getText());
                            statement.setString(4, tfAgentPhone.getText());
                            statement.setString(5, tfAgentEmail.getText());
                            statement.setString(6, tfAgentPos.getText());
                            statement.setInt(7, Integer.parseInt(tfAgentAgencyid.getText()));
                            statement.setInt(8, Integer.parseInt(tfAgentAgentid.getText()));

                            int rowsAffected = statement.executeUpdate();
                            if (rowsAffected > 0) {
                                System.out.println("Update worked");
                            } else {
                                System.out.println("Update failed");
                            }

                            con.close();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        PopulateAgentListView();
                        btnEditAgent.setDisable(true);
                        btnSaveAgent.setDisable(true);
                        btnAddAgent.setDisable(false);
                        ClearTextFields();
                        labelMessage.setText("");
                        break;


                    case 2: // Mode is equal to 2 when the add button is clicked so it goes in
                        try {

                            String sql = "INSERT INTO `Agents` (`AgtFirstName`, `AgtMiddleInitial`, `AgtLastName`, `AgtBusPhone`, " +
                                    "`AgtEmail`, `AgtPosition`, `AgencyId`)" +
                                    "VALUES (?,?,?,?,?,?,?)";

                            Connection con = new DBConnectionManager().getConnection();
                            PreparedStatement statement = con.prepareStatement(sql);
                            statement.setString(1, tfAgentFname.getText());
                            statement.setString(2, tfAgentMname.getText());
                            statement.setString(3, tfAgentLname.getText());
                            statement.setString(4, tfAgentPhone.getText());
                            statement.setString(5, tfAgentEmail.getText());
                            statement.setString(6, tfAgentPos.getText());
                            statement.setInt(7, Integer.parseInt(tfAgentAgencyid.getText()));

                            int rowsAffectedAdd = statement.executeUpdate();
                            if (rowsAffectedAdd > 0) {
                                System.out.println("Agent added successfully");
                            } else {
                                System.out.println("Agent addition Failed");
                            }

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        PopulateAgentListView();
                        btnSaveAgent.setDisable(true);
                        btnDeleteAgent.setDisable(true);
                        ClearTextFields();
                        labelMessage.setText("");
                        break;

                }
            }
            }
        });

    }// end of initialize


    // Function that populates the Listview with the data from the database
    private void PopulateAgentListView(){
        try {
            Connection con = new DBConnectionManager().getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Agents");
            ObservableList<Agent> observableList = FXCollections.observableArrayList();

            while (resultSet.next())
            {
                observableList.add(new Agent(resultSet.getInt("AgentId"), resultSet.getString("AgtFirstName"),
                        resultSet.getString("AgtMiddleInitial"), resultSet.getString("AgtLastName"),
                        resultSet.getString("AgtBusPhone"), resultSet.getString("AgtEmail"),
                        resultSet.getString("AgtPosition"), resultSet.getInt("AgencyId")));
            }
            // show the list created with the data from the database into the listview
            lvAgentInfo.setItems(observableList);
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Function that gets the data from the listview and display it on the form
    private void DisplayAgentInfo() {
        tfAgentAgentid.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getAgentID() + "");
        tfAgentFname.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getFirstName());
        tfAgentMname.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getMiddleName());
        tfAgentLname.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getLastName());
        tfAgentPhone.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getPhone());
        tfAgentEmail.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getEmail());
        tfAgentPos.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getPosition());
        tfAgentAgencyid.setText(lvAgentInfo.getSelectionModel().getSelectedItem().getAgencyID() + "");
    }

    // Function that Clears the text fields in the form
    private void ClearTextFields(){
        tfAgentAgentid.setText("");
        tfAgentFname.setText("");
        tfAgentMname.setText("");
        tfAgentLname.setText("");
        tfAgentPhone.setText("");
        tfAgentEmail.setText("");
        tfAgentPos.setText("");
        tfAgentAgencyid.setText("");
    }




} // end of class

