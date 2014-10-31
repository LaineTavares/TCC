package com.example.tcc;

import java.util.List;

import entidades.Ingrediente;
import entidades.Nutriente;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CadastroNutriente extends Activity {

	Button btnSalvarNutriente, btnCancelarNutriente;
	EditText txtNomeNutriente;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastronutriente);
		CarregarInterfaceCadastro();
	}

	
	public void CarregarInterfaceCadastro()
    { 
        
        btnCancelarNutriente = (Button)findViewById(R.id.btnCancelarNutriente);
        btnCancelarNutriente.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	 
	       		 finish();
            }});
 
        //configurando o formulário de cadastro
        txtNomeNutriente = (EditText)findViewById(R.id.txtNomeNutriente);
             
 
        //configurando o botão de salvar
        btnSalvarNutriente = (Button)findViewById(R.id.btnSalvarNutriente);
        btnSalvarNutriente.setOnClickListener(new OnClickListener(){
           

			public void onClick(View v) {
				String nomeNutriente = txtNomeNutriente.getText().toString();
				Nutriente nutriente = new Nutriente(nomeNutriente, 1);
				insereNutriente(nutriente);
            }});
    }
	public TccDao tccDao;
	
	public void insereNutriente(Nutriente nutriente)
    {
      tccDao = TccDao.getInstance(this);
 		Log.d("nutriente",
				"salvando nutriente -> " + nutriente.getId() + " -> "
						+ nutriente.getNome());
		tccDao.salvar(nutriente);
		List<Nutriente> nutrientes = tccDao.recuperarTodosNutrientes();
		for(Nutriente nutrienteFor : nutrientes){
			Log.d("nutriente", nutrienteFor.getNome());
			
		}
		
		finish();
    
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro_nutriente, menu);
		return true;
	}

}
