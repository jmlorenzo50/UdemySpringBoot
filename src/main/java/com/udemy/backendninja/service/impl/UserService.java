package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.entity.UserRole;
import com.udemy.backendninja.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service("userService")
public class UserService implements UserDetailsService{
	
	
	/** The user repository. */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.udemy.backendninja.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> autorities = buildAuthorities(user.getUserRole());
		return buildUser(user, autorities);
	}
	
	/**
	 * Builds the user.
	 *
	 * @param user the user
	 * @param authorities the authorities
	 * @return the user
	 */
	private User buildUser(com.udemy.backendninja.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), 
				true, true, true, authorities);
	}
	
	/**
	 * Builds the authorities.
	 *
	 * @param userRole the user role
	 * @return the list
	 */
	private  List<GrantedAuthority> buildAuthorities (Set<UserRole> userRole) {
		Set<GrantedAuthority> outs = new HashSet<GrantedAuthority>();
		for (UserRole role : userRole) {
			outs.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new ArrayList<GrantedAuthority>(outs);
	}

}
