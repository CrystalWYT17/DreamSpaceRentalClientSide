package com.rental.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String agentFName;
	private String agentLName;
	private String agentEmail;
	private String agentPh;
	private String agentTownship;
	private String agentAddress;
	
	private Boolean active = true;
	
	@Transient
	private MultipartFile agentImage;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAgentFName() {
		return agentFName;
	}
	public void setAgentFName(String agentFName) {
		this.agentFName = agentFName;
	}
	public String getAgentLName() {
		return agentLName;
	}
	public void setAgentLName(String agentLName) {
		this.agentLName = agentLName;
	}
	public String getAgentEmail() {
		return agentEmail;
	}
	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}
	public String getAgentPh() {
		return agentPh;
	}
	public void setAgentPh(String agentPh) {
		this.agentPh = agentPh;
	}
	public String getAgentTownship() {
		return agentTownship;
	}
	public void setAgentTownship(String agentTownship) {
		this.agentTownship = agentTownship;
	}
	public String getAgentAddress() {
		return agentAddress;
	}
	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public MultipartFile getAgentImage() {
		return agentImage;
	}
	public void setAgentImage(MultipartFile agentImage) {
		this.agentImage = agentImage;
	}
	
	
	
}
