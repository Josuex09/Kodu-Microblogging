package main.java.data;
import java.util.List;

public interface BaseRepository <T,K> {
	
	public List<T> findAll();

	public K findOne(K k);

	public K save(T t);

	public boolean exists(K k);

	public long count();

	public void delete(K k);

	public void deleteAll();
	
}
