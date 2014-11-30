package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract.DataUsageFeedback;
import android.util.Log;
import entidades.Animal;
import entidades.Animal_Ingrediente;
import entidades.Ingrediente;
import entidades.Ingrediente_Nutriente;
import entidades.Nutriente;
import entidades.TipoAnimal;

public class TccDao {

	public static final String tabela_animal = "Animais";
	public static final String id = "id";
	public static final String nome = "nome";
	public static final String cor = "cor";

	public static final String tabela_ingrediente = "Ingredientes";
	// public static final String idTabelaIngrediente = "idTabelaIngrediente";
	public static final String idIngrediente = "idIngrediente";
	public static final String nomeIngrediente = "nomeIngrediente";
	public static final String precoIngrediente = "precoIngrediente";

	public static final String tabela_ingrediente_nutriente = "Ingredientes_Nutrientes";
	public static final String idTabelaIngredienteNutriente = "idTabelaIngredienteNutriente";
	public static final String idIngre_Nutri = "idIngre_Nutri";
	public static final String porcentagem_Nutri = "porcentagem_Nutri";
	public static final String idNutri_Ingre = "idNutri_Ingri";
	
	public static final String tabela_animal_ingrediente = "Animal_Ingrediente";
	public static final String idTabelaAnimalIngrediente = "idTabelaAnimalIngrediente";
	public static final String idAnimal_Ingre = "idAnimal_Ingre";
	public static final String porcentagem_Ingrediente = "porcentagem_Ingrediente";
	public static final String idIngre_Animal = "idIngre_Animal";

	public static final String tabela_nutriente = "Nutrientes";
	public static final String idTabelaNutriente = "idTabelaNutriente";
	public static final String idNutriente = "idNutriente";
	public static final String nomeNutriente = "nomeNutriente";

	public static final String tabela_tipo_animal = "Tipo_Animal";
	public static final String idTabelaTipoAnimal = "idTabelaTipoAnimal";
	public static final String tipoAnimal = "tipoAnimal";

	public static final String CREATE_TABLE_ANIMAL = "CREATE TABLE IF NOT EXISTS "
			+ tabela_animal
			+ "("
			+ id
			+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ nome
			+ " TEXT, "
			+ cor
			+ " TEXT, "
			+ idTabelaTipoAnimal
			+ " Long);";

	public static final String DELETE_TABLE_ANIMAL = "DROP TABLE IF EXISTS "
			+ tabela_animal;

	public static final String CREATE_TABLE_INGREDIENTE = "CREATE TABLE IF NOT EXISTS "
			+ tabela_ingrediente
			+ "("
			+ tabela_ingrediente
			+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ precoIngrediente
			+ " TEXT ," + nomeIngrediente + " TEXT );";

	public static final String DELETE_TABLE_INGREDIENTE = "DROP TABLE IF EXISTS "
			+ tabela_ingrediente;

	public static final String CREATE_TABLE_INGREDIENTE_NUTRIENTE = "CREATE TABLE IF NOT EXISTS "
			+ tabela_ingrediente_nutriente
			+ "("
			+ idTabelaIngredienteNutriente
			+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ idIngre_Nutri
			+ " Long ,"
			+ porcentagem_Nutri + " TEXT ," + idNutri_Ingre + " LONG );";

	public static final String DELETE_TABLE_INGREDIENTE_NUTRIENTE = "DROP TABLE IF EXISTS "
			+ tabela_ingrediente_nutriente;

	public static final String CREATE_TABLE_ANIMAL_INGREDIENTE = "CREATE TABLE IF NOT EXISTS "
			+ tabela_animal_ingrediente
			+ "("
			+ idTabelaAnimalIngrediente
			+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ idAnimal_Ingre
			+ " Long ,"
			+ porcentagem_Ingrediente + " TEXT ," + idIngre_Animal + " LONG );";

	public static final String DELETE_ANIMAL_INGREDIENTE = "DROP TABLE IF EXISTS "
			+ tabela_animal_ingrediente;
	
