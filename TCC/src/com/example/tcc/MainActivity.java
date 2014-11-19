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
	Button btnCadastros;
	Button btnRelatoriosButton;
	Button btnGraficos;
	Button btnFechar;
		
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
		        //setContentView(R.layout.activity_main);
				setContentView(R.layout.tela_inicial);
		 
		        //configurando o botão de criar novo cadastro
		        
				btnCadastros = (Button)findViewById(R.id.btnCadastros);
				btnCadastros.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent it = new Intent(getApplicationContext(), Cadastros.class);
		        		startActivity(it);
						
					}
				});
				
				 btnRelatoriosButton = (Button) findViewById(R.id.btnRelatorios);
			     btnRelatoriosButton.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Intent it = new Intent(getApplicationContext(), Relatorios.class);
			        		startActivity(it);
							
						}
					});	 
			     
				 btnGraficos = (Button) findViewById(R.id.btnGraficos);
			     btnGraficos.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Intent it = new Intent(getApplicationContext(), criarGrafico.class);
			        		startActivity(it);
							
						}
					});	 
		        
		    }
	
}
