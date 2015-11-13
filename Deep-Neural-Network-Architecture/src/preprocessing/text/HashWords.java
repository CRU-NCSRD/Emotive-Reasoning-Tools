/*
 * Copyright (C) 2015 Computational Systems & Human Mind Research Unit
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package preprocessing.text;

import java.util.ArrayList;

/**
 *
 * @author Antonis Koukourikos
 */
public class HashWords {
    private ArrayList<String> words;
    private ArrayList<Double> normalizedHashedWords;
    private String word;
    private double normalizedHashedWord;
    
    private double minimum=Integer.MIN_VALUE;
    private double maximum=Integer.MAX_VALUE;   
    private double x;
    private double y;

    public HashWords() {
    }

    public HashWords(ArrayList<String> words,double x,double y) {
        this.words = words;
        this.x=x;
        this.y=y;
    }
    public HashWords(String word,double x,double y) {
        this.word = word;
        this.x=x;
        this.y=y;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<Double> getnormalizedHashedWords() {
        return normalizedHashedWords;
    }

    public void setHashedWords(ArrayList<Double> normalizedHashedWords) {
        this.normalizedHashedWords = normalizedHashedWords;
    }  

    public double getNormalizedHashedWord() {
        return normalizedHashedWord;
    }

    public void setNormalizedHashedWord(double normalizedHashedWord) {
        this.normalizedHashedWord = normalizedHashedWord;
    }
    
    public void defaultHashWords(){
        normalizedHashedWords=new ArrayList();
        double range=maximum-minimum;
        double range_x_y=y-x;
        for (String local_word : words) {
            double hashedWord=local_word.hashCode();            
            double tmp=(double)(hashedWord-minimum)/range;
            double tmp_2=(tmp*range_x_y)+x;
            normalizedHashedWords.add(tmp_2);            
        }
    }
    public void defaultHashWord(){
        double range=maximum-minimum;
        double range_x_y=y-x;
        double hashedWord=(double)word.hashCode();
        double tmp=(hashedWord-minimum)/range;
        normalizedHashedWord=(tmp*range_x_y)+x;        
    }
    
    public double normalizePolarity(double polarity){
        double normalizedPolarity=(polarity*y);          
        return normalizedPolarity;
    }
}
