package com.mjp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Debt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id;
	@ManyToOne
	@JoinColumn(name = "debitor_id")
	private User debtor;
	@ManyToOne
	@JoinColumn(name = "creditor_id")
	private User creditor;
	private double amount;
	public Debt() {
		
	}
	public Debt(User debtor, User creditor, double amount) {
		super();
		this.debtor = debtor;
		this.creditor = creditor;
		this.amount = amount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getDebtor() {
		return debtor;
	}
	public void setDebtor(User debtor) {
		this.debtor = debtor;
	}
	public User getCreditor() {
		return creditor;
	}
	public void setCreditor(User creditor) {
		this.creditor = creditor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
