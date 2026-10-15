package cat.institutmarianao.salary.servlet.ejb.impl;

import cat.institutmarianao.salary.servlet.ejb.SalaryCalculationBeanLocal;
import jakarta.ejb.Stateless;

/**
 * Stateless EJB that implements the SalaryCalculationBeanLocal interface. This
 * bean provides methods to calculate withholding and net salary based on the
 * number of children and gross salary.
 */
@Stateless
public class SalaryCalculationBean implements SalaryCalculationBeanLocal {

	@Override
	public double calculateWithholding(int children) {
		return Math.max(MIN_WITHHOLDING, (21 - 5 * children) / 100.0);
	}

	@Override
	public double calculateNetSalary(double grossSalary, int children) {
		return grossSalary * (1 - calculateWithholding(0));
	}

}
