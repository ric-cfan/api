package br.org.serratec.biblioteca.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="livro")
public class Livro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="titulo", nullable=false, length=40)
	private String titulo;
	
	@NotBlank
	@Column(name="isbn", nullable=false, length=20, unique = true)
	private String isbn;

	@Column(name="data_publicacao")
	private LocalDate dataPublicacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	@JoinColumn(name="id_categoria", nullable = false)
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name = "livro_autor",
	joinColumns = @JoinColumn(name="id_livro"),
	inverseJoinColumns = @JoinColumn(name="id_autor"))
	private List<Autor> autores;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
