package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "issue_record")
public class IssueRecord 
{
	private Integer id;
	
	private Date issue_date;
	private Date return_date;
	private Date due_date;
	private float fine_amount;
	
	private Copies copyId;
	private User memberid ;
	
	
	public IssueRecord()
	{  }
	
	
	public IssueRecord( Date issue_date, Date return_date, Date due_date,
			float fine_amount) {
		super();
		
		this.issue_date = issue_date;
		this.return_date = return_date;
		this.due_date = due_date;
		this.fine_amount = fine_amount;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "issue_date")
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	@Column(name = "fine_amount",length = 30)
	public float getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(float fine_amount) {
		this.fine_amount = fine_amount;
	}
	
	@ManyToOne
	@JoinColumn(name = "copyId")
	public Copies getCopyId() {
		return copyId;
	}


	public void setCopyId(Copies copyId) {
		this.copyId = copyId;
	}

	
	@ManyToOne
	@JoinColumn(name = "memberId")
	public User getMemberid() {
		return memberid;
	}
	
	public void setMemberid(User memberid) {
		this.memberid = memberid;
	}
	@Override
	public String toString() {
		return "BookIssueDetails [id=" + id + ", copyid=" + copyId + ", memberid=" + memberid + ", issue_date="
				+ issue_date + ", return_date=" + return_date + ", due_date=" + due_date + ", fine_amount="
				+ fine_amount + "]";
	}

}
