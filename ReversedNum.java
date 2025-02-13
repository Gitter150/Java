import java.util.Scanner;
public class ReversedNum {
    public static void main(String[] args){
        int num, rev=0;
        System.out.print("Enter the number: ");
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        while(num>0){
           rev = rev*10 + num%10;
           num = num/10;
        }
        System.out.println("The reversed number is: "+(rev));
        input.close();
    }
}
