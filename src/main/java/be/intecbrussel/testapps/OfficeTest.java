package be.intecbrussel.testapps;

import be.intecbrussel.data.OfficeDaoImp;
import be.intecbrussel.entities.Office;

public class OfficeTest {

    public static void main(String[] args) {

        OfficeDaoImp officeApp = new OfficeDaoImp();

        Office office = officeApp.readOffice(1);
        //Office office2 = new Office("SAN KEREMINO","098765432","aqui ta", "aqui no","CA","USA","11030030","NA");
        //officeApp.createOffice(office2);
        Office office2 = officeApp.readOffice(8);
        office2.setCity("ANOTHER CITY");
        officeApp.updateOffice(office2);
        officeApp.deleteOffice(office2);
    }
}
