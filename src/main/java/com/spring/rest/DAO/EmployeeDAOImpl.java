package com.spring.rest.DAO;

import com.spring.rest.entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id){
    Session session = sessionFactory.getCurrentSession();
    Employee employee = session.get(Employee.class, id);
    return employee;
    }
    
     @Override
      @Transactional
    public void deleteEmployee(int id) {
         Session session = sessionFactory.getCurrentSession();
         Query <Employee> query = session.createQuery("delete from Employees where id=:employeeId");
         query.setParameter("employeeId", id);
          query.executeUpdate();
       }
}
