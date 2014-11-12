package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import entidades.Ingrediente;
import entidades.Nutriente;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class RelatorioIngrediente  extends Activity{


	Button btnVoltar;
	
	
	private ListView lista;
	private AdapterListViewIngrediente adapterIngrediente;
	private List<Ingrediente> listaIngrediente;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.relatorio_ingrediente);
		 lista = (ListView) findViewById(R.id.listIngrediente);
		 montaListaIngrediente();
		 Log.i("lista" , listaIngrediente.size() + "");
		 adapterIngrediente = new AdapterListViewIngrediente(RelatorioIngrediente.this, listaIngrediente); 
		 lista.setAdapter(adapterIngrediente);
		 Log.i("lista" , adapterIngrediente.getCount() + "");
		 CarregarInterfaceCadastro();
		}
	
	private void montaListaIngrediente(){
		listaIngrediente = new ArrayList<Ingrediente>();
		TccDao tccDao = TccDao.getInstance(this);
		listaIngrediente = tccDao.recuperarTodosIngrediente();
		for(Ingrediente ingrediente : listaIngrediente){
		   	Log.i("entrei", ingrediente.getNomeIngrediente());
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
