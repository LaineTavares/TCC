package entidades;

public class Ingrediente_Nutriente {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Ingrediente ingrediente;
	private Nutriente nutriente;
	private String porcentagemNutriente;
	
	
	
	public String getPorcentagemNutriente() {
		return porcentagemNutriente;
	}
	public void setPorcetagemNutriente(String porcetagemNutriente) {
		this.porcentagemNutriente = porcetagemNutriente;
	}
	public Ingrediente_Nutriente(Integer id, Ingrediente ingrediente,
			Nutriente nutriente, String porcentagemNutriente) {
		super();
		this.id = id;
		this.ingrediente = ingrediente;
		this.nutriente = nutriente;
		this.porcentagemNutriente = porcentagemNutriente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public Nutriente getNutriente() {
		return nutriente;
	}
	public void setNutriente(Nutriente nutriente) {
		this.nutriente = nutriente;
	}
	
	
	
}
