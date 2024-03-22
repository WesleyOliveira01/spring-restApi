package com.example.apiUserDept.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiUserDept.Repositories.UserRepository;
import com.example.apiUserDept.entities.User.User;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity.badRequest().body("Usuário é obrigatório");
        }
        User savedUser = repository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Usuário ID é obrigatório");
        }
        User result = repository.findById(id).get();
        return ResponseEntity.ok(result);
    }

    

}
