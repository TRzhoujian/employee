package dao.impl;

import java.util.List;

import dao.IEmployeeDAO;
import domain.Employee;
import handler.impl.BeanHandler;
import handler.impl.BeanListHandler;
import util.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO{

	@Override
	public void save(Employee e) {
		String sql = "insert into t_employee values(NULL,?,?,?,?)";
		Object[] args = {e.getName(),e.getPassword(),e.getEmail(),e.getHireDate()};
		JdbcTemplate.update(sql, args);
	}

	

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		String sql = "update t_employee set name = ?,password = ?,email = ?,hireDate = ? where id =?";
		Object[] args = {e.getName(),e.getPassword(),e.getEmail(),e.getHireDate(),e.getId()};
		JdbcTemplate.update(sql, args);
	}

	
	@Override
	public List<Employee> list() {
		String sql = "select * from t_employee";
		return JdbcTemplate.query(sql,new BeanListHandler<>(Employee.class));
		
	}

	@Override
	public Employee getEmployee(Long id) {
		String sql = "select * from t_employee where id = ?" ;
		Employee stu = JdbcTemplate.query(sql,new BeanHandler<>(Employee.class),id);
		return stu;
	}



	@Override
	public void delete(Long id) {
		String sql = "delete from t_employee where id = ?";
		JdbcTemplate.update(sql, id);
		
	}

}
