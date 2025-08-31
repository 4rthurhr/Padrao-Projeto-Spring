package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Model.Aluno;

@Service
public class AlunoService {
	private AlunoRepository alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	
	public List<Aluno> listarTodos(){
		return alunoRepository.findAll();
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		Optional<Aluno> alunoExiste = alunoRepository.findByNome(aluno.getNome());
		
		if (alunoExiste.isPresent()) {
			throw new IllegalArgumentException("Já tem um aluno cadastrado com esse nome");
		}
		return alunoRepository.save(aluno);
	}
	
	
	
	
	

}
