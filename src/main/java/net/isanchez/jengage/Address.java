package net.isanchez.jengage;

public class Address {
	private String formatted;
	private String streetAddress;
	private String locality;
	private String region;
	private String postalCode;
	private String country;

	public String getFormatted() {
		return formatted;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getLocality() {
		return locality;
	}

	public String getRegion() {
		return region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;

		if (country != null ? !country.equals(address.country) : address.country != null) return false;
		if (formatted != null ? !formatted.equals(address.formatted) : address.formatted != null) return false;
		if (locality != null ? !locality.equals(address.locality) : address.locality != null) return false;
		if (postalCode != null ? !postalCode.equals(address.postalCode) : address.postalCode != null) return false;
		if (region != null ? !region.equals(address.region) : address.region != null) return false;
		if (streetAddress != null ? !streetAddress.equals(address.streetAddress) : address.streetAddress != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = formatted != null ? formatted.hashCode() : 0;
		result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
		result = 31 * result + (locality != null ? locality.hashCode() : 0);
		result = 31 * result + (region != null ? region.hashCode() : 0);
		result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
		result = 31 * result + (country != null ? country.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Address{" +
				"formatted='" + formatted + '\'' +
				", streetAddress='" + streetAddress + '\'' +
				", locality='" + locality + '\'' +
				", region='" + region + '\'' +
				", postalCode='" + postalCode + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}
