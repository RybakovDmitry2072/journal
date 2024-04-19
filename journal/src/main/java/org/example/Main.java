package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        JsonDeserilialize s=new JsonDeserilialize();
        System.out.println(s.parse());
    }
    public static void ma() {
        try (FileInputStream fileInputStream=
             new FileInputStream("C:\\Users\\user\\Desktop\\Книга1.xlsx");
             Workbook workbook=new XSSFWorkbook(fileInputStream)){
            Journal journal=new Journal();
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                Subject subject = new Subject(sheet.getRow(0).getCell(0).getStringCellValue());
                Professor professor = new Professor(sheet.getRow(1).getCell(0).getStringCellValue(),
                        subject);
                int course = (int) sheet.getRow(2).getCell(1).getNumericCellValue();
                List<Student> studentList = new ArrayList<>();

                for (int rowNum = 4; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    Map<Subject, List<Integer>> subjectListMap = new HashMap<>();
                    List<Integer> grades = new ArrayList<>();
                    String name = row.getCell(1).getStringCellValue();
                    if (row != null) {
                        for (int cellNum = 2; cellNum < row.getLastCellNum(); cellNum++) {
                            Cell cell = row.getCell(cellNum);
                            if (cell != null) {
                                grades.add((int) cell.getNumericCellValue());
                            }
                        }
                    }
                    subjectListMap.put(subject, grades);
                    Student student = new Student(name, course, subjectListMap);
                    studentList.add(student);
                }
                journal.getProfessorList().add(professor);
                journal.getStudentList().addAll(studentList);
                journal.getSubjectList().add(subject);
            }

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(journal);
            WriteInJson writeInJson=new WriteInJson();
            writeInJson.writeInJson(json);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}