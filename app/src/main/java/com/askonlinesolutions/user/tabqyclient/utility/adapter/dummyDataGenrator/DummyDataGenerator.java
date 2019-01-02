package com.askonlinesolutions.user.tabqyclient.utility.adapter.dummyDataGenrator;


import java.util.ArrayList;
import java.util.List;

public class DummyDataGenerator {


    public static List<String> getDummyStringList(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + "");
        }
        return list;
    }

    public static List<BankModel> getBankList() {
        List<BankModel> bankList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BankModel model = new BankModel();
            switch (i) {
                case 0:
                    model.setBankName("Axis Bank");
                    break;
                case 1:
                    model.setBankName("Bank Of Baroda");
                    break;
                case 2:
                    model.setBankName("Bank Of India");
                    break;
                case 3:
                    model.setBankName("City Bank");
                    break;
                case 4:
                    model.setBankName("Dena Bank");
                    break;
                case 5:
                    model.setBankName("HDFC Bank");
                    break;
                case 6:
                    model.setBankName("IDFC Bank");
                    break;
                case 7:
                    model.setBankName("ICICI Bank");
                    break;
                case 8:
                    model.setBankName("IndusInd Bank");
                    break;
                case 9:
                    model.setBankName("State Bank Of India");
                    break;
            }
            bankList.add(model);
        }
        return bankList;
    }

}
