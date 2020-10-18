package de.desertfox.random;

import de.desertfox.random.annotation.Name;
import de.desertfox.random.person.Gender;
import de.desertfox.random.person.Names;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ObjectInitializerTest {

	public static class NameAnnotated {

		@Name
		private String defaultName;

		@Name(gender = Gender.FEMALE)
		private String femaleFullName;

		@Name(gender = Gender.MALE)
		private String maleFullName;

		@Name(gender = Gender.NONE)
		private String noneGenderName;

		@Name(fullName = false, gender = Gender.FEMALE)
		private String femaleForename;

		@Name(fullName = false, gender = Gender.MALE)
		private String maleForename;

		@Name(fullName = false, gender = Gender.NONE)
		private String forename;

	}

	@Test
	public void test() {
		Names names = mock(Names.class);
		String maleForename = "Peter";
		String forename = "Petra";
		String surname = "Petersen";
		String fullName = forename + " " + surname;
		String maleFullName = maleForename + " " + surname;
		when(names.maleName()).thenReturn(maleForename);
		when(names.femaleName()).thenReturn(forename);
		when(names.foreName()).thenReturn(forename);
		when(names.surName()).thenReturn(surname);

		when(names.fullName()).thenReturn(fullName);
		when(names.fullFemaleName()).thenReturn(fullName);
		when(names.fullMaleName()).thenReturn(maleFullName);

		ObjectInitializer initializer = new ObjectInitializer(names);
		NameAnnotated object = initializer.init(NameAnnotated.class);

		assertEquals(fullName, object.defaultName);

		assertEquals(maleFullName, object.maleFullName);
		assertEquals(fullName, object.femaleFullName);
		assertEquals(fullName, object.noneGenderName);

		assertEquals(maleForename, object.maleForename);
		assertEquals(forename, object.femaleForename);
		assertEquals(forename, object.forename);
	}


}
