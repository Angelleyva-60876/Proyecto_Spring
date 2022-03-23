package mx.uacam.fi.al60876.mueble.Controller;

import mx.uacam.fi.al60876.mueble.Model.Cliente;
import mx.uacam.fi.al60876.mueble.Model.Mueble;
import mx.uacam.fi.al60876.mueble.repository.ClienteRepository;
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
public class ClientesController {

    private final ClienteRepository clienteRepository;
    private final MuebleRepository muebleRepository;

    @Autowired
    public ClientesController(ClienteRepository clienteRepository, MuebleRepository muebleRepository) {
        this.clienteRepository = clienteRepository;
        this.muebleRepository = muebleRepository;
    }

    @GetMapping("/cliente/index")
    public String index(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "/Clientes/index";
    }

    @GetMapping("/cliente/new")
    public String create(Model model) {
        List<Mueble> MuebleList = (List<Mueble>) muebleRepository.findAll();
        model.addAttribute("clientes", new Cliente());
        model.addAttribute("MuebleList", MuebleList);
        return "/Clientes/ClientesForm";
    }

    @PostMapping("/cliente/save")
    public String save(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "/Clientes/MueblesForm";
        }

        clienteRepository.save(cliente);
        return "redirect:/cliente/index";
    }

    @GetMapping("/cliente/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("error id:" + id));
        List<Mueble> MuebleList = (List<Mueble>) muebleRepository.findAll();
        model.addAttribute("cliente", cliente);
        model.addAttribute("MuebleList",MuebleList);

        return "/Clientes/ClientesUpdate";
    }

    @PostMapping("/cliente/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            cliente.setId(id);
            return "/Clientes/ClientesUpdate";
        }

        clienteRepository.save(cliente);

        return "redirect:/cliente/index";
    }

    @GetMapping("/cliente/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        clienteRepository.delete(cliente);

        return "redirect:/cliente/index";
    }

    @GetMapping("/cliente/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        List<Mueble> MuebleList = (List<Mueble>) muebleRepository.findAll();
        model.addAttribute("cliente", cliente);
        model.addAttribute("MuebleList",MuebleList);

        return "/Clientes/ClientesShow";
    }



}
