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

import base.Comparators;
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
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import preprocessing.text.HashWords;

/**
 *
 * @author Sotiris Konstantinidis
 */
public class Run {
    
   
    public static void main(String[] args) throws IOException{
        System.out.println("Start");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int window_size=10;
        String filepath="C:\\Users\\PK\\Desktop\\CRU\\#1-Projects\\c2learn\\emotionalANN\\swn-stemmed_sorted.csv";
        ArrayList<HashedTextEmotions> htp_list=new ArrayList();
        ArrayList<HashedTextEmotions> avg_htp_list=new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
               String[] split_line=line.split(";");
               String word=split_line[1];
               HashWords hw=new HashWords(word,-1,1);
               hw.defaultHashWord();
               
               double emotional_value=Double.parseDouble(split_line[0]);
               double hashedWord=hw.getNormalizedHashedWord();
               HashedTextEmotions htp=new HashedTextEmotions(hashedWord,emotional_value,0,0);
               htp_list.add(htp);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Collections.sort(htp_list, new Comparators());
        
        int num_of_windows=(int)htp_list.size()/window_size;
        
        for(int i=0;i<=num_of_windows-1;i++){
            double avg_v=0;
            double avg_hash=0;
            //------------------
            for(int j=0;j<=window_size-1;j++){
                System.out.println(htp_list.get((i*window_size)+j).getHashedWord());
                avg_v=avg_v+htp_list.get((i*window_size)+j).getEmotion();
                avg_hash=avg_hash+htp_list.get((i*window_size)+j).getHashedWord();                
            }
            //------------------
            avg_v=avg_v/window_size;
            avg_hash=avg_hash/window_size;
            //------------------
            HashedTextEmotions avg_htp=new HashedTextEmotions(avg_hash,avg_v,0,0);
            avg_htp_list.add(avg_htp);
        }
        
        File file = new File("C:\\Users\\PK\\Desktop\\CRU\\#1-Projects\\c2learn\\emotionalANN\\hashed_word_list.txt");
        
        // if file doesnt exists, then create it
        if (!file.exists()) {
                file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);        
        for (HashedTextEmotions local_htp : avg_htp_list) {
            double hashedWord=local_htp.getHashedWord();
            double emotion=local_htp.getEmotion();              
            bw.write(new BigDecimal(hashedWord).toPlainString()+";"+local_htp.getEmotion()+"\n");
        }        
        bw.close();

        System.out.println("Done");
    }    
}
