package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        TextEntity title = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2),"Spatial Invaders");
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.AZURE);
        title.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
    }
}
