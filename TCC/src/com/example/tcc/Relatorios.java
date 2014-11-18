package com.example.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Relatorios extends Activity{
	
	Button btnRelatorioNutriente, btnRelatorioIngrediente, btnRelatorioAnimal, btnRelatorioTipoAnimal,
	btnSairRelatorio;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relatorios);
		CarregarInterfaceCadastro();
	}
	
	public void CarregarInterfaceCadastro()
    { 
               
        
        btnRelatorioNutriente = (Button)findViewById(R.id.btnRelatorioNutri);
        btnRelatorioNutriente.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent it = new Intent(getApplicationContext(), RelatorioNutriente.class);
        		startActivity(it);
        		
        	}
        	
        });
        btnSairRelatorio = (Button)findViewById(R.id.btnSairRelatorio);
        btnSairRelatorio.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	 
	       		 finish();
            }});
    }
}
