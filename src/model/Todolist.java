package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Entity
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long listid;

	@Temporal(TemporalType.DATE)
	private Date completedate;

	private int doerid;

	@Temporal(TemporalType.DATE)
	private Date duedate;

	private String itemdescription;

	private int statusid;

	public Todolist() {
	}

	public long getListid() {
		return this.listid;
	}

	public void setListid(long listid) {
		this.listid = listid;
	}

	public Date getCompletedate() {
		return this.completedate;
	}

	public void setCompletedate(Date completedate) {
		this.completedate = completedate;
	}

	public int getDoerid() {
		return this.doerid;
	}

	public void setDoerid(int i) {
		this.doerid = i;
	}

	public Date getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getItemdescription() {
		return this.itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public int getStatusid() {
		return this.statusid;
	}

	public void setStatusid(int i) {
		this.statusid = i;
	}

}