	public static final String CREATE_TABLE_NUTRIENTE = "CREATE TABLE IF NOT EXISTS "
			+ tabela_nutriente
			+ "("
			+ idTabelaNutriente
			+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ nomeNutriente
			+ " TEXT );";

	public static final String DELETE_TABLE_NUTRIENTE = "DROP TABLE IF EXISTS "
			+ tabela_nutriente;

	public static final String CREATE_TABLE_TIPO_ANIMAL = "CREATE TABLE IF NOT EXISTS "
			+ tabela_tipo_animal
			+ "("
			+ idTabelaTipoAnimal
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + tipoAnimal + " TEXT );";

	public static final String DELETE_TABLE_TIPO_ANIMAL = "DROP TABLE IF EXISTS "
			+ tabela_tipo_animal;

	private SQLiteDatabase dataBase = null;

	private static TccDao instance;

	public static TccDao getInstance(Context context) {
		if (instance == null)
			instance = new TccDao(context);
		return instance;
	}

	private TccDao(Context context) {
		PersistenceHelper persistenceHelper = PersistenceHelper
				.getInstance(context);
		dataBase = persistenceHelper.getWritableDatabase();
	}

	public void salvar(Animal animal) {
		ContentValues values = gerarContentValuesAnimais(animal);
		dataBase.insert(tabela_animal, null, values);
	}

	public void salvar(Ingrediente_Nutriente ing_nut) {
		ContentValues values = gerarContentValuesIngNut(ing_nut);
		dataBase.insert(tabela_ingrediente_nutriente, null, values);

	}
	
	public void salvar(Animal_Ingrediente animal_ingre) {
		ContentValues values = gerarContentValuesAnimalIngrediente(animal_ingre);
		dataBase.insert(tabela_animal_ingrediente, null, values);

	}


	public void salvar(Ingrediente ingrediente) {
		ContentValues values = gerarContentValuesIngredientes(ingrediente);
		dataBase.insert(tabela_ingrediente, null, values);

	}

	public void salvar(TipoAnimal tipoAnimal) {
		ContentValues values = gerarContentValuesTipoAnimal(tipoAnimal);
		dataBase.insert(tabela_tipo_animal, null, values);

	}

	public void salvar(Nutriente nutriente) {
		ContentValues values = gerarContentValuesNutrientes(nutriente);
		dataBase.insert(tabela_nutriente, null, values);

	}

	private ContentValues gerarContentValuesIngredientes(Ingrediente ingrediente) {
		ContentValues values = new ContentValues();
		values.put(nomeIngrediente, ingrediente.getNomeIngrediente());
		values.put(precoIngrediente, ingrediente.getPrecoIngrediente());
		// values.put(idIngrediente, ingrediente.getId());

		return values;

	}

	private ContentValues gerarContentValuesTipoAnimal(TipoAnimal tipoAnimal) {
		ContentValues values = new ContentValues();
		values.put(TccDao.tipoAnimal, tipoAnimal.getTipoAnimal());
		// values.put(idIngrediente, ingrediente.getId());

		return values;

	}

	private ContentValues gerarContentValuesNutrientes(Nutriente nutriente) {
		ContentValues values = new ContentValues();
		values.put(nomeNutriente, nutriente.getNome());
		// values.put(idNutriente, nutriente.getId());

		return values;

	}

	private ContentValues gerarContentValuesAnimais(Animal animal) {
		ContentValues values = new ContentValues();
		values.put(nome, animal.getNome());
		values.put(cor, animal.getCor());
		values.put(idTabelaTipoAnimal, animal.getTipoAnimal().getId());

		return values;
	}

	private ContentValues gerarContentValuesIngNut(
			Ingrediente_Nutriente ing_nutri) {
		ContentValues values = new ContentValues();
		// values.put(idTabelaIngredienteNutriente, ing_nutri.getId());
		values.put(idIngre_Nutri, ing_nutri.getIngrediente().getId());
		values.put(idNutri_Ingre, ing_nutri.getNutriente().getId());
		values.put(porcentagem_Nutri, ing_nutri.getPorcentagemNutriente());

		return values;
	}
	
