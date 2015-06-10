/*package kodu;

import kodu.data.impl.es.ElasticsearchUserRepository;
import kodu.model.User;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleElasticSearchRepository extends BaseTest{
	
	@Autowired
	static ElasticsearchUserRepository sampleElasticsearchRepository;
	
	@Before
    public void emptyData(){
        sampleElasticsearchRepository = context.getBean(ElasticsearchUserRepository.class);
        sampleElasticsearchRepository.deleteAll();
    }


    @Test
    public void testIndexing(){
        User user = new User("danielon","234","danielon@gmail.com");

        //should index
        sampleElasticsearchRepository.save(user);

        //try search
        User userSample = sampleElasticsearchRepository.findOne(user.getId());
        userSample.setEmail(user.getEmail());
        userSample.setUsername(user.getUsername());
    }

}
*/