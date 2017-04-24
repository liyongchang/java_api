package com.thread.eg.bank;

public class Account {
	private double balance; // ??????

	/**
	 * ???
	 * 
	 * @param money
	 *            ??????
	 */
	public void deposit(double money) {
		double newBalance = balance + money;
		try {
			Thread.sleep(10); // ???????????????????
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		balance = newBalance;
	}

	/**
	 * ?????????
	 */
	public double getBalance() {
		return balance;
	}

}
