package com.example.demo.controller;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class scheduled {
    public static void main(String[] args) {
//        new shedule().start();

        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getYear()+":"+date.getMonthValue()+":"+date.getDayOfMonth()+":"+date.getDayOfWeek());
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.getHour()+":"+time.getMinute()+":"+time.getSecond());
        System.out.println(time.get(ChronoField.MILLI_OF_SECOND));
        System.out.println(time);
        Date date1 = new Date();
        long ss = date1.getTime();
        Clock clock = Clock.systemDefaultZone();
        boolean b = clock.millis() == ss ;
        System.out.println(date1.getTime());
        System.out.println(clock.millis());
        System.out.println(b);

        LocalTime myTime = LocalTime.of(10, 50, 45);
        System.out.println(myTime.getHour() + ":" + myTime.getMinute() + ":" + myTime.getSecond()); // 10:30:45
        System.out.println(myTime);
        LocalDate formatDate1 = LocalDate.of(2013, 12, 4);
        String dateString = formatDate1.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(dateString); // 2013/12/04

        LocalDate startDate=LocalDate.now().minusMonths(Integer.parseInt("2"));
        LocalDate endDate=LocalDate.now().minusYears(50);
        System.out.println(startDate.isBefore(endDate));
        System.out.println(endDate);

        Date date2 = new Date();
        Instant instant2 = date2.toInstant();
        LocalDateTime dateTimeFromDate = LocalDateTime.ofInstant(instant2, ZoneOffset.systemDefault());
        System.out.println(dateTimeFromDate);
        System.out.println(instant2.equals(LocalDateTime.now()));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        long delay = 2;
        long interval = 1;

        // 从现在开始 2 秒钟之后启动，每隔 1 秒钟执行一次
        service.scheduleAtFixedRate(
                new JobTask2(), delay,
                interval, TimeUnit.SECONDS);
    }
}

class shedule extends Thread{
    @Override
    public void run(){
        while (true){
            System.out.println("定时任务");
            try {
                Thread.sleep(1000);
                System.out.println(LocalDateTime.now());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class JobTask2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Test: " + Calendar.getInstance().getTime());
    }
}


