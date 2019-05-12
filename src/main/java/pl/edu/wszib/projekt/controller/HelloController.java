package pl.edu.wszib.projekt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloPage() {
        return "Hello!!!";
    }

    @GetMapping("/aaaaa")
    public String aaaa() {
        return "Aaaaaaaaaaaaaaaaa!!!";
    }

}
