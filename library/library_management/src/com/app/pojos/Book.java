package com.app.pojos;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book")
public class Book 
{
    
	private Integer bookId;
    
	private String subjectName, bookName, authorName;
    
	private float price;
    
    private List<Copies> copyId;
	public Book() 
	{	}
	
	
	public Book( String subjectName, String bookName, String authorName, float price) 
	{
		
		this.subjectName = subjectName;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	@Column(length = 20)
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Column(length = 20)
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Column(length = 20)
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Column(length = 20)
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@OneToMany(mappedBy = "bookId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public List<Copies> getCopyId() {
		return copyId;
	}
	public void setCopyId(List<Copies> copyId) {
		this.copyId = copyId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", subjectName=" + subjectName + ", bookName=" + bookName + ", authorName="
				+ authorName + ", price=" + price + "]";
	}
	
	
	
}

