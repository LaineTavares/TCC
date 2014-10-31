package entidades;

import java.util.List;

public class Ingrediente {
	
	private List<Nutriente> nutriente;
		
	public List<Nutriente> getNutriente() {
		return nutriente;
	}

	public void setNutriente(List<Nutriente> nutriente) {
		this.nutriente = nutriente;
	}

	private static final long serialVersionUID = 1L;
	private String nomeIngrediente;
	private Integer id;
	private String precoIngrediente;
	
	
	
	public String getPrecoIngrediente() {
		return precoIngrediente;
	}

	public void setPrecoIngrediente(String precoIngrediente) {
		this.precoIngrediente = precoIngrediente;
	}

	public Ingrediente(String nomeIngrediente, Integer id, String precoIngrediente){
		super();
		this.id = id;
		this.nomeIngrediente = nomeIngrediente;
		this.precoIngrediente = precoIngrediente;
		
	}

	public String getNomeIngrediente() {
		return nomeIngrediente;
	}

	public void setNomeIngrediente(String nomeIngrediente) {
		this.nomeIngrediente = nomeIngrediente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	 public String toString(){
	  return nomeIngrediente;
	 }
	
}
