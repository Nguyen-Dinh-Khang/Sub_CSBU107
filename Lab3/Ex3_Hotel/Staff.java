package Lab3.Ex3_Hotel;

public class Staff extends Person {
    private String licenseId;
    private String employeeId;

    public Staff(String name, int age, String LID, String EID){
        super(name, age);
        setLicenseid(LID);
        setEmployeeed(EID);
    }

    public String getLicenseid(){
        return licenseId;
    }

    public void setLicenseid(String licenseid){
        if (licenseid == null || licenseid.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid license id!");
        }
        this.licenseId = licenseid;
    }

    public String getEmployeeid(){
        return employeeId;
    }

    public void setEmployeeed(String employeeid){
        if (employeeid == null || employeeid.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid employee id!");
        }
        this.employeeId = employeeid;
    }

    public void setEmployeeId(String employeeid){
        setEmployeeed(employeeid);
    }

    @Override 
    public String toString(){
        return String.format("[Staff] %s | LicenseId: %s | EmployeeId: %s", 
                            super.toString(), licenseId, employeeId);
    }
}
