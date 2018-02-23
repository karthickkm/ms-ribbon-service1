package com.msribbonservice1.msribbonservice1.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class SayHelloApplication {
    private static Logger log = LoggerFactory.getLogger(SayHelloApplication.class);

    @GetMapping("/greeting")
    public String greet() {
        List<String> greetings = null;
        int randomNum = 0;
        InetAddress ipAddr = null;
        try {

            ipAddr =  InetAddress.getLocalHost();
            log.info("Access /greeting"+ ipAddr);

           greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
            Random rand = new Random();

            randomNum = rand.nextInt(greetings.size());
            log.info("Calling me..");
        }catch(Exception e) {
            log.error(e.getMessage());
        }

        return greetings.get(randomNum)+" - "+ipAddr;
    }

    @GetMapping("/")
    public String home() {
        log.info("Access /");
        return "Hi!";
    }
}
