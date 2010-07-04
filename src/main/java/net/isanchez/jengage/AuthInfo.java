package net.isanchez.jengage;

import java.util.List;

public class AuthInfo {
	private Profile profile;
	private AccessCredentials accessCredentials;
	private List<String> friends;
	private Err err;
	private Stat stat;

	public AuthInfo() {
	}

	public AuthInfo(Profile profile) {
		this.profile = profile;
		this.stat = Stat.ok;
	}

	public Profile getProfile() {
		return profile;
	}

	public AccessCredentials getAccessCredentials() {
		return accessCredentials;
	}

	public List<String> getFriends() {
		return friends;
	}

	public Err getErr() {
		return err;
	}

	public Stat getStat() {
		return stat;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AuthInfo authInfo = (AuthInfo) o;

		if (accessCredentials != null ? !accessCredentials.equals(authInfo.accessCredentials) : authInfo.accessCredentials != null)
			return false;
		if (err != null ? !err.equals(authInfo.err) : authInfo.err != null) return false;
		if (friends != null ? !friends.equals(authInfo.friends) : authInfo.friends != null) return false;
		if (profile != null ? !profile.equals(authInfo.profile) : authInfo.profile != null) return false;
		if (stat != authInfo.stat) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = profile != null ? profile.hashCode() : 0;
		result = 31 * result + (accessCredentials != null ? accessCredentials.hashCode() : 0);
		result = 31 * result + (friends != null ? friends.hashCode() : 0);
		result = 31 * result + (err != null ? err.hashCode() : 0);
		result = 31 * result + (stat != null ? stat.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "AuthInfo{" +
				"profile=" + profile +
				", accessCredentials=" + accessCredentials +
				", friends=" + friends +
				", err=" + err +
				", stat=" + stat +
				'}';
	}
}
