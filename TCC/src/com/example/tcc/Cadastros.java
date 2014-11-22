package com.example.tcc;

import entidades.TipoAnimal;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Cadastros extends Activity{
	Button btnCadastroIngrediente, btnCadastroAnimal, btnCadastroTipoAnimal, btnCadastroNutriente,
	btnVincula, btnVoltar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastros);
		CarregarInterfaceCadastro();
	}
	public void CarregarInterfaceCadastro()
    { 
               
        
        btnCadastroIngrediente = (Button)findViewById(R.id.btnCadastroIngrediente);
        btnCadastroIngrediente.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent it = new Intent(getApplicationContext(), CadastroIngrediente.class);
        		startActivity(it);
        		
        	}
        	
        });
 
        btnCadastroAnimal = (Button)findViewById(R.id.btnCadastroAnimal);
        btnCadastroAnimal.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            Intent it = new Intent(getApplicationContext(), CadastroAnimal.class);
            startActivity(it);
            
       				            
            }});
        btnCadastroNutriente = (Button)findViewById(R.id.btnCadastroNutriente);
        btnCadastroNutriente.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            Intent it = new Intent(getApplicationContext(), CadastroNutriente.class);
            startActivity(it);
            
       				            
            }});
        btnCadastroTipoAnimal = (Button)findViewById(R.id.btnCadastroTipoAnimal);
        btnCadastroTipoAnimal.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            Intent it = new Intent(getApplicationContext(), CadastroTipoAnimal.class);
            startActivity(it);
            
       				            
            }});
        
        btnVincula = (Button)findViewById(R.id.btnVincula);
        btnVincula.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            Intent it = new Intent(getApplicationContext(), VinculaIngredienteNutriente.class);
            startActivity(it);
            
       				            
            }});
        
        btnVoltar = (Button)findViewById(R.id.btnVoltarCadastro);
        btnVoltar.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	 
	       		 finish();
            }});
    }
}
