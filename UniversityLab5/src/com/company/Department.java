package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Department {
    public static class Worker {
        private String name;
        private String surname;
        private String position;

        public Worker(String name, String surname, String position) {
            this.name = name;
            this.surname = surname;
            this.position = position;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getSurname() { return surname; }
        public void setSurname(String surname) { this.surname = surname; }

        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Worker worker = (Worker) o;
            return Objects.equals(name, worker.name) &&
                    Objects.equals(surname, worker.surname) &&
                    Objects.equals(position, worker.position);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, position);
        }

        @Override
        public String toString() {
            return name + ' ' +
                     surname +
                    ", position = " + position;
        }

        public void changePosition(String newPos) {
            this.position = newPos;
        }
    }

    public class Logger {
        private Map<Worker, String> currentPositions = new HashMap<>();
        private Map<String, ArrayList<Worker>> positionHistory = new HashMap<>();

        public void update(Worker worker, String newPos) {
            ArrayList<Worker> temp = positionHistory.get(newPos);
            if(temp == null) {
                ArrayList<Worker> tempList = new ArrayList<>();
                tempList.add(worker);
                positionHistory.put(newPos, tempList);
            } else {
                temp.add(worker);
            }
            worker.setPosition(newPos);
            currentPositions.put(worker, newPos);
        }

        public Map<Worker, String> getCurrentPositions() { return currentPositions; }
        public Map<String, ArrayList<Worker>> getPositionHistory() { return positionHistory; }
    }

    public void getOpen() {
        System.out.println("Department has opened!");
    }
}
