package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Controller
@Entity
@Table(name="cust_details")
public class CustomerPojo {

	@Id
	@Column(name="cid")
	@GeneratedValue //autoincrement
	private int cid;

	@Column(name="c_name")
	private String cname;

	@Column(name="c_email")
	private String cemail;

	@Column(name="c_pass")
	private String cpass;

	@Column(name="gender")
	private String gender;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	@Column(name="c_address")
	private String caddress;

}
