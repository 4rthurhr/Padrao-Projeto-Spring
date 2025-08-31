package Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Treino;
import Service.TreinoService;

@RestController
@RequestMapping("/treino")
public class TreinoController {
	
	private TreinoService treinoService;

	public TreinoController(TreinoService treinoService) {
		this.treinoService = treinoService;
	}
	
	@GetMapping
	public List<Treino> listarTodos() {
		return treinoService.buscarTreino();
	}
	
	@PostMapping
	public Treino salvarTreino(@RequestBody Treino treino) {
		return treinoService.salvarTreino(treino);
	}
	
	

}
