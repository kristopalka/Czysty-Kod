package exercises;

import java.util.ArrayList;
import java.util.Scanner;

/** TODO
 * Uporządkuj ten kod używając zasad przedstawionych podczas prezentacji, władnej kreatywności oraz logiki
 * Kod powinien być jak najbardziej czytelny i przejrzysty, przede wszystkim dla osoby widzącej go pierwszy raz
 */


public class SelectionSort {

    public static void posortuj() {
        Scanner scanner = new Scanner(System.in);
        int n;
        ArrayList<Integer> tab=new ArrayList<>(); // input data
        ArrayList<Integer> tab2=new ArrayList<>(); // output data

        // --------------- get data ---------------

        System.out.print("Type table length: ");
        n = scanner.nextInt();

        System.out.println("Type all elements:");


        for (int i=0;i<n;i++){
            tab.add(scanner.nextInt());
            //System.out.println(tab[i]);
        }



        // --------------- sort --------------------

        // adding minimum element to tab2
        for (int i=0;i<n;i++){

            int min = 0; // index of minimum element
            // find minimum remaining element in tab
            for (int q=0;q<tab.size();q++){
                if(tab.get(q) < tab.get(min)){ // if minimum element isn' minimum
                    min = q;                 // change minimum element
                }
            }

            // rewrite founded minimum element to out tab
            tab2.add(tab.get(min));
            // delete founded minimum
            tab.remove(min);
        }
        // --------------- write ---------------

        System.out.println("Sorted data:");


        for (int i=0;i<n;i++){
            System.out.print(tab2.get(i) + " ");
        }


    }
}
