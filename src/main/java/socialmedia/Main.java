package socialmedia;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static UserManager userManager = DataGenerator.generateData();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginPage LoginPage = new LoginPage();
        LoginPage.start(stage);
    }
}

