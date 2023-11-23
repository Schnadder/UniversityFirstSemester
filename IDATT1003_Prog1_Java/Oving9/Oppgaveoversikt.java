package Oving9;

public class Oppgaveoversikt {
    private Student[] studenter;
    private int antStud = 0;

    public Oppgaveoversikt(){}

    public int getAntallStudenter(){
        return antStud;
    }

    public int getAntallOppgaverForStudent(int studindex){
        return studenter[studindex].getAntOppg();
    }
    
    public int getAntallOppgaverForStudent(String studnavn){
        for (Student stud : studenter){
            if(stud.getNavn() == studnavn){
                return stud.getAntOppg();
            }
        }
        return -1;
    }

    public void newStudent(Student nystudent) {
        Student[] newStudenter = new Student[antStud + 1];
        for (int i = 0; i < antStud; i++) {
            newStudenter[i] = studenter[i];
        }
        newStudenter[newStudenter.length - 1] = nystudent;
        studenter = newStudenter;
        antStud += 1;
    }

    public void økAntallOppgaverForStudent(int studindex, int øking){
        studenter[studindex].økAntOppg(øking);
    }

    public void økAntallOppgaverForStudent(String studnavn, int øking){
        for (Student stud : studenter){
            if(stud.getNavn() == studnavn){
                stud.økAntOppg(øking);
            }
        }
    }

    public String toString(){
        String output = "Studenter: \n";
        for (Student student : studenter){
            output += student.toString();
        }
        return output;
    }
}
