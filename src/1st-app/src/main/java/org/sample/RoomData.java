package org.sample;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomData {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Long createdBy;
	
	@Column(nullable = false)
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "RoomData [id=" + this.id +
				", title=" + this.title +
				", createdBy=" + this.createdBy.toString() +
				", createdAt=" + this.createdAt.toString() +
				"]";
	}
}
