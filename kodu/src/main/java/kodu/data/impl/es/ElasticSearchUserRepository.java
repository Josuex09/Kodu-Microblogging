package kodu.data.impl.es;

import java.util.List;

import kodu.model.elasticsearch.UserES;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchUserRepository  extends ElasticsearchRepository<UserES, String>{
	public List<UserES> findByUsernameIsLike(String username);
}
