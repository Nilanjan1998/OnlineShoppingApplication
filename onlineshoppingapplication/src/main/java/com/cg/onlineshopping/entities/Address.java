package com.cg.onlineshopping.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address_details")
public class Address {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
	private int addressId;

	@Column(name = "street_no")
	@NotEmpty(message="Stree_no should not empty")
	private String streetNo;

	@Column(name = "building_name")
	@NotEmpty(message="Building Name should not empty")
	private String buildingName;

	@Column(name = "city")
	@NotEmpty(message="City should not empty")
	private String city;

	@Column(name = "state")
	@NotEmpty(message="State should not empty")
	private String state;

	@Column(name = "country")
	@NotEmpty(message="Country should not empty")
	private String country;

	@Column(name = "pincode")
	@Size(min=6, max=10, message="Pincode should minimum be 6 and maximum 10")
	private String pincode;

	// Mapping Part
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "addressOrder")
	private List<Order> order = new ArrayList<Order>();

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customerAdd;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String streetNo, String buildingName, String city, String state, String country,
			String pincode) {
		super();
		this.addressId = addressId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Customer getCustomerAdd() {
		return customerAdd;
	}

	public void setCustomerAdd(Customer customerAdd) {
		this.customerAdd = customerAdd;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNo=" + streetNo + ", buildingName=" + buildingName
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", order="
				+ order + ", customerAdd=" + customerAdd + "]";
	}

}
