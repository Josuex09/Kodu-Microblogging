package main.java.model;

import java.util.ArrayList;

public  class Post extends BaseEntity {
	
	
	private User user;
	private String description;
	//private String postId;
	private Code code;
	private ArrayList<Rating> ratings;
	private ArrayList<User> shared;
	private ArrayList<Comment> comments;
	
	
	
	public Post(){
		
	}
	public Post(String description, Code code,User user) {
		this.user = user;
		this.description = description;
		this.code = code;
		//this.postId=postId;
		this.ratings = new ArrayList<Rating>();
		this.shared = new ArrayList<User>();
		this.comments = new ArrayList<Comment>(); }

/*
	public String getPostId() {
		return postId;
	}
*/

	public User getUser() {
		return user;
	}
	public String getDescription() {
		return description; }

	public Code getCode() {
		return code; }

	public ArrayList<Rating> getRating() {
		return ratings; }
	
	public void addRating(Rating rating){
		ratings.add(rating);
	}

	public ArrayList<User> getShared() {
		return shared; }

	public void addShared(User user){
		shared.add(user);
	}
	
	public  ArrayList<Comment> getComments() {
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