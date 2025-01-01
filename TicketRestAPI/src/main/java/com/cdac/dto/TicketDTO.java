package com.cdac.dto;

import java.time.LocalDateTime;

import com.cdac.entity.Ticket.Category;
import com.cdac.entity.Ticket.Status;

public class TicketDTO {

    private Integer id;
    private String phoneNumber;
    private Category category;
    private String issueDetails;
    private String resolutionDetails;
    private Status status;
    private LocalDateTime createDateTime;
    private LocalDateTime resolutionDateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getIssueDetails() {
		return issueDetails;
	}
	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}
	public String getResolutionDetails() {
		return resolutionDetails;
	}
	public void setResolutionDetails(String resolutionDetails) {
		this.resolutionDetails = resolutionDetails;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public LocalDateTime getResolutionDateTime() {
		return resolutionDateTime;
	}
	public void setResolutionDateTime(LocalDateTime resolutionDateTime) {
		this.resolutionDateTime = resolutionDateTime;
	}

    
}
