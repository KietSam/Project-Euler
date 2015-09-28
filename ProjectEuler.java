import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Double;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.lang.Integer;
public class ProjectEuler {
   public static void main (String[]args) throws FileNotFoundException{
      System.out.println(problem18());
   }
   //CURRENTLY WORKING ON
   
   public static int problem18 () throws FileNotFoundException{
      Scanner console = new Scanner(new File("problem18.txt"));
      ArrayList<Integer> temp = new ArrayList<>(); 
      System.out.println(console.nextInt());
      return 0;
   }
   
   public static BigDecimal problem439 (double s){
      BigDecimal sum = new BigDecimal(0);
      for (long x = (long)s; x >= 1; x--){
         for (long y = (long)s; y >= 1; y--){
            sum = sum.add(new BigDecimal(sumOfDivisors(x * y)));
            System.out.println(sum + " " + x + " " + y);
         }
      }
      System.out.println(sum);
      return sum.remainder(new BigDecimal(Math.pow(10,9)));
   }
      
   //SUPPLEMENTAL TOOLS
   
   public static double sumOfDivisors (long a){
      double sum = 0;
      int incrementer = 1;
        if (a % 2 != 0)
        {
            incrementer = 2; //only test the odd ones
        }
        for (int i = 1; i <= a / 2; i=i+incrementer)
        {
            if (a % i == 0)
            {
                sum += i;
            }
        }
        return sum;
   }
   
   /*public static double sumOfDivisors (long a){
      double sum = 0;
      for (long x = a-1; x >= 1; x--){
         if (a%x == 0){
            sum +=x;
         }
      }
      return sum;
   }*/
   
   public static boolean isPrime(int a){
      int count = 0;
      for (int x = 2; x <= a; x++){
         if (a%x == 0){
            count++;
            if (count == 2){
               return false;
            }
         }
      }
      return true;
   }
   
   //SOLVED
   
   public static int problem21 (){
      int sum = 0;
      for (int x = 2; x <= 10000; x++){
         int sum1 = 0;
         int sum2 = 0; //divisor sums
         for (int a = 1; a < x; a++){
            if (x%a == 0){
               sum1 +=a;
            }
         }
         for (int a = 1; a < sum1; a++){
            if (sum1%a == 0){
               sum2 +=a;
            }
         }
         if (sum2 == x && x != sum1){
            sum+=x;
         }
      }
      return sum;
   }

   
   public static int problem20 (){
      BigDecimal a = new BigDecimal(1);
      for (int x = 1; x <= 100; x++){
         a = a.multiply(new BigDecimal(x));
         System.out.println(a);
      }
      System.out.println(a);
      String b = ""+a;
      System.out.println(b);
      int sum = 0;
      for (int x = 0; x < b.length(); x++){
         sum+= Integer.parseInt(b.charAt(x)+ "");
      }
      System.out.println(b);
      return sum;
   }
   
   public static int problem17 (){
      int [] ones = {3,3,5,4,4,3,5,5,4};
      int [] eleven = {6,6,8,8,7,7,9,8,8};
      int [] tens = {3,6,6,5,5,5,7,6,6};
      int total = 11;
      for (int x = 1; x <=999; x++){
         if (x%100 >= 11 && x%100 <= 19){
            total += eleven[x%100-11];
         }
         else if (x%10 != 0){
            total += ones[x%10-1];
         }
         if (x%100 > 9 && !(x%100 >= 11 && x%100 <= 19)){
            if (x%100/10-1 != -1)
            total += tens[x%100/10-1];
         }
         if (x>=100){
            if (x%100 == 0)
               total+= ones[x/100-1] + 7;
            else
               total += ones[x/100-1] + 10;
         }
      }
      return total;
   }
   
