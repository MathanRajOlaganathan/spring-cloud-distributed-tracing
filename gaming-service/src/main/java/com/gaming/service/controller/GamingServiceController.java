package com.gaming.service.controller;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 20/12/2020
 */
@RestController
@RequestMapping("/games")
public class GamingServiceController {

    private static final Logger log = Logger.getLogger(GamingServiceController.class.getName());

    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Value("${server.port}")
    private String port;

    @GetMapping
    public List<String> getGames(){
        log.info("GamingServiceController");
        return Stream.of("CS GO","NFS","God of War","Prince of Persia","WWE 2K20","CRIC 07",port)
                .collect(Collectors.toList());
    }
}
