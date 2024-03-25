package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String gmail;
	
	private String password;
	
	private String gender;
	
	private List<Integer> followers = new ArrayList<>();
	
	private List<Integer> following = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	private List<Post> savedPost = new ArrayList<>();
	
	public User() {
		super();
	}

	public User(Integer id, String firstName, String lastName, String gmail, String password, String gender,
			List<Integer> followers, List<Integer> following, List<Post> savedPost) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gmail = gmail;
		this.password = password;
		this.gender = gender;
		this.followers = followers;
		this.following = following;
		this.savedPost = savedPost;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Integer> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}

	public List<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(List<Integer> following) {
		this.following = following;
	}

	
	public List<Post> getSavedPost() {
		return savedPost;
	}

	public void setSavedPost(List<Post> savedPost) {
		this.savedPost = savedPost;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", gmail=" + gmail + ", password=" + password
				+ "]";
	}
	
}
