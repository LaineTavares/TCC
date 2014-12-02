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
import entidades.Animal_Ingrediente;
import entidades.Ingrediente;
import entidades.Ingrediente_Nutriente;
import entidades.Nutriente;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class GraficoIngrediente extends Activity{
	

		private List<Animal> listaAnimal;

		Spinner spinnerAnimal;
		ArrayAdapter<Animal> adapterAnimal;
		Button btnGeraGraficoIngrediente;
		String cor = "";

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.grafico_ingrediente);
			montaListaAnimal();
			Log.i("lista", listaAnimal.size() + "");
			CarregarInterfaceCadastro();
		}

		private void montaListaAnimal() {
			listaAnimal = new ArrayList<Animal>();
			TccDao tccDao = TccDao.getInstance(this);

			listaAnimal = tccDao.recuperarTodosAnimal();
			spinnerAnimal = (Spinner) findViewById(R.id.spinnerAnimal);
			adapterAnimal = new ArrayAdapter<Animal>(this,
					android.R.layout.simple_spinner_item, listaAnimal);
			adapterAnimal
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerAnimal.setAdapter(adapterAnimal);

		}

		public void CarregarInterfaceCadastro() {

			// configurando o botão de salvar
			btnGeraGraficoIngrediente = (Button) findViewById(R.id.btnGeraGraficoIngrediente_Animal);
			btnGeraGraficoIngrediente.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Animal i = (Animal) spinnerAnimal
							.getSelectedItem();
					abrirGrafico(i);

				}
			});
		}

		public void abrirGrafico(Animal animal) {
			final DefaultRenderer defaultRenderer = new DefaultRenderer();
			defaultRenderer.setChartTitle("Ingredientes do animal: " + animal.getNome());
			defaultRenderer.setZoomButtonsVisible(false);
			defaultRenderer.setLegendTextSize(40);
			defaultRenderer.setZoomEnabled(false);
			defaultRenderer.setChartTitleTextSize(30);
			defaultRenderer.setLabelsTextSize(30);
			defaultRenderer.setLabelsColor(Color.BLACK);
			defaultRenderer.setStartAngle(180);
			defaultRenderer.setDisplayValues(false);
			defaultRenderer.setShowLegend(true);
			defaultRenderer.setShowLabels(true);
			defaultRenderer.setClickEnabled(true);
			defaultRenderer.setInScroll(true);
			final CategorySeries categorySeries = new CategorySeries("");

			final NumberFormat numberFormat = NumberFormat.getNumberInstance();
			numberFormat.setParseIntegerOnly(true);
			numberFormat.setMinimumFractionDigits(0);

			List<Animal_Ingrediente> listAnimal = new ArrayList<Animal_Ingrediente>();
			TccDao tccDao = TccDao.getInstance(this);
			listAnimal = tccDao.recuperaTodosAni_Ingre(animal);
			for (Animal_Ingrediente n : listAnimal) {
				categorySeries.add(n.getIngrediente().getNomeIngrediente(),
						Double.parseDouble(n.getPorcentagemIngrediente()));
				SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
				renderer.setColor(Integer.valueOf(setaCorBackgroundRandom()));

				renderer.setChartValuesFormat(numberFormat);
				defaultRenderer.addSeriesRenderer(renderer);
			}

			final GraphicalView graphicalView = ChartFactory.getPieChartView(this,
					categorySeries, defaultRenderer);

			graphicalView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					SeriesSelection seriesSelection = graphicalView
							.getCurrentSeriesAndPoint();
					if (seriesSelection != null) {
						for (int i = 0; i < categorySeries.getItemCount(); i++) {
							defaultRenderer.getSeriesRendererAt(i).setHighlighted(
									i == seriesSelection.getPointIndex());
						}
						graphicalView.repaint();

					}
				}
			});

			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("Gráfico de Ingrediente!");
			builder.setView(graphicalView);
			builder.setNegativeButton("Fechar", null);
			builder.setInverseBackgroundForced(true);

			builder.create().show();
		}

		private String setaCorBackgroundRandom() {

			Cores cores = new Cores(getApplicationContext());
			cor = cores.getRandomCorSemRepetir(cor);
			return cor;
		}

	}



