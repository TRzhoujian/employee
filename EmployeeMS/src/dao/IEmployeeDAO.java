package dao;

import java.util.List;

import domain.Employee;

public interface IEmployeeDAO {
	void save(Employee e);
	void delete(Long id);
	void update(Employee e);
	Employee getEmployee (Long id);
	List<Employee> list();
}
