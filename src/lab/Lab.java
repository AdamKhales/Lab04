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
        
        
        TextField days = new TextField();
        TextField airfare = new TextField();
        TextField rental = new TextField();
        TextField miles = new TextField();
        TextField parking = new TextField();
        TextField taxi = new TextField();
        TextField registration = new TextField();
        TextField lodging = new TextField();
        Label totalExpenses = new Label();
        Label allowable = new Label();
        Label excess = new Label();

        
        Button calculate = new Button("Calculate");
        calculate.setOnAction(e -> {
            
            
            int d = verifyDay(days);
            double af = verifyInput(airfare);
            double r = verifyInput(rental);
            double m = verifyInput(miles);
            double p = verifyInput(parking);
            double t = verifyInput(taxi);
            double reg = verifyInput(registration);
            double l = verifyInput(lodging);
            
            
            
            if (d == -1 || af == -1 || r == -1 || m == -1 || p == -1 || t == -1 || reg == -1 || l == -1) {
            totalExpenses.setText("Error: enter valid numbers");
            return;
            }
            
            
            double expenses = calculateExpenses(d,af,r,m,p,t,reg,l);
            double totalAllowable = calculateAllowable(d,af,r,m,p,t,reg,l);
            
            totalExpenses.setText("Total Expenses: " + expenses + "$");
            allowable.setText("Total Allowable: " + totalAllowable + "$");
            
            excess.setText(calculateExcess(expenses,totalAllowable));
            
            
            
          
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
            totalExpenses.setText("");
            allowable.setText("");
            excess.setText("");
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
        gp.add(allowable, 0, 10);
        gp.add(excess, 0, 11);
        gp.add(clear, 0, 8);
        gp.add(calculate, 1, 8);
        gp.setPadding(new Insets(20,20,20,20));
        gp.setHgap(10);
        gp.setVgap(10);
        
        Scene scene = new Scene(gp, 500,500);
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }
    private double calculateAllowable(int days, double airfare, double rental, double miles, double parking, double taxi, double registration, double lodging){
        return miles * 0.27 +
                days * 37.00 +
                Math.min(parking, days * 10.00)+
                Math.min(taxi, days * 20.00)+
                Math.min(lodging, days * 95.00);
                
                
    }
    
    private double calculateExpenses(int days, double airfare, double rental, double miles, double parking, double taxi, double registration, double lodging){
        double totalExpenses = airfare + rental + miles + parking + taxi + registration + (lodging * (days - 1));
        return totalExpenses;
    }
    
    private String calculateExcess(double totalExpenses, double allowable) {
        if(allowable >= totalExpenses) {
            return "You saved " + totalExpenses + "dollars";
        } else {
            return "You have exceeded the allowable money, you must pay " + (totalExpenses - allowable) + "dollars";
        }
        
    }
    
    
    private double verifyInput(TextField tx) {
        String text = tx.getText();
        if(text.isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(text);
        } catch(NumberFormatException e) {
            return -1;
        }
    }
    
    private int verifyDay(TextField tx) {
        String text = tx.getText();
        if(text.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(text);
        } catch(NumberFormatException e) {
            return -1;
        }
    }
    
}
