package com.example.tcc;



import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;




import entidades.Animal;
import entidades.Ingrediente;
import entidades.Nutriente;




import android.R.color;
import android.R.integer;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	Button btnCadastros;
	Button btnRelatoriosButton;
	Button btnGraficos;
	Button btnFechar;
		
	private ListView mDrawerList;
	private ListView lista;
	private DrawerLayout mDrawer;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] menuItems;
	private AdapterListViewNutriente exemploAdapter;
	private List<Nutriente> listaExemplo;
	String cor="";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 //setContentView(R.layout.menu_teste);
		 
		 //mDrawer = (DrawerLayout) findViewById(R.id.help);
		 CarregarInterfaceListagem();
		
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
	  //  MenuItem item =  menu.add(0, 1, 0, "Teste");
	    //return true;
	//}
	
	public void CarregarInterfaceListagem()
		    {
		        //setContentView(R.layout.activity_main);
				setContentView(R.layout.tela_inicial);
		 
		        //configurando o botão de criar novo cadastro
		        
				btnCadastros = (Button)findViewById(R.id.btnCadastros);
				btnCadastros.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent it = new Intent(getApplicationContext(), Cadastros.class);
		        		startActivity(it);
						
					}
				});
				
				 btnRelatoriosButton = (Button) findViewById(R.id.btnRelatorios);
			     btnRelatoriosButton.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Intent it = new Intent(getApplicationContext(), Relatorios.class);
			        		startActivity(it);
							
						}
					});	 
			     
				 btnGraficos = (Button) findViewById(R.id.btnGraficos);
			     btnGraficos.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							abrirGrafico();
							
						}
					});	 
		        
		    }
	public void abrirGrafico(){	
		final DefaultRenderer defaultRenderer = new DefaultRenderer();
		defaultRenderer.setChartTitle("Convidados por grupo");
	    defaultRenderer.setZoomButtonsVisible(false);
	    defaultRenderer.setLegendTextSize(40);
	    defaultRenderer.setZoomEnabled(false);
	    defaultRenderer.setChartTitleTextSize(30);
	    defaultRenderer.setLabelsTextSize(30);
	    defaultRenderer.setLabelsColor(Color.GRAY);
	    defaultRenderer.setStartAngle(180);
	    defaultRenderer.setDisplayValues(false);
	    defaultRenderer.setShowLegend(true);
	    defaultRenderer.setShowLabels(true);
	    defaultRenderer.setClickEnabled(true);
	    defaultRenderer.setInScroll(true);
	    final CategorySeries categorySeries = new CategorySeries("");

	    final NumberFormat numberFormat= NumberFormat.getNumberInstance();
	    numberFormat.setParseIntegerOnly(true);
	    numberFormat.setMinimumFractionDigits(0);

	    List<Nutriente> listNutriente = new ArrayList<Nutriente>();
	    listNutriente.add(new Nutriente("teste", 1));
	    listNutriente.add(new Nutriente("aaaaa", 2));
	    for (Nutriente n : listNutriente){
	       categorySeries.add(n.getNome(), n.getId());
	       SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
	       renderer.setColor(Integer.valueOf(setaCorBackgroundRandom()));
	       
	       renderer.setChartValuesFormat(numberFormat);
	       defaultRenderer.addSeriesRenderer(renderer);
	    }
	    
	    
	    final GraphicalView graphicalView = ChartFactory.getPieChartView(this, categorySeries, defaultRenderer);


    graphicalView.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	SeriesSelection seriesSelection = graphicalView.getCurrentSeriesAndPoint();
	              if (seriesSelection != null) {
	                  for (int i = 0; i < categorySeries.getItemCount(); i++) {
	                	  defaultRenderer.getSeriesRendererAt(i).setHighlighted(i == 
	                	  seriesSelection.getPointIndex());
	                    }
	                    graphicalView.repaint();

	                            }
	              }
	          });

	    AlertDialog.Builder builder = new Builder(this);
	    builder.setTitle("Gráfico!");
	    builder.setView(graphicalView);
	    builder.setNegativeButton("Fechar", null);
	    builder.setInverseBackgroundForced(true);

	    builder.create().show();
	  }
	  private String setaCorBackgroundRandom(){
	        
	        Cores cores = new Cores(getApplicationContext());
	        cor = cores.getRandomCorSemRepetir(cor);
	        return cor;
	    }

	
}
