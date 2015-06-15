package kodu.data.impl.es;

import kodu.model.elasticsearch.PostES;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchPostRepository extends ElasticsearchRepository<PostES, String>{

}
