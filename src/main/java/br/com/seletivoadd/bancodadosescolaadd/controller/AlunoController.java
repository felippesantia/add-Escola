package br.com.seletivoadd.bancodadosescolaadd.controller;


import br.com.seletivoadd.bancodadosescolaadd.model.Aluno;
import br.com.seletivoadd.bancodadosescolaadd.model.Turma;
import br.com.seletivoadd.bancodadosescolaadd.model.dto.AlunoForm;
import br.com.seletivoadd.bancodadosescolaadd.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/turmaa/{id}")
    public List<Turma> getTurmaId(@PathVariable Long id) {
        return service.getAllTurmaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "nome", required = false)
                              String nome){
        return service.getAll(nome);
        }
}
