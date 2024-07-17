package starter.statistics;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StatisticsContoller {
	@Autowired
	StatisticsService stat;

	@GetMapping("/statistics/{id}")

	public Map<String,Integer> userStatstics(@PathVariable String id)
	{
		return  stat.getUserStat(id);
	}

}
