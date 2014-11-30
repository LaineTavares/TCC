package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import com.example.tcc.R.id;

import entidades.Animal;
import entidades.Nutriente;
import entidades.TipoAnimal;
import android.R.anim;
import android.app.Activity;
import android.graphics.YuvImage;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroAnimal extends Activity {

	private List<TipoAnimal> listaExemplo;

	Spinner spinner;
	ArrayAdapter<TipoAnimal> adapter;
	Button btnSalvar, btnCancelar;
	EditText txtTipo, txtCor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_animal);
		montaLista();
		Log.i("lista", listaExemplo.size() + "");
		CarregarInterfaceCadastro();
	}

	private void montaLista() {
		listaExemplo = new ArrayList<TipoAnimal>();

		TccDao tccDao = TccDao.getInstance(this);

		listaExemplo = tccDao.recuperarTodosTipoAnimais();

		spinner = (Spinner) findViewById(R.id.spinnerTipoAnimal);
		adapter = new ArrayAdapter<TipoAnimal>(this,
				android.R.layout.simple_spinner_item, listaExemplo);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);

	}

	public void CarregarInterfaceCadastro() {

		btnCancelar = (Button) findViewById(R.id.btnCancelar);
		btnCancelar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				finish();
			}
		});

		// configurando o formulário de cadastro
		txtTipo = (EditText) findViewById(R.id.txtNome);
		txtCor = (EditText) findViewById(R.id.txtCor);

		// configurando o botão de salvar
		btnSalvar = (Button) findViewById(R.id.btnSalvar);
		btnSalvar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (txtCor.getText().toString().equals("")
						|| txtTipo.getText().toString().equals("")
						|| adapter.getCount() == 0) {
					Toast.makeText(getApplicationContext(),
							"Todos os campos devem ser preenchidos!",
							Toast.LENGTH_SHORT).show();
				} else {
					String tipoAnimal = txtTipo.getText().toString();
					String corAnimal = txtCor.getText().toString();
					TipoAnimal tipoA = (TipoAnimal) spinner.getSelectedItem();

					Animal animal = new Animal(tipoAnimal, corAnimal, 1, tipoA);
					insereAnimal(animal);
				}
			}
		});
	}

	public TccDao tccDao;

	public void insereAnimal(Animal animal) {
		tccDao = TccDao.getInstance(this);
		Log.d("animal", "salvando animal -> " + animal.getId() + " -> "
				+ animal.getNome());
		tccDao.salvar(animal);
		List<Animal> animais = tccDao.recuperarTodosAnimal();
		for (Animal animaisfor : animais) {
			Log.d("animal", animaisfor.getNome());

		}

		finish();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

}
