package Service;

import Model.ClientModel;

public interface ClientService {
	
	Iterable<ClientModel> buscarTodos();

	ClientModel buscarPorId(Long id);

	void Criar(ClientModel cliente);

	void atualizar(Long id, ClientModel cliente);

	void deletar(Long id);

	void inserir(ClientModel cliente);


}
