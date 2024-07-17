package starter.account;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AccountResponse {

	private boolean type;
	private String description;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String password;

	public AccountResponse() {

	}

	public AccountResponse(boolean type, String description, String password) {
		super();
		this.type = type;
		this.description = description;
		this.password = password;
	}

	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
