package theme8patterns.task3;

public class LinuxDialog extends Dialog{
    @Override
    void createButton() {
        this.button = new LinuxButton();
        System.out.println("Кнопка Linux создана");
        this.button.render();
    }
}
