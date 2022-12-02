/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.rest.DAO;

import com.spring.rest.entity.Employee;
import java.util.List;


public interface EmployeeDAO {
    public List<Employee>getAllEmployees();
    public void saveEmployee(Employee employee); 
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
    
}
