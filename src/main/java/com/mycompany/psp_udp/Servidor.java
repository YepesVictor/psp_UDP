/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Diurno
 */
public class Servidor {

    public static void main(String[] args) throws Exception {
        int puertoOrigen = 12345;
        int puertoDestino = 4567;

        InetAddress ipDestino = InetAddress.getLocalHost();

        byte[] mensaje = new byte[1024];

        System.out.println("Creando Datagrama UDP..");
        DatagramPacket paqueteRecibido = new DatagramPacket(mensaje, mensaje.length);

        System.out.println("Creando Socket UDP..");
        DatagramSocket ds = new DatagramSocket(puertoOrigen);
        System.out.println("Socket UDP creado!!");

        System.out.println("Esperando datagrama...");

        for (int i = 0; i < 3; i++) {
            ds.receive(paqueteRecibido);
            System.out.println("Datagrama UDP recibido!!");
            mensaje = paqueteRecibido.getData();
            String mensajeString = new String(mensaje);
            System.out.println("Mensaje: " + mensajeString);
            String[] comando = mensajeString.split(" ");
            switch (comando[0]) {
                case "getdate":
                    String enviar = LocalDate.now().toString();
                    System.out.println(enviar);
                    mensaje = enviar.getBytes();
                    DatagramPacket paqueteEnvio = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);
                    ds.send(paqueteEnvio);
                    System.out.println("Paquete enviado\n");
                    break;
                case "gethour":
                    int hora=LocalDateTime.now().getHour();
                    int minuto=LocalDateTime.now().getMinute();
                    String enviar2 = Integer.toString(hora)+":"+Integer.toString(minuto);
                    mensaje = enviar2.getBytes();
                    DatagramPacket paqueteEnvio2 = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);
                    ds.send(paqueteEnvio2);
                    System.out.println("Paquete enviado\n");
                    break;
                case "getmayus":
                    String enviar3 = comando[1].toUpperCase();
                    mensaje = enviar3.getBytes();
                    DatagramPacket paqueteEnvio3 = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);
                    ds.send(paqueteEnvio3);
                    System.out.println("Paquete enviado\n");
                    break;
                default:
                    throw new AssertionError();
            }
        }
        System.out.println("Cerrando Datagram Socket...");
        ds.close();
        System.out.println("Datagram Socket cerrado!");
    }
}