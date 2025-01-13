/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio;

import java.io.BufferedReader;
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
        int puerto = 12345;
                int puertoO = 12346;

        MulticastSocket ms = new MulticastSocket(puerto);
        byte[] buf=new byte[1000];
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        
        DatagramPacket recibir=new DatagramPacket(buf, buf.length);
        System.out.println("Esperando cliente");
        ms.receive(recibir);  
        System.out.println("Cliente conectado");
        
        String cadena = "Introduce nombre de usuaio";
        DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puertoO);
        ms.send(paquete);
        System.out.println("Pedir nombre enviado");
        
        recibir=new DatagramPacket(buf, buf.length);
        System.out.println("Esperando nombre");
        ms.receive(recibir);  
        String nombre=new String(paquete.getData());
        System.out.println("Nombre recibido "+nombre);
        
        cadena="Bienvenido "+nombre+" ya puedes comenzar a chatear";
        paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puertoO);
        ms.send(paquete);
        System.out.println("Bienvenida enviada");
        
        paquete=new DatagramPacket(buf, buf.length);
        ms.receive(paquete);
        cadena=new String(paquete.getData());
        paquete=new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
        ms.send(paquete);
            
        ms.close();//cierro socket
        System.out.println("Socket cerrado...");

    }
}
