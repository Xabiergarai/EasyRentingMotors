package erm.pay;


public interface Payment {

	/**
	 * @param user 
	 * @param amount
	 */
	public void pay(String username, int amount);
}

