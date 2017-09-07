package com.udemy.backendninja.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCredential.
 */
public class UserCredential {

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Instantiates a new user credential.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public UserCredential(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Instantiates a new user credential.
	 */
	public UserCredential() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCredential [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
