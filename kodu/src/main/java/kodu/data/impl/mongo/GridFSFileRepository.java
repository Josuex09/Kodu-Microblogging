package kodu.data.impl.mongo;

import kodu.data.FileRepository;
import kodu.model.mongo.PersistedFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import com.mongodb.gridfs.GridFSDBFile;


@Repository
public class GridFSFileRepository implements FileRepository {


    @Autowired
    private GridFsOperations gridFsOperations;

    @Override
    public String create(PersistedFile image) {
        gridFsOperations.store(image.getInputStream(), image.getFilename());
        return image.getFilename();
    }

    @Override
    public PersistedFile findById(String filename) {
        GridFSDBFile file = gridFsOperations.findOne(Query.query(GridFsCriteria.whereFilename().is(filename)));
        return (file != null) ? new PersistedFile(file.getFilename(), file.getInputStream()) : null;
    }

    @Override
    public void update(PersistedFile image) {
        gridFsOperations.store(image.getInputStream(), image.getFilename());
    }

    @Override
    public void delete(String filename) {
        gridFsOperations.delete(Query.query(GridFsCriteria.whereFilename().is(filename)));
    }
}

