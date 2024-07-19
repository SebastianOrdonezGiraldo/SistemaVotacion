package com.example.sistemavotacion.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewCandidatesController {

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    public void initialize() {
        try {

            imageView1.setImage(new Image(getClass().getResourceAsStream("/image/fotoUribe.jpg")));
            imageView2.setImage(new Image(getClass().getResourceAsStream("/image/fotoPetro.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
