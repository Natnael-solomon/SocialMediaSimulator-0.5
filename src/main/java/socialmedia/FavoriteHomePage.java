package socialmedia;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

import static socialmedia.Main.userManager;

public class FavoriteHomePage extends ScrollPane {

    private final VBox content;
    private Stage primaryStage;

    public FavoriteHomePage(Stage primaryStage) {
        this.primaryStage=primaryStage;

        this.content = new VBox();
        this.content.setSpacing(15);
        this.content.getStyleClass().add("favorite");
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        this.setStyle("-fx-background: white;");

        Label title = new Label("Favorite Users");
        title.getStyleClass().add("favorite-title");
        this.content.getChildren().add(title);

        List<User> favoriteUsers = userManager.getCurrentUser().getFavoriteUsers();

        for (int i = 1; i < favoriteUsers.size(); i++) {
            Button trendItem = new Button(favoriteUsers.get(i).getFullName());
            trendItem.getStyleClass().add("favorite-user");
            int finalI = i;
            trendItem.setOnMouseClicked(event -> {
                ProfilePage profilePage = new ProfilePage(favoriteUsers.get(finalI), primaryStage);
                primaryStage.setScene(profilePage.getScene());
            });
            this.content.getChildren().add(trendItem);
        }

        this.setContent(content);
        this.setFitToWidth(true);
    }
}