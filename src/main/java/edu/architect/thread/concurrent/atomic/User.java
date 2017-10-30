package edu.architect.thread.concurrent.atomic;

public class User {

	private String name;
	private int old;

	public User(String name, int old) {
		this.name = name;
		this.old = old;
		}

	public String getName() {
		return name;
	}

	public int getOld() {
		return old;
	}
	
}
