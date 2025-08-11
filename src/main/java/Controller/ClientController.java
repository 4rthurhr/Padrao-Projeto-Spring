package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.ClientModel;
import Service.ClientService;

@RestController
@RequestMapping("clientes")
public class ClientController {
	
	@Autowired
	private ClientService clientservice;
	
	@GetMapping
	public ResponseEntity<Iterable<ClientModel>> BuscarTodos(){
		return ResponseEntity.ok(clientservice.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientModel> BuscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(clientservice.buscarPorId(id));
		
	}
	
	@PostMapping
	public ResponseEntity<ClientModel> Criar(@RequestBody ClientModel cliente){
		clientservice.Criar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<ClientModel> Atualizar(@PathVariable Long id, @RequestBody ClientModel cliente){
		clientservice.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
		
	}
	
	public ResponseEntity<Void> DeletarPorId(@PathVariable Long id){
		clientservice.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	

}
