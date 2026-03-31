package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.interfejs.BibliotekaInterface;
import biblioteka.interfejs.BibliotekaInterfaceTest;

class BibliotekaTest extends BibliotekaInterfaceTest{

	@Override
	public BibliotekaInterface getInstance() {
		return new Biblioteka();
	}

}
