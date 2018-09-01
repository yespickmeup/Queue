/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guinness
 */
public class Ip {

    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("System IP Address : "
                    + (localhost.getHostAddress()).trim());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Ip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
