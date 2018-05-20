/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odyssey.Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 13mariano
 */
public class Server 
{
    public static void iniciar() throws IOException
    {
        ServerSocket serversocket = new ServerSocket(1133);
        System.out.println("Contacts server is ready ....");

        while (true)
        {
            Socket client = serversocket.accept();
            System.out.println("Connected");
            // take input and output streams
            Scanner scanner = new Scanner(client.getInputStream());
            
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            // find contact with the given name
            String peticion = scanner.nextLine();
            System.out.println(peticion);
           
            client.close();
        }
    }
}
