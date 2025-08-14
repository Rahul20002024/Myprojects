package com.demo.service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDAO;
import com.demo.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void addEmployee(Employee emp) {
        System.out.println("Service: Adding employee");
        employeeDAO.save(emp);
        System.out.println("Service: Employee added");
    }

    public void deleteEmployee(int id) {
        System.out.println("Service: Deleting employee with ID " + id);
        employeeDAO.delete(id);
        System.out.println("Service: Employee deleted");
    }

    public void updateEmployee(Employee emp) {
        System.out.println("Service: Updating employee with ID " + emp.getId());
        employeeDAO.update(emp);
        System.out.println("Service: Employee updated");
    }

    public Employee getEmployeeById(int id) {
        System.out.println("Service: Fetching employee with ID " + id);
        return employeeDAO.getById(id);
    }

    public List<Employee> getAllEmployees() {
        System.out.println("Service: Fetching all employees");
        return employeeDAO.getAll();
    }
}