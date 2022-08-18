package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());		
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAll() {
		return  alunoRepository.findAll(); 		
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		alunoRepository.deleteById(id);		
	}

	@Override
	public List<AvaliacaoFisica> getAllAvalicaoFisicaId(Long id) {
		//fazer tratamento de excessão para caso o aluno não esteja no BDD
		Aluno aluno = alunoRepository.findById(id).get();
		return aluno.getAvaliacoes();
	}
	
	@Override
	public List<Aluno> getAllDataNascimento(String dataNascimento) {
		if(dataNascimento == null) {
			return alunoRepository.findAll();
		} else {
			LocalDate data = LocalDate.parse(dataNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return alunoRepository.findByDataDeNascimento(data);			
		}
	}

}