	private ContentValues gerarContentValuesAnimalIngrediente(
			Animal_Ingrediente animal_ingrediente) {
		ContentValues values = new ContentValues();
		// values.put(idTabelaIngredienteNutriente, ing_nutri.getId());
		values.put(idIngre_Animal, animal_ingrediente.getIngrediente().getId());
		values.put(idAnimal_Ingre, animal_ingrediente.getAnimal().getId());
		values.put(porcentagem_Ingrediente, animal_ingrediente.getPorcentagemIngrediente());

		return values;
	}

	public List<Animal> recuperarTodosAnimal() {
		String queryReturnAll = "SELECT * FROM " + tabela_animal;
		Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
		List<Animal> animais = construirAnimalPorCursor(cursor);

		return animais;
	}

	public List<Ingrediente> recuperarTodosIngrediente() {
		String queryReturnAll = "SELECT * FROM " + tabela_ingrediente;
		Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
		List<Ingrediente> ingredientes = construirIngredientePorCursor(cursor);

		return ingredientes;
	}
	
	public List<Ingrediente_Nutriente> recuperaTodosIngri_Nutri(Ingrediente ingrediente){
		String queryReturnAll = "select n.nomeNutriente, i.porcentagem_Nutri from Ingredientes_Nutrientes " +
				" as i join Nutrientes as n on n.idTabelaNutriente = i.idNutri_Ingri" +
				" where i.idIngre_Nutri = " + ingrediente.getId();
		Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
		List<Ingrediente_Nutriente> ingri_nutriente = construirVinculo(cursor);
		
		return ingri_nutriente;
		
	}

	public List<Nutriente> recuperarTodosNutrientes() {
		String queryReturnAll = "SELECT * FROM " + tabela_nutriente;
		Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
		List<Nutriente> nutrientes = construirNutrientePorCursor(cursor);

		return nutrientes;
	}

	public List<TipoAnimal> recuperarTodosTipoAnimais() {
		String queryReturnAll = "SELECT * FROM " + tabela_tipo_animal;
		Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
		List<TipoAnimal> tipoAnimais = construirTipoAnimalPorCursor(cursor);

		return tipoAnimais;
	}

	public void removerAnimal() {
		// dataBase.delete(tabela_usuario, null, null);
		String sql = "DELETE FROM " + tabela_animal;
		Log.d("login", "Remover animal: " + sql);
		dataBase.execSQL(sql);
	}

	public void removerIngrediente() {
		// dataBase.delete(tabela_usuario, null, null);
		String sql = "DELETE FROM " + tabela_ingrediente;
		Log.d("login", "Remover ingrediente: " + sql);
		dataBase.execSQL(sql);
	}

	public void removerNutriente() {
		// dataBase.delete(tabela_usuario, null, null);
		String sql = "DELETE FROM " + tabela_nutriente;
		Log.d("login", "Remover nutriente: " + sql);
		dataBase.execSQL(sql);
	}

	public void removerTipoAnimal() {
		// dataBase.delete(tabela_usuario, null, null);
		String sql = "DELETE FROM " + tabela_tipo_animal;
		Log.d("login", "Remover tipo animal: " + sql);
		dataBase.execSQL(sql);
	}

	private List<Ingrediente_Nutriente> construirVinculo(Cursor cursor) {

		List<Ingrediente_Nutriente> ing_nutri = new ArrayList<Ingrediente_Nutriente>();

		if (cursor == null)
			return ing_nutri;

		try {

			if (cursor.moveToFirst()) {
				do {

					int indexNomeNutriente = cursor
							.getColumnIndex(nomeNutriente);
					int indexPorcetangem = cursor
							.getColumnIndex(porcentagem_Nutri);

					String nome = cursor.getString(indexNomeNutriente);
					String porcetantagem = String.valueOf(cursor
							.getString(indexPorcetangem));

					Nutriente nutriente = new Nutriente(nome, null);
					Ingrediente_Nutriente ingre_nutri = new Ingrediente_Nutriente(
							null, null, nutriente, porcetantagem);

					ing_nutri.add(ingre_nutri);

				} while (cursor.moveToNext());
			}

		} finally {
			cursor.close();
		}
		return ing_nutri;
	}

