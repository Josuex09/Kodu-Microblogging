package kodu.data;

import kodu.data.support.CrudDao;
import kodu.model.PersistedFile;

import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudDao<PersistedFile, String>{

}
