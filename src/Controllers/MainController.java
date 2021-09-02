/**
 * Author: Gabriel Capobianco
 * Date: May 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP-264 Java, JavaFX
 * Function: This class controls all the other Controller's class
 */

package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tabHome"
    private Tab tabHome; // Value injected by FXMLLoader

    @FXML // fx:id="btnExit"
    private Button btnExit; // Value injected by FXMLLoader

    @FXML // fx:id="tabCustomers"
    private Tab tabCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="tabAgents"
    private Tab tabAgents; // Value injected by FXMLLoader

    @FXML // fx:id="tabPackages"
    private Tab tabPackages; // Value injected by FXMLLoader

    @FXML // fx:id="tabBookings"
    private Tab tabBookings; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tabHome != null : "fx:id=\"tabHome\" was not injected: check your FXML file 'Main.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'Main.fxml'.";
        assert tabCustomers != null : "fx:id=\"tabCustomers\" was not injected: check your FXML file 'Main.fxml'.";
        assert tabAgents != null : "fx:id=\"tabAgents\" was not injected: check your FXML file 'Main.fxml'.";
        assert tabPackages != null : "fx:id=\"tabPackages\" was not injected: check your FXML file 'Main.fxml'.";
        assert tabBookings != null : "fx:id=\"tabBookings\" was not injected: check your FXML file 'Main.fxml'.";


        //------------- Bing He (Carol) --------------------------------------------------------------------------//
        //------------- Exit the application when exit button is clicked in Home tab -----------------------------//
        btnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage = (Stage) btnExit.getScene().getWindow();
                stage.close();
            }
        });

        // Calls and display the CustomersTab.fxml scene when the tab is selected
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane anchCustomers = loader.load(getClass().getResource("../Scenes/CustomersTab.fxml"));
            tabCustomers.setContent(anchCustomers);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Calls and display the AgentsTab.fxml scene when the tab is selected
        try
        {
            FXMLLoader loader = new FXMLLoader();
            BorderPane anchAgents = loader.load(getClass().getResource("../Scenes/AgentsTab.fxml"));
            tabAgents.setContent(anchAgents);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Calls and display the PackagesTab.fxml scene when the tab is selected
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane anchPackages = loader.load(getClass().getResource("../Scenes/PackagesTab.fxml"));
            tabPackages.setContent(anchPackages);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Calls and display the BookingsTab.fxml scene when the tab is selected
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane anchPackages = loader.load(getClass().getResource("../Scenes/BookingsTab.fxml"));
            tabBookings.setContent(anchPackages);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    } // end of initialize
} // end of main controller
