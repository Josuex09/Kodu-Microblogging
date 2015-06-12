package kodu.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="user")
public class UserES {
	@Id
	String Id;
	String username;

}
