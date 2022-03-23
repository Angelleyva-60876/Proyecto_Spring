package mx.uacam.fi.al60876.mueble.Controller;


import mx.uacam.fi.al60876.mueble.Model.Cliente;
import mx.uacam.fi.al60876.mueble.Model.Mueble;
import mx.uacam.fi.al60876.mueble.repository.MuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class MueblesController {

    private final MuebleRepository muebleRepository;

    @Autowired
    public MueblesController(MuebleRepository muebleRepository){

        this.muebleRepository = muebleRepository;
    }

    @GetMapping("/mueble/index")
    public String index(Model model){
        model.addAttribute("muebles", muebleRepository.findAll());
        return "/Muebles/index";
    }

    @GetMapping("/mueble/new")
    public  String create(Model model){
        model.addAttribute("muebles", new Mueble());
        return "/Muebles/MueblesForm";
    }

    @PostMapping("/mueble/save")
    public String save(@Valid Mueble mueble, BindingResult result){
        if (result.hasErrors()){
            return "/Muebles/MueblesForm";
        }
        muebleRepository.save(mueble);
        return "redirect:/mueble/index";
    }
    @GetMapping("/mueble/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Mueble mueble = muebleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        muebleRepository.delete(mueble);
        return "redirect:/mueble/index";
    }

    @GetMapping("/mueble/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Mueble mueble = muebleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("muebles", mueble);
        return "/Muebles/MueblesShow";
    }
    @PostMapping("/mueble/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Mueble mueble, BindingResult result, Model model) {
        if (result.hasErrors()) {
            mueble.setId(id);
            return "/Muebles/MueblesUpdate";
        }
        muebleRepository.save(mueble);
        return "redirect:/mueble/index";
    }

    @GetMapping("/mueble/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Mueble mueble = muebleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("error id:" + id));
        model.addAttribute("muebles", mueble);
        return "/Muebles/MueblesUpdate";
    }
}
