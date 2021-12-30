package erm.clasesBasicas;

import java.util.Date;

import erm.pay.PaymentEnum;
class TarjetaCredito extends PaymentMethod{
	
	private String nombre;
	private String cunetaBanco;
	private String codigoTargeta;
	
	private Date fExpriracion;
	

	public TarjetaCredito() {
		this.paymentType = PaymentEnum.CreditCard;
	}
	
	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public String getBankAccount() {
		return cunetaBanco;
	}

	public void setBankAccount(String bankAccount) {
		this.cunetaBanco = bankAccount;
	}

	public String getCardCode() {
		return codigoTargeta;
	}

	public void setCardCode(String cardCode) {
		this.codigoTargeta = cardCode;
	}

	public Date getExpirationDate() {
		return fExpriracion;
	}

	public void setExpirationDate(Date expirationDate) {
		this.fExpriracion = expirationDate;
	}
	
}
