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

public class GraficoDeNutriente extends Activity {
	private List<Ingrediente> listaIngrediente;

	Spinner spinnerIngrediente;
	ArrayAdapter<Ingrediente> adapterIngrediente;
	Button btnGeraGrafico;
	String cor = "";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grafico_nutriente);
		montaListaIngrediente();
		Log.i("lista", listaIngrediente.size() + "");
		CarregarInterfaceCadastro();
	}

	private void montaListaIngrediente() {
		listaIngrediente = new ArrayList<Ingrediente>();
		TccDao tccDao = TccDao.getInstance(this);

		listaIngrediente = tccDao.recuperarTodosIngrediente();
		spinnerIngrediente = (Spinner) findViewById(R.id.spinnerIngrediente);
		adapterIngrediente = new ArrayAdapter<Ingrediente>(this,
				android.R.layout.simple_spinner_item, listaIngrediente);
		adapterIngrediente
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerIngrediente.setAdapter(adapterIngrediente);

	}

	public void CarregarInterfaceCadastro() {

		// configurando o botão de salvar
		btnGeraGrafico = (Button) findViewById(R.id.btnGeraGrafico);
		btnGeraGrafico.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Ingrediente i = (Ingrediente) spinnerIngrediente
						.getSelectedItem();
				abrirGrafico(i);

			}
		});
	}

	public void abrirGrafico(Ingrediente ingrediente) {
		final DefaultRenderer defaultRenderer = new DefaultRenderer();
		defaultRenderer.setChartTitle("Amostra de Nutrientes");
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

		List<Ingrediente_Nutriente> listNutriente = new ArrayList<Ingrediente_Nutriente>();
		TccDao tccDao = TccDao.getInstance(this);
		listNutriente = tccDao.recuperaTodosIngri_Nutri(ingrediente);
		for (Ingrediente_Nutriente n : listNutriente) {
			categorySeries.add(n.getNutriente().getNome(),
					Double.parseDouble(n.getPorcentagemNutriente()));
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
		builder.setTitle("Gráfico de Nutriente!");
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
