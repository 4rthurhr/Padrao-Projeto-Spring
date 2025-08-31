package Service;

import java.util.List;


import org.springframework.stereotype.Service;


import Model.Treino;

@Service
public class TreinoService {
	
	private TreinoRepository treinoRepository;

	public TreinoService(TreinoRepository treinoRepository) {
		this.treinoRepository = treinoRepository;
	}
	
	public Treino salvarTreino(Treino treino) {
		return treinoRepository.save(treino);
	}
	
	public List<Treino> buscarTreino(){
		return treinoRepository.findAll();
	}
	
	
}
