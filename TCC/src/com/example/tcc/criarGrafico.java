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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import entidades.Nutriente;

public class criarGrafico extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		abrirGrafico();
			}
  public void abrirGrafico(){	
	final DefaultRenderer defaultRenderer = new DefaultRenderer();
	defaultRenderer.setChartTitle("Convidados por grupo");
    defaultRenderer.setZoomButtonsVisible(false);
    defaultRenderer.setZoomEnabled(false);
    defaultRenderer.setChartTitleTextSize(26);
    defaultRenderer.setLabelsTextSize(16);
    defaultRenderer.setLabelsColor(Color.GRAY);
    defaultRenderer.setStartAngle(90);
    defaultRenderer.setDisplayValues(true);
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
    for (Nutriente n : listNutriente){
       categorySeries.add("nutriente", n.getId());
       SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
       renderer.setColor(Color.BLUE);
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

                    Toast.makeText(criarGrafico.this, categorySeries.getCategory(seriesSelection.getPointIndex())+
                            " = "+numberFormat.format(seriesSelection.getValue()), Toast.LENGTH_LONG).show();
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

}
