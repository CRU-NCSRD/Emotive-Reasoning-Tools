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

import java.util.Comparator;

/**
 *
 * @author Sotiris Konstantinidis
 */
public class Comparators implements Comparator<HashedTextEmotions> {

    public  int compare(HashedTextEmotions htp1, HashedTextEmotions htp2) {        
             return Double.compare(htp1.getHashedWord(), htp2.getHashedWord());
    }
     
}
