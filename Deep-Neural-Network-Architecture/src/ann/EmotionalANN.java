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

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import emotionalANN.MatlabANN;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pythagoras Karampiperis, Sotiris Konstantinidis
 */
public class EmotionalANN {
    
    private double[] vector=new double[25];
    private double emotion;

    public EmotionalANN(double[] vector) {
        this.vector=vector;
    }

    public double getEmotion() {
        return emotion;
    }

    public void setEmotion(double emotion) {
        this.emotion = emotion;
    }    
    
    public void callANN(){
        try {       
            MatlabANN cl=new MatlabANN();
            Object[] result;
            result = cl.emotionalANN(1,vector);
            MWNumericArray res=(MWNumericArray)result[0];
            this.emotion=res.getDouble();
            
        } catch (MWException ex) {
            Logger.getLogger(EmotionalANN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws IOException{
        double[] vec=new double[25];
        vec[0]=97;
        vec[1]=98;
        vec[2]=99;
        vec[3]=100;
        vec[4]=97;
        vec[5]=97;
        vec[6]=97;
        vec[7]=97;
        vec[8]=97;
        vec[9]=97;
        vec[10]=97;
        vec[11]=97;
        vec[12]=97;
        vec[13]=97;
        vec[14]=97;
        vec[15]=97;
        vec[16]=97;
        vec[17]=97;
        vec[18]=97;
        vec[19]=97;
        vec[20]=97;
        vec[21]=97;
        vec[22]=97;
        vec[23]=97;
        vec[24]=97;
        
        EmotionalANN emo=new EmotionalANN(vec);
        emo.callANN();
        System.out.println(emo.getEmotion());
    }
}
