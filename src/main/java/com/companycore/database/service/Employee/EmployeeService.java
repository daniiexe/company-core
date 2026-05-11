package com.companycore.database.service.Employee;

import com.companycore.database.dao.employee.EmployeeDao;
import com.companycore.database.model.employee.Employee;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {this.employeeDao = employeeDao;}

    public void createUser(int id, String firstName, String lastName, String phoneNumber, String email) {
        Employee employee = new Employee(id, firstName, lastName, phoneNumber, email);

        employeeDao.addEmployee(employee);
    }
}
