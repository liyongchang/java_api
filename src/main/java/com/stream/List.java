package com.stream;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class List {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1", "2");


        System.out.println("测试版");

        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.get());

        Optional<String> empty = Optional.empty();
        System.out.println((empty.isPresent()));

        String name1 = null;
        //Optional<String> optNull = Optional.of(name1);
        Optional<String> optNullAble = Optional.ofNullable(name1);
        System.out.println("optNullAble.isPresent():  " + optNullAble.isPresent());


        //3. Checking Value Presence: isPresent() and isEmpty()
        Optional<String> opt3 = Optional.of("Baeldung");
        System.out.println(opt.isPresent());

        opt = Optional.ofNullable(null);
        System.out.println(opt.isPresent());
        //4. Conditional Action With ifPresent()
        Optional<String> opt4 = Optional.of("baeldung");
        opt4.ifPresent(c -> System.out.println(c.length()));
        //5. Default Value With orElse()
        String nullName = "null";
        String name5 = Optional.ofNullable(nullName).orElse(getName1("tom"));
        System.out.println(name5);
        //orElse get,前面有值后面就不走了
        String name501 = Optional.ofNullable(nullName).orElseGet(() -> getName1("tom"));
        System.out.println(name501);

        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2017);


        System.out.println("priceIsInRange2 ："+priceIsInRange2(new Modem(10.0)));
    }

    private static String getName1(String name) {
        System.out.println("eeeee");
        return name;
    }

    public static boolean priceIsInRange2(Modem modem2) {
        return Optional.ofNullable(modem2)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }

    @Data
    private static class Modem {
        private Double price;

        public Modem(Double price) {
            this.price = price;
        }


    }
}
