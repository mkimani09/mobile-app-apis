package com.faidihr.mobile.app.api.model.repository;

import com.faidihr.mobile.app.api.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long>
{
    public Employee findEmployeeByEmailAndEmpTerminated(String emailAddress,Integer terminated);
}
