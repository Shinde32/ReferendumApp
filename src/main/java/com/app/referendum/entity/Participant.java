package com.app.referendum.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NaturalId;
import com.app.referendum.entity.audit.DateAudit;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "participant", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }), @UniqueConstraint(columnNames = { "aadharNumber" }) })
public class Participant extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String name;

	@NotBlank
	@Size(max = 15)
	private String username;

	@NaturalId
	@NotBlank
	@Size(min = 12, max = 12)
	private String aadharNumber;

	@NaturalId
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

	@NotBlank
	@Size(max = 100)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "participant_role_details", joinColumns = @JoinColumn(name = "participant_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Participant() {

	}

	public Participant(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(min = 12, max = 12) String aadharNumber, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.aadharNumber = aadharNumber;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
