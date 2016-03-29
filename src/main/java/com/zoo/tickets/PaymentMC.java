package com.zoo.tickets;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class PaymentMC {
	private String order;
	private String price;
	private int cardNumber;
	private int securityNumber;
	private String expiryDate;

	@Inject
	private BookingHolder bookingHolder;

	@Inject
	BookingService bookingServie;

	@PostConstruct
	public void init() {
		order = bookingHolder.getBooking().orderToString();
		price = String.valueOf(bookingHolder.getBooking().getPrice());
	}

	public String payment() {
		bookingServie.saveBooking(bookingHolder.getBooking());
		return Boolean.TRUE.toString();
	}

	// Getters / Setters
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getSecurityNumber() {
		return securityNumber;
	}

	public void setSecurityNumber(int securityNumber) {
		this.securityNumber = securityNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
}
