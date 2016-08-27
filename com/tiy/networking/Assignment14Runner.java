package com.tiy.networking;

/**
 * Created by Brett on 8/25/16.
 */
public class Assignment14Runner {
	public static void main(String[] args) {
		System.out.println("AssignmentRunner Running");

		AssignmentServer myServer = new AssignmentServer();
		myServer.startServer();
	}
}
