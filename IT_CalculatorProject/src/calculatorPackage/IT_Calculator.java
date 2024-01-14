package calculatorPackage;

import java.util.Scanner;

public class IT_Calculator {

	public static void main(String[] args) {
		int Taxableincome;
		int TaxpaidperYear;
		int TaxPayablePerMonth;
		int tax;

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the Taxableincome");
		Taxableincome = kb.nextInt();
		if (Taxableincome <= 25000) {
			tax = 0;
			TaxpaidperYear = 0;
			TaxPayablePerMonth = TaxpaidperYear / 12;

			System.out.println("Tax per year is " + TaxpaidperYear);

			System.out.println("Tax per Month is " + TaxPayablePerMonth);

		}

		else if (Taxableincome > 25000 && Taxableincome <= 50000) {
			tax = Taxableincome * 10 / 100;
			TaxpaidperYear = Taxableincome - tax;
			TaxPayablePerMonth = TaxpaidperYear / 12;

			System.out.println("Tax per year is " + TaxpaidperYear);

			System.out.println("Tax per Month is " + TaxPayablePerMonth);
		}

		else if (Taxableincome > 50000 && Taxableincome <= 75000) {
			tax = Taxableincome * 20 / 100;
			TaxpaidperYear = Taxableincome - tax;
			TaxPayablePerMonth = TaxpaidperYear / 12;

			System.out.println("Tax per year is " + TaxpaidperYear);

			System.out.println("Tax per Month is " + TaxPayablePerMonth);
		}

		else if (Taxableincome > 75000) {
			tax = Taxableincome * 30 / 100;
			TaxpaidperYear = Taxableincome - tax;
			TaxPayablePerMonth = TaxpaidperYear / 12;

			System.out.println("Tax per year is " + TaxpaidperYear);

			System.out.println("Tax per Month is " + TaxPayablePerMonth);
		}
	}

}
