/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 *
 * @author Diurno
 */
public class MC_Cliente {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int puertoO = 12346;
        int puerto=12345;
        MulticastSocket ms = new MulticastSocket(puertoO);
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        InetSocketAddress grupoIP = new InetSocketAddress(grupo, puertoO);
        NetworkInterface netIf = NetworkInterface.getByName("10.2.6.9");
        String cadena = "hola servidor";

        ms.joinGroup(grupoIP, netIf);
        
        DatagramPacket enviar=new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
        ms.send(enviar);
        System.out.println("Hola enviado");
        
        byte[] buf = new byte[1000];
        DatagramPacket dg = new DatagramPacket(buf, buf.length);
        System.out.println("Esperando Datagrama");
        ms.receive(dg);
        cadena = new String(dg.getData());
        System.out.println(cadena);

        cadena = in.readLine();
        dg = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
        ms.send(dg);
        System.out.println("Nombre enviado "+cadena);

        dg = new DatagramPacket(buf, buf.length);
        System.out.println("Esperando Datagrama");
        ms.receive(dg);
        cadena = new String(dg.getData());
        System.out.println(cadena);

        cadena = in.readLine();
        dg = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
        ms.send(dg);
    }
}
