package table_per_class.main;

import table_per_class.dao.AnimalDAO;
import table_per_class.model.ForgeModelObjects;
import table_per_class.model.Mammals;
import table_per_class.model.Reptiles;

public class MainApp {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            Reptiles reptiles = ForgeModelObjects.createReptiles();
            AnimalDAO.saveAnimal(reptiles);

            Mammals mammals = ForgeModelObjects.createMammals();
            AnimalDAO.saveAnimal(mammals);

        }
    }
}
