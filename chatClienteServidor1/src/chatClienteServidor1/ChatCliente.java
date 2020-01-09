package chatClienteServidor1;

import java.io.*;
import java.net.*;

public class ChatCliente {
  public static void main(String[] args) throws IOException {

    Socket cliente = null;
    PrintWriter salida = null;
    BufferedReader entrada = null;
    int puerto=5000;
    String ip= "192.168.1.25";
    
    try {
      cliente = new Socket(ip, puerto);
      salida = new PrintWriter(cliente.getOutputStream(), true);
      entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host: manis.csi.ull.es.");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to: manis.csi.ull.es.");
      System.exit(1);
    }
    String fromServidor;
    String fromCliente;

    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
  
    while ((fromServidor = entrada.readLine()) != null) {
      System.out.println("Server: " + fromServidor);
      if (fromServidor.equals("Bye."))
        break;
        
      fromCliente = stdIn.readLine();
      if (fromCliente != null) {
       // System.out.println("Client: " + fromCliente);
        salida.println(fromCliente);
      }
    }

    salida.close();
    entrada.close();
    stdIn.close();
    cliente.close();
 }
}