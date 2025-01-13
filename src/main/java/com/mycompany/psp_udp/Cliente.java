/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Diurno
 */
public class Cliente {

    public static void main(String[] args) throws Exception {

        int puertoDestino = 12345;
        int puertoOrigen = 4567;

        InetAddress ipDestino = InetAddress.getLocalHost();

        String cadena1 = "getdate ";
        String cadena2 = "gethour ";
        String cadena3 = "getmayus hola";
        byte[] mensaje = new byte[1024];
        mensaje = cadena1.getBytes();

        System.out.println("Creando Datagrama UDP..");
        DatagramPacket paqueteEnvio = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);
        DatagramPacket paqueteRecibido = new DatagramPacket(mensaje, mensaje.length);

        System.out.println("D/atagrama UDP   creado correctamente!");
        System.out.println("IP destino:" + paqueteEnvio.getAddress());
        System.out.println("PUERTO destino:" + paqueteEnvio.getPort());
        System.out.println("");

        System.out.println("Creando Socket UDP..");
        DatagramSocket ds = new DatagramSocket(puertoOrigen);
        System.out.println("Socket UDP creado!!");
        System.out.println("Enviandio datagrama UDP por Socket UDP...");

        ds.send(paqueteEnvio);
        //Primer envio
        System.out.println("Esperando datagrama");
        ds.receive(paqueteRecibido);
        mensaje = paqueteRecibido.getData();
        String mensajeRecibo = new String(mensaje);
        System.out.println(mensajeRecibo);

        //Segundo envio
        System.out.println("Esperando datagrama");
        mensaje = cadena2.getBytes();
        paqueteEnvio = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);
        ds.send(paqueteEnvio);

        ds.receive(paqueteRecibido);
        mensaje = paqueteRecibido.getData();
        String mensajeRecibo2 = new String(mensaje);
        System.out.println(mensajeRecibo2);

        //Tercer envio
        System.out.println("Esperando datagrama");
        mensaje = cadena3.getBytes();
        paqueteEnvio = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);
        ds.send(paqueteEnvio);

        ds.receive(paqueteRecibido);
        mensaje = paqueteRecibido.getData();
        String mensajeRecibo3 = new String(mensaje);
        System.out.println(mensajeRecibo3);

        System.out.println("Datagrama UDP enviado!!");
        System.out.println("Cerrando Datagram Socket...");
        ds.close();
        System.out.println("Datagram Socket cerrado!");

    }
}
