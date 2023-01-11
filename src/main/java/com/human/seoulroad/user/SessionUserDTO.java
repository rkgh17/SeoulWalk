package com.human.seoulroad.user;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionUserDTO implements Serializable{
	private String name;
	private String email;
	
	public SessionUserDTO(SiteUser siteuser) {
		this.name = siteuser.getName();
		this.email = siteuser.getEmail();
	}

}