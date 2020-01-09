package chatClienteServidor1;
import java.io.*;
import java.net.*;

public class ChatServidor {
    public static void main(String[] args) throws IOException {
    	
    	Socket clientSocket = null;
        ServerSocket serverSocket = null;
        int puerto=4000;
        
        try {
            serverSocket = new ServerSocket(puerto);
	       System.out.println("Socket Creado");
        } catch (IOException e) {
            System.err.println("puerto"+ puerto + " no disponible.");
            System.exit(1);
        }

       
        try {
            clientSocket = serverSocket.accept();
	    System.out.println("Cliente Aceptado");
        } catch (IOException e) {
            System.err.println("Admision fallida.");
            System.exit(1);
        }

        PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine; //outputLine;
        String fromServidor;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    
	//salida.println("ingriddddddddd!");
        
    while ((inputLine = entrada.readLine()) != null) {
             
		System.out.println("CLIENTE: " + inputLine);
 
		fromServidor = stdIn.readLine();
	  	if (fromServidor != null) {
			System.out.println("SERVIDOR: " + fromServidor);
			salida.println(fromServidor);
	   }

		if (fromServidor.equals("Bye."))
                	break;
        }
        salida.close();
        entrada.close();
        clientSocket.close();
        serverSocket.close();
    }
}
