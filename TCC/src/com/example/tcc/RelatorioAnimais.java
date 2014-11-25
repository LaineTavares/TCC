package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import entidades.Animal;
import entidades.Ingrediente;
import entidades.Nutriente;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class RelatorioAnimais extends Activity{


	Button btnVoltar;
	
	
	private ListView lista;
	private AdapterListViewAnimais adapterAnimal;
	private List<Animal> listaAnimal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.relatorio_animais);
		 lista = (ListView) findViewById(R.id.listAnimais);
		 montaListaIngrediente();
		 Log.i("lista" , listaAnimal.size() + "");
		 adapterAnimal = new AdapterListViewAnimais(RelatorioAnimais.this, listaAnimal); 
		 lista.setAdapter(adapterAnimal);
		 Log.i("lista" , adapterAnimal.getCount() + "");
		 CarregarInterfaceCadastro();
		}
	
	private void montaListaIngrediente(){
		listaAnimal = new ArrayList<Animal>();
		TccDao tccDao = TccDao.getInstance(this);
		listaAnimal = tccDao.recuperarTodasAnimal();
		for(Animal animal: listaAnimal){
		   	Log.i("entrei", animal.getNome());
		}
	
	}
	public void CarregarInterfaceCadastro()
   { 
       
       btnVoltar = (Button)findViewById(R.id.btnVoltar);
       btnVoltar.setOnClickListener(new OnClickListener(){
           public void onClick(View v) {
           	 
	       		 finish();
           }});
   }
	
}
