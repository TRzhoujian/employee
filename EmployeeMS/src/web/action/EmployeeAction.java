package web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.IEmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import domain.Employee;

public class EmployeeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private IEmployeeDAO dao = new EmployeeDAOImpl();
		
	private Employee e;
	public String list() {
		List<Employee> list = dao.list();
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}

	public String delete() {
		if (e.getId() !=null) {
			dao.delete(e.getId());	
		}
		return "list";
	}
	public String input() {
		if (e.getId() !=null) {
			e = dao.getEmployee(e.getId());
		}
		return INPUT;
	}
	public String save() {
		dao.save(e);
		return "list";
	}

	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}
	
	
	
}
