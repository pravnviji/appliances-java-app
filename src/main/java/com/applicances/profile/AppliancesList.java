package com.applicances.profile;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppliancesList {

	@Id
	private Long serialNo;
	public Long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	private String brand;
	private String model;
	private int price;
	private String status;
	private Date regDate;

	protected AppliancesList() {

	}

	public AppliancesList(Long serialNo, String brand, String model, int price, String status, Date regDate) {
		super();
		this.setSerialNo(serialNo);
		this.setBrand(brand);
		this.setModel(model);
		this.setPrice(price);
		this.setStatus(status);
		this.regDate = regDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serialNo == null) ? 0 : serialNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppliancesList other = (AppliancesList) obj;
		if (serialNo == null) {
			if (other.serialNo != null)
				return false;
		} else if (!serialNo.equals(other.serialNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppliancesList [serialNo=" + serialNo + ", brand=" + brand + ", model=" + model + ", price=" + price
				+ ", status=" + status + ", regDate=" + regDate + "]";
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
