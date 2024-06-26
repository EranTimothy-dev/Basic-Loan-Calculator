public class Main {
    public static void main(String[] args) {
        double a = 20000.00;
        float f = (float)a;
        LoanCalculator cal = new LoanCalculator(f,0.6f,12);
        cal.displayPaymentSchedule();
    }
}