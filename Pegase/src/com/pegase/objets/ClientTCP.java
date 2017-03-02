package com.pegase.objets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTCP {


	private static Socket socket;
	private static final int port = 9632;
	private static InetAddress serveur;
	private static BufferedReader in;
    private static PrintStream out;
    private static ClientTCP INSTANCE = new ClientTCP();
	
	ClientTCP (/*TODO : Mettre l'entier port en paramètre du constructeur*/)
	{
		this.initialize();
	}

	public static ClientTCP getInstance() {
		return INSTANCE;
	}

	public boolean initialize(){
		try {
			this.serveur = InetAddress.getLocalHost();
			this.socket = new Socket(this.serveur, this.port);
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new PrintStream(this.socket.getOutputStream());
			return true;
		} catch (Exception e) {
		      e.printStackTrace();
		      return false;
		}
	} 
	
	public String HelloWorld(){
		try {
			this.out.println("Hello World !");
			return this.in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "Error";
		}
	}
		
	
}
