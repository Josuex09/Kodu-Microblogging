package kodu.data.impl.es;

import java.util.List;

import kodu.model.elasticsearch.PostES;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchPostRepository extends ElasticsearchRepository<PostES, String>{
	public List<PostES> findByDescriptionIsLike(String description);
	public List<PostES> findByUserIsLikeAndDescriptionIsLike(String user, String description);
	

}
