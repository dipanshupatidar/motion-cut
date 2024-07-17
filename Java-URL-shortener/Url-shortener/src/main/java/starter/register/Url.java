package starter.register;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq", initialValue=10000, allocationSize=100)
public class Url {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private long idUrl;
	private String longUrl;
	private String redirectType;
	
	
	public String getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(String redirectType) {
		this.redirectType = redirectType;
	}

	public Url() {
		
	}
	
	public Url(String longUrl, String redirectType) {
		super();
		this.longUrl = longUrl;
		this.redirectType= redirectType;
	}


	public long getIdUrl() {
		return idUrl;
	}

	public void setIdUrl(long idUrl) {
		this.idUrl = idUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	

}
