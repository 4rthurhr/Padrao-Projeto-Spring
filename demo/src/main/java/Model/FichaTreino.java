package Model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FichaTreino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataInicio;
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	@JsonManagedReference // <-- ADICIONE ESTA LINHA
	@OneToMany(mappedBy = "fichaDeTreino", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ItemFicha> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<ItemFicha> getItens() {
		return itens;
	}

	public void setItens(List<ItemFicha> itens) {
		this.itens = itens;
	}
	
	

}
