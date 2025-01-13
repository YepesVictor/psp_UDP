/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Diurno
 */
public class Recibo {

    public static void main(String[] args) throws Exception {
        int puertoDestino = 12345;
        
        InetAddress ipDestino = InetAddress.getLocalHost();

        String Saludo = "Paquete de prueba 1";
        byte[] mensaje = new byte[1024];

        System.out.println("Creando Datagrama UDP..");
        DatagramPacket paqueteRecibido = new DatagramPacket(mensaje, mensaje.length);

        System.out.println("Creando Socket UDP..");
        DatagramSocket ds = new DatagramSocket(puertoDestino);
        System.out.println("Socket UDP creado!!");
        
        System.out.println("Esperando datagrama...");
        
        ds.receive(paqueteRecibido);
        System.out.println("Datagrama UDP recibido!!");
        
        mensaje = paqueteRecibido.getData();
        String mensajeString = new String(mensaje);
        System.out.println("Mensaje: " + mensajeString);
        
        System.out.println("Cerrando Datagram Socket...");
        ds.close();
        System.out.println("Datagram Socket cerrado!");
    }
}
