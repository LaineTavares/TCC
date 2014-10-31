package entidades;

import java.util.List;

public class Nutriente {


	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer id;
	
	private List<Ingrediente> ingrediente;
	
	
	
	public  Nutriente(String nome, Integer id){
		super();
		this.id = id;
		this.nome = nome;
		
	}
	public List<Ingrediente> getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(List<Ingrediente> ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	 public String toString(){
	  return nome;
	 }
	
}
