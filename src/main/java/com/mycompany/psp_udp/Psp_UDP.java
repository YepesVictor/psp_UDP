/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.psp_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diurno
 */
public class Psp_UDP {

    public static void main(String[] args) throws Exception {

        int puertoDestino = 12345;
        int puertoOrigen = 4567;

        InetAddress ipDestino = InetAddress.getLocalHost();

        String Saludo = "Paquete de prueba 1";
        byte[] mensaje = new byte[1024];
        mensaje = Saludo.getBytes();

        System.out.println("Creando Datagrama UDP..");
        DatagramPacket paqueteEnvio = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);
        System.out.println("Datagrama UDP creado correctamente!");
        System.out.println("IP destino:" + paqueteEnvio.getAddress());
        System.out.println("PUERTO destino:" + paqueteEnvio.getPort());
        System.out.println("");

        System.out.println("Creando Socket UDP..");
        DatagramSocket ds = new DatagramSocket(puertoOrigen);
        System.out.println("Socket UDP creado!!");
        System.out.println("Enviandio datagrama UDP por Socket UDP...");
        ds.send(paqueteEnvio);
        System.out.println("Datagrama UDP enviado!!");
        System.out.println("Cerrando Datagram Socket...");
        ds.close();
        System.out.println("Datagram Socket cerrado!");
      
    }

}



