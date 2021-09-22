package com.leizhou.roomclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FizzBuzzApp implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(FizzBuzzApp.class);

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 ==0 && i%5 == 0){
                log.info("FizzBuzz");
            } else if (i%3 == 0){
                log.info("Fizz");
            }else{
                log.info("Buzz");
            }
        }
    }
}
