package kodu.data.impl;

import kodu.data.FileRepository;
import kodu.model.PersistedFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import com.mongodb.gridfs.GridFSDBFile;

public class GridFSFileRepository implements FileRepository {


    @Autowired
    private GridFsOperations gridFsOperations;
	
	
	@Override
	public <S extends PersistedFile> S save(S image) {
        gridFsOperations.store(image.getInputStream(), image.getFilename());
        return image;
	}

	@Override
	public <S extends PersistedFile> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistedFile findOne(String filename) {
        GridFSDBFile file = gridFsOperations.findOne(Query.query(GridFsCriteria.whereFilename().is(filename)));
        return (file != null) ? new PersistedFile(file.getFilename(), file.getInputStream()) : null;
	}

	@Override
	public boolean exists(String filename) {
        GridFSDBFile file = gridFsOperations.findOne(Query.query(GridFsCriteria.whereFilename().is(filename)));
        return (file != null) ? true : false;
	}

	@Override
	public Iterable<PersistedFile> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PersistedFile> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String filename) {
		 gridFsOperations.delete(Query.query(GridFsCriteria.whereFilename().is(filename)));
		
	}

	@Override
	public void delete(PersistedFile entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends PersistedFile> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
