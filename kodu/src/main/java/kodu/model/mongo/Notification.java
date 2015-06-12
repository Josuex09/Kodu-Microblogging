package kodu.model.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notification extends BaseEntity {
	
	private String content;
	private boolean seen;
	private String user;
	
	public Notification(String content,String user) {
		this.content = content;
		this.user = user;
		this.seen = false; }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content; }

	public boolean isSeen() {
		return seen; }

	public void setSeen(boolean seen) {
		this.seen = seen; }

	
	public String toString() {
		return "Notification [content=" + content + ", seen=" + seen + "]"; }

	
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (seen ? 1231 : 1237);
		return result; }

	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Notification)) {
			return false; }
		Notification other = (Notification) obj;
		if (content == null) {
			if (other.content != null) {
				return false; } } 
		else if (!content.equals(other.content)) {
			return false; }
		if (seen != other.seen) {
			return false; }
		return true; }

	public void setContent(String content) {
		this.content = content;
	}
}