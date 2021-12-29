package erm.clasesBasicas;

import erm.pay.Payment;

public class PaymentMethod {
	protected Payment paymentType = null;
	
	private Usuario user;
	
	public Payment getPaymentType() {
		return this.paymentType;
	}
}
