package kodu.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "user")
public class UserES {
	@Id
	private String Id;
	private String username;

	public UserES(String Id, String username) {
		this.Id=Id;
		this.username = username;

	}

	public String getId() {
		return Id;
	}

	public String getUsername() {
		return username;
	}

}
