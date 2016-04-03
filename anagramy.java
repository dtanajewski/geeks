
package anagrams;
import java.util.Arrays;
import java.util.Scanner;

class input { //klasa odpowiadająca za wczytanie danych

    String pierwszeSlowo() { //metoda - wczytanie słowa 1
        System.out.println("Podaj pierwsze slowo: ");
        Scanner odczyt1 = new Scanner(System.in);
        return odczyt1.nextLine();
    }
    String drugieSlowo() { //metoda - wczytanie slowa 2
        System.out.println("Podaj drugie slowo: ");
        Scanner odczyt2 = new Scanner(System.in);
        return odczyt2.nextLine();
    }
            
}

class isAnagrams {
    String word1;
    String word2;            
    
    isAnagrams(String word1, String word2) { //Konstruktor
        this.word1=word1;
        this.word2=word2;
    }
    
    
    boolean isAnagram() { 
        char[] dict1 = word1.toCharArray(); //zamiana slowa 1 na tablice ze znakami
        char[] dict2 = word2.toCharArray(); //zamiana slowa 2 na tablice ze znakami
        //sortowanie znakow w tablicach
        Arrays.sort(dict1); 
        Arrays.sort(dict2);
        //sprawdzenie czy tablice sa takie same i zwrócenie wyniku
        return Arrays.equals(dict1, dict2);        
    }
}

public class Anagrams {
    
    public static void main(String[] args) {
        input dane = new input();       
        isAnagrams kontrola = new isAnagrams(dane.pierwszeSlowo(),dane.drugieSlowo());
        System.out.println(kontrola.isAnagram());
    }
    
}
