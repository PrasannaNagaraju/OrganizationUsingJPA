package controllers;

import java.util.List;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.mize.employee.Employee;
import com.mize.service.Service;
import com.mize.service.ServiceImpl;

public class Application extends Controller {

	static Service service = new ServiceImpl();

	public static Result getEmployeeById() {
		JsonNode json = request().body().asJson();
		if (json != null) {

			Employee emp = Json.fromJson(json, Employee.class);
			Employee employee = service.getEmployeeById(emp);
			if (employee != null) {
				play.Logger.info("Record Found");
				return ok(Json.toJson(employee));
			} else {
				play.Logger.info("Record not found");
				return notFound("Record not found");

			}
		} else {
			play.Logger.error("Invalid Id");
			return ok("Invalid Id");
		}
	}

	public static Result insertEmployee() {

		JsonNode json = request().body().asJson();
		if (json != null) {
			Employee emp = Json.fromJson(json, Employee.class);
			if (service.insertIntoemployees(emp)) {
				play.Logger.info("Record Insertion successfull...!");
				return ok("record inserted successfully..");
			} else {
				play.Logger.error("Record insertion failed");
				return ok("record insertionn failed..");
			}
		} else {
			play.Logger.error("Invalid Insertion Operation");
			return ok("Invalid Insertion operation");
		}

	}

	public static Result getAllEmployees() {
		List<Employee> list = service.getAllEmployees();
		if (list == null) {
			play.Logger.error("Empty List...!");
			return ok("Empty List");
		} else {
			play.Logger.info("Displaying Employee List...!");
			return ok(Json.toJson(list));
		}
	}

	public static Result updateEmployee() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Employee emp = Json.fromJson(json, Employee.class);
			if (service.updateEmployee(emp)) {
				play.Logger.info("Record updation operation successfull...!");
				return ok("record updated successfully...!");
			}
			play.Logger.error("Record Updation failed...!");
			return ok("record updation failed...!");
		} else {
			play.Logger.error("Invalid Update Operation");
			return ok("Invalid Update operation");
		}

	}

	public static Result removeEmployee() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Employee emp = Json.fromJson(json, Employee.class);

			if (service.removeFromEmpById(emp)) {
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
}