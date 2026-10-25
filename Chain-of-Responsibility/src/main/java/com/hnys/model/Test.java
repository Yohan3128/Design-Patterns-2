package com.hnys.model;

class Patient {
    private final String name;
    private final String symptom;

    public Patient(String name, String symptom) {
        this.name = name;
        this.symptom = symptom;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }
}


abstract class Doctor {
    public abstract void handle(Patient patient);
}


class GeneralDoctor extends Doctor {

    Specialist specialist;

    public void handle(Patient patient) {

        if (patient.getSymptom().equalsIgnoreCase("Fever")) {
            System.out.println("General Doctor: Treating " + patient.getName() + " for " + patient.getSymptom());
        } else {
            specialist.handle(patient);
        }
    }
}

class Specialist extends Doctor {
    Consultant consultant;

    public void handle(Patient patient) {
        if (patient.getSymptom().equalsIgnoreCase("Chest Pain")) {
            System.out.println("Specialist: Treating " + patient.getName() + " for " + patient.getSymptom());
        } else {
            consultant.handle(patient);
        }
    }
}

class Consultant extends Doctor {

    public void handle(Patient patient) {
        if (patient.getSymptom().equalsIgnoreCase("Heart Problem")) {
            System.out.println("Consultant: Treating " + patient.getName() + " for " + patient.getSymptom());
        } else {
            System.out.println("Consultant: No treatment available for " + patient.getName() + " with symptom " + patient.getSymptom());
        }
    }

}


public class Test {

    public static void main(String[] args) {

        Patient patient = new Patient("Silva", "Heart Problem");

        GeneralDoctor generalDoctor = new GeneralDoctor();
        Specialist specialist = new Specialist();
        Consultant consultant = new Consultant();

        generalDoctor.specialist = specialist;
        specialist.consultant = consultant;

        generalDoctor.handle(patient);
    }
}
