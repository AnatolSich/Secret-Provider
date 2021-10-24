package org.example.controller;

import org.example.auth.User;
import org.example.auth.UserRepository;
import org.example.model.Pack;
import org.example.model.Secret;
import org.example.model.SecretRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {

    private final UserRepository userRepository;
    private final SecretRepository secretRepository;

    public AppController(UserRepository userRepository, SecretRepository secretRepository) {
        this.userRepository = userRepository;
        this.secretRepository = secretRepository;
    }

    @GetMapping("/secret")
    public String getSecret() {
        return "secret";
    }

    @PostMapping("/postSecret")
    public String postSecret(Model model, @ModelAttribute Pack pack ) {

        Secret secret = new Secret(pack.getPayload());
        User user = new User(pack.getUser(), pack.getPassword());
        userRepository.save(user);
        secret = secretRepository.save(secret);
        model.addAttribute("payload", "localhost:8080/secret/" + secret.getId());
        return "secret-view";
    }

    @GetMapping("/secret/{secretId}")
    public String getSecret(Model model, @PathVariable String secretId) {
        Secret secret = secretRepository.getOne(Long.parseLong(secretId));
        secretRepository.delete(secret);
        model.addAttribute("payload", secret.getPayload());
        return "secret-view";

    }
}
