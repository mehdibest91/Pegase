package com.pegase.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.pegase.objets.ClientTCP;

//import com.pegase.beans.Game;
//import com.pegase.objets.GameSingleton;

public class GameManager extends HttpServlet {
	
	//private GameSingleton gameSingleton = GameSingleton.getInstance();

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		// Création et initialisation du message. 		
		String message = "Aucun nouveau message";
		String paramTurnGame = request.getParameter( "turnGame" );
		String turnGame = "";
		if (paramTurnGame == null)
			turnGame = "";
		else
			turnGame = paramTurnGame.toUpperCase();
//		String nom = gameSingleton.getNom();
//    	Game game = new Game();
		switch (turnGame) { //TODO : Mettre des int
			case "" : break;
			case "ON": 
	        	message = "La partie est (re)demarrée";
//	        	nom = "Partie-"+ (new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss", Locale.FRANCE).format(new Date()));
//	        	game.setNom(nom);
//	        	gameSingleton.setNom(nom);
//	        	game.setInProgress(true);
//	        	gameSingleton.setInProgress(true);
//	        	game.setGameSingleton(gameSingleton);
	            break;
	        case "OFF":  message = "La partie est arrêtée";
//		        game.setInProgress(false);	
//		        gameSingleton.setInProgress(false);
	            break;
	        default: message = "Paramètre <i>turnGame</i> invalide : \"" + turnGame + "\"";
	            break;
		}
		
//		request.setAttribute( "Game", game );
		request.setAttribute( "Message", message );
		
		this.getServletContext().getRequestDispatcher( "/manager.jsp" ).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		//System.out.println("La fonction doPost a été appelée");
		boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
		if (ajax) {
			String func = request.getParameter("function");
			System.out.print("function : " + func + " ");
	        // Handle ajax (JSON or XML) response.
			if (func.equals("turn")){
				String msgPegase;
				String msgHermes = "Pas de nouveau message d'Hermes";
				//TODO : PEC de l'envoi du message TCP et de sa réception
				String allState = request.getParameter("state");
				String state = "";
				
				if (allState.equals("ON")){
					state = "OFF";
					msgPegase = "La partie est arrêtée";
				} else if (allState.equals("OFF")){
					state = "ON";
					msgPegase = "\n\tInitialisation du Client TCP : ";
					if (ClientTCP.getInstance().initialize())
					{
						msgPegase += "Succès\n";
					} else {
						msgPegase += "Erreur : Voir la stack pour plus d'information\n";
					}
					msgPegase += "\nLa partie est en cours";
					
				} else {
					state = "";
					msgPegase = "Erreur, mauvais status de partie rentré en paramètre";
				}
				System.out.print(state);
				JSONObject monJson = new JSONObject();
				try {
					monJson.put("messagePegase", msgPegase);
					monJson.put("messageHermes", msgHermes);
					monJson.put("state", state);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.setContentType("json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(monJson.toString());
			} else if (func.equals("helloWorld")){
				String msgHermes = ClientTCP.getInstance().HelloWorld();
				String msgPegase = msgHermes.equals("Error") ? "Une erreur est survenue dans la fonction HelloWorld()": "Le message a bien été envoyé sur la socket";
				msgHermes = msgHermes.equals("Error")? "Une erreur est survenue sur Pegase, aucun message d'Hermes n'a été reçu": msgHermes;
				JSONObject monJson = new JSONObject();
				try {
					monJson.put("messagePegase", msgPegase);
					monJson.put("messageHermes", msgHermes);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.setContentType("json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(monJson.toString());
				System.out.println();
			}
			System.out.println();
	    } else {
	        // Handle regular (JSP) response.
	    }
		
	}
}
