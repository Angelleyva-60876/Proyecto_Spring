package mx.uacam.fi.al60876.mueble.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String Inicio(){
        return "index";
    }
}
