package com.example.tcc;

import java.util.List;

import com.example.tcc.R.id;

import entidades.Animal;
import entidades.Ingrediente;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroIngrediente extends Activity {
	Button btnSalvarIngrediente, btnCancelar;
	EditText txtNomeIngrediente, txtPrecoIngrediente;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastroingrediente);
		CarregarInterfaceCadastro();
	}

	public void CarregarInterfaceCadastro() {

		btnCancelar = (Button) findViewById(R.id.btnCancelarIngrediente);
		btnCancelar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				finish();
			}
		});

		// configurando o formulário de cadastro
		txtNomeIngrediente = (EditText) findViewById(R.id.txtNomeIngrediente);
		txtPrecoIngrediente = (EditText) findViewById(R.id.txtPrecoIngrediente);

		// configurando o botão de salvar
		btnSalvarIngrediente = (Button) findViewById(R.id.btnSalvarIngrediente);
		btnSalvarIngrediente.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (txtNomeIngrediente.getText().toString().equals("")
						|| txtPrecoIngrediente.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(),
							"Todos os campos devem ser preenchido!",
							Toast.LENGTH_SHORT).show();
				} else {
					String nomeIngrediente = txtNomeIngrediente.getText()
							.toString();
					String precoIngrediente = txtPrecoIngrediente.getText()
							.toString();
					Ingrediente ingrediente = new Ingrediente(nomeIngrediente,
							1, precoIngrediente);
					insereIngrediente(ingrediente);
				}
			}
		});
	}

	public TccDao tccDao;

	public void insereIngrediente(Ingrediente ingrediente) {
		tccDao = TccDao.getInstance(this);
		Log.d("ingrediente", "salvando ingrediente -> " + ingrediente.getId()
				+ " -> " + ingrediente.getNomeIngrediente());
		tccDao.salvar(ingrediente);
		List<Ingrediente> ingredientes = tccDao.recuperarTodosIngrediente();
		for (Ingrediente ingrediente2 : ingredientes) {
			Log.d("ingrediente", ingrediente2.getPrecoIngrediente());

		}

		finish();

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}
}
