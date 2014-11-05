package menu;

public class MenuItemModel {
	
	private String titulo;
	private  int icone;
	
	
	
	public MenuItemModel(String titulo, int icone) {
		super();
		this.titulo = titulo;
		this.icone = icone;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIcone() {
		return icone;
	}
	public void setIcone(int icone) {
		this.icone = icone;
	}

}
