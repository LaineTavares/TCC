package com.example.tcc;



import entidades.Animal;




import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
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
	
	private ListView mDrawerList;
	private DrawerLayout mDrawer;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] menuItems;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
         CarregarInterfaceListagem();
 		}
	
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
		        
		   
		        
		        
		    }
	
	

}
