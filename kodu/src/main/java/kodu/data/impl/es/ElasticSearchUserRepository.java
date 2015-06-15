package kodu.data.impl.es;

import kodu.model.elasticsearch.UserES;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchUserRepository  extends ElasticsearchRepository<UserES, String>{

}
