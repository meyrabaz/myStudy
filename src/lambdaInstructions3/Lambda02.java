package lambdaInstructions3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {

    public static void main(String[] args) throws IOException {


        List < String > myList = new ArrayList<>();
        myList.add("Bahar");
        myList.add("Kaan");
        myList.add("Elif");
        myList.add("Julia");

        System.out.println(myList);
        System.out.println(checkLastCharToBeLowerCaseR(myList));



        // Create the code that get the writing in LambdaTextFile.

        Files.lines(Paths.get("src/lambdaInstructions3/LambdaTextFile.txt")).forEach(System.out::println);


        // Create the code that get the writing in LambdaTextFile with uppercase.

        Files.
                lines(Paths.get("src/lambdaInstructions3/LambdaTextFile.txt")).
                     map(String::toUpperCase).
                            forEach(System.out::println);



        // Create the method if the text include that word the user gives us.

        boolean result1 =Files.
                lines(Paths.get("src/lambdaInstructions3/LambdaTextFile.txt")).
                map(t-> t.split(" ")).
                flatMap(Arrays::stream).
                anyMatch(t->t.contains("Easier"));    // How can we do ignore case easier true but Easier ???
        System.out.println(result1);

        // allMatch method gives us a char in a word. "Java" is including "a".
        // allMatch(t->t.contains("a"))        --> anyMatch is useful for focusing word in text.
        // allMatch(t->t.lenght()>2) every word lenght is bigger than 2 that is true.





    }


    //8)Create a method to check if at least one of the elements ending with "r"
    public static boolean checkLastCharToBeLowerCaseR(List<String> myList){
        return myList.stream().anyMatch(t->t.endsWith("r"));
    }
}


