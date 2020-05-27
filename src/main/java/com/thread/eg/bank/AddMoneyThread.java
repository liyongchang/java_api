package com.thread.eg.bank;

public class AddMoneyThread implements Runnable {

	private Account account;
	private double money;

	public AddMoneyThread(Account account, double money) {
		this.account = account;
		this.money = money;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		account.deposit(money);

	}

}
