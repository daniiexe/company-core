package com.companycore.database.dao.employee;

import com.companycore.database.model.employee.Employee;

public interface EmployeeDao {
    void addEmployee(Employee employee);
    Employee getEmployee(int id);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
