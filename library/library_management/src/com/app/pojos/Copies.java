package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="copies")
public class Copies 
{
	 public Integer id;
	 public Integer rack;
	 public String status;
	 
	 public  Book bookId;
	 public List<IssueRecord> issue_record;
	
	 
	 public Copies()
	 { }
	 
	public Copies( Integer rack, String status) {
		this.rack = rack;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Column(length = 30)
	public Integer getRack() {
		return rack;
	}
	public void setRack(Integer rack) {
		this.rack = rack;
	}
	
	@Column(length = 30)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@OneToMany(mappedBy ="copyId", cascade = CascadeType.ALL, orphanRemoval = true )
	public List<IssueRecord> getIssue_record() {
		return issue_record;
	}
	
	public void setIssue_record(List<IssueRecord> issue_record) {
		this.issue_record = issue_record;
	}
	
	@ManyToOne
	@JoinColumn(name = "bookId")
	public Book getBookId() {
		return bookId;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	

	@Override
	public String toString() {
		return "copies [id=" + id + ", bookid=" + bookId + ", rack=" + rack + ", status=" + status + "]";
	}

}