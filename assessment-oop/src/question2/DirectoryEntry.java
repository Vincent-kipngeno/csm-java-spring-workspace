package question2;

class DirectoryEntry {
	static Integer count = 0;
    private String name;
    private String address;
    private String telephoneNumber;
    private String mobileNumber;
    private String headOfFamily;
    private Integer uniqueID;

    public DirectoryEntry(String name, String address, String telephoneNumber, String mobileNumber,
                          String headOfFamily) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.mobileNumber = mobileNumber;
        this.headOfFamily = headOfFamily;
        this.uniqueID = count++;
    }
    
    public DirectoryEntry(String name, String address, String headOfFamily) {
		this.name = name;
		this.address = address;
		this.headOfFamily = headOfFamily;
		this.uniqueID = count++;
	}

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHeadOfFamily() {
        return headOfFamily;
    }

    public Integer getUniqueID() {
        return uniqueID;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setHeadOfFamily(String headOfFamily) {
		this.headOfFamily = headOfFamily;
	}

	public void setUniqueID(Integer uniqueID) {
		this.uniqueID = uniqueID;
	}

	@Override
	public String toString() {
		return "DirectoryEntry [name=" + name + ", address=" + address + ", telephoneNumber=" + telephoneNumber
				+ ", mobileNumber=" + mobileNumber + ", headOfFamily=" + headOfFamily + ", uniqueID=" + uniqueID + "]";
	}
    
    
}
