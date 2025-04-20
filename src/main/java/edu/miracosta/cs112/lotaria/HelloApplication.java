package edu.miracosta.cs112.lotaria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.TextAlignment;

import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;



public class HelloApplication extends Application implements EventHandler<ActionEvent> {
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

private Label messageLabel, titleLabel;
private ImageView cardImageView;
private Button drawCardButton;
private int count = 0;

    @Override
    public void start(Stage stage) {
        titleLabel = new Label("Welcom to EChALE STEM Loteria!");
        cardImageView = new ImageView();
        messageLabel = new Label("Click the button to randomly draw a card. The progress bar will indicate how far we're into the game.")
        drawCardButton = new Button("Draw Random Card");

        LoteriaCard tempCard = new LoteriaCard();
        cardImageView.setImage(tempCard.getImage());
        cardImageView.setFitWidth(300);
        cardImageView.setPreserveRatio(true);

        messageLabel.setWrapText(true);
        messageLabel.setTextAlignment(TextAlignment.Center);

        //Event Handling
        drawCardButton.setOnAction(this);

        Vbox mainLayout = new VBox();
        mainLayout.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton);
        mainLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainLayout, 350, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("EChALE STEM Loteria");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == drawCardButton) {
            int cardNum = (int) (Math.random() * LOTERIA_CARDS.length);


            LoteriaCard drawnCard = LOTERIA_CARDS[cardNum];

            cardImageView.setImage(drawnCard.getImage());
            messageLabel.setText(drawnCard.getCardName());
        }

    }
}