package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _06_ApachePOISteps {
    DialogContent dc = new DialogContent();
    @When("User Create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        //Excel'den oku citizenshipleri oluştur
        ArrayList<ArrayList<String>> list =
        ExcelUtility.getListData
                ("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen", 2);
        for (ArrayList<String> line : list) {
            dc.findAndClick("addButton");
            dc.findAndSend("nameInput", line.get(0));
            dc.findAndSend("shortNameInput", line.get(1));
            dc.findAndClick("saveButton");
            dc.findAndContainsText("successMessage","success");
        }
    }

    @When("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        //Excel'den oku citizenshipleri sil
        ArrayList<ArrayList<String>> list =
                ExcelUtility.getListData
                        ("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                                "testCitizen", 2);
        for (ArrayList<String> line : list) {
            dc.findAndDelete(line.get(0));
            dc.findAndContainsText("successMessage","success");
        }
    }
}
