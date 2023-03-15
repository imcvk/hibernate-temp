package join_table.main;

import join_table.dao.AnimalDAO;
import join_table.model.ForgeModelObjects;
import join_table.model.Mammals;
import join_table.model.Reptiles;

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
