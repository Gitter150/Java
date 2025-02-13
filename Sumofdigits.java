import java.util.Scanner;
public class Sumofdigits{
    public static void main(String[] args){
        int sum = 0, num;
        System.out.print("Enter the number: ");
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        int n = num;
        while (num>0){
            sum+=num%10;
            num = num/10;
        }
        System.out.println("Sum of digits of "+(n)+" is: "+(sum));
        
        input.close();
    }
}