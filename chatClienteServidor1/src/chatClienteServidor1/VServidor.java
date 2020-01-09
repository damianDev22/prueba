package chatClienteServidor1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;


public class VServidor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_mensaje;
	private JTextArea textArea_chat;
	private Socket cliente=null;
	private ServerSocket servidor=null;
	private BufferedReader entrada=null;
	
	private PrintWriter salida=null;
	
	
	private int puerto=8000;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VServidor frame = new VServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
	
	}
	/**
	 * Create the frame.
	 */
	public VServidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			        
			        	
			        		 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			        		 String inputLine; //outputLine;
			        		 String fromServidor;
			        	try {	
			        		
			        			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			        			salida = new PrintWriter(cliente.getOutputStream(), true);
			        			
			        		
			        		  while ((inputLine = entrada.readLine()) != null) {
			        	             
			        				textArea_chat.setText(inputLine);
			        				textArea_chat.getText();
			        		
			        				fromServidor = stdIn.readLine();
			        				
			        				textField_mensaje.setText(fromServidor);
			        				
			        			  	if (fromServidor != null) {
			        			  		textField_mensaje.getText();
			        			  		textArea_chat.setText(textField_mensaje.getText());
			        			  		textArea_chat.getText();
			        			  		salida.println(fromServidor);
			        			  	}
			        		  }	
			        			   }catch (IOException e1) {
						
			        				   e1.printStackTrace();

			        				
						 
					 
			        			   }
			       

			       
				
				
			
				
				
						
			}
		});
		btnEnviar.setBounds(335, 227, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				   try {
			            servidor = new ServerSocket(puerto);
				       System.out.println("Socket Creado");
			        } catch (IOException e) {
			            System.err.println("puerto"+ puerto + " no disponible.");
			            System.exit(1);
			        }

			       
			        try {
			            cliente = servidor.accept();
				    System.out.println("Cliente Aceptado");
			        } catch (IOException e) {
			            System.err.println("Admision fallida.");
			            System.exit(1);
			        }
		
				
				
			}
		});
		btnConectar.setBounds(335, 11, 89, 23);
		contentPane.add(btnConectar);
		
		JTextArea textArea_chat = new JTextArea();
		textArea_chat.setBounds(10, 45, 414, 171);
		contentPane.add(textArea_chat);
		
		
		
		textField_mensaje = new JTextField();
		textField_mensaje.setBounds(10, 228, 315, 20);
		contentPane.add(textField_mensaje);
		textField_mensaje.setColumns(10);
		
	}
}

