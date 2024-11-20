package Corner.Spring_Study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController_2 {

    @RequestMapping("/hello_2")
    public String hello() {
        return "Hello World";
    }
}
