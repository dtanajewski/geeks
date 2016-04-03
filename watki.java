package watki;

import java.util.Scanner;

/**
 *
 * @author Darek
 */
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

class Mix extends Thread {
    char[] tablica;   //zmienna do ktorej zapisany zostanie drugi wyraz
            
    Mix (char[] tablica) {
        super("Mix");
        this.tablica=tablica;
        start();
    }
    
    public void run() {
        try {
            for(int i = 0; i<tablica.length; i++) {
                Watki.wynik = Watki.wynik+tablica[i];
                sleep(1);
            }               
        } catch (InterruptedException e) {
        System.out.println("Blad: \n" + e);
        }
    }
}
public class Watki {
    
    public static String wynik;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Watki.wynik="";
        input dane=new input();
        char[] tabela1 = dane.pierwszeSlowo().toCharArray(); //zamiana slowa 1 na tablice ze znakami
        char[] tabela2 = dane.drugieSlowo().toCharArray(); //zamiana slowa 2 na tablice ze znakami
        new Mix(tabela2); //uruchomienie watku 
        
        try {
            for(int j = 0; j<tabela1.length; j++) {
                Watki.wynik = Watki.wynik+tabela1[j];
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("Blad: \n" + e);
        }
        System.out.println("Wynik: "+wynik);
    }
    
}
