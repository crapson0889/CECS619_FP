/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patternmatchingstrings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author p0ros_000
 */

class rabinKarp{
  
 public static void main(String[] args) throws FileNotFoundException, IOException{
  BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\p0ros_000\\Documents\\GitHub\\CECS619_FP\\PatternMatchingStrings\\src\\patternmatchingstrings\\p3.txt"));
  String txt=br.readLine(); //test data
  String ptn="bababbb";
  
  int count = 0;
  int n=txt.length();//get the lenght of the given text
  int m=ptn.length();//get the lenght of the pattern given
  
  int hashOfPatt= ptn.hashCode(); //get the hash value of the pattern

  /*a loop runs shorter than the text lenght to find out the hashes tally each other*/
  for(int i=0;i<n;i++){
   if(i+m+1<=n){
    String sub=txt.substring(i,i+m);//split the text consecutively by lenght of the pattern

    int hashOfSub=sub.hashCode(); //check hash of the text and hash of the pattern match each other


    if(hashOfPatt==hashOfSub){ //if the pattern and text tallies, then start character by character checking

     int k=0;
     boolean d=true;

   /*loop runs through both the selected parts to check whether both the parts match each other*/

     for(int j=i;j<i+m;j++){ 
      if(txt.charAt(j)==ptn.charAt(k)){ 
       k++;      
      }
      else{
       d=false;
       break; //end ot loop when a un matchable part found
      }      
     }
     if(d){
      //System.out.println(sub); //print the pattern each and every time a match found
      count++;
     }
    }
   }   
  } 
  System.out.println(count);
 } 
}