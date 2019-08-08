package com.boiler.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "id", "employee_name", "employee_salary", "employee_age", "profile_image" })
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	public Employee() {
        super();
    }
	
	public Employee(String id, String employeeName, String employeeSalary, String employeeAge, String profileImage) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.profileImage = profileImage;
	}

	private String id;
	@JsonProperty("employee_name")
	private String employeeName;
	@JsonProperty("employee_salary")
	private String employeeSalary;
	@JsonProperty("employee_age")
	private String employeeAge;
	@JsonProperty("profile_image")
	private String profileImage;
	//@JsonIgnore
	//private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getEmployeeName() {
		return employeeName;
	}

	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
	public String getEmployeeSalary() {
		return employeeSalary;
	}

	
	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	
	public String getEmployeeAge() {
		return employeeAge;
	}

	
	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}

	
	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	/*
	 * @JsonAnyGetter public Map<String, Object> getAdditionalProperties() { return
	 * this.additionalProperties; }
	 * 
	 * @JsonAnySetter public void setAdditionalProperty(String name, Object value) {
	 * this.additionalProperties.put(name, value); }
	 */

}