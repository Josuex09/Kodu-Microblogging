package model;

import java.io.InputStream;

public class Medal {
	
	private String type;
	private String language;
	
	public Medal(InputStream image, String type, String language) {
		this.type = type;
		this.language = language; }


	public String getType() {
		return type; }

	public String getLanguage() {
		return language; }

	
	public String toString() {
		return "Medal [type=" + type + ", language="
				+ language + "]"; }

	
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result; }

	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (!(obj instanceof Medal)) {
			return false; }
		Medal other = (Medal) obj;
		if (language == null) {
			if (other.language != null) {
				return false; } } 
		else if (!language.equals(other.language)) {
			return false; }
		if (type == null) {
			if (other.type != null) {
				return false; } }
		else if (!type.equals(other.type)) {
			return false; }
		return true; }
}