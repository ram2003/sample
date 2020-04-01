package com.accenture.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table (name="customer_spring")
public class CustomerEntityBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	
	@Temporal(TemporalType.DATE)
	private Date billingtime;
	private double billingamount;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Date getBillingtime() {
		return billingtime;
	}
	public void setBillingtime(Date billingtime) {
		this.billingtime = billingtime;
	}
	public double getBillingamount() {
		return billingamount;
	}
	public void setBillingamount(double billingamount) {
		this.billingamount = billingamount;
	}
	
}
