package main.java.model;

public class Comment {
	
	private User user;
	private String content;
	
	public Comment(User user, String content) {
		this.user = user;
		this.content = content; }

	public User getUser() {
		return user; }

	public String getContent() {
		return content; }

	
	public String toString() {
		return "Comment [user=" + user + ", content=" + content + "]"; }

	
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result; }

	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Comment)) {
			return false; }
		Comment other = (Comment) obj;
		if (content == null) {
			if (other.content != null) {
				return false; } }
		else if (!content.equals(other.content)) {
			return false; }
		if (user == null) {
			if (other.user != null) {
				return false; } }
		else if (!user.equals(other.user)) {
			return false; }
		return true; }	
}