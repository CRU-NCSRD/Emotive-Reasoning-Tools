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
 * @author Sotiris Konstantinidis
 */
public class VectorizeText {
    String word;
    ArrayList<Double> asciiVector;

    public VectorizeText(String word) {
        this.word = word;               
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Double> getAsciiVector() {
        return asciiVector;
    }

    public void setAsciiVector(ArrayList<Double> asciiVector) {
        this.asciiVector = asciiVector;
    }
    
    
    public void vectorize(){        
        asciiVector=new ArrayList(25);
        double normalized_value=0;
        for(int i=0;i<25;i++){
            asciiVector.add(normalized_value);
        }
        int end=0;
        
        if(word.length()<25){
            end=word.length();
        }else{
            end=25;
        }
        
        for(int i=0;i<end;i++){           
            Character ch=word.charAt(i);           
            int ascii_code=(int)ch;
            int value=ascii_code;
            if((ascii_code<97)||(ascii_code>122)){
                value=110;
            }else if(ascii_code>=110){
                value=ascii_code+1;
            }
            
            double normalized_value_2=(1.8*((value-97.0)/(123.0-97.0)))-0.9;            
            asciiVector.remove(i);
            asciiVector.add(i,normalized_value_2);
        }
        System.out.println(asciiVector.size());
    }
    
}
