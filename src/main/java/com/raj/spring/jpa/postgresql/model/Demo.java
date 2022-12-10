package com.raj.spring.jpa.postgresql.model;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.Data;

@Entity
@Data
@Table(name = "demo")
public class Demo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	public String description="SELECT new map(u.id as id,u.title) FROM Tutorial u";

	@Nullable
	@Column(name = "published")
	private Boolean published;



	public Demo(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public Demo() {
		super();
	}


	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}

}
