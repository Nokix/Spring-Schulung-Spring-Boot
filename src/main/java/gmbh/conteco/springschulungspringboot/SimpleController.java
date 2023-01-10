package gmbh.conteco.springschulungspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/simple")
public class SimpleController {

    @GetMapping("/")
    public String getHello() {
        return "Hallo DB! Was geht. wie ist? har har";
    }

    @GetMapping("/name")
    public String getName() {
        return "Viktor";
    }

}
