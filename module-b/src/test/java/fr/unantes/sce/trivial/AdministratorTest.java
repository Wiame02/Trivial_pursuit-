package fr.unantes.sce.trivial;

import java.lang.reflect.Field;

import fr.unantes.sce.trivial.model.Administrator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AdministratorTest
{
	Administrator admin;

	@BeforeEach
	public void setUp() throws Exception
	{
		admin = Administrator.getInstance();
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		// Les 3 instructions suivantes permettent de tester n'importe quel Singleton gr�ce � l'introspection.
		Field instance = Administrator.class.getDeclaredField("instance");// On r�cup�re l'attribut "instance".
		// que l'on place dans un objet "Field".
		instance.setAccessible(true); // On rend l'objet "Field" accessible.
		instance.set(null, null);// On donne la valeur null � l'attribut "instance".
		admin = null; // On donne la valeur null au r�f�rent de l'instance.
	}

	@Test
	public void testGetInstance() 
	{
		assertTrue(admin == Administrator.getInstance());
	}
	
}
