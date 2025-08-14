package com.demo.dao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository
public class EmployeeDAO {

    @Autowired
    private SessionFactory factory;

    public EmployeeDAO() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void save(Employee emp) {
        System.out.println("Saving employee: " + emp.getName());
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(emp);
        tx.commit();
        session.close();
        System.out.println("Employee saved successfully");
    }

    public void delete(int id) {
        System.out.println("Deleting employee with id: " + id);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }
        tx.commit();
        session.close();
    }

    public void update(Employee emp) {
        System.out.println("Updating employee with id: " + emp.getId());
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(emp);
        tx.commit();
        session.close();
        System.out.println("Employee updated");
    }

    public Employee getById(int id) {
        System.out.println("Fetching employee by id: " + id);
        Session session = factory.openSession();
        Employee emp = session.get(Employee.class, id);
        session.close();
        return emp;
    }

    public List<Employee> getAll() {
        System.out.println("Fetching all employees");
        Session session = factory.openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return list;
    }
}