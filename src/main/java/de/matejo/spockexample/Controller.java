package de.matejo.spockexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Greeter greeter;

    public Controller(Greeter greeter) {
        this.greeter = greeter;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloTo(@PathVariable String name){
        return greeter.sayHelloTo(name);
    }

}
