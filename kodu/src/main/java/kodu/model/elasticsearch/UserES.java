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
	public void setId(String id) {
		Id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserES(){}

	public String getId() {
		return Id;
	}

	public String getUsername() {
		return username;
	}

}
