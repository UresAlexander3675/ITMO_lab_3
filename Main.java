import Enums.*;
import Items.*;
import People.*;
import Enums.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Puaro puaro = new Puaro(Role.DETECTIVE, 76);
        MonsieurBouc monsieurBouc = new MonsieurBouc(Role.DETECTIVE, 81);
        Ratchett ratchett = new Ratchett(Role.VICTIM, 100);

        System.out.println(puaro.introduce(ratchett));
        puaro.presentFirstVersion();

        System.out.println("========");
        System.out.println(monsieurBouc.discuss());
        System.out.println("========");
        try{
            puaro.presentSecondVersion();
        } catch (CompartmentLockedException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<ClueType> clueTypes = new ArrayList<>();
        clueTypes.add(ClueType.BROKEN_CLOCK);
        clueTypes.add(ClueType.FOOTPRINT);
        clueTypes.add(ClueType.BLOOD_STAIN);
        puaro.investigate(clueTypes);
    }
}
