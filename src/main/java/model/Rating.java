package main.java.model;
public class Rating {
	
	private User user;
	private int score;
	
	public Rating(User user, int score) {
		this.user = user;
		this.score = score; }

	public User getUser() {
		return user; }
	
	public int getScore() {
		return score; }

	public void setScore(int score) {
		this.score = score; }

	
	public String toString() {
		return "Rating [user=" + user + ", score=" + score + "]"; }

	
	public int hashCode() {
	 int prime = 31;
		int result = 1;
		result = prime * result + score;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result; }

	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Rating)) {
			return false; }
		Rating other = (Rating) obj;
		if (score != other.score) {
			return false; }
		if (user == null) {
			if (other.user != null) {
				return false; } }
		else if (!user.equals(other.user)) {
			return false; }
		return true; }
}
