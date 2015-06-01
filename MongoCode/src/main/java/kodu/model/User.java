package kodu.model;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class User extends BaseEntity{
	
	private String username;
	private String email;
	private String locatedOn;
	private String password;
	private InputStream profileImage;
	private ArrayList<String> languages;
	private ArrayList<Post> posts;
	private ArrayList<Medal> medals;
	private ArrayList<Notification> notifications;
	private ArrayList<User> followers;
	private ArrayList<User> follows;
	private HashMap<String, Long> scores;
	
	public User(){
		
	}
	public User(String username,String password, String email) {
		this.username = username;
		this.email = email;
		this.password=password;
		this.profileImage = null;
		this.languages = new ArrayList<String>();
		this.posts = new ArrayList<Post>();
		this.medals = new ArrayList<Medal>();
		this.notifications = new ArrayList<Notification>();
		this.followers = new ArrayList<User>();
		this.follows = new ArrayList<User>();
		this.scores = new HashMap<String, Long>(); 
		//this.createdDate =  new Date();
		}

	public String getUsername() {
		return username; }

	public String getEmail() {
		return email; }
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocatedOn() {
		return locatedOn; }

	public void setLocatedOn(String locatedOn) {
		this.locatedOn = locatedOn; }

	public InputStream getProfileImage() {
		return profileImage; }

	public void setLanguages(ArrayList<String> languages) {
		this.languages = languages;
	}

	public void setProfileImage(InputStream profileImage) {
		this.profileImage = profileImage; }

	public ArrayList<String> getLanguages() {
		return languages; }
	
	
	public ArrayList<Post> getPosts() {
		return posts; }

	
	public void deletePost(Post post){
		posts.remove(post);
	}
	
	public ArrayList<Medal> getMedals() {
		return medals; }

	public ArrayList<Notification> getNotifications() {
		return notifications; }
	
	
	public ArrayList<User> getFollowers() {
		return followers; }


	public ArrayList<User> getFollows() {
		return follows; }
	
	public void deleteFollow(User follow){
		follows.remove(follow);
	}
	public HashMap<String, Long> getScores() {
		return scores; }
	
	
	public String toString() {
		return "User [username=" + username + ", email=" + email
				+ ", locatedOn=" + locatedOn + ", profileImage=" + profileImage
				+ ", languages=" + languages + ", posts=" + posts + ", medals="
				+ medals + ", notifications=" + notifications + ", followers="
				+ followers + ", follows=" + follows + ", scores=" + scores
				+ "]"; }

	
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result; }

	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof User)) {
			return false; }
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false; } }
		else if (!email.equals(other.email)) {
			return false; }
		if (username == null) {
			if (other.username != null) {
				return false; } }
		else if (!username.equals(other.username)) {
			return false; }
		return true; }
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	public void setMedals(ArrayList<Medal> medals) {
		this.medals = medals;
	}
	public void setNotifications(ArrayList<Notification> notifications) {
		this.notifications = notifications;
	}
	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}
	public void setFollows(ArrayList<User> follows) {
		this.follows = follows;
	}
	public void setScores(HashMap<String, Long> scores) {
		this.scores = scores;
	}
}