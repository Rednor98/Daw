package cat.institutmarianao.salary.servlet.ejb;

import jakarta.ejb.Local;

/**
 * Local interface for the SalaryCalculationBean EJB. This interface defines the
 * methods that can be called by clients within the same application to perform
 * salary calculations.
 */
@Local
public interface SalaryCalculationBeanLocal {
	double MIN_GROSS_SALARY = 1424.50; // Minimum gross salary in Spain for 2026
	int MIN_CHILDREN = 0; // Minimum number of children
	double MIN_WITHHOLDING = 0; // Minimum withholding percentage


	/**
	 * Calculates the withholding percentage based on the number of children.
	 *
	 * @param children The number of children.
	 * @return The withholding percentage as a decimal (e.g., 0.15 for 15%).
	 */
	double calculateWithholding(int children);

	/**
	 * Calculates the net salary based on the gross salary and number of children.
	 *
	 * @param grossSalary The gross salary.
	 * @param children    The number of children.
	 * @return The net salary after applying the withholding.
	 */
	double calculateNetSalary(double grossSalary, int children);
}
