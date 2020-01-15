package com.app.pojos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User 
{
	private Integer id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private UserRole role;
	private List<IssueRecord>issue_record;
		
	public User() {
		
	}
	
	public User( String name, String password, String phone,String email,UserRole role) {
		super();
		
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email=email;
		this.role=role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length = 20)
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 20)
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	@Column(length = 20, unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy ="memberid", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<IssueRecord> getIssue_record() {
		return issue_record;
	}

	public void setIssue_record(List<IssueRecord> issue_record) {
		this.issue_record = issue_record;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", role=" + role + ", issue_record=" + issue_record +  "]";
	}

	
	
	
	
}


