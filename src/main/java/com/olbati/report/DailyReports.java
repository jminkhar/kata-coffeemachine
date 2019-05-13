package com.olbati.report;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.olbati.beans.DrinkBean;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DailyReports {

    public boolean record(DrinkBean drinkRequested) {
        JSONObject jsonObject = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        DailyReportsObject dailyReportsObject = null;

        try {
            File src = new File("/Users/jminkhar/IdeaProjects/coffeemachine/src/main/resources/report.json");

            if (!src.exists()) {
                src.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(src));
                writer.write((new JSONObject()).toString());
                writer.close();
            }
            dailyReportsObject = mapper.readValue(src, DailyReportsObject.class);

            switch (drinkRequested.getDrink()) {
                case "TEA":
                    dailyReportsObject.addTea();
                    break;
                case "COFFEE":
                    dailyReportsObject.addCoffee();
                    break;
                case "CHOCOLATE":
                    dailyReportsObject.addChocolate();
                    break;
                case "EXTRA_HOT_TEA":
                    dailyReportsObject.addHotTea();
                    break;
                case "EXTRA_HOT_COFFEE":
                    dailyReportsObject.addHotCoffee();
                    break;
                case "EXTRA_HOT_CHOCOLATE":
                    dailyReportsObject.addHotChocolate();
                    break;
                case "ORANGE":
                    dailyReportsObject.addOrange();
                    break;
            }
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            System.out.println(dailyReportsObject.toString());
            writer.writeValue(src, dailyReportsObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
