package stud.oiv.crud.controller.command;

public interface Command {
    /**
     * <p>Выполняет определенную функцию слоя сервисов</p>
     * @param request Параметры, передаваемые ввиде одной строки
     */
    public String execute(String request);
}
