package starter.account;




import org.springframework.data.repository.CrudRepository;



public interface AccountRepository extends CrudRepository<Account,Long>
{

	Account findOneByUsername(String username);

}
