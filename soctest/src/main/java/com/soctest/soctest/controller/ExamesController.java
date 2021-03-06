package com.soctest.soctest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soctest.soctest.model.Exames;
import com.soctest.soctest.repository.ExamesRepository;

import javax.swing.JOptionPane;
import javax.validation.Valid;

@Controller
@RequestMapping("/exames/")
public class ExamesController {
	
    private final ExamesRepository examesRepository;

    @Autowired
    public ExamesController(ExamesRepository examesRepository) {
        this.examesRepository = examesRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Exames exames) {
        return "add-exame";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("exames", examesRepository.findAllByNomePacienteDesc());
        return "index";
    }

    @PostMapping("add")
    public String addExame(@Valid Exames exames, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-exame";
        }
    try {
        examesRepository.save(exames);
        return "redirect:list";} catch (Exception nomePaciente){
        	return "add-exame";
    }
   }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Exames exames = examesRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Inválido, Id:" + id));
        model.addAttribute("exames", exames);
        return "update-exame";
    }

    @PostMapping("update/{id}")
    public String updateExames(@PathVariable("id") long id, @Valid Exames exames, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            exames.setId(id);
            return "update-exame";
        }
    try {   
        examesRepository.save(exames);
        model.addAttribute("exames", examesRepository.findAll());
        return "index";} catch (Exception nomePaciente){
        	return "add-exame";
    }
    }

    @GetMapping("delete/{id}")
    public String deleteExames(@PathVariable("id") long id, Model model) {
        Exames exames = examesRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Inválido, Id:" + id));
        examesRepository.delete(exames);
        model.addAttribute("exames", examesRepository.findAll());
        return "index";
    }
}
