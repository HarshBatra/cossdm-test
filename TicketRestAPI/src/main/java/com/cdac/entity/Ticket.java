package com.cdac.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(name = "issue_details", nullable = false)
    private String issueDetails;

    @Column(name = "resolution_details")
    private String resolutionDetails;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "create_date_time", nullable = false)
    private LocalDateTime createDateTime;

    @Column(name = "resolution_date_time")
    private LocalDateTime resolutionDateTime;

    public enum Category {
        SIM, CALLING, BROADBAND
    }

    public enum Status {
        OPEN, IN_PROGRESS, RESOLVED
    }

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

	public Ticket(Integer id, String phoneNumber, Category category, String issueDetails, String resolutionDetails,
			Status status, LocalDateTime createDateTime, LocalDateTime resolutionDateTime) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.category = category;
		this.issueDetails = issueDetails;
		this.resolutionDetails = resolutionDetails;
		this.status = status;
		this.createDateTime = createDateTime;
		this.resolutionDateTime = resolutionDateTime;
	}

	public Ticket() {}
}
