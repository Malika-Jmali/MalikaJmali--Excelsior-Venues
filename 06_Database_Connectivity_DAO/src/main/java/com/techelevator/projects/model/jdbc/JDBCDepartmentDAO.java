package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		String getAllDepartmentsql = "select department_id, name  FROM department";

		List<Department> newResults = new ArrayList<>();

		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllDepartmentsql);

		while(results.next()) {
			Department department = new Department();
			department.setId(results.getLong("department_id"));
			department.setName(results.getString("name"));
			newResults.add(department);
		}
		return newResults;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		String getAllDepartmentsql = "select department_id, name  FROM department WHERE name = '"+ nameSearch+ "';";

		List<Department> newResults = new ArrayList<>();

		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllDepartmentsql);

		while(results.next()) {
			Department department = new Department();
			department.setId(results.getLong("c"));
			department.setName(results.getString("name"));
			newResults.add(department);
		}
		return newResults;

	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlInsertDepartement = "INSERT INTO department(department_id, name) " +   //define our query
				"VALUES(?, ?)";

		jdbcTemplate.update(sqlInsertDepartement,
				updatedDepartment.getName());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlCreateDepartment = "INSERT into department (name) VALUES(?)";
		jdbcTemplate.update(sqlCreateDepartment, newDepartment.getName());
		return searchDepartmentsByName(newDepartment.getName()).get(0);
	}

	@Override
	public Department getDepartmentById(Long id) {
		String getAllDepartmentsql = "select department_id, name  FROM department where department_id = "+id+";";
		Department department = new Department();
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllDepartmentsql);
		if(results.next()) {
			department.setId(results.getLong("department_id"));
			department.setName(results.getString("name"));
		}
		return department;	}

}
