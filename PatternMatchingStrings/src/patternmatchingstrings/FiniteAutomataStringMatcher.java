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
public class FiniteAutomataStringMatcher {
    
    public ExecutionStatistics findPattern(char[] pattern) throws FileNotFoundException, IOException {
        int[][] stateMachine = generateStateMachine(pattern);
        
        ExecutionStatistics runStatistics = new ExecutionStatistics(new Date());
        
        ArrayList<Integer> foundPatterns = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\crapson\\Documents\\GitHub\\CECS619_FP\\PatternMatchingStrings\\src\\patternmatchingstrings\\p3.txt"))) {
            int character = br.read();
            int stateMachineIndex = 0;
            int index = 1;

            while (br.ready()) {
                stateMachineIndex = stateMachine[character % 97][stateMachineIndex];
                
                if(stateMachineIndex == stateMachine[0].length)
                {
                    System.out.println(index - (stateMachine[0].length - 1));
                    foundPatterns.add(index - (stateMachine[0].length - 1));
                    stateMachineIndex = stateMachine[4][0];
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
    
    private int[][] generateStateMachine(char[] pattern)
    {
        //Additional Feature: dynamically generate these state machines
        switch (new String(pattern)) {
            case "cad":
                return new int[][]{
                    {0, 2, 0}, //a
                    {0, 0, 0}, //b
                    {1, 1, 1}, //c
                    {0, 0, 3}, //d
                    {0} //Return Index
                };
            case "cccd":
                return new int[][]{
                    {0, 0, 0, 0}, //a
                    {0, 0, 0, 0}, //b
                    {1, 2, 3, 3}, //c
                    {0, 0, 0, 4}, //d
                    {0} //Return Index
                };
            case "bababbb":
                return new int[][]{
                    {0, 2, 0, 4, 0, 4, 2}, //a
                    {1, 1, 3, 1, 5, 6, 7}, //b
                    {0, 0, 0, 0, 0, 0, 0}, //c
                    {0, 0, 0, 0, 0, 0, 0}, //d
                    {1} //Return Index
                };
            default:
                return new int[][]{
                    {},
                    {},
                    {},
                    {}
                };
        }
    }
}
