package Assignment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream
        							.rangeClosed(1, 100)
        							.boxed()
        							.collect(Collectors.toList());

        long Divisible = numbers.stream()
                                    .filter(n -> n % 2 == 0 && n % 4 == 0)
                                    .count();
        
        System.out.println("Numbers that are both divisible to 2 and 4: " + Divisible);

        long countOddNumbers = numbers.stream()
                                   .filter(n -> n % 2 != 0)
                                   .count();
        
        int sumOddNumbers = numbers.stream()
                                   .filter(n -> n % 2 != 0)
                                   .mapToInt(Integer::intValue)
                                   .sum();
        
        System.out.println("Number of odd numbers: " + countOddNumbers);
        
        System.out.println("Summary of odd numbers: " + sumOddNumbers);

        long countEvenNumbers = numbers.stream()
                                    .filter(n -> n % 2 == 0)
                                    .count();
        
        int sumEvenNumbers = numbers.stream()
                                    .filter(n -> n % 2 == 0)
                                    .mapToInt(Integer::intValue)
                                    .sum(); 
        
        System.out.println("Number of even numbers: " + countEvenNumbers);
        
        System.out.println("Summary of even numbers: " + sumEvenNumbers);
    }
}