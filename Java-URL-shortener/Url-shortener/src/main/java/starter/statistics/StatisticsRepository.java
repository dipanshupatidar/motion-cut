package starter.statistics;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

;



public interface StatisticsRepository extends CrudRepository <Statistics,Integer>{

	Statistics findByUrlStatAndUserStat(String urlStat, String userStat);
	List <Statistics> findByUserStat(String userStat);
	
}
