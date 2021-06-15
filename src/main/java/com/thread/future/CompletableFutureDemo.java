package com.thread.future;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        //test
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        System.out.println(completableFutureDemo.getPrices());
    }

    private Set<Integer> getPrices() {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        CompletableFuture<Void> t1 = CompletableFuture.runAsync(new Task(123, prices));
        CompletableFuture<Void> t2 = CompletableFuture.runAsync(new Task(456, prices));
        CompletableFuture<Void> t3 = CompletableFuture.runAsync(new Task(789, prices));

        CompletableFuture<Void> allTask = CompletableFuture.allOf(t1, t2, t3);
        try {
            allTask.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return prices;
    }


    private class Task implements Runnable {
        private Integer productId;
        private Set<Integer> prices;

        public Task() {
        }

        public Task(Integer productId, Set<Integer> prices) {
            this.productId = productId;
            this.prices = prices;
        }

        @Override
        public void run() {
            int price = 0;
            try {
                Thread.sleep((long) (Math.random() * 4000));
                price = productId * 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prices.add(price);
        }
    }
}
