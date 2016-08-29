package com.tiy.networking;

import com.sun.deploy.util.SessionState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Brett on 8/25/16.
 */
public class ConnectionHandler implements Runnable {

	Socket connection;

	public ConnectionHandler(Socket incomingConnection) {
		this.connection = incomingConnection;
	}

	public void run() {
		handleIncomingConnections(connection);
	}


	private void handleIncomingConnections(Socket inputSocket) {
		try {
			System.out.println("Incoming connection from " + inputSocket.getInetAddress().getHostAddress());

			BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
			PrintWriter outputToClient = new PrintWriter(inputSocket.getOutputStream(), true);

			ClientMessageStorage myClientStorage = new ClientMessageStorage();
			String firstInput;
			String clientName;
			firstInput = inputFromClient.readLine();
			String[] nameArray = firstInput.split("=");
			clientName = nameArray[1];
			outputToClient.println("Thank you, " + clientName);
			myClientStorage.setUserName(clientName);


			String inputLine;
			String historyString = null;
			while ((inputLine = inputFromClient.readLine()) != null) {
				if (inputLine.equalsIgnoreCase("history"))  {
//					outputToClient.println("You have " + myClientStorage.userMessages.size() + " messages. Would you like to receive them? y/n");
//					if(inputLine.equalsIgnoreCase("y")) {
//						while(true) {
							for (String myHistory : myClientStorage.userMessages) {
								outputToClient.println(myHistory);
							}
//							outputToClient.println("bye");
//						}
//					}
				} else {
					System.out.println(clientName + " says: " + inputLine);
					outputToClient.println("Message sent");
					myClientStorage.userMessages.add(inputLine);
				}
			}
			}catch (IOException exception){
				exception.printStackTrace();
			}
	}
}

