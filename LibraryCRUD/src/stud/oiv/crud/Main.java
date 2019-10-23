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

    private void  BookDAOSaveTest()
    {
        FileBookDAO test = new FileBookDAO();
        var res = test.getAll();
        res.add(new StudyBook("Geometrics",150,"xz","Math"));
        res.add(new ArtBook("Война и мир",500,"Лев","Роман"));
        res.add(new Comics("IronMan",50,"Sten Li","Action","none"));
        test.saveBooksToFile(res);
    }
}

