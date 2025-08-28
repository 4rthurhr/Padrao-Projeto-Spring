package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.ClientModel;
import Model.ClientRepository;
import Model.EnderecoModel;
import Model.EnderecoRepository;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceimpl implements ClientService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClientRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ServiceCepVia viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<ClientModel> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public ClientModel buscarPorId(Long id) {
		// Buscar Cliente por ID.
		Optional<ClientModel> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(ClientModel cliente) {
		salvarClienteComCep(cliente);
	}

	private void salvarClienteComCep(ClientModel cliente) {
		String cep = cliente.getEndereco().getCep();
		EnderecoModel Endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			EnderecoModel novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});cliente.setEndereco(Endereco);
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizar(Long id, ClientModel cliente) {
		Optional<ClientModel> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public void Criar(ClientModel cliente) {
		// TODO Auto-generated method stub
		
	}



}