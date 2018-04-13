/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2114928
 */
public class Client extends Thread{
    public final static int CONT_THREADS = 20;
    public final static String url= "https://parcialserv.herokuapp.com/";
    
    public static void main(String[] args){
        for(int i = 0; i<CONT_THREADS; i++){
            Thread h = new Client();
            h.start();
        }
    }

    @Override
    public void run() {
        try {
            printResult("db");
            printResult("");
            printResult("hello");                        
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void printResult(String path) throws MalformedURLException {
        URL result = new URL(url+path);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(result.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
