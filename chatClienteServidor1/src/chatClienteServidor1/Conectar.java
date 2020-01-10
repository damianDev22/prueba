package chatClienteServidor1;
import java.io.*;
import java.net.*;

import javax.swing.JTextField;

public class Conectar {
	Socket Cliente;
	ServerSocket Servidor;
	PrintWriter salida = null;
    BufferedReader entrada = null;
    
    
    String nada ="nada como estas";
    
    final int puerto=8000;
   
    
    public Conectar(){
    	
    	try {
    		Servidor=new ServerSocket(this.puerto);
    		Cliente=Servidor.accept();
    		
    		 entrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
    		 salida = new PrintWriter(Cliente.getOutputStream(), true);
    		
    	}catch(IOException e){
    		System.err.println("Sistema Caido");
    		System.exit(1);
    	}
    }
    
    public Conectar(String ip) {
    	
    	try {
    		
    		Cliente=new Socket(ip,this.puerto);
    		
    		 entrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
    		 salida = new PrintWriter(Cliente.getOutputStream(), true);
    		
    	}catch(IOException e){
    		System.err.println("Sistema Caido del cliente");
    		System.exit(1);
    	}
    	
    }
 
    public void enviarMSJ(String msj){
    	
    	try {
    		
    		salida.write(msj);
    		
    	}catch(Exception e) {
    		
    	}
    	
    }
    
    public String leerMSJ(){
    	
    	try {
    		return entrada.readLine();
    		
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    public void desconectar() {
    	
    	try {
    		
    		Cliente.close();
    		
    	}catch(Exception e) {
    		
    		
    	}
    	
    	try {
    		
    		Servidor.close();
    		
    	}catch(Exception e) {
    		
    		
    	}
    	
    }
    
}
