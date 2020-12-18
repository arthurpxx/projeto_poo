package br.projeto.api.springapi.controllers;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.api.springapi.entity.Users;
import br.projeto.api.springapi.repository.UserRepository;

// @CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserRepository _UserRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Users> Get() {
        return _UserRepository.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> GetById(@PathVariable(value = "id") Long id) {
        Optional<Users> user = _UserRepository.findById(id);

        if (user.isPresent())
            return new ResponseEntity<Users>(user.get(), HttpStatus.OK);
        else   
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Users Post(@RequestBody Users user) {
        return _UserRepository.save(user);
    }

    @RequestMapping(value = "/user/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Users> Put(@PathVariable(value = "id") Long id, @RequestBody Users newUser)
    {
        Optional<Users> oldUser = _UserRepository.findById(id);
        if(oldUser.isPresent()){
            Users user = oldUser.get();
            user.setNome(newUser.getNome());
            _UserRepository.save(user);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id)
    {
        Optional<Users> user = _UserRepository.findById(id);
        if(user.isPresent()){
            _UserRepository.delete(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}