package model;

import java.util.ArrayList;

public final class Post {
	
	private String description;
	private Code code;
	private ArrayList<Rating> rating;
	private ArrayList<User> shared;
	private ArrayList<Comment> comments;
	
	public Post(String description, Code code) {
		this.description = description;
		this.code = code;
		this.rating = new ArrayList<Rating>();
		this.shared = new ArrayList<User>();
		this.comments = new ArrayList<Comment>(); }

	public final String getDescription() {
		return description; }

	public final void setDescription(String description) {
		this.description = description; }

	public final Code getCode() {
		return code; }

	public final void setCode(Code code) {
		this.code = code; }

	public final ArrayList<Rating> getRating() {
		return rating; }

	public final void setRating(ArrayList<Rating> rating) {
		this.rating = rating; }

	public final ArrayList<User> getShared() {
		return shared; }

	public final void setShared(ArrayList<User> shared) {
		this.shared = shared; }

	public final ArrayList<Comment> getComments() {
		return comments; }

	public final void setComments(ArrayList<Comment> comments) {
		this.comments = comments; }

	@Override
	public String toString() {
		return "Post [description=" + description + ", code=" + code
				+ ", rating=" + rating + ", shared=" + shared + ", comments="
				+ comments + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		return result; }

	@Override
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