/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.jmx.remote.util.EnvHelp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

/**
 *
 * @author Romentoss
 */
public class Calculadora extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

       
        Parent root = FXMLLoader.load(getClass().getResource("vista.fxml"));
       
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/historial","root","romenSk8die");
            Statement mySt = con.createStatement();
            ResultSet myRt = mySt.executeQuery("select * from operaciones");
            while (myRt.next()) {
                System.out.println(myRt.getString("IdOperacion")+"."+myRt.getString("Operando1")+" "+myRt.getString("Operacion")+" "+
                        myRt.getString("Operando2")+ " = " + myRt.getString("Resultado"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }
    
}
