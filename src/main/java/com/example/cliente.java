/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;
import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 2108263
 */
public class cliente extends Thread {
    public static void main(String[] args) throws Exception { 
        for(int i=0;i<20;i++){
            Thread hilo = new cliente();
            hilo.start();
            
        }
    }
    
    public void run(){
        copy("/");
        copy("/hello");
        copy("/db");
        
    }
    
    public void copy(String opcion){
        try {
            URL google = new URL("https://aremparci2.herokuapp.com/"+opcion);
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(google.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println(inputLine);
                }
            } catch (IOException x) { 
                System.err.println(x);
            }
            
        } catch (MalformedURLException ex) { 
                Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null,ex); 
        } 
    
    }
}
