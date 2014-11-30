package com.example.tcc;

import java.util.List;

import entidades.Nutriente;
import entidades.TipoAnimal;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroTipoAnimal extends Activity {

	Button btnSalvarTipo, btnCancelarTipo;
	EditText txtTipoAnimal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_tipo_animal);
		CarregarInterfaceCadastro();
	}

	public void CarregarInterfaceCadastro() {

		btnCancelarTipo = (Button) findViewById(R.id.btnCancelarTipoAnimal);
		btnCancelarTipo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				finish();
			}
		});

		// configurando o formulário de cadastro
		txtTipoAnimal = (EditText) findViewById(R.id.txtTipoAnimal);

		// configurando o botão de salvar
		btnSalvarTipo = (Button) findViewById(R.id.btnSalvarTipoAnimal);
		btnSalvarTipo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (txtTipoAnimal.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(),
							"O campo deve ser preenchido!", Toast.LENGTH_SHORT)
							.show();
				} else {
					String tipoAnimal = txtTipoAnimal.getText().toString();
					TipoAnimal tipo_animal = new TipoAnimal(tipoAnimal, 1);
					insereTipoAnimal(tipo_animal);
				}

			}

		});
	}

	public TccDao tccDao;

	public void insereTipoAnimal(TipoAnimal tipoAnimal) {
		tccDao = TccDao.getInstance(this);
		Log.d("tipo_animal", "salvando tipo animal -> " + tipoAnimal.getId()
				+ " -> " + tipoAnimal.getTipoAnimal());
		tccDao.salvar(tipoAnimal);
		List<TipoAnimal> tipo_animais = tccDao.recuperarTodosTipoAnimais();
		for (TipoAnimal tipoAnimal2 : tipo_animais) {
			Log.d("tipo animal", tipoAnimal2.getTipoAnimal());

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
