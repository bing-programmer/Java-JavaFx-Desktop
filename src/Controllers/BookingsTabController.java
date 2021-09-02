/**
 * Author: Shey Adepoju
 * Date: May 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP-264 Java, JavaFX
 */

package Controllers;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Classes.Bookings;
import Main.DBConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookingsTabController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tableView"
    private TableView<Bookings> tableView; // Value injected by FXMLLoader

    @FXML
    private TableColumn<Bookings, Integer> colBkId;

    @FXML
    private TableColumn<Bookings, String> colBkDate;

    @FXML
    private TableColumn<Bookings, String> colBkNo;

    @FXML
    private TableColumn<Bookings, Integer> colCount;

    @FXML
    private TableColumn<Bookings, Integer> CustId;

    @FXML
    private TableColumn<Bookings, String> colType;

    @FXML
    private TableColumn<Bookings, Integer> colPkId;

    @FXML // fx:id="btnEditBooking"
    private Button btnEditBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveBooking"
    private Button btnSaveBooking; // Value injected by FXMLLoader

    @FXML // fx:id="txtbxType"
    private TextField txtbxType; // Value injected by FXMLLoader

    @FXML // fx:id="txtbxCustId"
    private TextField txtbxCustId; // Value injected by FXMLLoader

    @FXML // fx:id="txtbxCount"
    private TextField txtbxCount; // Value injected by FXMLLoader

    @FXML // fx:id="txtbxBkNo"
    private TextField txtbxBkNo; // Value injected by FXMLLoader

    @FXML // fx:id="txtbxBookingId"
    private TextField txtbxBookingId; // Value injected by FXMLLoader

    @FXML // fx:id="txtbxPkgId"
    private TextField txtbxPkgId; // Value injected by FXMLLoader

    @FXML // fx:id="DatePickerBookings"
    private DatePicker DatePickerBookings; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert colBkId != null : "fx:id=\"colBkId\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert colBkDate != null : "fx:id=\"colBkDate\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert colBkNo != null : "fx:id=\"colBkNo\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert colCount != null : "fx:id=\"colCount\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert CustId != null : "fx:id=\"CustId\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert colType != null : "fx:id=\"colType\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert colPkId != null : "fx:id=\"colPkId\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert btnEditBooking != null : "fx:id=\"btnEditBooking\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert btnSaveBooking != null : "fx:id=\"btnSaveBooking\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert txtbxType != null : "fx:id=\"txtbxType\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert txtbxCustId != null : "fx:id=\"txtbxCustId\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert txtbxCount != null : "fx:id=\"txtbxCount\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert txtbxBkNo != null : "fx:id=\"txtbxBkNo\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert txtbxBookingId != null : "fx:id=\"txtbxBookingId\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert txtbxPkgId != null : "fx:id=\"txtbxPkgId\" was not injected: check your FXML file 'BookingsTab.fxml'.";
        assert DatePickerBookings != null : "fx:id=\"DatePickerBookings\" was not injected: check your FXML file 'BookingsTab.fxml'.";


        btnEditBooking.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                txtbxBkNo.setEditable(true);
                DatePickerBookings.setEditable(true);
                txtbxCount.setEditable(true);

                txtbxBookingId.setDisable(false);
                DatePickerBookings.setDisable(false);
                txtbxBkNo.setDisable(false);
                txtbxCount.setDisable(false);
                txtbxCustId.setDisable(false);
                txtbxType.setDisable(false);
                txtbxPkgId.setDisable(false);

                btnEditBooking.setDisable(true);

            }
        });

        //--Save booking button ----------------------------------------------//
        btnSaveBooking.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String sql = "UPDATE `Bookings` SET `BookingDate`=?,`BookingNo`=?,`TravelerCount`=?,"
                        + "`CustomerId`=?,`TripTypeId`=?,`PackageId`=null WHERE BookingId=?";
                Connection conn = new DBConnectionManager().getConnection();
                try {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(6, Integer.parseInt(txtbxBookingId.getText()));
                    stmt.setString(1, (DatePickerBookings.getValue().toString()));
                    stmt.setString(2, txtbxBkNo.getText());
                    stmt.setInt(3, Integer.parseInt(txtbxCount.getText()));
                    stmt.setInt(4, Integer.parseInt(txtbxCustId.getText()));
                    stmt.setString(5, txtbxType.getText());
//                        stmt.setInt(7, Integer.parseInt(txtbxPkgId.getText()));

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("update worked");
                    } else {
                        System.out.println("update failed");
                    }
                    conn.close();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                PopulateBookingListView();
            }
        });


        PopulateBookingListView();
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                DisplayBookingInfo();
                btnEditBooking.setDisable(false);
            }
        });



    } // end of initialize

    //--Populate list view ----------------------------------//
    private void PopulateBookingListView() {

        try {
            Connection conn = new DBConnectionManager().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bookings");
            ObservableList<Bookings> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Bookings(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6) ,rs.getInt(7)));
            }

            colBkId.setCellValueFactory(new PropertyValueFactory<Bookings, Integer>("BkId"));
            colBkDate.setCellValueFactory(new PropertyValueFactory<Bookings, String>("BkDate"));
            colBkNo.setCellValueFactory(new PropertyValueFactory<Bookings, String>("BkNo"));
            colCount.setCellValueFactory(new PropertyValueFactory<Bookings, Integer>("TravelerCount"));
            CustId.setCellValueFactory(new PropertyValueFactory<Bookings, Integer>("CustId"));
            colType.setCellValueFactory(new PropertyValueFactory<Bookings, String>("TripTypeId"));
            colPkId.setCellValueFactory(new PropertyValueFactory<Bookings, Integer>("PkgId"));
            tableView.setItems(list);
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //--Display Booking Information on Tableview-----------------------//
    private void DisplayBookingInfo() {

        String DateString = tableView.getSelectionModel().getSelectedItem().getBkDate();

        String DateResult = DateString.split(" ")[0];

        txtbxBookingId.setText(tableView.getSelectionModel().getSelectedItem().getBkId() + "");
        DatePickerBookings.setValue(LocalDate.parse(DateResult));
        txtbxBkNo.setText(tableView.getSelectionModel().getSelectedItem().getBkNo());
        txtbxCount.setText(tableView.getSelectionModel().getSelectedItem().getTravelerCount()+ "");
        txtbxType.setText(tableView.getSelectionModel().getSelectedItem().getTripTypeId());
        txtbxCustId.setText(tableView.getSelectionModel().getSelectedItem().getCustId()+ "");
        txtbxPkgId.setText(tableView.getSelectionModel().getSelectedItem().getPkgId()+ "");
    }




} // end of class
