package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment 
{
  private Integer id;
  private double amount;
  private String type;
  private String transaction_time;
  private Date nextPayment_dueDate;
 
  
  
  public Payment()
  {   
	  
  }
public Payment(double amount, String type, String transaction_time, Date nextPayment_dueDate) {
	super();
	this.amount = amount;
	this.type = type;
	this.transaction_time = transaction_time;
	this.nextPayment_dueDate = nextPayment_dueDate;
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
public double getAmount() {
	return amount;
}


public void setAmount(double amount) {
	this.amount = amount;
}

@Column(length = 30)
public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}

@Column(length = 30)
public String getTransaction_time() {
	return transaction_time;
}


public void setTransaction_time(String transaction_time) {
	this.transaction_time = transaction_time;
}

@Temporal(TemporalType.DATE)
@Column(name = "due_date")
public Date getNextPayment_dueDate() {
	return nextPayment_dueDate;
}


public void setNextPayment_dueDate(Date nextPayment_dueDate) {
	this.nextPayment_dueDate = nextPayment_dueDate;
}





@Override
public String toString() {
	return "Payment [id=" + id + ", amount=" + amount + ", type=" + type + ", transaction_time=" + transaction_time
			+ ", nextPayment_dueDate=" + nextPayment_dueDate +  "]";
}
  

  
}
