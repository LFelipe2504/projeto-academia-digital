	package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl alunoService;
	
	@PostMapping
	public Aluno create (@Valid @RequestBody AlunoForm alunoForm) {
		return alunoService.create(alunoForm);
	}
	
	@GetMapping
	public List<Aluno> getAll() {
		return alunoService.getAll();
	}
	
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvalicaoFisicaId(@PathVariable Long id){
		return alunoService.getAllAvalicaoFisicaId(id);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		alunoService.delete(id);
	}
	
	@GetMapping("/dataNascimento")
	public List<Aluno> getAllDataNascimento(@RequestParam(value = "dataDeNascimento", required = false)
																					String dataDeNascimento) {
		return alunoService.getAllDataNascimento(dataDeNascimento);
	}
	
	
}
