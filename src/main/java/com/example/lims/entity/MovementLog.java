package com.example.lims.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class MovementLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "sample_id")
    private Sample sample;

    @ManyToOne
    @JoinColumn(name = "from_location_id")
    private StorageLocation fromLocation;

    @ManyToOne
    @JoinColumn(name = "to_location_id")
    private StorageLocation toLocation;

    private Timestamp movementDate; // Use Timestamp instead of Date
    private String movementType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public StorageLocation getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(StorageLocation fromLocation) {
		this.fromLocation = fromLocation;
	}

	public StorageLocation getToLocation() {
		return toLocation;
	}

	public void setToLocation(StorageLocation toLocation) {
		this.toLocation = toLocation;
	}

	public Timestamp getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Timestamp movementDate) {
		this.movementDate = movementDate;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    // Getters and Setters
}
