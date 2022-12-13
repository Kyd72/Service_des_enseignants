package champollion;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;

	Intervention inter1CM, inter1TD, inter1TP;

	Intervention inter2;
	Salle B105 = new Salle("B105",20);
	Salle B106 = new Salle("B106",20);

		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");

		inter1CM = new Intervention(LocalDateTime.of(2022,12,15,8,15),4,TypeIntervention.CM,B105,uml );
		inter1TD = new Intervention(LocalDateTime.of(2022,12,15,8,15),5,TypeIntervention.TD,B105,uml );
		inter1TP = new Intervention(LocalDateTime.of(2022,12,15,8,15),6,TypeIntervention.TP,B105,uml );
		inter2 = new Intervention(LocalDateTime.of(2022,12,17,8,15),4,TypeIntervention.CM,B106,java );
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {

		UE bdd = new UE("Base de données");
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

		assertEquals(0, untel.heuresPrevuesPourUE(bdd),
				"L'enseignant doit avoir 0 heures pour l'UE 'uml car, enseignement non ajouté'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testResteAPlanifier(){

		//ii
		untel.ajouteEnseignement(uml, 10, 20, 10);
		untel.ajouteIntervention(inter1CM);//realise 4 heures de CM de uml
		untel.ajouteIntervention(inter1TD);//realise 5 heures de TD de uml
		untel.ajouteIntervention(inter1TP);//realise 6 heures de TP de uml

		assertEquals(10-(4), untel.resteAPlanifier(uml, TypeIntervention.CM),
				"L'enseignant doit maintenant avoir 6 heures à planifier pour l'UE 'uml'");

		assertEquals(20-(5), untel.resteAPlanifier(uml, TypeIntervention.TD),
				"L'enseignant doit maintenant avoir 15 heures à planifier pour l'UE 'uml'");
		assertEquals(10-(6), untel.resteAPlanifier(uml, TypeIntervention.TP),
				"L'enseignant doit maintenant avoir 4 heures à planifier pour l'UE 'uml'");

	}



	@Test
	public void testEstEnSousService (){

		//ii
		untel.ajouteEnseignement(uml, 80, 50, 10);

		assertTrue(untel.enSousService(), "L'enseignant doit être en sous service");

		untel.ajouteEnseignement(uml, 0, 30, 0);

		assertFalse(untel.enSousService(), "L'enseignant ne doit pas être en sous service");




	}


	
}
