package com.example.tcc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Graficos extends Activity {
	Button btnGeraGraficoNutriente, btnGeraGraficoIngrediente, btnVoltar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gerar_graficos);
		CarregarInterfaceCadastro();
	}

	public void CarregarInterfaceCadastro() {

	
		btnGeraGraficoIngrediente = (Button)findViewById(R.id.btnGerarGraficoIngrediente);
		btnGeraGraficoIngrediente.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent it = new Intent(getApplicationContext(), GraficoIngrediente.class);
        		startActivity(it);
        		
        	}
        	
        });
		
		btnGeraGraficoNutriente = (Button)findViewById(R.id.btnGerarGraficoNutrientes);
		btnGeraGraficoNutriente.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent it = new Intent(getApplicationContext(), GraficoDeNutriente.class);
        		startActivity(it);
        		
        	}
        	
        });

         
        
		btnVoltar = (Button) findViewById(R.id.btnVoltarInicio);
		btnVoltar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				finish();
			}
		});

	}
}
