/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.geneticalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Olugbayike
 */
public class GeneticAlgorithm <C extends Chromosome<C>>{
    private ArrayList<C> population;
    private double mutationChance;
    private double crossoverChance;
    private SelectionType selectionType;
    private Random random;
    
    
    public enum SelectionType{
        ROULETTE, TOURNAMENT;
    }

    public GeneticAlgorithm(List<C> initialPopulation, double mutationChance, double crossoverChance, SelectionType selectionType) {
        this.population = new ArrayList<>(initialPopulation);
        this.mutationChance = mutationChance;
        this.crossoverChance = crossoverChance;
        this.selectionType = selectionType;
        this.random = new Random();
    }
    
    // use the probability distribution wheel to pick numPicks individuals
    private List<C> pickRoulette(double[] wheel, int numPicks){
        List<C> picks = new ArrayList<>();
        for (int i = 0; i < numPicks; i++) {
            double pick = random.nextDouble();
            for (int j = 0; j < wheel.length; j++) {
                pick -= wheel[j];
                if(pick<=0){ // went "over", leads to a pick
                    picks.add(population.get(j));
                }
            }
        }
        return picks;
    }

}
