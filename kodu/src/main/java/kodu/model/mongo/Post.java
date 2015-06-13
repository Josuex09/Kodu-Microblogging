package kodu.model.mongo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public  class Post extends BaseEntity {
	
	private String user;
	private String description;
	private Code code;
	private List<Rating> ratings;
	private List<String> shared;
	private List<Comment> comments;
	private String createdBy;
	
	public Post(String description, Code code,String user) {
		this.user = user;
		this.description = description;
		this.code = code;
		this.ratings = new ArrayList<Rating>();
		this.shared = new ArrayList<String>();
		this.comments = new ArrayList<Comment>(); 
		this.createdDate = Calendar.getInstance().getTime();
		this.createdBy = user;
		
	}
	

	public String getUser() {
		return user;
	}
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description; }

	public Code getCode() {
		return code; }

	public List<Rating> getRating() {
		return ratings; }
	
	public void addRating(Rating rating){
		ratings.add(rating);
	}

	public List<String> getShared() {
		return shared; }

	public void addShared(String user){
		shared.add(user);
	}
	
	public  List<Comment> getComments() {
		return comments; }

	public void addComment(Comment comment){
		comments.add(comment);
	}
	
	
	public String toString() {
		return "Post [description=" + description + ", code=" + code
				+ ", rating=" + ratings + ", shared=" + shared + ", comments="
				+ comments + "]"; }

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		return result; }

	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Post)) {
			return false; }
		Post other = (Post) obj;
		if (code == null) {
			if (other.code != null) {
				return false; } }
		else if (!code.equals(other.code)) {
			return false; }
		if (description == null) {
			if (other.description != null) {
				return false; } }
		else if (!description.equals(other.description)) {
			return false; }
		return true; }
}