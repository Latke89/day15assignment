package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Brett on 8/25/16.
 */
public class AssignmentServer {


	public void startServer() {
		try {
			ServerSocket serverListener = new ServerSocket(8005);
			System.out.println("Ready to accept incoming connections!");

			while(true){
				Socket clientSocket = serverListener.accept();
				ConnectionHandler myHandler = new ConnectionHandler(clientSocket);
				Thread myThread = new Thread(myHandler);
				myThread.start();
			}



		}catch(IOException serverException){
			serverException.printStackTrace();
		}

	}

}
