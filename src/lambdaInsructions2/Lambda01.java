package lambdaInsructions2;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

        List<Double> myList = new ArrayList<>();

        myList.add(12.0);
        myList.add(4.0);
        myList.add(7.0);
        myList.add(3.6);
        myList.add(26.8);
        myList.add(38.4);
       List<Double> half = getHalfofElementsGreaterThanFiveDistinctReversed(myList);
        System.out.println(half);


        List<String> list = new ArrayList<>();

        list.add("Tom");
        list.add("Ajda");
        list.add("Angelina");
        list.add("Tom");
        list.add("Brad");
        list.add("Cuneyt");
        printAllAlphabeticallyUpperDistinct(list);
        System.out.println();
        printAllLowerDistinctNonAlphabetically(list);
        System.out.println();
        printAllUpperSortwithLenghtDistinct(list);
        System.out.println();
        printAllUpperSortwithLenghtDistinctSameLenghtAlpabeticallyOrder(list);
        System.out.println();
        //System.out.println(removeElementIftheLenghtGreaterThanFive(list));
        System.out.println(removeElementStartsAEndD(list));


    }

    // 1. Creating method to find half of the elements greater than 5, distinct , in reverse order in a list.

    public static List<Double> getHalfofElementsGreaterThanFiveDistinctReversed (List<Double> myList ) {

       return myList.stream().distinct().filter(t -> t > 5).map(t -> t / 2).sorted(Comparator.reverseOrder()).collect(Collectors.toList());


    }

   // 2.Print the elements from list with uppercase , alphabetically order, distinct

    public static void printAllAlphabeticallyUpperDistinct(List<String> list){

       list.stream().distinct().map(t-> t.toUpperCase()) .sorted().forEach(t-> System.out.print(t+"  "));

          }


          //3. Print the list elements with lower case, reverse of alphabetic order and distinct


    public static void printAllLowerDistinctNonAlphabetically (List < String> list){

        list.stream().distinct().map(t-> t.toLowerCase()).sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+ "  "));

    }

    //4.Print the list elements with upper case, sort with the lenght and distinct


    public static void printAllUpperSortwithLenghtDistinct (List<String> list){


        list.stream().distinct().map(String::toUpperCase).sorted(Comparator.comparing(t->t.length())).forEach(t-> System.out.print(t+ "  "));


    }

// Print the elements from the list with upper case , in order by lenght and distinct
    // The elements have same lenght will be alphabetically order.
public static void printAllUpperSortwithLenghtDistinctSameLenghtAlpabeticallyOrder (List<String> list){

        list.stream().
                distinct().
                map(String::toUpperCase).
                sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).
                forEach(System.out::println);




}

// 7. Delete the elements have numbers of characters bigger than 5. Print as list.

    //public static List<String> removeElementIftheLenghtGreaterThanFive (List<String> list) {


       // list.removeIf(t-> t.length()>5);

        //return list;

    //}


// 8. Remove elements start with A or end with D. Then print as list.


    public static List<String> removeElementStartsAEndD (List<String> list) {


        list.removeIf(t-> t.startsWith("A")|| t.endsWith("D"));

        return list;

// return list.stream().distinct(). collect(Collectors.toList));
// if we write like this we can do stream and we can also use distinct method.
// But first step we want to answer as a list so we have to turn list by collect method.

// yazarsak stream yaparız ve distinct kullanabiliriz
        // Ama sonucu list olarak getirmesini istediğimiz için streami tekrar collect yoluyla liste çevirmemiz gerekir.

        // Benim projemde elementin uzunluğunun karesini sık sık alıyorsam utils classı oluşturup oraya metodu koyarım.
        // lambda exp yerine method reference göstererek utils classından metodu kullanırım.





    }




}


