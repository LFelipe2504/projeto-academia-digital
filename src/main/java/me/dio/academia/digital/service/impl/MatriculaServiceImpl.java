package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	@Autowired
	private MatriculaRepository mRepository;
	
	@Autowired
	private AlunoRepository aRepository;

	@Override
	public Matricula create(MatriculaForm form) {
		Aluno aluno = aRepository.findById(form.getAlunoId()).get();
		Matricula matricula = new Matricula();
		
		matricula.setId(form.getAlunoId());
		matricula.setAluno(aluno);
		return mRepository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
		return mRepository.findById(id).get();
	}

	@Override
	public List<Matricula> getAll() {
		return mRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		mRepository.deleteById(id);
		
	}

	@Override
	public List<Matricula> getAllAlunoBairro(String bairro) {
		if(bairro == null) {
			return mRepository.findAll();
		}else {
			return mRepository.findByAlunoBairro(bairro);			
		}
	}
	
}
