package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FrontPage extends Pane {
    private ImageView goKart = new ImageView("https://static.dgda.dk/media/4861/gokart-aarhus-racehall-8.jpg");

    private ImageView sumoWrestling = new ImageView("https://funguide.dk/wp-content/uploads/2014/12/Sumobrydning.jpg");

    private ImageView paintBall = new ImageView("https://media.tacdn.com/media/attractions-splice-spp-674x446/06/fc/" +
            "f9/a3.jpg");

    public FrontPage() {
        //Overhead text for frontpage
        /*Text overHeadText = new Text(200,250,"Welcome to Adventure Alley");
        overHeadText.setFont(new Font(40));*/

        //Picture properties for Go Cart and text
        Text goKartText = new Text(185,475,"Go Kart");
        goKartText.setFont(new Font(25));
        goKart.setFitWidth(400);
        goKart.setFitHeight(600);
        goKart.setX(0);
        goKart.setY(50);

        //Picture properties for Sumo Wrestling and text
        Text sumoWrestlingText = new Text(485,475,"Sumo Wrestling");
        sumoWrestlingText.setFont(new Font(25));
        sumoWrestling.setFitHeight(600);
        sumoWrestling.setFitWidth(400);
        sumoWrestling.setX(400);
        sumoWrestling.setY(50);

        //Picture Properties for paintball
        Text paintBallText = new Text(785,475,"Paint Ball");
        paintBallText.setFont(new Font(25));
        paintBall.setFitWidth(400);
        paintBall.setFitHeight(600);
        paintBall.setX(800);
        paintBall.setY(50);

        getChildren().addAll(goKart, sumoWrestling, paintBall, goKartText, sumoWrestlingText, paintBallText);
    }
}
