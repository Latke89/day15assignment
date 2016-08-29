package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Brett on 8/25/16.
 */
public class AssignmentClient {

	public static void main(String[] args) {
		int messageCount = 0;
		Scanner inputScanner = new Scanner(System.in);
		try {
			// connect to the server on the target port
			Socket clientSocket = new Socket("localhost", 8005);
			System.out.println("Please input your name");
			String name = inputScanner.nextLine();

			// once we connect to the server, we also have an input and output stream
			PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			while(true) {
				if (messageCount == 0) {
					outputToServer.println("name=" + name);
					String serverResponse = inputFromServer.readLine();
					messageCount++;
				} else {
					System.out.println("What would you like to send?");
					System.out.println("Type \"history\" for message history");
					String message = inputScanner.nextLine();
					// send the server an arbitrary message
					outputToServer.println(message);
					// read what the server returns
					String serverResponse = inputFromServer.readLine();
					System.out.println(serverResponse);
					if (serverResponse.startsWith("You")) {
//						while(true) {
							String historyResponse = inputScanner.nextLine();
							outputToServer.println(historyResponse);
							String historyFromServer = inputFromServer.readLine();
							System.out.println(historyFromServer);
//							if(historyFromServer == "bye"){
//								break;
//							}
						}
//					}
					System.out.println("Would you like to send another message? y/n");
					String userChoice = inputScanner.nextLine();
					if (userChoice.equalsIgnoreCase("n")) {
						break;
				}
				}
			}
			// close the connection
			clientSocket.close();

		} catch (IOException clientException) {
			clientException.printStackTrace();
		}
	}
}

