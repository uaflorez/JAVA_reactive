package com.bancolombia.user.service;

import com.bancolombia.user.entity.User;
import com.bancolombia.user.repository.UserRepository;
import com.bancolombia.user.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        Optional.of(user).filter(u -> user.getName() !=null)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(400), "El nombre debe estar definido"));
        Optional.of(user).filter(u -> !user.getName().isBlank())
                .orElseThrow(()-> new ResponseStatusException(HttpStatusCode.valueOf(400), "El nombre no puede ir vacio"));
        Optional.of(user).filter(u -> user.getEmail() !=null)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(400), "El email debe estar definido"));
        Optional.of(user).filter(u -> !user.getEmail().isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(400), "El email no puede estar vacío"));
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}