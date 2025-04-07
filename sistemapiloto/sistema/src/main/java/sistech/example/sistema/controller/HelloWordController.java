package sistech.example.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistech.example.sistema.service.HelloWorldService;

@RestController
@RequestMapping("/hello-world")
public class HelloWordController{

    @Autowired
   private HelloWorldService helloWorldService;



    @GetMapping
    public String helloWorld (){
    return helloWorldService.helloWorld("Lucas");
    }

}
