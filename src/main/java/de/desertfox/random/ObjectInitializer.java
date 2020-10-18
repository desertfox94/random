package de.desertfox.random;

import de.desertfox.random.annotation.Name;
import de.desertfox.random.person.Gender;
import de.desertfox.random.person.Names;

import java.lang.reflect.Field;

import static de.desertfox.random.person.Gender.FEMALE;
import static de.desertfox.random.person.Gender.MALE;

public class ObjectInitializer {

	private final Names names;

	public ObjectInitializer() {
		this(new Names());
	}

	ObjectInitializer(Names names) {
		this.names = names;
	}

	public <T> T init(Class<T> clazz) {
		T o = null;
		try {
			o = clazz.newInstance();
			init(o);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return o;
	}

	public void init(Object o) {
		Class<?> clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			setField(o, field, clazz);
			field.setAccessible(accessible);
		}
	}

	private void setField(Object o, Field field, Class<?> clazz) {
		initNameField(o, field, clazz);
	}

	private void initNameField(Object o, Field field, Class<?> clazz) {
		Name name = field.getDeclaredAnnotation(Name.class);
		if (name != null) {
			Gender gender = name.gender();
			String value;
			if (gender == MALE) {
				value = name.fullName() ? names.fullMaleName() : names.maleName();
			} else if(gender == FEMALE) {
				value = name.fullName() ? names.fullFemaleName() : names.femaleName();
			} else {
				value = name.fullName() ? names.fullName() : names.foreName();
			}
			try {
				field.set(o, value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
