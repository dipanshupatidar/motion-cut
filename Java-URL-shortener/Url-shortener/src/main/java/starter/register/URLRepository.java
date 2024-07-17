package starter.register;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;





public interface URLRepository extends CrudRepository<Url,Long>
{
	Optional<Url> findBylongUrl(String longUrl);
	Optional<Url> findByidUrl(long id);
}
