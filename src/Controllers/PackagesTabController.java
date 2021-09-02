/**
 * Author: Angelito Tuguinay
 * Date: May 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP-264 Java, JavaFX
 */

package Controllers;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Classes.Packages;
import Main.DBConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PackagesTabController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lvPackages"
    private ListView<Packages> lvPackages; // Value injected by FXMLLoader

    @FXML // fx:id="taPackages"
    private TextArea taPackages; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddPackage"
    private Button btnAddPackage; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeletePackage"
    private Button btnDeletePackage; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditPackage"
    private Button btnEditPackage; // Value injected by FXMLLoader

    @FXML // fx:id="btnSavePackage"
    private Button btnSavePackage; // Value injected by FXMLLoader

    @FXML // fx:id="tfPackageId"
    private TextField tfPackageId; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgName"
    private TextField tfPkgName; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgDesc"
    private TextField tfPkgDesc; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgBasePrice"
    private TextField tfPkgBasePrice; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgAgencyCommission"
    private TextField tfPkgAgencyCommission; // Value injected by FXMLLoader

    @FXML // fx:id="dtStartDate"
    private DatePicker dtStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="dtEndDate"
    private DatePicker dtEndDate; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lvPackages != null : "fx:id=\"lvPackages\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert taPackages != null : "fx:id=\"taPackages\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert btnAddPackage != null : "fx:id=\"btnAddPackage\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert btnDeletePackage != null : "fx:id=\"btnDeletePackage\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert btnEditPackage != null : "fx:id=\"btnEditPackage\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert btnSavePackage != null : "fx:id=\"btnSavePackage\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert tfPackageId != null : "fx:id=\"tfPackageId\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert tfPkgDesc != null : "fx:id=\"tfPkgDesc\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert tfPkgAgencyCommission != null : "fx:id=\"tfPkgAgencyCommission\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert dtStartDate != null : "fx:id=\"dtStartDate\" was not injected: check your FXML file 'PackagesTab.fxml'.";
        assert dtEndDate != null : "fx:id=\"dtEndDate\" was not injected: check your FXML file 'PackagesTab.fxml'.";

        final String[] mode = {"none"};
        listPackages();
        taPackages.setDisable(true);
        btnEditPackage.setDisable(true);
        btnSavePackage.setDisable(true);

        //Package list-view listener
        lvPackages.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                displayPackages();
                btnEditPackage.setDisable(false);
                tfPackageId.setDisable(true);
            }
        });

        //Package Edit Button
        btnEditPackage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                enablePackageTf();
                btnEditPackage.setDisable(true);
                btnSavePackage.setDisable(false);
                mode[0] = "edit";
            }

        });

        //Package Save Button
        btnSavePackage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String sql_edit = "UPDATE `packages` SET `PkgName`=?,`PkgStartDate`=?,`PkgEndDate`=?,"
                        + "`PkgDesc`=?,`PkgBasePrice`=?,`PkgAgencyCommission`=?" +
                        "WHERE PackageId=?";
                Connection conn = new DBConnectionManager().getConnection();
                switch (mode[0]) {
                    case "edit":


                        try {
                            PreparedStatement stmt_edit = conn.prepareStatement(sql_edit);
                            stmt_edit.setString(1, tfPkgName.getText());
                            stmt_edit.setString(2, (dtStartDate.getValue().toString()));
                            stmt_edit.setString(3, (dtEndDate.getValue()).toString());
                            stmt_edit.setString(4, tfPkgDesc.getText());
                            stmt_edit.setDouble(5, Double.parseDouble(tfPkgBasePrice.getText()));
                            stmt_edit.setDouble(6, Double.parseDouble(tfPkgAgencyCommission.getText()));
                            stmt_edit.setInt(7, Integer.parseInt(tfPackageId.getText()));
                            int rowsAffectedEdit = stmt_edit.executeUpdate();
                            if (rowsAffectedEdit > 0) {
                                System.out.println("Packages table updated success");
                            } else {
                                System.out.println("Packages table update failed");
                            }
                            conn.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        clearPackages();
                        listPackages();
                        disablePackageTf();
                        break;

                    case "add":
                        String sql_add = "INSERT INTO `packages` (`PkgName`, `PkgStartDate`, `PkgEndDate`, `PkgDesc`, " +
                                "`PkgBasePrice`, `PkgAgencyCommission`) " +
                                "VALUES (?,?,?,?,?,?)";
                        try {
                            PreparedStatement stmt_add = conn.prepareStatement(sql_add);
                            stmt_add.setString(1, tfPkgName.getText());
                            stmt_add.setDate(2, Date.valueOf(dtStartDate.getValue()));
                            stmt_add.setDate(3, Date.valueOf(dtEndDate.getValue()));
                            stmt_add.setString(4, tfPkgDesc.getText());
                            stmt_add.setDouble(5, Double.parseDouble(tfPkgBasePrice.getText()));
                            stmt_add.setDouble(6, Double.parseDouble(tfPkgAgencyCommission.getText()));
                            int rowsAffectedAdd = stmt_add.executeUpdate();
                            if (rowsAffectedAdd > 0) {
                                System.out.println("Packages table: Add successful");
                            } else {
                                System.out.println("Packages table: Add failed");
                            }

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        clearPackages();
                        listPackages();
                        break;
                }
            }
        });

        //Package Add Button
        btnAddPackage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clearPackages();
                enablePackageTf();
                btnEditPackage.setDisable(false);
                tfPackageId.setDisable(true);
                tfPkgName.setEditable(true);
                dtStartDate.setEditable(true);
                dtEndDate.setEditable(true);
                tfPkgDesc.setEditable(true);
                tfPkgBasePrice.setEditable(true);
                tfPkgAgencyCommission.setEditable(true);
                btnSavePackage.setDisable(false);
                mode[0] = "add";
            }
        });

        //Package Delete Button
        btnDeletePackage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Packages packages = lvPackages.getSelectionModel().getSelectedItem();
                String sql = "DELETE FROM `packages` WHERE PackageId=" + packages.getPackageId();
                Connection conn = new DBConnectionManager().getConnection();

                try {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.execute();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                clearPackages();
                listPackages();

            }
        });

    } // end of initialize

        //Display Packages on Text fields
        private void displayPackages () {
            disablePackageTf();
            btnSavePackage.setDisable(true);

            String startDateString = lvPackages.getSelectionModel().getSelectedItem().getPkgStartDate();
            String endDateString = lvPackages.getSelectionModel().getSelectedItem().getPkgEndDate();

            String startDateResult = startDateString.split(" ")[0];
            String endDateResult = endDateString.split(" ")[0];

            tfPackageId.setText(lvPackages.getSelectionModel().getSelectedItem().getPackageId() + "");
            tfPkgName.setText(lvPackages.getSelectionModel().getSelectedItem().getPkgName());
            dtStartDate.setValue(LocalDate.parse(startDateResult));
            dtEndDate.setValue(LocalDate.parse(endDateResult));
            tfPkgDesc.setText(lvPackages.getSelectionModel().getSelectedItem().getPkgDesc());
            tfPkgBasePrice.setText(lvPackages.getSelectionModel().getSelectedItem().getPkgBasePrice() + "");
            tfPkgAgencyCommission.setText(lvPackages.getSelectionModel().getSelectedItem().getPkgAgencyCommission() + "");
        }

        //Display packages on List View
        private void listPackages () {
            try {
                Connection conn = new DBConnectionManager().getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from packages");
                ObservableList<Packages> list = FXCollections.observableArrayList();

                while (rs.next()) {
                    list.add(new Packages(rs.getInt("PackageId"), rs.getString("PkgName"),
                            rs.getString("PkgStartDate"), rs.getString("PkgEndDate"),
                            rs.getString("PkgDesc"), rs.getDouble("PkgBasePrice"),
                            rs.getDouble("PkgAgencyCommission")));
                }
                lvPackages.setItems(list);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        //clear packages
        private void clearPackages () {
            tfPackageId.setText(null);
            tfPkgName.setText(null);
            dtStartDate.setValue(null);
            dtEndDate.setValue(null);
            tfPkgDesc.setText(null);
            tfPkgBasePrice.setText(null);
            tfPkgAgencyCommission.setText(null);
        }

        //disable package textfields
        private void disablePackageTf () {
            tfPackageId.setDisable(true);
            tfPkgName.setDisable(true);
            dtStartDate.setDisable(true);
            dtEndDate.setDisable(true);
            tfPkgDesc.setDisable(true);
            tfPkgBasePrice.setDisable(true);
            tfPkgAgencyCommission.setDisable(true);
            btnEditPackage.setDisable(false);
        }

        //enable package textfields
        private void enablePackageTf () {
            tfPackageId.setDisable(false);
            tfPkgName.setDisable(false);
            dtStartDate.setDisable(false);
            dtEndDate.setDisable(false);
            tfPkgDesc.setDisable(false);
            tfPkgBasePrice.setDisable(false);
            tfPkgAgencyCommission.setDisable(false);
            btnSavePackage.setDisable(false);
        }

    }



