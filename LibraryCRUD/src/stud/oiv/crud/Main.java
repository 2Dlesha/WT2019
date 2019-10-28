package stud.oiv.crud;
import stud.oiv.crud.beans.ArtBook;
import stud.oiv.crud.beans.Comics;
import stud.oiv.crud.beans.StudyBook;
import stud.oiv.crud.dao.impl.FileBookDAO;
import stud.oiv.crud.view.console.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        consoleView.Show();
        System.out.println("End");
    }
}

