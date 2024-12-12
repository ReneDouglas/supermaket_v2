package br.edu.ifpi.supermarket.controllers;

import br.edu.ifpi.supermarket.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class TestAjaxController {

    private List<User> users;


    public TestAjaxController() {
        this.users = new ArrayList<>();
    }

    @GetMapping("/exemplo")
    public String exemploAjax() {
        return "exemploAjax";
    }

    @GetMapping("/exemploHTMX")
    public String exemploAjaxHTMX() {
        return "exemploAjaxHTMX";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String name, @RequestParam String email, Model model) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        users.add(user);
        model.addAttribute("users", users);


        return "fragments/clienteInfo :: informacoes";
    }
}
