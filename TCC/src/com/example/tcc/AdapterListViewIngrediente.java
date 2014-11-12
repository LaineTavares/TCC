package com.example.tcc;

import java.util.List;

import entidades.Ingrediente;
import entidades.Nutriente;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterListViewIngrediente extends BaseAdapter{
	
	private Context context;
	private LayoutInflater mInflater;
    private List<Ingrediente> itens;
    
    public AdapterListViewIngrediente(Context context, List<Ingrediente> itens)
    {
    	super();
        this.itens = itens;
        this.context = context;
        //mInflater = LayoutInflater.from(context);
    }
    public int getCount()
    {
        return itens.size();
    }
 
   
    public Ingrediente getItem(int position)
    {
        return itens.get(position);
    }
 
    public long getItemId(int position)
    {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Ingrediente item = itens.get(position);
        Log.i("adapter", item.getNomeIngrediente());
        //view = mInflater.inflate(R.layout.listview_nutriente, null);
        View layout;
        
     //  ((TextView) view.findViewById(R.id.textNutriente)).setText(item.getNome());
        if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.listview_ingrediente, null);
		}
		else{
			layout = convertView;
		}
		
		Log.i("adapter", item.getNomeIngrediente());
		TextView txtNome = (TextView) layout.findViewById(R.id.textIngrediente);
		
		txtNome.setText(item.getNomeIngrediente());
		
        return layout;
    }
}
