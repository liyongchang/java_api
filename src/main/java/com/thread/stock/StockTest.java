package com.thread.stock;

public class StockTest {

    public Boolean minusStock(String ticketId, Integer stock) {
        synchronized (this) {
            return true;
        }
    }
}
