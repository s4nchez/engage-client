package net.isanchez.engage;

public class Name {
	private String formatted;
	private String familyName;
	private String givenName;
	private String middleName;
	private String honorificPrefix;
	private String honorificSuffix;

	public String getFormatted() {
		return formatted;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getHonorificPrefix() {
		return honorificPrefix;
	}

	public String getHonorificSuffix() {
		return honorificSuffix;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Name name = (Name) o;

		if (familyName != null ? !familyName.equals(name.familyName) : name.familyName != null) return false;
		if (formatted != null ? !formatted.equals(name.formatted) : name.formatted != null) return false;
		if (givenName != null ? !givenName.equals(name.givenName) : name.givenName != null) return false;
		if (honorificPrefix != null ? !honorificPrefix.equals(name.honorificPrefix) : name.honorificPrefix != null)
			return false;
		if (honorificSuffix != null ? !honorificSuffix.equals(name.honorificSuffix) : name.honorificSuffix != null)
			return false;
		if (middleName != null ? !middleName.equals(name.middleName) : name.middleName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = formatted != null ? formatted.hashCode() : 0;
		result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
		result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
		result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
		result = 31 * result + (honorificPrefix != null ? honorificPrefix.hashCode() : 0);
		result = 31 * result + (honorificSuffix != null ? honorificSuffix.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Name{" +
				"formatted='" + formatted + '\'' +
				", familyName='" + familyName + '\'' +
				", givenName='" + givenName + '\'' +
				", middleName='" + middleName + '\'' +
				", honorificPrefix='" + honorificPrefix + '\'' +
				", honorificSuffix='" + honorificSuffix + '\'' +
				'}';
	}
}
