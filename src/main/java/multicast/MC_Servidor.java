/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Diurno
 */
public class MC_Servidor {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        MulticastSocket ms = new MulticastSocket();

        int puerto = 12345;
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        String cadena = "";
        while (!cadena.trim().equals("*")) {
            System.out.print("Datos a enviar al grupo: ");
            cadena = in.readLine();
            // ENVIANDO AL GRUPO
            DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
            ms.send(paquete);
        }
        ms.close();//cierro socket
        System.out.println("Socket cerrado...");

    }
}
