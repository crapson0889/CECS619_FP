/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patternmatchingstrings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author crapson
 */
public class NaiveStringMatcher {
    
    public ExecutionStatistics findPattern(char[] pattern) throws FileNotFoundException, IOException {
        ExecutionStatistics runStatistics = new ExecutionStatistics(new Date());
        
        ArrayList<Integer> foundPatterns = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\crapson\\Documents\\GitHub\\CECS619_FP\\PatternMatchingStrings\\src\\patternmatchingstrings\\p3.txt"))) {
            int character = br.read();
            int index = 1;

            while (br.ready()) {
                if(character == pattern[0]){
                    br.mark(pattern.length); //Mark the current br position
                    int patternCheckResult = patternCheck(pattern, br, index);
                    br.reset(); //Reset to marked position
                    if(patternCheckResult != 0)
                    {
                        if(patternCheckResult != 0)
                        {
                            System.out.println(patternCheckResult);
                            foundPatterns.add(patternCheckResult);
                        }
                    }
                }
                character = br.read();
                index++;
            }
        }
        
        /*System.out.println("\n\n");
        for(int i = 0; i < foundPatterns.size(); i++)
        {
            System.out.println(foundPatterns.get(i));
        }*/
        
        runStatistics.setEndTime(new Date());
        
        return runStatistics;
    }
    
    private int patternCheck(char[] pattern, BufferedReader brCopy, int index) throws IOException
    {
        for(int i = 1; i < pattern.length; i++)
        {
            if(pattern[i] != brCopy.read())
            {
                return 0;
            }
        }
        return index;
    }
}
