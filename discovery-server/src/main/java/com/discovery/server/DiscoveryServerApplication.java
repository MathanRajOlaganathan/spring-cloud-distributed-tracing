package com.discovery.server;

import brave.sampler.Sampler;
import jdk.dynalink.beans.StaticClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	private static final Logger log = Logger.getLogger(DiscoveryServerApplication.class.getName());

    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    public static void main(String[] args) {
		log.info("Discovery Server");
        SpringApplication.run(DiscoveryServerApplication.class, args);

    }

}