	private List<Animal> construirAnimalPorCursor(Cursor cursor) {
		List<Animal> animais = new ArrayList<Animal>();
		if (cursor == null)
			return animais;

		try {

			if (cursor.moveToFirst()) {
				do {

					int indexID = cursor.getColumnIndex(id);
					int indexNome = cursor.getColumnIndex(nome);
					int indexCor = cursor.getColumnIndex(cor);

					int id = cursor.getInt(indexID);
					String nome = cursor.getString(indexNome);
					String cor = String.valueOf(cursor.getString(indexCor));

					Animal animal = new Animal(id, nome, cor);

					animais.add(animal);

				} while (cursor.moveToNext());
			}

		} finally {
			cursor.close();
		}
		return animais;
	}

	private List<Ingrediente> construirIngredientePorCursor(Cursor cursor) {
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		if (cursor == null)
			return ingredientes;

		try {

			if (cursor.moveToFirst()) {
				do {

					// int indexIdIngrediente =
					// cursor.getColumnIndex(idIngrediente);
					int indexIdTabelaIngrediente = cursor
							.getColumnIndex(tabela_ingrediente);
					int indexNomeIngrendiente = cursor
							.getColumnIndex(nomeIngrediente);
					int indexPrecoIngrediente = cursor
							.getColumnIndex(precoIngrediente);

					int id = cursor.getInt(indexIdTabelaIngrediente);
					String precoIngrediente = cursor
							.getString(indexPrecoIngrediente);
					String nomeIngrediente = cursor
							.getString(indexNomeIngrendiente);

					Ingrediente ingrediente = new Ingrediente(nomeIngrediente,
							id, precoIngrediente);

					ingredientes.add(ingrediente);

				} while (cursor.moveToNext());
			}

		} finally {
			cursor.close();
		}
		return ingredientes;
	}

	private List<Nutriente> construirNutrientePorCursor(Cursor cursor) {
		List<Nutriente> nutrientes = new ArrayList<Nutriente>();
		if (cursor == null)
			return nutrientes;

		try {

			if (cursor.moveToFirst()) {
				do {

					int indexIdNutriente = cursor
							.getColumnIndex(idTabelaNutriente);
					int indexNomeNutriente = cursor
							.getColumnIndex(nomeNutriente);

					int id = cursor.getInt(indexIdNutriente);
					String nomeNutriente = cursor.getString(indexNomeNutriente);

					Nutriente nutriente = new Nutriente(nomeNutriente, id);

					nutrientes.add(nutriente);

				} while (cursor.moveToNext());
			}

		} finally {
			cursor.close();
		}
		return nutrientes;
	}

	private List<TipoAnimal> construirTipoAnimalPorCursor(Cursor cursor) {
		List<TipoAnimal> tipo_animais = new ArrayList<TipoAnimal>();
		if (cursor == null)
			return tipo_animais;

		try {

			if (cursor.moveToFirst()) {
				do {

					int indexIdTipoAnimal = cursor
							.getColumnIndex(idTabelaTipoAnimal);
					int indexTipoAnimal = cursor.getColumnIndex(tipoAnimal);

					int id = cursor.getInt(indexIdTipoAnimal);
					String tipoAnimal = cursor.getString(indexTipoAnimal);

					TipoAnimal tipoAnimal1 = new TipoAnimal(tipoAnimal, id);

					tipo_animais.add(tipoAnimal1);

				} while (cursor.moveToNext());
			}

		} finally {
			cursor.close();
		}
		return tipo_animais;
	}

	private long getLong(Cursor cursor, int columnIndex) {
		long value = 0;

		try {
			if (!cursor.isNull(columnIndex)) {
				value = cursor.getLong(columnIndex);
			}
		} catch (Throwable tr) {
			Log.d("[c] - " + columnIndex, tr.getMessage());
		}

		return value;
	}

	private int getInt(Cursor cursor, int columnIndex) {
		int value = 0;

		try {
			if (!cursor.isNull(columnIndex)) {
				value = cursor.getInt(columnIndex);
			}
		} catch (Throwable tr) {
			Log.d("[c] - " + columnIndex, tr.getMessage());
		}

		return value;
	}

}
