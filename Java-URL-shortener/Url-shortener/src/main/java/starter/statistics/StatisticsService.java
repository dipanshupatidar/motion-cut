package starter.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StatisticsService {
	@Autowired
	StatisticsRepository statisticsRepository;



	public Map<String, Integer> getUserStat(String name)
	{
		Map<String, Integer> map = new HashMap<String,Integer>();

		List<Statistics>  stat = new ArrayList<>();

		statisticsRepository.findByUserStat(name).forEach(stat::add);

		for(int i=0; i<stat.size(); i++)
		{
			map.put(stat.get(i).getUrlStat(), stat.get(i).getNumberOfRedirects());

		}

		return map;

	}
}
