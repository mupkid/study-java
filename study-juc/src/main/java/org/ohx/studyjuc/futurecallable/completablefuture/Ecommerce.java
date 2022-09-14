package org.ohx.studyjuc.futurecallable.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author mudkip
 * @date 2022/9/12
 */
public class Ecommerce {
    static List<NetMall> list = Arrays.asList(
        new NetMall("jd"),
        new NetMall("dangdang"),
        new NetMall("taobao")
    );

    /**
     * 一个个查询
     *
     * @param list
     * @param productName
     * @return
     */
    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list
            .stream()
            .map(netMall ->
                String.format(productName + "in %s price is %.2f",
                    netMall.getNetMallName(),
                    netMall.calcPrice(productName)))
            .collect(Collectors.toList());
    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list.stream()
            .map(netMall ->
                CompletableFuture.supplyAsync(() ->
                    String.format(productName + "in %s price is %.2f", netMall.getNetMallName(),
                        netMall.calcPrice(productName))))
            .collect(Collectors.toList())
            .stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<String> mysql1 = getPrice(list, "mysql");
        mysql1.forEach(System.out::println);

        long endTime = System.currentTimeMillis();
        System.out.println("cost time: " + (endTime - startTime) + " milliseconds.");

        System.out.println("----------");

        startTime = System.currentTimeMillis();

        List<String> mysql2 = getPriceByCompletableFuture(list, "mysql");
        mysql2.forEach(System.out::println);

        endTime = System.currentTimeMillis();
        System.out.println("cost time: " + (endTime - startTime) + " milliseconds.");
    }
}

class NetMall {

    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }

    public String getNetMallName() {
        return netMallName;
    }
}