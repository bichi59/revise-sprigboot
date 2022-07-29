package com.example.demo;

import com.example.demo.dto.EnvDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //Get
    //URI  - / hello-world
    //method - "hello world"

    //@RequestMapping (method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return " Hello World";
    }

    @GetMapping (path="/env-details")
    public EnvDetails getEnvDetails(){
        return new EnvDetails("Dev","1.0");
    }

    @GetMapping( path="/greeting/{name1}")
    public String greetMe(@PathVariable String name1){
        return String.format("dear %s", name1);
    }

}
