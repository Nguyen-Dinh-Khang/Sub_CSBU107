package Lab4.Ex2_Employee;

public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double allowance;
    private int workdays;

    public FullTimeEmployee(String id, String fullName, String department, double baseSalary, double allowance, int workdays) {
        super(id, fullName, department);
        setBaseSalary(baseSalary);
        setAllowance(allowance);
        setWorkdays(workdays);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary must be >= 0!");
        }
        this.baseSalary = baseSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        if (allowance < 0) {
            throw new IllegalArgumentException("Allowance must be >= 0!");
        }
        this.allowance = allowance;
    }

    public int getWorkdays() {
        return workdays;
    }

    public void setWorkdays(int workdays) {
        if (workdays < 0 || workdays > 31) {
            throw new IllegalArgumentException("Workdays must be between 0 and 31 (inclusive)!");
        }
        this.workdays = workdays;
    }

    @Override
    public double calculateSalary() {
        return (baseSalary * Math.min(workdays, 26) / 26.0) + allowance;
    }

    @Override
    public String toString() {
        return String.format("[Full Time] %s | Base Salary: %,.0f VND | Allowance: %,.0f VND | Workdays: %d",
                super.toString(), baseSalary, allowance, workdays);
    }
}
