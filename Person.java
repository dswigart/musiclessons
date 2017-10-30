import java.io.Serializable;

abstract class Person implements Serializable {
    
	private static final long serialVersionUID = 469265213089396130L;
	protected int mID;
    protected String mFirstName, mLastName, mStreet, mCity, mZip, mEmailAddress,
    mCellPhone, mBirthdate, mType;
    
    int getID(){
    	return mID;
    }
    
    String getName() {
    	String name = mFirstName + "." + mLastName;
    	return name;
    }
    String getFirstName() {
        return mFirstName;
    }
    
    String getLastName() {
        return mLastName;
    }
    
    String getStreet() {
        return mStreet;
    }
    
    String getCity() {
        return mCity;
    }
    
    String getZip() {
        return mZip;
    }
    
    String getEmailAddress() {
        return mEmailAddress;
    }
    
    String getCellPhone() {
        return mCellPhone;
    }
    
    String getBirthdate() {
        return mBirthdate;
    }
    
    String getType() {
        return mType;
    }
    
    void displayAttributes() {
        
        System.out.println("\n" + mFirstName + " " + mLastName);
        System.out.println(mStreet + " " + mCity + " " + mZip);
        
        System.out.println(mEmailAddress);
        System.out.println(mCellPhone + "\n");
        
    }
    
    void setID(int x) {
    	mID = x;
    }
    void setFirstName(String x) {
        mFirstName = x;
    }
    
    void setLastName(String x) {
        mLastName = x;
    }
    
    void setStreet(String x) {
        mStreet = x;
    }
    
    void setCity(String x) {
        mCity = x;
    }
    
    void setZip(String x) {
        mZip = x;
    }
    
    void setEmailAddress(String x) {
        mEmailAddress = x;
    }
    
    void setCellPhone(String x) {
        mCellPhone = x;
    }
    
    void setBirthdate(String x) {
        mBirthdate = x;
    }
    
    void setType(String x) {
        mType = x;
    }
}