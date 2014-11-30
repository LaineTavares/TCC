package entidades;

public class Animal_Ingrediente {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Ingrediente ingrediente;
	private Animal animal;
	private String porcentagemIngrediente;

	public Animal_Ingrediente(Integer id, Ingrediente ingrediente,
			Animal animal, String porcentagemIngrediente) {
		super();
		this.id = id;
		this.ingrediente = ingrediente;
		this.animal = animal;
		this.porcentagemIngrediente = porcentagemIngrediente;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getPorcentagemIngrediente() {
		return porcentagemIngrediente;
	}

	public void setPorcentagemIngrediente(String porcentagemIngrediente) {
		this.porcentagemIngrediente = porcentagemIngrediente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
