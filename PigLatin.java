package piglatin;
//Import scanner and io to scan in file name as source
import java.util.Scanner;
import java.io.*;
/**Program: PigLatin
 * File: PigLatin.java
 * Summary: Takes specified text file and 
 * converts the english text into pig latin.
 * Author: Eric George
 * Date: November 25, 2018
 */
public class PigLatin {
    //Establish string to throw FileNotFoundException
    public static void main(String[] args) throws FileNotFoundException {
        //Create scanner input that uses file name as source
        Scanner input = new Scanner(new File("G:\\Programming stuff\\PigLatin\\src\\piglatin\\textfile.txt"));
        //Create conditions for reading lines from text file
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner words = new Scanner(line);
            String pigLatin = "";
            while (words.hasNext()) {
                String word = words.next();
                pigLatin = pigLatinWord(word) + " ";
                //Create output that gives orignal word with a space and pig latin word in all caps in next column
                System.out.print(word + "\t" + pigLatin.toUpperCase() + "\n");
            }
        }
    }

    //Create a public class for converting input words into pig latin using another public class for vowels
    public static String pigLatinWord(String s) {
        String pigWord;
        if (isVowel(s.charAt(0))) {
           //If word starts with a vowel, add way to the end
            pigWord = s + "way";
            //If word starts with th or Th return word in new order and add ay to end
        } else if (s.startsWith("th") || s.startsWith("Th")|| s.startsWith("St")|| s.startsWith("st")) {     
            pigWord = s.substring(2) + s.substring(0,2) + "ay";
        } else {
            pigWord = s.substring(1,s.length()) + s.charAt(0) + "ay";
        }
        //Return word to pigLatinWord value
        return pigWord;
    }

    //Create action for reading vowel characters
    public static boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        //When index of c in vowels is not -1, c = vowel
        return (vowels.indexOf(c) >= 0);   
    }
}
