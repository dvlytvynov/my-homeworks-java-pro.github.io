package homework.multimodule.project.application;

import homework.multimodule.project.Creator;
import homework.multimodule.project.CsvReaderWriter;
import homework.multimodule.project.ExcelReaderWriter;
import homework.multimodule.project.ReaderWriter;

import java.io.File;
import java.util.List;

public class Application {
    public void apply() {
        char separator = File.separatorChar;
        String directory = "." + separator
                + "application" + separator
                + "src" + separator
                + "main" + separator
                + "resources";
        String csvFileName = "csv_table.csv";
        String excelFileName = "excel_table.xls";
        String path;
        ReaderWriter<List<List<String>>> csvReaderWriter = new CsvReaderWriter();
        ReaderWriter<List<List<String>>> excelReaderWriter = new ExcelReaderWriter();
        Creator<List<List<String>>> creator = new TableListCreator();
        List<List<String>> table = creator.create(5, new String[]{
                "1", "One", "January", "31", "Thirty one days",
                "2", "Two", "February", "28", "Twenty eight days",
                "3", "Three", "March", "31", "Thirty one days",
                "4", "Four", "April", "30", "Thirty days",
                "5", "Five", "May", "31", "Thirty one days",
                "6", "Six", "June", "30", "Thirty days",
                "7", "Seven", "July", "31", "Thirty one days",
                "8", "Eight", "August", "31", "Thirty one days",
                "9", "Nine", "September", "30", "Thirty days",
                "10", "Ten", "October", "31", "Thirty one days",
                "11", "Eleven", "November", "30", "Thirty days",
                "12", "Twelve", "December", "31", "Thirty one days",
        });
        path = directory + separator + csvFileName;
        System.out.println("\nWriting and then reading from file: " + path);
        csvReaderWriter.write(path, table);
        System.out.println(csvReaderWriter.read(path));
        path = directory + separator + excelFileName;
        System.out.println("\nWriting and then reading from file: " + path);
        excelReaderWriter.write(path, table);
        System.out.println(excelReaderWriter.read(path));
    }
}
