package com.thread.interviewTest;/**
 * 上海识装信息科技有限公司
 * <p>
 * 〈〉
 *
 * @author yongchangli
 * @date 2023/5/18 11:23
 * @since 1.0.0
 */

/**
 * 上海识装信息科技有限公司
 * <p>
 * 〈竞拍前置准备线程池〉
 *
 * @author yongchangli
 * @date 2023/5/1811:23
 * @since 4.85
 */
public class Test {

    public static void main(String[] args) {
        FooBar2 fooBar = new FooBar2(3);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();

    }
}
