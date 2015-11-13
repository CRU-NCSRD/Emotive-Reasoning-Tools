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
package base;

/**
 *
 * @author Antonis Koukourikos, Sotiris Konstantinidis
 */
public class HashedTextEmotions {
    private double hashedWord;
    private double emotion;
    private double positive;
    private double negative;

    public HashedTextEmotions(double hashedWord, double emotion,double positive, double negative) {
        this.hashedWord = hashedWord;
        this.emotion = emotion;
        this.positive=positive;
        this.negative=negative;
    }

    public double getHashedWord() {
        return hashedWord;
    }

    public void setHashedWord(double hashedWord) {
        this.hashedWord = hashedWord;
    }

    public double getEmotion() {
        return emotion;
    }

    public void setEmotion(double emotion) {
        this.emotion = emotion;
    }

    public double getPositive() {
        return positive;
    }

    public void setPositive(double positive) {
        this.positive = positive;
    }

    public double getNegative() {
        return negative;
    }

    public void setNegative(double negative) {
        this.negative = negative;
    }
        
    
}
