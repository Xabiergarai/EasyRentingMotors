package erm.clasesBasicas;

import java.util.Date;

import erm.pay.PaymentEnum;
class TargetaCredito extends PaymentMethod{
	
	private String name;
	private String bankAccount;
	private String cardCode;
	
	private Date expirationDate;
	

	public TargetaCredito() {
		this.paymentType = PaymentEnum.CreditCard;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
