package Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class ItemFicha {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private int series;
 private int repeticoes;

 @JsonBackReference
 @ManyToOne
 @JoinColumn(name = "ficha_de_treino_id")
 private FichaTreino fichaDeTreino;

 @ManyToOne
 @JoinColumn(name = "exercicio_id")
 private Treino exercicio;

 public Long getId() {
	return id;
 }

 public void setId(Long id) {
	this.id = id;
 }

 public int getSeries() {
	return series;
 }

 public void setSeries(int series) {
	this.series = series;
 }

 public int getRepeticoes() {
	return repeticoes;
 }

 public void setRepeticoes(int repeticoes) {
	this.repeticoes = repeticoes;
 }

 public FichaTreino getFichaDeTreino() {
	return fichaDeTreino;
 }

 public void setFichaDeTreino(FichaTreino fichaDeTreino) {
	this.fichaDeTreino = fichaDeTreino;
 }

 public Treino getExercicio() {
	return exercicio;
 }

 public void setExercicio(Treino exercicio) {
	this.exercicio = exercicio;
 }


 
}