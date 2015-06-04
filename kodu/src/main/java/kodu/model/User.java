package kodu.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class User extends BaseEntity{
	
	private String username;
	private String email;
	private String locatedOn;
	private String password;
	private InputStream profileImage;
	private List<String> languages;
	private List<String> posts;
	private List<Medal> medals;
	private List<String> notifications;
	private List<String> followers;
	private List<String> follows;
	private HashMap<String, Long> scores;
	
	public User(String username,String password, String email) {
		this.username = username;
		this.email = email;
		this.password=password;
		this.profileImage = null;
		this.languages = new ArrayList<String>();
		this.posts = new ArrayList<String>();
		this.medals = new ArrayList<Medal>();
		this.notifications = new ArrayList<String>();
		this.followers = new ArrayList<String>();
		this.follows = new ArrayList<String>();//ArrayList<User>();
		this.scores = new HashMap<String, Long>(); 
		this.createdDate = Calendar.getInstance().getTime();
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

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public void setProfileImage(InputStream profileImage) {
		this.profileImage = profileImage; }

	public List<String> getLanguages() {
		return languages; }
	
	
	public List<String> getPosts() {
		return posts; }

	
	public void deletePost(Post post){
		posts.remove(post);
	}
	
	public List<Medal> getMedals() {
		return medals; }

	public List<String> getNotifications() {
		return notifications; }
	
	
	public List<String> getFollowers() {
		return followers; }


	public List<String> getFollows() {
		return follows; }
	
	public void deleteFollow(String follow){
		follows.remove(follow);
	}
	
	public void deleteFollower(String follower){
		followers.remove(follower);
	}
	
	public HashMap<String, Long> getScores() {
		return scores; }
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPosts(List<String> posts) {
		this.posts = posts;
	}
	
	public void setPost(String post) {
		this.posts.add(post);
	}
	
	public void setMedals(List<Medal> medals) {
		this.medals = medals;
	}
	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}
	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}
	
	public void addFollower(String follower) {
		this.followers.add(follower);
	}

	public void setFollows(List<String> follows) {
		this.follows = follows;
	}
	
	public void addFollows(String follows) {
		this.follows.add(follows);
	}

	
	public void setScores(HashMap<String, Long> scores) {
		this.scores = scores;
	}
	
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
}