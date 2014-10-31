package com.example.tcc;

import entidades.Ingrediente;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;

public class PersistenceHelper extends SQLiteOpenHelper{

	private static final String NOME_BD = "Animal";
	private static final int VERSAO_BD = 2;
	private static final String LOG_TAG = "Animal";
	private static final String LOG_TAG1 = "Ingrediente";
	private static final String LOG_TAG2 = "Nutriente";
	private static final String LOG_TAG3 = "TipoAnimal";
	private static final String LOG_TAG4 = "Ingrediente_Nutriente";
		
	private  static PersistenceHelper instance;

	
	public PersistenceHelper(Context context){
		super(context, NOME_BD, null, VERSAO_BD);
				
	}
	 public static PersistenceHelper getInstance(Context context) {
	        if(instance == null)
	            instance = new PersistenceHelper(context);
	         
	        return instance;
	    }
	 
	
	
	 @Override
	    public void onCreate(SQLiteDatabase db) {
	        db.execSQL(TccDao.CREATE_TABLE_ANIMAL);
	        db.execSQL(TccDao.CREATE_TABLE_INGREDIENTE);
	        db.execSQL(TccDao.CREATE_TABLE_NUTRIENTE);
	        db.execSQL(TccDao.CREATE_TABLE_TIPO_ANIMAL);
	        db.execSQL(TccDao.CREATE_TABLE_INGREDIENTE_NUTRIENTE);
	    
	    }
	 
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        db.execSQL(TccDao.DELETE_TABLE_ANIMAL);
	      	        onCreate(db);
	      	db.execSQL(TccDao.DELETE_TABLE_INGREDIENTE);
	      			onCreate(db);
	      	db.execSQL(TccDao.DELETE_TABLE_NUTRIENTE);
	      			onCreate(db);
	      	db.execSQL(TccDao.DELETE_TABLE_TIPO_ANIMAL);
	      			onCreate(db);
	      	db.execSQL(TccDao.DELETE_TABLE_INGREDIENTE_NUTRIENTE);
	      			onCreate(db);
	    }
	    

	
}
