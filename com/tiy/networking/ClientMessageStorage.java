package com.tiy.networking;

import java.util.ArrayList;

/**
 * Created by Brett on 8/27/16.
 */
public class ClientMessageStorage {
	private String userName;
	ArrayList<String> userMessages = new ArrayList<String>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<String> getUserMessages() {
		return userMessages;
	}

	public void setUserMessages(ArrayList<String> userMessages) {
		this.userMessages = userMessages;
	}
}
