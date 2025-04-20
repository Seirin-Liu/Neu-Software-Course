package reflect;

public class People {
	private String name;
	private String mobilePhone;
	private String company;
	
	public People() {
		super();
	}

	public People(String name, String mobilePhone, String company) {
		super();
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:"+name+", Mobile Phnoe:"+mobilePhone+", Company:"+company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final People other = (People) obj;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