   public static int problem16 (){
      BigDecimal a = new BigDecimal(Math.pow(2,1000));
      String b = ""+a;
      int sum = 0;
      for (int x = 0; x < b.length(); x++){
         sum+= Integer.parseInt(b.charAt(x)+ "");
      }
      System.out.println(b);
      return sum;
   }

   
   public static int problem14 (){
      int winner = 0;
      int lChain = 0;
      for (int x = 510000; x < 1000000; x++){
         long a = x;
         int chain = 1;
         while (a != 1){
            if (a < 0){
               x = 100000000;
               break;
            }
            if (a%2 == 0){
               a = a/2;
               chain++;
            }
            else {
               a = 3 * a + 1;
               chain++;
            }
         }
         if (chain > lChain){
            winner = x;
            lChain = chain;
         }
      }
      System.out.println(lChain);
      return winner;
   }

   
   public static int problem12 (){
      int sum = 0;
      int count = 1;
      boolean found = false;
      while (found == false){
         int divisor = 0;
         sum += count;
         count++;
         for (int x = 2; x <= sum; x++){
            if (sum %x == 0){
               divisor++;
               if (divisor >= 500){
                  return sum;
               }
               System.out.println(divisor);
            }
         }
         //System.out.println(divisor);
      }
      return 0;
   }
   
   public static double problem13 () throws FileNotFoundException{
      Scanner input = new Scanner (new File("problem13.txt")) ;
      double a = 0L;
      while (input.hasNextLine()){
         String hold = input.nextLine();
         a+= Double.parseDouble(hold);
      }
      return a;
   }
   
   public static double problem9 (){
      for (int a = 1; a < 499; a++){
         for (int b = 1; b < 500; b++){
            if (a + b + Math.sqrt(Math.pow(a,2) + Math.pow(b,2)) == 1000.0){
               System.out.println(a + " " + b + " " +Math.sqrt(Math.pow(a,2) + Math.pow(b,2)));
               return a * b * Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
            }
            //System.out.println(a + " " + b + " " +Math.sqrt(Math.pow(a,2) + Math.pow(b,2)));
         }
      }
      return 0;
   }
   
   public static long problem10 (){
      int a = 2000000;
      long sum = 0;
      for (int x = 2; x <= a; x++){
         if (isPrime(x) == true){
            sum+=x;
         }
      }
      return sum;
   }
   
   public static long problem3 (){
      long a = 600851475143L ;
      long high = 0;
      for (int x = 2; x <= a; x++){
         if (a%x == 0){
            if (isPrime(x) == true){
               high = x;
            }
         }
      }
      return high;
   }
   
   public static int problem5 (){
      for (int x = 2520; x <= 1000000000;x++){
         if (x%2 == 0 && x%3 == 0 && x%4 == 0 && x%5 == 0 && x%6 == 0 && x%7 == 0 && x%8 == 0 && x%9 == 0 && x%10 == 0 && x%11 == 0 && x%12 == 0 && x%13 == 0 && x%14 == 0 && x%15 == 0 && x%16 == 0 && x%17 == 0 && x%18 == 0 && x%19 == 0 && x%20 == 0){
            return x;
         }
      }
      return 0;
   }
   
   public static int problem4 (){
      int palindrome = 0;
      int temp;
      String holder;
      for (int x = 999; x >= 900; x--){
         for (int y = 999; y >= 900; y--){
            temp = x * y;
            holder = "" + temp;
            if (holder.substring(0,1).equals(holder.substring(holder.length()-1,holder.length())) && holder.substring(1,2).equals(holder.substring(holder.length()-2,holder.length()-1)) && holder.substring(2,3).equals(holder.substring(holder.length()-3,holder.length()-2))){
               palindrome = temp;
               System.out.println(holder.substring(holder.length()-3,holder.length()-2));
               y = 1;
               x = 1;
            }
         }
      }
      return palindrome;
   }
   /*
   public static long problem3 (){ //Unsolved
      long large = 600851475143;
      for(long x = 600851475143; x > 1;x--){
         if (600851475143%x==0){
            if (!(x%2 == 0 && x%3 == 0 &&x%4 == 0 &&x%5 == 0 &&x%6 == 0 &&x%7 == 0 &&x%8 == 0 &&x%9 == 0)){
               large = x;
            }
         }
      }
      return large;
   }
   */
   public static long problem2 () {
      long sum = 2;
      long a = 1;
      long b = 2;
      long c;
      for(int x = 2; x <= 4000000;x++){
         c = a+b;
         a = b;
         b = c;
         if (c%2==0 && c < 4000000){
            sum+=c;
            System.out.println(c);
         }
         if (c > 4000000){
            break;
         }
      }
      return sum;
   }
   
   public static int problem1 () {
      int sum = 0;
      for(int x = 1; x < 1000;x++){
         if ((x % 3 == 0) || (x % 5 == 0)){
            sum+=x;
         }
      }
      return sum;
   }
}