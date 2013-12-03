/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patternmatchingstrings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author crapson
 */
public class PatternMatchingStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[] patterns = new String[]{"cad", "cccd", "bababbb"};
        
        NaiveStringMatcher naiveStringMatcher = new NaiveStringMatcher();
        ArrayList<ExecutionStatistics> NaiveExecutionStatistics = new ArrayList<>();
        
        System.out.println("PATTERN LOCATIONS:");
        for(int i = 0; i < patterns.length; i++) {
            System.out.println(patterns[i].toString()+":");
            NaiveExecutionStatistics.add(naiveStringMatcher.findPattern(patterns[i].toCharArray()));
        }
        System.out.println("\nSTATISTICS:");
        for(int i = 0; i < patterns.length; i++) {
            System.out.println(patterns[i].toString()+":");
            System.out.println(NaiveExecutionStatistics.get(i).getRunTime());
        }
    }
}
