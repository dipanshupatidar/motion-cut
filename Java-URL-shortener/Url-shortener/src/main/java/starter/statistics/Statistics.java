package starter.statistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Statistics {
	@Id @GeneratedValue
	private int idStat;
	private String  userStat;
	private  String urlStat;
	private int numberOfRedirects;
	
	public Statistics(String userstat, String urlstat, int numberOfRedirects) {
		super();
		this.userStat = userstat;
		this.urlStat = urlstat;
		this.numberOfRedirects = numberOfRedirects;
	}
	
	public Statistics() {
		
	}

	public String getUserStat() {
		return userStat;
	}

	public void setUserStat(String userStat) {
		this.userStat = userStat;
	}

	public String getUrlStat() {
		return urlStat;
	}

	public void setUrlStat(String urlStat) {
		this.urlStat = urlStat;
	}

	public int getNumberOfRedirects() {
		return numberOfRedirects;
	}

	public void setNumberOfRedirects(int numberOfRedirects) {
		this.numberOfRedirects = numberOfRedirects;
	}
	

}
