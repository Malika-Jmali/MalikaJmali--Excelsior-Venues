package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeesAll = new ArrayList<>();
		String sqlGetAllEmployees = "SELECT employee_id, first_name, last_name FROM employee ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		while(results.next()) {
			Employee theEmployee = mapRowToEmployee (results);
			employeesAll.add(theEmployee);
		}
		return employeesAll;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlSearchEmployeesByName = "SELECT employee_id, first_name, last_name " + "FROM employee " + "WHERE first_name LIKE ? AND last_name LIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while(results.next()) {
			Employee theEmployee1 = mapRowToEmployee(results);
			employees.add(theEmployee1);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee> employeesByDept = new ArrayList<>();
		String sqlGetEmployeesByDepartmentId = "SELECT employee_id, department_id, first_name, last_name " + "FROM employee " + "WHERE first_name LIKE ? AND last_name LIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByDepartmentId);
		while(results.next()) {
			Employee theEmployee1 = mapRowToEmployee(results);
			employeesByDept.add(theEmployee1);
		}
		return employeesByDept;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employeesNoProject = new ArrayList<>();
		String sqlGetEmployeesWithoutProjects = "SELECT employee_id, first_name, last_name FROM employee WHERE employee_id NOT IN (SELECT employee_id FROM project_employee);";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesWithoutProjects);
		while(results.next()) {
			Employee theEmployee1 = mapRowToEmployee(results);
			employeesNoProject.add(theEmployee1);
		}
		return employeesNoProject;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> employeesByProjectId = new ArrayList<>();
		String sqlGetEmployeesByProjectId = "SELECT project_id " + "FROM project_employee " + "WHERE employee_id NOT NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByProjectId);
		while(results.next()) {
			Employee theEmployee1 = mapRowToEmployee(results);
			employeesByProjectId.add(theEmployee1);
		}
		return employeesByProjectId;
	}


	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
	}
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee;
		theEmployee = new Employee();
		theEmployee.setId(results.getLong("employee_id"));
		theEmployee.setFirstName(results.getString("first_name"));
		theEmployee.setLastName(results.getString("last_name"));
		theEmployee.setDepartmentId(results.getLong("department_id"));
		theEmployee.setId(results.getLong("project_id"));
		return theEmployee;
	}

}
