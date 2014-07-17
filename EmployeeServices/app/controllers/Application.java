package controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;
import com.mize.dto.Employee;
import com.mize.service.EmployeeService;

@Component
public class Application extends Controller {

	@Autowired
	public static EmployeeService employeeService;

	public static Result getEmployees() {

		List<Employee> list = getEmployeeService().findAll();
		if (list == null) {
			play.Logger.error("Empty List...!");
			return notFound("Empty List");
		} else {
			play.Logger.info("Displaying Employee List...!");
			return ok(Json.toJson(list));
		}
	}

	public static Result getEmpById() {
		JsonNode json = request().body().asJson();
		if (json != null) {

			Employee emp = Json.fromJson(json, Employee.class);
			Employee employee = getEmployeeService().findById(emp);
			if (employee != null) {
				play.Logger.info("Record Found");
				return ok(Json.toJson(employee));
			} else {
				play.Logger.info("Record not found");
				return notFound("Record not found");

			}
		} else {
			play.Logger.error("Invalid Id");
			return badRequest("Invalid Id");
		}
	}

	public static Result getEmpByDep() {
		JsonNode json = request().body().asJson();
		if (json != null) {

			Employee emp = Json.fromJson(json, Employee.class);
			List<Employee> deplist = getEmployeeService().findByDepartment(emp);
			if (deplist == null) {
				play.Logger.error("Empty List...!");
				return notFound("Empty List");
			} else {
				play.Logger.info("Displaying Employee DepList...!");
				return ok(Json.toJson(deplist));
			}

		} else {
			play.Logger.error("Invalid Department");
			return badRequest("Invalid Department");
		}
	}

	public static Result insertEmployee() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Employee emp = Json.fromJson(json, Employee.class);
			if (getEmployeeService().insertEmployee(emp)) {
				play.Logger.info("Record Insertion successfull...!");
				return ok("record inserted successfully..");
			} else {
				play.Logger.error("Record insertion failed");
				return internalServerError("record insertionn failed..");
			}
		} else {
			play.Logger.error("Invalid Insertion Operation");
			return badRequest("Invalid Insertion operation");
		}
	}

	public static Result updateEmployee() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Employee emp = Json.fromJson(json, Employee.class);
			if (getEmployeeService().updateEmployee(emp)) {
				play.Logger.info("Record updation operation successfull...!");
				return ok("record updated successfully...!");
			}
			play.Logger.error("Record Updation failed...!");
			return internalServerError("record updation failed...!");
		} else {
			play.Logger.error("Invalid Update Operation");
			return badRequest("Invalid Update operation");
		}
	}

	public static Result deleteEmployee() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Employee emp = Json.fromJson(json, Employee.class);

			if (getEmployeeService().deleteEmployeeById(emp)) {
				play.Logger.info("Employee Deleted successfully...!");
				return ok("Employee Deleted...!");
			}
			play.Logger.error("Employee Deletion failed..!");
			return ok("Removal failed...!");

		} else {
			play.Logger.error("Invalid Removal Operation");
			return ok("Invalid Removal operation");
		}
	}

	public static Result getAvgSalByDept() {

		List<Map<String, Object>> deplist = getEmployeeService()
				.getAvgSalByDept();
		if (deplist == null) {
			play.Logger.error("Empty List...!");
			return notFound("Empty List");
		} else {
			play.Logger.info("Displaying Employee DepList...!");
			return ok(Json.toJson(deplist));
		}

	}

	public static Result getEmpCount() {
		int n = getEmployeeService().empCount();
		return ok(index.render("Total Emp count is" + n));
	}

	private static EmployeeService getEmployeeService() {
		if (employeeService == null) {
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"bean.xml");

			employeeService = (EmployeeService) context.getBean("service");
		}
		return employeeService;

	}
}
