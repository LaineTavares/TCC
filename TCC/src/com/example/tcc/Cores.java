package com.example.tcc;

import android.content.Context;
import android.util.Log;

import java.util.Arrays;
import java.util.Random;



public class Cores {

    private String[] cores;

    public Cores (Context context){
        cores = context.getResources().getStringArray(R.array.cores);
    }

    public String getRandomCor(){
        String random;
        random = cores[new Random().nextInt(cores.length)];
        return  random;
    }

    public String getRandomCorSemRepetir(String corAtual){
        String corNova;
        corNova = getRandomCor();
        while(corNova.equals(corAtual)){
            corNova = getRandomCor();
            break;
        }
        return corNova;
    }

    public int findIndexCor(String cor){
        return Arrays.asList(cores).indexOf(cor);
    }

    public String getNextCor(String corAtual){
        String proxima;
        int index = findIndexCor(corAtual) + 1;
        if(index >= cores.length){
            proxima = cores[0];
        }else{
            proxima = cores[index];
        }
        return proxima;
    }

    public String getPrevCor(String corAtual){
        String anterior;
        int index = findIndexCor(corAtual) - 1;
        if(index < 0){
            anterior = cores[cores.length - 1];
        }else{
            anterior = cores[index];
        }
        return anterior;
    }

}
