package Oving9;

public class StudentsClient {
    public static void main(String[] args){    
        Student stud1 = new Student("Stud1", 1);
        Student stud2 = new Student("Stud2", 2);
        Student stud3 = new Student("Stud3", 3);


        Oppgaveoversikt studlist = new Oppgaveoversikt();
        
        
        studlist.newStudent(stud1);
        studlist.newStudent(stud2);
        studlist.newStudent(stud3);


        System.out.println(studlist.toString());
        System.out.println("Stud1 har lost: " + studlist.getAntallOppgaverForStudent("Stud1"));
        System.out.println("Stud5 har lost: " + studlist.getAntallOppgaverForStudent("Stud5"));
        studlist.økAntallOppgaverForStudent(0, 4);
        studlist.økAntallOppgaverForStudent("Stud2", 4);


        System.out.println(studlist.toString());
    }
}
