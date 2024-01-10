package com.quiz.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Entity
@Table(name = "company")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String business;
	private String scale;
	private int headcount;
	private String region;
	
	@Column(name="createdAt", updatable = false)
	@UpdateTimestamp
	private ZonedDateTime createdAt;
	
	@Column(name="updatedAt", updatable = false)
	@UpdateTimestamp
	private ZonedDateTime updatedAt;
}
