package com.game.simplegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class SimpleGame extends Application {

    int screenWidth = 500;
    int screenHeight = 500;
    int blockWidth = 50;
    int blockHeight = 50;
    Pane root = new Pane();
    Scene scene = new Scene(root, screenWidth, screenHeight);

    Rectangle block = new Rectangle(blockWidth,blockHeight);
    @Override
    public void start(Stage stage)  {


        block.setStyle("-fx-background-color: red");
        block.setX(screenWidth/2 - blockWidth/2);
        block.setY(screenHeight/2 - blockHeight/2);

        AnimationTimer timer =new AnimationTimer() {
            @Override
            public void handle(long l) {
                scene.setOnKeyPressed(event-> handleKeyPress(event.getCode()));
            }
        };

        timer.start();
        root.getChildren().add(block);
        stage.setScene(scene);
        stage.show();
    }

    private void handleKeyPress(KeyCode keyCode) {
        switch (keyCode)
        {
            case W:{
                if(block.getY() >=0)
                {
                    block.setY(block.getY()-10);
                }
                break;
            }
            case S:{
                if(block.getY() <=screenHeight)
                {
                    block.setY(block.getY()+10);
                }
                break;
            }
            case A:{
                if(block.getX() >=0)
                {
                    block.setX(block.getX()-10);
                }
                break;
            }
            case D:{
                if(block.getX() <=screenWidth)
                {
                    block.setX(block.getX()+10);
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}