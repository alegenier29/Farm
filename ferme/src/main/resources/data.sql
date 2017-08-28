INSERT INTO TYPE_ANIMAL (ID, NOM) VALUES (1, 'Cheval');
INSERT INTO TYPE_ANIMAL (ID, NOM) VALUES (2, 'Cochon');
INSERT INTO TYPE_ANIMAL (ID, NOM) VALUES (3, 'Vache');
INSERT INTO TYPE_ANIMAL (ID, NOM) VALUES (4, 'Cat');

INSERT INTO FERMIER (ID, AGE, NOM) VALUES (1, '24','Tremblay');
INSERT INTO FERMIER (ID, AGE, NOM) VALUES (2, '50','Gagnon');
INSERT INTO FERMIER (ID, AGE, NOM) VALUES (3, '34','Roy');
INSERT INTO FERMIER (ID, AGE, NOM) VALUES (4, '50','Bouchard');
INSERT INTO FERMIER (ID, AGE, NOM) VALUES (5, '50','Dallaire');

INSERT INTO FERME (ID, FERME_NOM, ADRESSE, FERMIER_ID) VALUES (1, 'Ferme du Bassin', '1040, rang St-Jean-Baptiste', 1);
INSERT INTO FERME (ID, FERME_NOM, ADRESSE, FERMIER_ID) VALUES (2, 'Ferme Alpagas des Mondes Enchantés', '310, chemin du Petit Bernier', 2);
INSERT INTO FERME (ID, FERME_NOM, ADRESSE, FERMIER_ID) VALUES (3, 'Ferme La Bisonnière', '490, rang Sainte-Élizabeth', 3);
INSERT INTO FERME (ID, FERME_NOM, ADRESSE, FERMIER_ID) VALUES (4, 'Ferme éducative Panier nature', '11172, rang Double', 4);
INSERT INTO FERME (ID, FERME_NOM, ADRESSE, FERMIER_ID) VALUES (5, 'Ferme Ecomuseum Zoo', '21125 Sainte Marie Rd, Sainte-Anne-de-Bellevue', 5);


INSERT INTO ANIMAL (ID,TYPE_ANIMAL_ID, NOURRITURE_CONSOMME,FERME_ID) VALUES (1, 1,0,1);
INSERT INTO ANIMAL (ID,TYPE_ANIMAL_ID, NOURRITURE_CONSOMME,FERME_ID) VALUES (2, 2,0,2);
INSERT INTO ANIMAL (ID,TYPE_ANIMAL_ID, NOURRITURE_CONSOMME,FERME_ID) VALUES (3, 3,0,3);
INSERT INTO ANIMAL (ID,TYPE_ANIMAL_ID, NOURRITURE_CONSOMME,FERME_ID) VALUES (4, 4,0,4);
INSERT INTO ANIMAL (ID,TYPE_ANIMAL_ID, NOURRITURE_CONSOMME,FERME_ID) VALUES (5, 1,0,5);

INSERT INTO NOURRITURE_TYPE (ID,NOM,VALEUR_NUTRITIONELLE) VALUES (1, 'Fourrages', 100);
INSERT INTO NOURRITURE_TYPE (ID,NOM,VALEUR_NUTRITIONELLE) VALUES (2, 'Concentres', 100);
INSERT INTO NOURRITURE_TYPE (ID,NOM,VALEUR_NUTRITIONELLE) VALUES (3, 'Autres', 100);
INSERT INTO NOURRITURE_TYPE (ID,NOM,VALEUR_NUTRITIONELLE) VALUES (4, 'Autres2', 200);


INSERT INTO NOURRITURE (ID,NOM,TYPE_NOURRITURE_ID) VALUES (1, 'Foin', 1);
INSERT INTO NOURRITURE (ID,NOM,TYPE_NOURRITURE_ID) VALUES (2, 'Grain',2);
INSERT INTO NOURRITURE (ID,NOM,TYPE_NOURRITURE_ID) VALUES (3, 'Avoine', 3);
INSERT INTO NOURRITURE (ID,NOM,TYPE_NOURRITURE_ID) VALUES (4, 'Mais', 4);



INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (3,1,5);
INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (3,2,5);
INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (4,3,5);
INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (4,4,5);


INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (1,1,5);
INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (1,2,5);
INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (2,3,5);
INSERT INTO NOURRITURE_ANIMAL (ANIMAL_ID, NOURRITURE_ID, QUANTITE) VALUES (2,4,5);







