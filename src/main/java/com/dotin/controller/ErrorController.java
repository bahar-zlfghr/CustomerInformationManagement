package com.dotin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class ErrorController {

    @GetMapping("/404")
    public String handleError() {
        return "404-error";
    }
}
