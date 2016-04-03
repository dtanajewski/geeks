package watki;

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
                sleep(1000);
            }               
        } catch (InterruptedException e) {
        System.out.println("Blad: "+'\n' + e);
        }
    }
}
public class Watki {
    
    public static String wynik;

    public static void main(String[] args) {
        Watki.wynik="";
        input dane=new input();
        char[] tabela1 = dane.pierwszeSlowo().toCharArray(); //zamiana slowa 1 na tablice ze znakami
        char[] tabela2 = dane.drugieSlowo().toCharArray(); //zamiana slowa 2 na tablice ze znakami
        Mix w1 = new Mix(tabela1);
        Mix w2 = new Mix(tabela2);        
        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            System.out.println("Blad: "+'\n' + e);
        }
    System.out.println("Wynik: "+wynik);
    }
    
}
