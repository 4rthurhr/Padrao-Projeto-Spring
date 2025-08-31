package Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.FichaTreino;
import Service.FichaTreinoService;

@RestController
@RequestMapping("/fichas")
public class FichaTreinoController {
	
	private FichaTreinoService fichaService;
	
	
	public FichaTreinoController(FichaTreinoService fichaService) {
		this.fichaService = fichaService;
	}
	
	@GetMapping
	public List<FichaTreino> buscarTodos(){
		return fichaService.BuscarTodos();
	}
	
	@PostMapping
	public FichaTreino criarFicha(@RequestBody FichaTreino fichaTreino) {
		return fichaService.criar(fichaTreino);
	}
	
	

}
