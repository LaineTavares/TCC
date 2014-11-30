package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import entidades.Ingrediente;
import entidades.Ingrediente_Nutriente;
import entidades.Nutriente;

public class VinculaIngredienteNutriente extends Activity {

	private List<Nutriente> listaNutriente;
	private List<Ingrediente> listaIngrediente;

	Spinner spinnerNutriente, spinnerIngrediente;
	ArrayAdapter<Nutriente> adapterNutriente;
	ArrayAdapter<Ingrediente> adapterIngrediente;
	Button btnSalvar, btnCancelar;
	EditText porcNutriente;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ingr_nutri);
		montaListaIngrediente();
		montaListaNutriente();
		Log.i("lista", listaIngrediente.size() + "");
		Log.i("lista2", listaNutriente.size() + "");
		CarregarInterfaceCadastro();
	}

	private void montaListaNutriente() {
		listaNutriente = new ArrayList<Nutriente>();

		TccDao tccDao = TccDao.getInstance(this);
		listaNutriente = tccDao.recuperarTodosNutrientes();
		spinnerNutriente = (Spinner) findViewById(R.id.spinnerNutriente);
		adapterNutriente = new ArrayAdapter<Nutriente>(this,
				android.R.layout.simple_spinner_item, listaNutriente);
		adapterNutriente
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerNutriente.setAdapter(adapterNutriente);

	}

	private void montaListaIngrediente() {
		listaIngrediente = new ArrayList<Ingrediente>();
		TccDao tccDao = TccDao.getInstance(this);

		listaIngrediente = tccDao.recuperarTodosIngrediente();
		spinnerIngrediente = (Spinner) findViewById(R.id.spinnerIngrediente);
		adapterIngrediente = new ArrayAdapter<Ingrediente>(this,
				android.R.layout.simple_spinner_item, listaIngrediente);

		adapterIngrediente
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerIngrediente.setAdapter(adapterIngrediente);

	}

	public void CarregarInterfaceCadastro() {

		btnCancelar = (Button) findViewById(R.id.btnCancelar);
		btnCancelar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				finish();
			}
		});

		porcNutriente = (EditText) findViewById(R.id.txtPorcentagemNutriente);

		// configurando o botão de salvar
		btnSalvar = (Button) findViewById(R.id.btnSalvar);
		btnSalvar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (porcNutriente.getText().toString().equals("")
						|| adapterIngrediente.getCount() == 0
						|| adapterNutriente.getCount() == 0) {
					Toast.makeText(getApplicationContext(),
							"Todos os campos devem serem preenchidos!", Toast.LENGTH_SHORT)
							.show();
				} else {
					String porc = porcNutriente.getText().toString();
					Ingrediente i = (Ingrediente) spinnerIngrediente
							.getSelectedItem();
					Nutriente n = (Nutriente) spinnerNutriente
							.getSelectedItem();

					Ingrediente_Nutriente ing_nutri = new Ingrediente_Nutriente(
							1, i, n, porc);

					insereIngrediente_Nutriente(ing_nutri);
				}
			}
		});
	}

	public TccDao tccDao;

	public void insereIngrediente_Nutriente(Ingrediente_Nutriente ing_nutri) {
		tccDao = TccDao.getInstance(this);
		Log.d("ingrediente_nutriente",
				"salvando ingr_nutri -> " + ing_nutri.getId() + " -> "
						+ ing_nutri.getId());
		tccDao.salvar(ing_nutri);
		// List<Ingrediente_Nutriente> i]-n= tccDao.recuperarTodasAnimal();
		// for(Animal animaisfor : animais){
		// Log.d("animal", animaisfor.getNome());

		// }

		finish();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

}
