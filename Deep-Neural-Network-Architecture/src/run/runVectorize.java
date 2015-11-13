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
package run;

import base.HashedTextEmotions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import preprocessing.text.HashWords;
import preprocessing.text.VectorizeText;

/**
 *
 * @author Sotiris Konstantinidis
 */
public class runVectorize {
    
    public static void main(String[] args) throws IOException{
        System.out.println("Start");
        double min=97;
        double max=124;
        double range=max-min;
        
        String filepath="C:\\Users\\PK\\Desktop\\CRU\\#1-Projects\\c2learn\\emotionalANN\\swn-stemmed.csv";
        File file = new File("C:\\Users\\PK\\Desktop\\CRU\\#1-Projects\\c2learn\\emotionalANN\\stem_vec_emotional_(non_sorted).txt");

        if (!file.exists()) {
                file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw); 
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
               String[] split_line=line.split(";");
               String word=split_line[1].toLowerCase();
               
               VectorizeText vt=new VectorizeText(word);
               vt.vectorize();
               ArrayList<Double> av=vt.getAsciiVector();
               double emotion=Double.parseDouble(split_line[0]);
               
               for (Double local_av : av) {
                    double normalized_value=local_av;                    
                    bw.write(normalized_value+";");
                }        
               bw.write(emotion+"\n");              
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        bw.close();
    }
}
