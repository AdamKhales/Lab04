/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 2493077
 */
public class Lab extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        Label lblDays = new Label("Number of days on the trip:");
        Label lblAirfare = new Label("Amount airfare:");
        Label lblRental = new Label("Amount car:");
        Label lblMiles = new Label("Number of miles:");
        Label lblParking = new Label("Amount Parking:");
        Label lblTaxi = new Label("Amount taxi:");
        Label lblRegistration = new Label("Amount registration:");
        Label lblLodging = new Label("Amount lodging per night:");
        
        Label ValidateDays = new Label("Error");
        Label ValidateAirfare = new Label("Error");
        Label ValidateRental = new Label("Car rental fees:");
        Label ValidateMiles = new Label("Number of miles driven:");
        Label ValidateParking = new Label("Parking fees:");
        Label ValidateTaxi = new Label("Taxi charges:");
        Label ValidateRegistration = new Label("Conference or seminar registration fees");
        Label ValidateLodging = new Label("Lodging charges per night:");
        
        TextField days = new TextField();
        TextField airfare = new TextField();
        TextField rental = new TextField();
        TextField miles = new TextField();
        TextField parking = new TextField();
        TextField taxi = new TextField();
        TextField registration = new TextField();
        TextField lodging = new TextField();
        Label totalExpenses = new Label();

        
        Button calculate = new Button("Calculate");
        calculate.setOnAction(e -> {
            totalExpenses.setText(calculateExpenses(
            Integer.parseInt(days.getText()),
            Double.parseDouble(airfare.getText()),
            Double.parseDouble(rental.getText()),
            Double.parseDouble(miles.getText()),
            Double.parseDouble(parking.getText()),
            Double.parseDouble(taxi.getText()),
            Double.parseDouble(registration.getText()),
            Double.parseDouble(lodging.getText())
            ));
        });
        
        
        
        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            days.setText("");
            airfare.setText("");
            rental.setText("");
            miles.setText("");
            parking.setText("");
            taxi.setText("");
            registration.setText("");
            lodging.setText("");
        });
        
        
    
        
        
        
        
        GridPane gp = new GridPane();
        gp.add(lblDays, 0, 0);
        gp.add(days, 1, 0);
        
        gp.add(lblAirfare, 0, 1);
        gp.add(airfare, 1, 1);
        
        gp.add(lblRental, 0, 2);
        gp.add(rental, 1, 2);
        
        gp.add(lblMiles, 0, 3);
        gp.add(miles, 1, 3);
        
        gp.add(lblParking, 0, 4);
        gp.add(parking, 1, 4);
        
        gp.add(lblTaxi, 0, 5);
        gp.add(taxi,1, 5);
        
        gp.add(lblRegistration, 0, 6);
        gp.add(registration, 1, 6);
        
        gp.add(lblLodging, 0, 7);
        gp.add(lodging, 1, 7);
        gp.add(totalExpenses, 0, 9);
        gp.add(clear, 0, 8);
        gp.add(calculate, 1, 8);
        gp.setPadding(new Insets(20,20,20,20));
        gp.setHgap(10);
        gp.setVgap(10);
        
        Scene scene = new Scene(gp, 500,500);
        stage.setScene(scene);
        stage.show();
        
        Label[] labels = {ValidateDays, ValidateAirfare, ValidateRental, ValidateMiles,ValidateParking, ValidateTaxi, ValidateRegistration, ValidateLodging};
        
        
        
    }
    public double calculation(int days, double airfare, double rental, double miles, double parking, double taxi, double registration, double lodging){
        double totalExpenses = days + airfare + rental + miles + parking + taxi + registration + (lodging * days);
        double allowableMiles = miles * 0.27;
        double allowableParking = days * 10.00;
        double allowableTaxi = days * 20.00;
        double allowableLodging = days * 95.00;
        double allowableMeals = days * 37.00;
        
        double remainingParking = 0;
        double remainingTaxi = 0;
        double remainingLodging = 0;
        

        
        if (allowableParking < parking) {
            remainingParking = parking - allowableParking;
        }
        if (allowableParking < parking) {
            remainingParking = parking - allowableParking;
        }
        
        if (allowableTaxi < taxi) {
            remainingTaxi = taxi - allowableTaxi;
        }
        
        if(allowableLodging < (lodging * days)) {
            remainingLodging = lodging - allowableLodging;
        }
        
        double excess = remainingParking + remainingTaxi + remainingLodging + airfare;
        
        
        
        return 0;
    }
    
    public String calculateExpenses(int days, double airfare, double rental, double miles, double parking, double taxi, double registration, double lodging){
        double totalExpenses = days * 37 + airfare + rental + miles + parking + taxi + registration + (lodging * (days - 1));
        return "" + totalExpenses;
    }
    
}
