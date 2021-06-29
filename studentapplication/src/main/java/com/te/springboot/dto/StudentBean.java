package com.te.springboot.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
@JsonRootName("users")
@JsonPropertyOrder({"Userid","Name"})
@XmlRootElement(name="users")
public class StudentBean implements Serializable {

	@Id
	@JsonProperty("Userid")
	private int Userid;

	@Column
	private String Email;

	@Column
	private Double Marks;

     @Column
     private String Name;
     
	@Column
	private char Grade;


}
