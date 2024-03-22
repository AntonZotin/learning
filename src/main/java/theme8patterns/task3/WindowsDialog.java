package theme8patterns.task3;

public class WindowsDialog extends Dialog{
    @Override
    void createButton() {
        this.button = new WindowsButton();
        System.out.println("Кнопка Windows создана");
        this.button.render();
    }
}
