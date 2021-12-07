package com.dotin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class MainController {

    @GetMapping(value = "/")
    public String viewIndexPage() {
        return "index";
    }
}
