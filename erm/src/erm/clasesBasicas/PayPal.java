package erm.clasesBasicas;

import erm.pay.PaymentEnum;

 class Paypal  extends PaymentMethod{
	private String nombreusuario;

	public Paypal() {
		this.paymentType = PaymentEnum.Paypal;
	}
	
	public String getUsername() {
		return nombreusuario;
	}

	public void setUsername(String username) {
		
		this.nombreusuario = username;
	}
}
