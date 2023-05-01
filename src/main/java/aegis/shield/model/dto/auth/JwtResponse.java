/**
 * 
 */
package aegis.shield.model.dto.auth;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 14:04:43 - 01/05/2023
 *
 */
public class JwtResponse {

	private String token;
	private String type;
	private String username;

	public JwtResponse(String token, String username) {
		super();
		this.token = token;
		this.type = "Bearer";
		this.username = username;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
