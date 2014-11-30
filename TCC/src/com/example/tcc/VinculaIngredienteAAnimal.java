package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import entidades.Animal;
import entidades.Animal_Ingrediente;
import entidades.Ingrediente;
import entidades.Ingrediente_Nutriente;
import entidades.Nutriente;
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

public class VinculaIngredienteAAnimal extends Activity {
	private List<Ingrediente> listaIngrediente;
	private List<Animal> listaAnimal;

	Spinner spinnerAnimal, spinnerIngrediente;
	ArrayAdapter<Animal> adapterAnimal;
	ArrayAdapter<Ingrediente> adapterIngrediente;
	Button btnSalvar, btnCancelar;
	EditText porcIngrediente;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animal_ingrediente);
		montaListaIngrediente();
		montaListaAnimal();
		Log.i("lista", listaIngrediente.size() + "");
		Log.i("lista2", listaAnimal.size() + "");
		CarregarInterfaceCadastro();
	}

	private void montaListaAnimal() {
		listaAnimal = new ArrayList<Animal>();

		TccDao tccDao = TccDao.getInstance(this);
		listaAnimal = tccDao.recuperarTodosAnimal();
		spinnerAnimal = (Spinner) findViewById(R.id.spinnerAnimal);
		adapterAnimal = new ArrayAdapter<Animal>(this,
				android.R.layout.simple_spinner_item, listaAnimal);
		adapterAnimal
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerAnimal.setAdapter(adapterAnimal);

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

		porcIngrediente = (EditText) findViewById(R.id.txtPorcentagemIngrediente);

		// configurando o botão de salvar
		btnSalvar = (Button) findViewById(R.id.btnSalvar);
		btnSalvar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (porcIngrediente.getText().toString().equals("")
						|| adapterAnimal.getCount() == 0
						|| adapterIngrediente.getCount() == 0) {
					Toast.makeText(getApplicationContext(),
							"O campo deve ser preenchido!", Toast.LENGTH_SHORT)
							.show();
				} else {
					String porc = porcIngrediente.getText().toString();
					Ingrediente i = (Ingrediente) spinnerIngrediente
							.getSelectedItem();
					Animal n = (Animal) spinnerAnimal.getSelectedItem();

					Animal_Ingrediente animal_ingrediente = new Animal_Ingrediente(
							1, i, n, porc);

					insereAnimalIngrediente(animal_ingrediente);
				}
			}
		});
	}

	public TccDao tccDao;

	public void insereAnimalIngrediente(Animal_Ingrediente animal_ingrediente) {
		tccDao = TccDao.getInstance(this);
		Log.d("animal_ingrediente",
				"salvando animal_ingrediente -> " + animal_ingrediente.getId()
						+ " -> " + animal_ingrediente.getId());
		tccDao.salvar(animal_ingrediente);
		finish();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

}
