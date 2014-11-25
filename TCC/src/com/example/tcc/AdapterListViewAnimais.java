package com.example.tcc;

import java.util.List;

import entidades.Animal;
import entidades.Ingrediente;
import android.R.anim;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterListViewAnimais extends BaseAdapter {
	private Context context;
	private LayoutInflater mInflater;
    private List<Animal> itens;
    
    public AdapterListViewAnimais(Context context, List<Animal> itens) {
    	super();
        this.itens = itens;
        this.context = context;
  
    }
    public int getCount()
    {
        return itens.size();
    }
 
   
    public Animal getItem(int position)
    {
        return itens.get(position);
    }
 
    public long getItemId(int position)
    {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Animal item = itens.get(position);
        Log.i("adapter", item.getNome());
        //view = mInflater.inflate(R.layout.listview_nutriente, null);
        View layout;
        
     //  ((TextView) view.findViewById(R.id.textNutriente)).setText(item.getNome());
        if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.listview_animais, null);
		}
		else{
			layout = convertView;
		}
		
		Log.i("adapter", item.getNome());
		TextView txtNome = (TextView) layout.findViewById(R.id.textAnimais);
		
		txtNome.setText(item.getNome());
		
        return layout;
    }

}
