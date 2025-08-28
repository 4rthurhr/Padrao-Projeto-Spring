package Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Model.EnderecoModel;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>ViaCEP</b>.
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 * 
 * @author falvojr
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ServiceCepVia {

	@GetMapping("/{cep}/json/")
	EnderecoModel consultarCep(@PathVariable("cep") String cep);
}