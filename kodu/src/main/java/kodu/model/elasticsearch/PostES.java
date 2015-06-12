package kodu.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName="post")
public class PostES {
	@Id
	String Id;
	String description;
	

}
