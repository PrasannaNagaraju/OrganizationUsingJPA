package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;
import com.mize.dto.Organization;
import com.mize.service.Service;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	private Service service;

	public Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public Result getAllOrganizations() {
		List<Organization> list = service.getAllOrganizations();
		if (list == null) {
			play.Logger.error("Empty List...!");
			return notFound("Empty List");
		} else {
			play.Logger.info("Displaying Employee List...!");
			return ok(Json.toJson(list));
		}
	}

	public Result getOrgById() {
		JsonNode json = request().body().asJson();
		System.out.println(json);
		if (json != null) {

			Organization org = Json.fromJson(json, Organization.class);
			Organization employee = service.getOrganizationById(org);
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

	public Result addOrg() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Organization org = Json.fromJson(json, Organization.class);
			if (service.addOrganization(org) != null) {
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

	public Result removeOrg() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Organization org = Json.fromJson(json, Organization.class);

			service.removeOrganization(org);
			play.Logger.info("Employee Deleted successfully...!");
			return ok("Employee Deleted...!");

		} else {
			play.Logger.error("Invalid Removal Operation");
			return ok("Invalid Removal operation");
		}

	}

	public Result updateOrg() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Organization org = Json.fromJson(json, Organization.class);
			if (service.updateOrganization(org) != null) {
				play.Logger.info("Record Updation successfull...!");
				return ok("record updated successfully..");
			} else {
				play.Logger.error("Record updation failed");
				return internalServerError("record updation failed..");
			}
		} else {
			play.Logger.error("Invalid updation Operation");
			return badRequest("Invalid updation operation");
		}
	}

	public Result getOrgByCode() {
		JsonNode json = request().body().asJson();
		if (json != null) {
			Organization org = Json.fromJson(json, Organization.class);
			List<Organization> list = service.getOrgByCode(org);
			if (list == null) {
				play.Logger.error("Empty List...!");
				return notFound("Empty List");
			} else {
				play.Logger.info("Displaying Employee List...!");
				return ok(Json.toJson(list));
			}
		} else {
			return badRequest();
		}
	}
}
