package net.isanchez.jengage;

public class AccessCredentials {
	private String type;
	private String oauthType;
	private String oauthTokenSecret;
	private String uid;
	private String sessionKey;
	private String expires;
	private String eact;

	public String getType() {
		return type;
	}

	public String getOauthType() {
		return oauthType;
	}

	public String getOauthTokenSecret() {
		return oauthTokenSecret;
	}

	public String getUid() {
		return uid;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public String getExpires() {
		return expires;
	}

	public String getEact() {
		return eact;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AccessCredentials that = (AccessCredentials) o;

		if (eact != null ? !eact.equals(that.eact) : that.eact != null) return false;
		if (expires != null ? !expires.equals(that.expires) : that.expires != null) return false;
		if (oauthTokenSecret != null ? !oauthTokenSecret.equals(that.oauthTokenSecret) : that.oauthTokenSecret != null)
			return false;
		if (oauthType != null ? !oauthType.equals(that.oauthType) : that.oauthType != null) return false;
		if (sessionKey != null ? !sessionKey.equals(that.sessionKey) : that.sessionKey != null) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;
		if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (oauthType != null ? oauthType.hashCode() : 0);
		result = 31 * result + (oauthTokenSecret != null ? oauthTokenSecret.hashCode() : 0);
		result = 31 * result + (uid != null ? uid.hashCode() : 0);
		result = 31 * result + (sessionKey != null ? sessionKey.hashCode() : 0);
		result = 31 * result + (expires != null ? expires.hashCode() : 0);
		result = 31 * result + (eact != null ? eact.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "AccessCredentials{" +
				"type='" + type + '\'' +
				", oauthType='" + oauthType + '\'' +
				", oauthTokenSecret='" + oauthTokenSecret + '\'' +
				", uid='" + uid + '\'' +
				", sessionKey='" + sessionKey + '\'' +
				", expires='" + expires + '\'' +
				", eact='" + eact + '\'' +
				'}';
	}
}
