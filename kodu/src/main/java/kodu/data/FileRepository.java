package kodu.data;

import kodu.model.PersistedFile;

import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<PersistedFile, String>{

}
