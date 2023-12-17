package com.rental.user.domain;
/**
 * @author Lin Lae Win Wah
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contractId;
	
	private Date validUntil;
	private Double rentAmount;
	private String duration;
	private String paidBy;// All per 1 month per 3 month per 6 month
	private Date signDate;
	
	@Column(columnDefinition = "text")
	private String terms;
	
	@Transient
	private MultipartFile contractImage;

	@OneToOne(mappedBy = "contract")
	private ContractUser contractUser;
	
	
	public Contract() {}
	
	public MultipartFile getContractImage() {
		return contractImage;
	}

	public void setContractImage(MultipartFile contractImage) {
		this.contractImage = contractImage;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public Double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public ContractUser getContractUser() {
		return contractUser;
	}

	public void setContractUser(ContractUser contractUser) {
		this.contractUser = contractUser;
	}
	
	
}
