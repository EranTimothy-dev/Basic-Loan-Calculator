import java.text.DecimalFormat;

//import java.text.
public class LoanCalculator {
    public float loanAmount;
    public float interest;
    public int months;
    DecimalFormat df = new DecimalFormat("0.00");


    public LoanCalculator(float loanAmount, float annualInterestRate, int loanTerm){
        this.loanAmount = loanAmount;
        this.interest = annualInterestRate;
        this.months = loanTerm;
    }

    public void displayPaymentSchedule(){
        float monthlyInterestRate = interest/12;
        System.out.println("1. Monthly interest rate is: " + monthlyInterestRate + "%");
        float totalInterest = loanAmount * monthlyInterestRate * months;
        System.out.println("2. Total interest to be paid is: Rs." + df.format(totalInterest));
        float totalAmountToBePaid = loanAmount + totalInterest;
        System.out.println("3. Total amount to be paid with interest is: Rs." + df.format(totalAmountToBePaid));
        float monthlyInstallment = totalAmountToBePaid/months;
        System.out.println("4. Monthly installment plan per month is: Rs." + df.format(monthlyInstallment));
        System.out.println("5. Number of monthly payments planned for: " + months);
        System.out.println("""
                
                ~~~~~~~~~~~~~Loan Payment Schedule~~~~~~~~~~~~""");
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %-5s | %-16s | %-14s |%n","Month"," Reaming Balance", "Monthly Payment");
        System.out.printf("----------------------------------------------%n");
        for (int i = 1; i <= months ; i++) {
            System.out.printf("| %-5s | %-16s | %-15s |%n",i,df.format(totalAmountToBePaid), df.format(monthlyInstallment));
            System.out.printf("----------------------------------------------%n");
            totalAmountToBePaid -= monthlyInstallment;
        }
    }
}
