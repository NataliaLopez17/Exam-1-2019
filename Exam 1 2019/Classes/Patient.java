import java.util.Random;
import java.lang.String;

public class Patient {

	private static int lastRecordNumber = 0;

	private int recordNumber;
	private String patientTag;
	private String firstName;
	private String middleName;
	private String lastNames;
	private double height;
	private double weight;
	private BloodType bloodType;
	private RH rh;
	private Sex sex;

	public enum BloodType {
		AB, A, B, O
	}
	
	public enum RH{
		POS, NEG
	}

	public enum Sex {
		FEMALE, MALE, OTHER
	}

	// Constructors
	public Patient(String firstName, String middleName, String lastNames, double height, double weight, BloodType bloodType, RH rh, Sex sex) {
		this.recordNumber = lastRecordNumber++; 
		this.patientTag = "";  // Initials + random 4-digit number
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastNames = lastNames;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.rh = rh;
		this.sex = sex;
	}
	
	/**
	 *  Exercise #1
	 *  Copy Constructor creates a patient with the same properties as the
	 *  parameter patient, except for the unique identifiers: recordNumber
	 *  and patientTag)
	 */
	public Patient(Patient p) {
		

	}

	
	// Getters
	public int getRecordNumber() { return recordNumber; }
	public String getPatientTag() { return patientTag; }
	public String getFirstName() { return firstName; }
	public String getMiddleName() { return middleName; }
	public String getLastNames() { return lastNames; }
	public double getHeight() { return height; }
	public double getWeight() { return weight; }
	public BloodType getBloodType() { return bloodType; }
	public RH getRH() {return rh;}
	public Sex getSex() { return sex; }

	
	// Setters
	public void setRecordNumber(int recordNumber) { this.recordNumber = recordNumber; }
	public void setPatientTag(String patientTag) { this.patientTag = patientTag;}
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setMiddleName(String middleName) { this.middleName = middleName; }
	public void setLastNames(String lastNames) { this.lastNames = lastNames; }
	public void setHeight(double height) { this.height = height; }
	public void setWeight(double weight) { this.weight = weight; }
	public void setBloodType(BloodType bloodType) { this.bloodType = bloodType; }
	public void setSex(Sex sex) { this.sex = sex; }

	
	// Instance Methods
	
	/**
	 * Returns true if and only if both the target and the parameter objects
	 * have exactly the same attributes (except unique identifiers: recordNumber
	 * and patientTag) .  Returns false otherwise.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Patient)) { return false; }
		Patient c = (Patient) o;
		return ((c.firstName.equals(this.firstName)) &&
				(c.middleName.equals(this.middleName)) &&
				(c.lastNames.equals(this.lastNames)) &&
				(c.height == this.height)&&
				(c.weight == this.weight) &&
				(c.bloodType == this.bloodType) &&
				(c.sex == this.sex));
	}

	/**
	 * Get Initials -- Assumes all name fields have content and that
	 * two last names are separated by a space 
	 * 
	 */
	public String getInitials() {
		return getFirstName().substring(0,1) + getMiddleName().substring(0,1) + 
				getLastNames().substring(0,1) + 
				getLastNames().substring(getLastNames().indexOf(" ")+1,
						getLastNames().indexOf(" ")+2);
	}
				

	/**
	 *  Exercise #2
	 *  Method that returns the Body Mass Index (BMI) given 
	 *  the patient's weight in pounds & height in inches.
	 *  The BMI is 703 multiplied by the weight divided
	 *  by the square of the height
	 */
	public double getBMI() {
		return 0.0;
	}
	
	/**
	 *  Exercise #3
	 *  Creates and updates the patient's patientTag property.
	 *  The tag combines the patients initials with
	 *  a random 4-digit number. For example: BJVR4903
	 *  
	 *  Hint: use the getInitials() method above
	 */
	public void tagPatient() {
		

	}
	

    /**
     * Exercise #4
     * isUniversalDonor returns true for patients with
     * blood type O and RH Factor negative, false otherwise.
     */
	public boolean isUniversalDonor() {
		
		return false;
	}
	
	/**
	 * Exercise #5 
	 * Returns true if the target patient (recipient) and parameter (donor) 
	 * patient have compatible blood types. They are compatible if the donor
	 * has a negative RH factor or if the recipient has a positive RH factor.
	 * 
	 */
	public boolean hasCompatibleRHFactor(Patient p) {
		return false;
	}

}