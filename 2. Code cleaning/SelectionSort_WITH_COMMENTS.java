package exercises;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Uporządkuj ten kod używając zasad przedstawionych podczas prezentacji, władnej kreatywności oraz logiki
 * Kod powinien być jak najbardziej czytelny i przejrzysty, przede wszystkim dla osoby widzącej go pierwszy raz
 *
 * Podpowiedzi:
 * 1. Formatowanie - o powinno pomóc
 * 2. Nazwy zmiennych -
 * 3. Komentarze - czy da się zawrzeć je w kodzie?
 * 4. Funkcje - kod jest nieco za długi 🤔
 * 5. Komentarze pomocnicze --->>>                                                                                      // tutaj znajdują się komentarze pomocnicze ;)
 */



public class SelectionSort_WITH_COMMENTS {

    public static void posortuj() {                                                                                     // czemu ta nazwa jest po polsku?
        Scanner scanner = new Scanner(System.in);
        int n;                                                                                                          // czy ta zmienna jest w ogóle potrzebna?
        ArrayList<Integer> tab=new ArrayList<>();  // input data                                                        // te ArrayListy są bardzo brzydko nazwane
        ArrayList<Integer> tab2=new ArrayList<>(); // output data

        // --------------- get data ---------------                                                                     // bardzo brzydkie segregowanie kodu komentarzami (może lepiej funkcjami?)

        System.out.print("Type table length: ");
        n = scanner.nextInt();

        System.out.println("Type all elements:");


        for (int i=0;i<n;i++){
            tab.add(scanner.nextInt());                                                                                 // nieczytelne zagnieżdżenie jednego elementu w drugim. lepiej wyciągnąć to do lokalnej zmiennej
            //System.out.println(tab[i]);                                                                               // czyżby komentarz został z poprzedniej wersji programu? 🤔
        }                                                                                                               // zwróć uwagę że tab w tym programie nie jest tablicą



        // --------------- sort --------------------

        // adding minimum element to tab2
        for (int i=0;i<n;i++){

            int min = 0; // index of minimum element                                                                    // może by tak oddziellna funkcja dop wyszukiwania?
            // find minimum remaining element in tab
            for (int q=0;q<tab.size();q++){
                if(tab.get(q) < tab.get(min)){ // if minimum element isn' minimum
                    min = q;                 // change minimum element
                }
            }

            // rewrite founded minimum element to out tab
            tab2.add(tab.get(min));                                                                                     // nieczytelne zagnieżdżenie jednego elementu w drugim. lepie wyciągnąć to do lokalnej zmiennej
            // delete founded minimum
            tab.remove(min);
        }
        // --------------- write ---------------

        System.out.println("Sorted data:");


        for (int i=0;i<n;i++){                                                                                          // czy to iterowanie jest potrzebne?
            System.out.print(tab2.get(i) + " ");
        }


    }
}
