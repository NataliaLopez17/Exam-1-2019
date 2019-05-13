import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PatientTest {

	private static final double EPSILON = 0.000001;

	private Patient pepe, nana, tito, ana;

	@Before
	public void setUP() {
		pepe = new Patient("Jose", "Diego", "Cruz Soto", 48, 85, Patient.BloodType.O, Patient.RH.NEG, Patient.Sex.MALE );
		nana = new Patient("Nancy", "L", "Fas Mari", 70, 195, Patient.BloodType.O, Patient.RH.POS,Patient.Sex.FEMALE );
		tito = new Patient("Juan", "Jose", "Soto Detres", 72, 205, Patient.BloodType.AB, Patient.RH.POS,Patient.Sex.MALE );
	    ana = new Patient("Ana", "M", "Cruz Detres", 60, 140, Patient.BloodType.AB, Patient.RH.NEG,Patient.Sex.FEMALE );		
	}

	@Test
	public void testCopyContructor() {
		Patient pepito = new Patient(pepe);
		assertFalse("Copy contructor does not return new object", pepito == pepe);
		assertEquals("Copy constructor returns different object", pepito, pepe);
	}

	@Test
	public void testGetBMI(){
		assertEquals("The BMI is incorrect.", 25.9353298, pepe.getBMI(),EPSILON);
		assertEquals("The BMI is incorrect.", 27.9765306, nana.getBMI(),EPSILON);
		assertEquals("The BMI is incorrect.", 27.7999614, tito.getBMI(),EPSILON);
	}
	

	@Test
	public void testTagPatient(){
		pepe.tagPatient();
		assertTrue("Tag length should be more that 4", pepe.getPatientTag().length() > 4);		
		assertTrue("Problem with 4th digit",
				Character.isDigit(pepe.getPatientTag().charAt(pepe.getPatientTag().length()-1)));
		assertTrue("Problem with 3rd digit", 
				Character.isDigit(pepe.getPatientTag().charAt(pepe.getPatientTag().length()-2)));
		assertTrue("Problem with 2nd digit", 
				Character.isDigit(pepe.getPatientTag().charAt(pepe.getPatientTag().length()-3)));
		assertTrue("Problem with 1st digit", 
				Character.isDigit(pepe.getPatientTag().charAt(pepe.getPatientTag().length()-4)));
		String oldTag = pepe.getPatientTag();
		
		pepe.tagPatient();
		assertNotEquals("Generated Tags are not random",oldTag, pepe.getPatientTag());
	}

	@Test
	public void testIsUniversalDonor() {
		assertTrue(pepe.isUniversalDonor() );
		assertFalse(nana.isUniversalDonor() );
		assertFalse(tito.isUniversalDonor() );
		assertFalse(ana.isUniversalDonor() );
	}
	
	@Test
	public void testHasCompatibleRHFactor() {
		assertFalse(pepe.hasCompatibleRHFactor(nana) );
		assertTrue(nana.hasCompatibleRHFactor(tito) );
		assertTrue(tito.hasCompatibleRHFactor(ana) );
		assertTrue(ana.hasCompatibleRHFactor(pepe) );
	}	

}