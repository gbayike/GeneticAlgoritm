/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.geneticalgorithm;

import java.util.List;

/**
 *
 * @author Olugbayike
 */
public abstract class Chromosome<T extends Chromosome<T>> implements Comparable<T>{
    public abstract double fitness();
    
    public abstract List<T> crossover(T other);
    
    public abstract void mutate();
    
    public abstract T copy();

    @Override
    public int compareTo(T other){
        Double mine = this.fitness();
        Double theirs = other.fitness();
        return mine.compareTo(theirs);
    } 
}
