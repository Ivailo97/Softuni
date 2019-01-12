package CompanyRoster;

import java.util.List;

public class Department {

    private String name;
    private List<Employee> employees;

    public  Department(String name ,List<Employee> employees){

        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee){

        this.employees.add(employee);
    }

    public List<Employee> getEmployees(){

        return this.employees;
    }
}
