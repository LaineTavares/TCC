package com.example.tcc;



import java.util.ArrayList;
import java.util.List;




import entidades.Animal;
import entidades.Ingrediente;
import entidades.Nutriente;




import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	Button btnNovo;
	Button btnNovoIngrediente;
	Button btnNovoNutriente;
	Button btnNovoTipoAnimal;
	Button btnNovoIng_Nutri;
	Button btnRelNutriente;
	
	private ListView mDrawerList;
	private ListView lista;
	private DrawerLayout mDrawer;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] menuItems;
	private AdapterListViewNutriente exemploAdapter;
	private List<Nutriente> listaExemplo;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 //setContentView(R.layout.menu_teste);
		 
		 //mDrawer = (DrawerLayout) findViewById(R.id.help);
		 CarregarInterfaceListagem();
		 lista = (ListView) findViewById(R.id.listTeste);
		 montaLista();
		 Log.i("lista" , listaExemplo.size() + "");
		 exemploAdapter = new AdapterListViewNutriente(MainActivity.this, listaExemplo); 
		 lista.setAdapter(exemploAdapter);
		 Log.i("lista" , exemploAdapter.getCount() + "");
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

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
	  //  MenuItem item =  menu.add(0, 1, 0, "Teste");
	    //return true;
	//}
	
	public void CarregarInterfaceListagem()
		    {
		        setContentView(R.layout.activity_main);
		 
		        //configurando o botão de criar novo cadastro
		        
		        btnNovoIngrediente = (Button)findViewById(R.id.btnNovoIngrediente);
		        btnNovoIngrediente.setOnClickListener(new OnClickListener(){
		        	public void onClick(View v){
		        		Intent it = new Intent(getApplicationContext(), CadastroIngrediente.class);
		        		startActivity(it);
		        		
		        	}
		        	
		        });
		        btnNovo = (Button)findViewById(R.id.btnNovo);
		        btnNovo.setOnClickListener(new OnClickListener(){
		            public void onClick(View v) {
		            Intent it = new Intent(getApplicationContext(), CadastroAnimal.class);
		            startActivity(it);
		       				            
		            }});
		 
		        btnNovoNutriente = (Button)findViewById(R.id.btnNovoNutriente);
		        btnNovoNutriente.setOnClickListener(new OnClickListener(){
		        	public void onClick(View v){
		        		Intent it = new Intent(getApplicationContext(), CadastroNutriente.class);
		        		startActivity(it);
		        		
		        	}
		        	
		        });
		        btnNovoTipoAnimal = (Button)findViewById(R.id.btnNovoTipoanimal);
		        btnNovoTipoAnimal.setOnClickListener(new OnClickListener(){
		        	public void onClick(View v){
		        		Intent it = new Intent(getApplicationContext(), CadastroTipoAnimal.class);
		        		startActivity(it);
		        		
		        	}
		        			        	
		        });
		        
		        btnNovoIng_Nutri = (Button) findViewById(R.id.btnVinculaIng_Nutri);
		        btnNovoIng_Nutri.setOnClickListener(new OnClickListener() {
		        	public void onClick(View v){
		        		Intent it = new Intent(getApplicationContext(), VinculaIngredienteNutriente.class);
		        		startActivity(it);
		        		
		        	}
							
				});
		        
		        btnRelNutriente = (Button) findViewById(R.id.btnRelatorioNutri);
		        btnRelNutriente.setOnClickListener(new OnClickListener() {
		        	public void onClick(View v){
		        		Intent it = new Intent(getApplicationContext(), RelatorioIngrediente.class);
		        		startActivity(it);
		        		
		        	}
							
				});
		        
		   
		        
		        
		    }
	
	

}
