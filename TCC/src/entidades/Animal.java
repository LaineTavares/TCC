package entidades;

public class Animal {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String cor;
	private TipoAnimal tipoAnimal;
	
	
	public Animal( String nome, String cor,  Integer id, TipoAnimal tipoAnimal) {
		super();
		this.nome = nome;
		this.cor = cor;
		this.id = id;
		this.tipoAnimal = tipoAnimal;
		
	}	
	
	
	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}



	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}



	public Animal(Integer id, String nome, String cor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cor = cor;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
}
