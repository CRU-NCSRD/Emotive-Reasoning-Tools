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
package ann;

import ann.EmotionalANN;
import java.util.ArrayList;
import preprocessing.text.Stemmer;
import preprocessing.text.VectorizeText;

/**
 *
 * @author Pythagoras Karampiperis, Sotiris Konstantinidis
 */
public class PredictEmotion {
    private String text;
    private double overall_emotion;

    public PredictEmotion(String text) {
        this.text = text;
    }

    public double getOverall_emotion() {
        return overall_emotion;
    }

    public void setOverall_emotion(double overall_emotion) {
        this.overall_emotion = overall_emotion;
    }
    
    public void overallEmotion(){
        Stemmer st=new Stemmer("en");
        st.stem(text);
        ArrayList<String> stems=st.getStems();
        double sum_words_emotions=0;
        for(int i=0;i<stems.size();i++){
            String word=stems.get(i);
            VectorizeText vt=new VectorizeText(word);
            vt.vectorize();
            ArrayList<Double> av=vt.getAsciiVector();
            double[] vector=new double[25];
            
            for(int j=0;j<av.size();j++){                
                vector[j]=av.get(j);                
            }
            
            
            EmotionalANN emo=new EmotionalANN(vector);
            emo.callANN();
            sum_words_emotions+=emo.getEmotion();
        }
        
        this.overall_emotion=Math.sqrt(sum_words_emotions/stems.size());
    }
    
}
