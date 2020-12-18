package br.projeto.api.springapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.api.springapi.entity.Agendamento;
import br.projeto.api.springapi.repository.AgendamentoRepository;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository _AgendamentoRepository;

    @RequestMapping(value = "/agendamento", method = RequestMethod.GET)
    public List<Agendamento> Get() {
        return _AgendamentoRepository.findAll();
    }

    @RequestMapping(value = "/agendamento/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agendamento> GetById(@PathVariable(value = "id") Long id) {
        Optional<Agendamento> agendamento = _AgendamentoRepository.findById(id);

        if (agendamento.isPresent())
            return new ResponseEntity<Agendamento>(agendamento.get(), HttpStatus.OK);
        else   
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/agendamento", method = RequestMethod.POST)
    public Agendamento Post(@RequestBody Agendamento agendamento) {
        return _AgendamentoRepository.save(agendamento);
    }

    @RequestMapping(value = "/agendamento/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Agendamento> Put(@PathVariable(value = "id") Long id, @RequestBody Agendamento newUser)
    {
        Optional<Agendamento> oldAgendamento = _AgendamentoRepository.findById(id);
        if(oldAgendamento.isPresent()){
            Agendamento agendamento = oldAgendamento.get();
            Object newAgendamento = null;
			agendamento.setNome(((Agendamento) newAgendamento).getNome());
            _AgendamentoRepository.save(agendamento);
            return new ResponseEntity<Agendamento>(agendamento, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/agendamento/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id)
    {
        Optional<Agendamento> agendamento = _AgendamentoRepository.findById(id);
        if(agendamento.isPresent()){
            _AgendamentoRepository.delete(agendamento.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
