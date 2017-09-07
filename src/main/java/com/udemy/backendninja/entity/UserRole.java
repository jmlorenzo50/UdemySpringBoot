package com.udemy.backendninja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRole.
 */
@Entity
@Table(name ="user_roles", uniqueConstraints=@UniqueConstraint(columnNames={"role", "username"}))
public class UserRole {
	
	/** The user rol id. */
	@Id
	@GeneratedValue
	@Column(name="user_rol_id", unique=true, nullable=false)
	private Integer userRolId;
	
	/** The user. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="username", nullable = false)
	private User user;
	
	/** The role. */
	@Column(name="role", nullable=false, length=45)
	private String role;

	/**
	 * Instantiates a new user role.
	 *
	 * @param user the user
	 * @param role the role
	 */
	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	/**
	 * Instantiates a new user role.
	 */
	public UserRole() {
		super();
	}

	/**
	 * Gets the user rol id.
	 *
	 * @return the user rol id
	 */
	public Integer getUserRolId() {
		return userRolId;
	}

	/**
	 * Sets the user rol id.
	 *
	 * @param userRolId the new user rol id
	 */
	public void setUserRolId(Integer userRolId) {
		this.userRolId = userRolId;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
