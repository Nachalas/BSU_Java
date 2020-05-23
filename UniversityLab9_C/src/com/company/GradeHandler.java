package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GradeHandler {
    final String PATH = "F:/java epam/UniversityLab9_C/database/grades.txt";

    public String parseStudent(String student, double average) {
        StringTokenizer st = new StringTokenizer(student, " ");
        String name = st.nextToken();
        ArrayList<Integer> marks = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            int temp = Integer.parseInt(st.nextToken());
            marks.add(temp);
            sum += temp;
        }
        if(sum / 4. >= average) {
            return name.toUpperCase() + " " +
                    + marks.get(0) + " " + marks.get(1) + " " +
                    + marks.get(2) + " " + marks.get(3);
        } else {
            return name + " " +
                    + marks.get(0) + " " + marks.get(1) + " " +
                    + marks.get(2) + " " + marks.get(3);
        }
    }

    public void renewStudents() {
        new File("F:/java epam/UniversityLab9_C/database").mkdir();
        new File("F:/java epam/UniversityLab9_C/database/grades.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            writer.write("Ivanov 8 5 7 8");
            writer.newLine();
            writer.write("Olegov 9 10 4 8");
            writer.newLine();
            writer.write("Antonov 8 4 8 7");
            writer.newLine();
            writer.write("Dmitrin 10 10 7 7");
            writer.newLine();
            writer.write("Sotona 6 6 6 6");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeItalic(double average) {
        ArrayList<String> temp = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                temp.add(parseStudent(tempLine, average));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            for(var i : temp) {
                writer.write(i);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            writer.write(student);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
