package com.te.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.dto.StudentBean;
import com.te.springboot.dto.StudentResponse;
import com.te.springboot.service.StudentService;


	@RestController
	public class StudentController {
		
		@Autowired
		private StudentService service;
		
		
		@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public StudentResponse insertStudent(@RequestBody StudentBean studentBean) {
			StudentResponse response = new StudentResponse();
			if (service.insertStudent(studentBean)) {
				response.setStatusCode(200);
				response.setMsg("success");
				response.setDescription("Added Successfully");
			} else {
				response.setStatusCode(400);
				response.setMsg("failure");
				response.setDescription("Something Went Wrong !");
			}
			return response;
		}// end of ADD
		
	
		@DeleteMapping(path ="/delete",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		public StudentResponse removeStudent(int Userid) {
			StudentResponse response=new StudentResponse();
		
			if(service.removeStudent(Userid)) {
				response.setStatusCode(200);
				response.setMsg("Success");
				response.setDescription("Data deleted successfully for id :"+Userid);
				
			}else {
				response.setStatusCode(404);
				response.setMsg("Failure");
				response.setDescription("Data Not found to delete");
			}
			return response;
			
		}//end of delete

		
		@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public StudentResponse updateEmp(@RequestBody StudentBean bean) {
			System.out.println(bean);
			StudentResponse response = new StudentResponse();
			if (service.updateStudent(bean)) {
				response.setStatusCode(200);
				response.setMsg("success");
				response.setDescription("Updated Successfully");
			} else {
				response.setStatusCode(400);
				response.setMsg("failure");
				response.setDescription("Something Went Wrong");
			}
			return response;
		}// end of Update

			
		}//end of class



