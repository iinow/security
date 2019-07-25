package com.ha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "oauth_client_details")
public class OAuthClientDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String cilentId;
	
	@Column
	private String clientSecret;
	
	@Column
	private String scope;
	
	@Column
	private String grantType;
	
	@Column
	private String redirectUri;
	
	@Column
	private String authorites;
	
	@Column
	private String accesstokenValidity;
	
	@Column
	private String refreshtokenValidity;
	
	@Column
	private String info;
	
	@Column
	private String autoApprove;
}
