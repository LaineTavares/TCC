package com.example.tcc;

import java.util.ArrayList;
import java.util.List;

import entidades.Nutriente;
import entidades.TipoAnimal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterListViewNutriente extends BaseAdapter{
	
	private Context context;
	private LayoutInflater mInflater;
    private List<TipoAnimal> itens;
    
    public AdapterListViewNutriente(Context context, List<TipoAnimal> itens)
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
 
   
    public TipoAnimal getItem(int position)
    {
        return itens.get(position);
    }
 
    public long getItemId(int position)
    {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent)
    {
        TipoAnimal item = itens.get(position);
        Log.i("adapter", item.getTipoAnimal());
        //view = mInflater.inflate(R.layout.listview_nutriente, null);
        View layout;
        
     //  ((TextView) view.findViewById(R.id.textNutriente)).setText(item.getNome());
        if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.listview_nutriente, null);
		}
		else{
			layout = convertView;
		}
		
		Log.i("adapter", item.getTipoAnimal());
		TextView txtNome = (TextView) layout.findViewById(R.id.textNutriente);
		
		txtNome.setText(item.getTipoAnimal());
		
        return layout;
    }
    
}
