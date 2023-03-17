package lambdaInstructions3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lambda01 {

    public static void main(String[] args) {


        List<Integer> myList = new ArrayList<>();

        myList.add(12);
        myList.add(8);
        myList.add(23);
        myList.add(10);
        myList.add(7);

        System.out.println (getSumofAllElements (myList));
        System.out.println();
        System.out.println(getSumofSeventoSeventy());
        System.out.println();
        System.out.println(getMultiplicationFromThreetoNine());
        System.out.println();
        System.out.println(getFactorial(5));

    }

    //1. Create a method to get sum of all elements.
    // ( ıf we create method we have to create method out of main method and use variable how it ends with (int, String, list)

    public static int getSumofAllElements(List<Integer> myList){

       return myList.stream().reduce(Math::addExact).get();



    }

// 2. Create a method to get sum of the numbers from 7 to 70. (inc. 7 and 70)

    public static int getSumofSeventoSeventy(){

       return IntStream.rangeClosed(7,70).reduce(Math::addExact).getAsInt();


       // intstream give us answer stream in int variable. In this case there is no list. So we use intstream
        //range give us a range first number is inclusive but last number is not in it.
        // rangeClosed give us a range again but the first and last number are included.
        // Java suggest getAsInt. (get the result as int )


    }

    // Create a method the multiplication from 3 to 9.

    public static int getMultiplicationFromThreetoNine (){

        return IntStream.rangeClosed(3,9).reduce(Math::multiplyExact).getAsInt();

        // if we write only "range()" instead of "rangeClosed()" ,
        // range(3,10) has to be in this number for same result with rangeClosed(3,9)

        // rangeClosed() ==> [ ]
        // range() ==> [ )

    }

   // Create method the get fsctorial from given number.

    public static int getFactorial (int x)  {   //int x for the number user gives us.

       return IntStream.rangeClosed(1,x).reduce(Math::multiplyExact).getAsInt();   //5! ==> x=5 Result will be 120

        // If the user give negative numöber for x as (1,-5) , return error.
        //

    }







}
