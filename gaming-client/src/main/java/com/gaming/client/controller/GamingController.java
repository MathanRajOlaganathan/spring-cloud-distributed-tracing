package com.gaming.client.controller;

import brave.sampler.Sampler;
import com.gaming.client.api.GamingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 20/12/2020
 */
@RestController
public class GamingController {

    private static final Logger log = Logger.getLogger(GamingController.class.getName());

    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Autowired
    private GamingClient gamingClient;

    @GetMapping("/games")
    public String[] getGames(){
        log.info("GamingController");
       return gamingClient.getGames();

    }
}
