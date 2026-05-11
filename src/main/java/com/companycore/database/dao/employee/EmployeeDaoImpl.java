package com.companycore.database.dao.employee;

import com.companycore.database.connection.DatabaseConnection;
import com.companycore.database.model.employee.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {
    public EmployeeDaoImpl() {}

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (employee_firstname, employee_lastname, employee_phone_number, employee_email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getFistName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getPhoneNumber());
            stmt.setString(4, employee.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE employee_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employee = new Employee(0, null, null, null, null);
                employee.setId(rs.getInt("employee_id"));
                employee.setFistName(rs.getString("employee_firstname"));
                employee.setLastName(rs.getString("employee_lastname"));
                employee.setPhoneNumber(rs.getString("employee_phone_number"));
                employee.setEmail(rs.getString("employee_email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET employee_firstname = ?, employee_lastname = ?, employee_phone_number = ?, employee_email = ? WHERE employee_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getFistName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getPhoneNumber());
            stmt.setString(4, employee.getEmail());
            stmt.setInt(5, employee.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean employeeLogin(String username, String password) {
        String sql = "SELECT * FROM employee WHERE employee_username = ? AND employee_password = ?";


        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login success!");
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Login not succeeded!");
        return false;
    }
}
