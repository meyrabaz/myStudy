package lambdaInsructions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {
    /*
    1) We learnt "Structured Programming" so far, in "Structured Programming" structure is important we spend time on structure.
    2) Lambda is "Functional Programming", in "Functional Programming" we will focus on just the function(methods)
    3) "t-> code" is called "Lambda Expression"
        In "Functional Programming" we may use "Lambda Expression" but it is not recommended.
        We will prefer to use "Method Reference", We will learn it in the next sessions.
     */

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(9);
        numbers.add(122);
        numbers.add(14);
        numbers.add(9);
        numbers.add(10);
        numbers.add(4);
        numbers.add(12);
        numbers.add(15);

        printElements1(numbers);
        System.out.println();
        printElements2(numbers);
        System.out.println();
        printEvenElements1(numbers);
        System.out.println();
        printEvenElements2(numbers);
        System.out.println();
        printSquareOfOddElements(numbers);
        System.out.println();
        printCubeOfDistinctOddElements(numbers);
        System.out.println();
        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(5);
        numbers2.add(6);
        numbers2.add(7);
        numbers2.add(2);
        numbers2.add(2);
        numbers2.add(4);
        System.out.println(findSumOfSquareOfEvenDistinctElements(numbers2));
        System.out.println();
        System.out.println(findProductOfSquareOfDistinctEvenElements(numbers2));
        System.out.println(findMin(numbers));
        System.out.println();
        System.out.println(findMin2(numbers));
        System.out.println();
        System.out.println(findMin3(numbers));
        System.out.println();
        System.out.println(findMin4(numbers));
        System.out.println();
        System.out.println(findMax(numbers));
        System.out.println();
        System.out.println(findMax2(numbers));
        System.out.println();
        System.out.println(findMinValueGreaterThan7AndEven(numbers));
        System.out.println();
        System.out.println(findAnyValueLessThan15AndEven(numbers));


    }

    //1)Create a method to print all list elements on the console in the same line with a space among them
    //1. Way: Use "Structured Programming"
    public static void printElements1(List<Integer> myList) {

        for (Integer w : myList) {
            System.out.print(w + " ");
        }
    }

    //2. Way: Use "Functional Programming"
    public static void printElements2(List<Integer> myList) {


        myList.stream().forEach(t -> System.out.print(t + " "));//12 9 122 14 9 10 4 12 15

    }

    //2)Create a method to print the "even" list elements on the console
    // in the same line with a space between two consecutive elements.(Structured)

    //1. Way: Use "Structured Programming"
    public static void printEvenElements1(List<Integer> mylist) {

        for (Integer w : mylist) {

            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //2. Way: Use "Functional Programming"
    public static void printEvenElements2(List<Integer> mylist) {//12 9 122 14 9 10 4 12 15

        mylist.
                stream().
                filter(t -> t % 2 == 0).
                forEach(t -> System.out.print(t + " "));

    }

    //3)Create a method to print the square of odd list elements on the console
    // in the same line with a space between two consecutive elements.

    public static void printSquareOfOddElements(List<Integer> myList) {

        myList.
                stream().
                filter(t -> t % 2 != 0).
                map(t -> t * t).
                forEach(t -> System.out.print(t + " "));

    }

    //4)Create a method to print the "cube" of "distinct" "odd" list elements
    //  on the console in the same line with a space between two consecutive elements.

    public static void printCubeOfDistinctOddElements(List<Integer> myList) {

        myList.
                stream().
                filter(t -> t % 2 != 0).
                distinct().
                map(t -> t * t * t).
                forEach(t -> System.out.print(t + " "));
    }

    //5)Create a method to calculate the "sum" of the "squares" of "distinct" "even" elements

    public static int findSumOfSquareOfEvenDistinctElements(List<Integer> myList) {//1 5 6 7 2 2 4

        return myList.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);

    }

    //6)Create a method to calculate the "product" of the "square" of "distinct" "even" elements
    public static int findProductOfSquareOfDistinctEvenElements(List<Integer> myList) {

        return myList.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce((t, u) -> t * u).get();

    }

    //7)Create a method to find the "minimum value" from the list elements
    //1. Way:
    public static int findMin(List<Integer> myList) {//12 9 122 14 9 10 4 12 15

        return myList.stream().distinct().reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);

    }

    //2. Way:
    public static int findMin2(List<Integer> myList) {//12 9 122 14 9 10 4 12 15

        return myList.stream().distinct().reduce(myList.get(0), (t, u) -> t < u ? t : u);

    }

    //3. Way:
    public static int findMin3(List<Integer> myList) {//12 9 122 14 9 10 4 12 15

        return myList.stream().distinct().sorted().reduce((t, u) -> t).get();//reduce() method with a single parameter does not return Integer
        //To make return type integer use get() method
    }


    //4. Way:
    public static int findMin4(List<Integer> myList) {//12 9 122 14 9 10 4 12 15

        return myList.stream().distinct().sorted().findFirst().get();

    }

    //8)Create a method to find the "maximum value" from the list elements
    //1. Way:
    public static int findMax(List<Integer> myList) {//12 9 122 14 9 10 4 12 15

        return myList.stream().distinct().sorted(Comparator.reverseOrder()).findFirst().get();

    }

    //2. Way:
    public static int findMax2(List<Integer> myList) {//12 9 122 14 9 10 4 12 15

        return myList.stream().distinct().sorted().reduce((t, u) -> u).get();

    }

    //9)Create a method to find the minimum value which is greater than 7 and even from the list

    public static int findMinValueGreaterThan7AndEven(List<Integer> myList) {

        return myList.stream().distinct().filter(t -> t > 7 && t % 2 == 0).sorted().findFirst().get();

    }

    //10)Create a method to find any value which is less than 15 and even from the list
    public static int findAnyValueLessThan15AndEven(List<Integer> myList) {//12 9 122 14 9 10 4 12 15

        return myList.stream().distinct().filter(t -> t < 15 && t % 2 == 0).findAny().get();

    }

}
