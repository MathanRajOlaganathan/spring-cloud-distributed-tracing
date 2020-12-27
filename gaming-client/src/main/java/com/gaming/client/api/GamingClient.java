package com.gaming.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 22/12/2020
 */
@FeignClient("GAMING-SERVICE")
public interface GamingClient {

    @GetMapping("/games")
    public String[] getGames();
}
