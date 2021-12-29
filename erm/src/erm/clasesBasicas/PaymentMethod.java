package erm.clasesBasicas;

import erm.pay.Payment;
import erm.pay.PaymentEnum;

public class PaymentMethod {
	protected PaymentEnum paymentType = null;
	
	
	public PaymentEnum getPaymentType() {
		return this.paymentType;
	}
}
