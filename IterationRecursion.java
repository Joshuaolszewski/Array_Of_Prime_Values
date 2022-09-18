
//Joshua Olszewski
//January 24, 2021

import java.util.Scanner;
public class IterationRecursion 
{
    public IterationRecursion()
    {
    }
    /* 
    Iterates through an array and determines whether each number is prime. 
     
    Precondition: array - a none empty array of integers. 
                  arraySize - the actual size of the array.   
    Postcondition: 
    return: boolean, true or false 
    PseudoCode: 1) for(i = 0; i < size of array; i++)
                    1) if(current array element > 1)
                        1)if(current array element cant be divided by 2 wholly or = 2
                            1)loop through each odd integer up to the sqrt of the current array element
                                1)if(the current array element divided by any of those odd numbers is whole
                                    1)not prime
                        2) else not prime
                    2)else not prime 
                2) if it goes through the whole loop without finding a case where its not prime then = prime 
    */
    public boolean isArrayPrimeIter(int[] array, int arraySize)
    {
        System.out.println("Entering isArrayPrimeIter");
        for(int i = 0; i < arraySize; i++)
        {
            if(array[i] > 1)
            {
                if((array[i] % (double)2) != 0 || array[i] == 2)
                {
                    for(int j = 3; j <= Math.sqrt(array[i]); j+=2)
                    {
                        if(Math.sqrt(array[i]) % (double)j == 0)
                        {    
                            System.out.println("Leaving isArrayPrimeIter");
                            return false; 
                        }
                    }   
                }
                else
                {
                    System.out.println("Leaving isArrayPrimeIter");
                    return false;
                }
            }
            else
            {
                System.out.println("Leaving isArrayPrimeIter");
                return false;  
            }
        }
        System.out.println("Leaving isArrayPrimeIter");
        return true; 
    }
    /* 
    Using recursion, check to see if a single number satifies one condition of being prime which is that it doesnt divide 
    wholly with any odd number leading up to the sqrt of that number. 
     
    Precondition: number - integer number > 1
                  oddNumber - integer that has to have the input 3  
    Postcondition: 
    return: boolean, true or false 
    PseudoCode: 1) if(sqrt of number divides evenly with oddNumber
                    1) not prime 
                2)if(oddNumber > number)
                    1) means that it recursed through each odd number and could not find one that divides wholly
                        == prime
                3)else return isPrime(number, oddNumber +2)               
    */
    public boolean isPrime(int number, int oddNumber) 
    {
        if(Math.sqrt(number) % (double)oddNumber == 0)
        {
            return false; 
        }
        else if(oddNumber > number)
        {
            return true; 
        }
        else
        {
            return(isPrime(number, oddNumber + 2));
        }       
    }
    /* 
    Using recursion, check to see if each element in an array is prime. 
     
    Precondition: array - a none empty array of integers 
                  arraySize - actual size of array.   
    Postcondition: 
    return: boolean, true or false 
    PseudoCode: 1) if(arraySize = 0)
                    1) return true    end condition this means that it recursed through each element of array and could not find one that wasnt prime
                2)else
                    1)if array[arraysize - 1] > 1 
                        1)if[arraysize - 1] does not divide wholly with 2 or that current element = 2
                            1) use method isPrime(arraySize - 1, 3)   checks final condition of being prime 
                                1) return (isarrayprimerecur(array, arraysize - 1)    means that current element is prime and move on to the next element using recursion
                        2)return false as not prime number because it divides with 2
                    2) else not prime prime numbers are greater than one
    */      
    public boolean isArrayPrimeRecur(int[] array, int arraySize)
    {
        System.out.println("Entering isArrayPrimeRecur");
        
        if(arraySize == 0)
        {
            System.out.println("Leaving isArrayPrimRecur");
            return true; 
        }
        else
        {
            if(array[arraySize - 1] > 1)
            {
                if((array[arraySize - 1] % (double)2) != 0 || array[arraySize - 1] == 2)
                {
                    if(isPrime(array[arraySize - 1], 3))
                    {
                        return(isArrayPrimeRecur(array, arraySize - 1));
                    }
                }
                System.out.println("Leaving isArrayPrimRecur");
                return false; 
            }
            System.out.println("Leaving isArrayPrimRecur");
            return false; 
        }
    }
    /* 
    Main method that takes input between 1 and 99 inclusive to create an array of an inputed size and checks whether 
    all elements are prime using recursion and iteration 
     
    Precondition:   
    Postcondition: 
    return: 
    PseudoCode: 1) create iteration recursion object
                2) scanner object
                3) create array with inputed array size 
                4)loop through array 
                    1) fill out array with inputed integers between 1 and 99 inclusive 
                5) isArrayPrimeIter
                6 isArrayPrimeRecur
    */      
    public static void main(String[] args)
    {
        int SORT_MAX_SIZE = 16; 
        IterationRecursion test = new IterationRecursion(); 
        Scanner scanner = new Scanner(System.in);
        
        int arraySize = 17; 
        while(arraySize > SORT_MAX_SIZE || arraySize < 1)
        {
            System.out.println("Number of elements in Array? Has to be less than or equal to 16");
            String input = scanner.nextLine();
            arraySize = Integer.parseInt(input);
        }

        int[] array = new int[arraySize];
        
        for(int i = 0; i < arraySize; i++)
        {
            int number = 100;
            while(number > 99 || number < 1)
            {
                System.out.println("Enter integer between 1 and 99 inclusive into array place " + (i + 1));
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
            }
            array[i] = number; 
        }
        
        if(test.isArrayPrimeIter(array, arraySize))
        {
            System.out.println("");
            System.out.println("Prime array using iteration");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("Not a prime array using iteration");
            System.out.println("");
        }
        
        if(test.isArrayPrimeRecur(array, arraySize))
        {
            System.out.println("");
            System.out.println("Prime array using recursion");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("Not a prime array using recursion");
            System.out.println("");
        }
    }
}