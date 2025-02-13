public class Complex {
    int real, imag;
    public Complex() {
        real = 0;
        imag = 0;
    }
    public Complex(int x, int y) {
        real = x;
        imag = y;
    }
    public void display() {
        System.out.println((this.real) +" + "+this.imag+ "i");
    }
    public static Complex add(Complex c1, Complex c2) {
        Complex sum = new Complex();
        sum.real = c1.real + c2.real;
        sum.imag = c1.imag + c2.imag;
        return sum;
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(3,2);
        Complex sum = add(c1,c2);
        System.out.println("The sum is: ");
        sum.display();
    }
}
