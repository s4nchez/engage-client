package net.isanchez.engage;

public class Profile {
	private String identifier;
	private String providerName;
	private String primaryKey;
	private String displayName;
	private String preferredUsername;
	private Name name;
	private String gender;
	private String birthday;
	private String utcOffset;
	private String email;
	private String verifiedEmail;
	private String url;
	private String phoneNumber;
	private String photo;
	private Address address;
	private boolean limitedData;

	public Profile() {
	}

	public Profile(String displayName, String preferredUsername, String url, String providerName, String identifier) {
		this.displayName = displayName;
		this.preferredUsername = preferredUsername;
		this.url = url;
		this.providerName = providerName;
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getProviderName() {
		return providerName;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getPreferredUsername() {
		return preferredUsername;
	}

	public Name getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getUtcOffset() {
		return utcOffset;
	}

	public String getEmail() {
		return email;
	}

	public String getVerifiedEmail() {
		return verifiedEmail;
	}

	public String getUrl() {
		return url;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPhoto() {
		return photo;
	}

	public Address getAddress() {
		return address;
	}

	public boolean isLimitedData() {
		return limitedData;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Profile profile = (Profile) o;

		if (limitedData != profile.limitedData) return false;
		if (address != null ? !address.equals(profile.address) : profile.address != null) return false;
		if (birthday != null ? !birthday.equals(profile.birthday) : profile.birthday != null) return false;
		if (displayName != null ? !displayName.equals(profile.displayName) : profile.displayName != null) return false;
		if (email != null ? !email.equals(profile.email) : profile.email != null) return false;
		if (gender != null ? !gender.equals(profile.gender) : profile.gender != null) return false;
		if (identifier != null ? !identifier.equals(profile.identifier) : profile.identifier != null) return false;
		if (name != null ? !name.equals(profile.name) : profile.name != null) return false;
		if (phoneNumber != null ? !phoneNumber.equals(profile.phoneNumber) : profile.phoneNumber != null) return false;
		if (photo != null ? !photo.equals(profile.photo) : profile.photo != null) return false;
		if (preferredUsername != null ? !preferredUsername.equals(profile.preferredUsername) : profile.preferredUsername != null)
			return false;
		if (primaryKey != null ? !primaryKey.equals(profile.primaryKey) : profile.primaryKey != null) return false;
		if (providerName != null ? !providerName.equals(profile.providerName) : profile.providerName != null)
			return false;
		if (url != null ? !url.equals(profile.url) : profile.url != null) return false;
		if (utcOffset != null ? !utcOffset.equals(profile.utcOffset) : profile.utcOffset != null) return false;
		if (verifiedEmail != null ? !verifiedEmail.equals(profile.verifiedEmail) : profile.verifiedEmail != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = identifier != null ? identifier.hashCode() : 0;
		result = 31 * result + (providerName != null ? providerName.hashCode() : 0);
		result = 31 * result + (primaryKey != null ? primaryKey.hashCode() : 0);
		result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
		result = 31 * result + (preferredUsername != null ? preferredUsername.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		result = 31 * result + (utcOffset != null ? utcOffset.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (verifiedEmail != null ? verifiedEmail.hashCode() : 0);
		result = 31 * result + (url != null ? url.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		result = 31 * result + (photo != null ? photo.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (limitedData ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Profile{" +
				"identifier='" + identifier + '\'' +
				", providerName='" + providerName + '\'' +
				", primaryKey='" + primaryKey + '\'' +
				", displayName='" + displayName + '\'' +
				", preferredUsername='" + preferredUsername + '\'' +
				", name=" + name +
				", gender='" + gender + '\'' +
				", birthday='" + birthday + '\'' +
				", utcOffset='" + utcOffset + '\'' +
				", email='" + email + '\'' +
				", verifiedEmail='" + verifiedEmail + '\'' +
				", url='" + url + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", photo='" + photo + '\'' +
				", address=" + address +
				", limitedData=" + limitedData +
				'}';
	}
}
