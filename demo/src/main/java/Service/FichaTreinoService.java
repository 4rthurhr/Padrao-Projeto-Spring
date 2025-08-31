package Service;


import java.util.List;

import org.springframework.stereotype.Service;

import Model.Aluno;
import Model.FichaTreino;
import Model.ItemFicha;
import Model.Treino;
import jakarta.transaction.Transactional;

@Service
public class FichaTreinoService{
	
	private TreinoRepository treinoRepository;
	private AlunoRepository alunoRepository;
	private FichaTreinoRepository fichaRepository;
	
	public FichaTreinoService(TreinoRepository treinoRepository, AlunoRepository alunoRepository,
			FichaTreinoRepository fichaRepository) {;
		this.treinoRepository = treinoRepository;
		this.alunoRepository = alunoRepository;
		this.fichaRepository = fichaRepository;
	}
	
	@Transactional
	public FichaTreino criar(FichaTreino fichaTreino) {
		Aluno aluno = alunoRepository.findById(fichaTreino.getAluno().getId()).orElseThrow(() -> new RuntimeException("Aluno não Encontrado"));
		fichaTreino.setAluno(aluno);
		
		for (ItemFicha item : fichaTreino.getItens()) {
			Treino treino = treinoRepository.findById(item.getExercicio().getId()).orElseThrow(() -> new RuntimeException("Exercicio Não Encontrado"));
			
			item.setExercicio(treino);
			item.setFichaDeTreino(fichaTreino);
		}
		return fichaRepository.save(fichaTreino);
	}
	
	public List<FichaTreino> BuscarTodos(){
		return fichaRepository.findAll();
	}
	
}