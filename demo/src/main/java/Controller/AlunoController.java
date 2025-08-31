package Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Aluno;
import Service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@GetMapping
	public List<Aluno> listaluno(){
		return alunoService.listarTodos();
	}
	
	@PostMapping
	public Aluno criarAluno(@RequestBody Aluno aluno) {
		return alunoService.salvarAluno(aluno);
	}

}
