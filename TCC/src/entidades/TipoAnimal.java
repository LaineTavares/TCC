package entidades;

import android.app.Activity;

public class TipoAnimal extends Activity{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tipoAnimal;
	
	public TipoAnimal(String tipoAnimal, Integer id) {
		super();
		this.id = id;
		this.tipoAnimal = tipoAnimal;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	
	public String toString(){
		return tipoAnimal;
		
	}
	

}
