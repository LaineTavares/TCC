package menu;

import com.example.tcc.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<MenuItemModel> {

	
	public TextView texto;
	public ImageView imagem;

	public MenuAdapter(Context context) {
		super(context, 0);
	}


	public void addItem(String title, int icon) {
		add(new MenuItemModel(title, icon));
	}

	public void addItem(MenuItemModel itemModel) {
		add(itemModel);
	}

	public View getView(int position, View view, ViewGroup parent) {

		MenuItemModel item = getItem(position);
		
	
			int layout = R.layout.menuglobal;

			view = LayoutInflater.from(getContext()).inflate(layout, null);

			texto = (TextView) view.findViewById(R.id.menu_titulo);
			imagem = (ImageView) view.findViewById(R.id.menu_icone);
			texto.setText(item.getTitulo());
			imagem.setImageResource(item.getIcone());

	    return view;		
	}

}
