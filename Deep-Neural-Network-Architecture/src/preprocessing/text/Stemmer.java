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
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.tartarus.snowball.SnowballStemmer;

/**
 *
 * @author Antonis Koukourikos
 */
public class Stemmer {
    private SnowballStemmer stemmer;
    private String stemString;
    private ArrayList<String> stems;
    
    public Stemmer(String lang) {
        Class stemClass;
        try {
            stemClass = Class.forName("org.tartarus.snowball.ext." +
                    lang + "Stemmer");
            stemmer = (SnowballStemmer) stemClass.newInstance();
            stems = new ArrayList<>();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Stemmer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    public void stem(String text){
        String input = Cleaner.clean(text.toLowerCase());
        
        stemmer.setCurrent(input);
        stemmer.stem();
        stemString = stemmer.getCurrent();
        StringTokenizer tokenizer = new StringTokenizer(stemString);
        while (tokenizer.hasMoreTokens()){
            String currentToken = tokenizer.nextToken();
            if (!stems.contains(currentToken))
                stems.add(currentToken);
        }
        Collections.sort(stems);       
    }
    
    public void printStems(){
        for (String stem : stems) {
            System.out.println(stem);
        }
    }

    public String getStemString() {
        return stemString;
    }

    public void setStemString(String stemString) {
        this.stemString = stemString;
    }

    public ArrayList<String> getStems() {
        return stems;
    }

    public void setStems(ArrayList<String> stems) {
        this.stems = stems;
    }
}
    

