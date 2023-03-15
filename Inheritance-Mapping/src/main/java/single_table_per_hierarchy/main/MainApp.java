package single_table_per_hierarchy.main;

import single_table_per_hierarchy.dao.AnimalDAO;
import single_table_per_hierarchy.model.ForgeModelObjects;
import single_table_per_hierarchy.model.Mammals;
import single_table_per_hierarchy.model.Reptiles;

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
