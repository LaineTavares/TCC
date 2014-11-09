package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import entidades.Animal;
import entidades.Nutriente;
import entidades.TipoAnimal;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class RelatorioIngrediente extends Activity{

	private ListView lista;
	private AdapterListViewNutriente exemploAdapter;
	private List<Nutriente> listaExemplo;
	
	Button btnVoltar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 lista = (ListView) findViewById(R.id.listTeste);
		 montaLista();
		 Log.i("lista" , listaExemplo.size() + "");
		 exemploAdapter = new AdapterListViewNutriente(RelatorioIngrediente.this, listaExemplo); 
		 lista.setAdapter(exemploAdapter);
		 Log.i("lista" , exemploAdapter.getCount() + "");
		 CarregarInterfaceCadastro();
 		}
	
	private void montaLista(){
		listaExemplo = new ArrayList<Nutriente>();
		TccDao tccDao = TccDao.getInstance(this);
		listaExemplo = tccDao.recuperarTodosNutrientes();
		for(Nutriente nutri : listaExemplo){
		   	Log.i("entrei", nutri.getNome());
		}
		//Nutriente ex1 = new Nutriente("Diego", 1);
		//listaExemplo.add(ex1);
	
	}
	public void CarregarInterfaceCadastro()
    { 
        
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	 
	       		 finish();
            }});
      
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}
}
