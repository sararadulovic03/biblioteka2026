package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {
	
	BibliotekaInterface b;
	Knjiga k1,k2,k3;
	
	public abstract BibliotekaInterface getInstance();

	@BeforeEach
	void setUp() throws Exception {
		b=getInstance();
		
		k1= new Knjiga();
		k1.setIsbn(123);
		
		k2= new Knjiga();
		k2.setIsbn(456);
		
		k3= new Knjiga();
		k3.setIsbn(789);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		b= null;
	}

	@Test
	void testDodajKnjigu() {
		b.dodajKnjigu(k1);
		b.dodajKnjigu(k2);
		
		List<Knjiga> knjige = b.VratiSveKnjige();
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k1));
		assertTrue(knjige.contains(k2));
	}
	
	@Test
	void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class, ()-> b.dodajKnjigu(null));
	}
	
	@Test
	void testDodajKnjiguDuplikat() {
		b.dodajKnjigu(k1);
		k2.setIsbn(123);
		assertThrows(java.lang.IllegalArgumentException.class, ()-> b.dodajKnjigu(k2));;
	}

	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class, () -> b.obrisiKnjigu(null));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		b.dodajKnjigu(k1);
		b.dodajKnjigu(k2);
		
		assertThrows(java.lang.IllegalArgumentException.class, () -> b.obrisiKnjigu(k3));
	}
	
	@Test
	void testObrisiKnjigu() {
		b.dodajKnjigu(k1);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		
		b.obrisiKnjigu(k2);
		
		List<Knjiga> knjige = b.VratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k1));
		assertTrue(knjige.contains(k3));
	}


	@Test
	void testPronadjiKnjiguSveNull() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> b.pronadjiKnjigu(null, 0, null, null));
	}

	@Test
	void testPronadjiKnjiguPrazno() {
		k1.setNaslov("Knjiga 1");
		k2.setNaslov("Knjiga 2");
		k3.setNaslov("Knjiga 3");
		
		b.dodajKnjigu(k1);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		
		List<Knjiga> knjige = b.pronadjiKnjigu(null, 0, "Gospodar", null);
		
		assertEquals(0, knjige.size());
		
	}
	
	@Test
	void testPronadjiKnjiguJednaKnjiga() {
		k1.setNaslov("Knjiga 1");
		k2.setNaslov("1 gospodar prstenova");
		k3.setNaslov("Knjiga 3");
		
		b.dodajKnjigu(k1);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		
		List<Knjiga> knjige = b.pronadjiKnjigu(null, 0, "Gospodar", null);
		
		assertEquals(1, knjige.size());
	}
	
	@Test
	void testPronadjiKnjiguViseKnjiga() {
		k1.setNaslov("Knjiga 1");
		k2.setNaslov("1 gospodar prstenova");
		k3.setNaslov("2 Gospodar prstenova");
		
		b.dodajKnjigu(k1);
		b.dodajKnjigu(k2);
		b.dodajKnjigu(k3);
		
		List<Knjiga> knjige = b.pronadjiKnjigu(null, 0, "Gospodar", null);
		
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k2));
		assertTrue(knjige.contains(k3));
	}
}
