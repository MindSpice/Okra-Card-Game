package gameboard;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import pawn.Pawn;
import asset.Character.Warrior;


import java.net.URL;
import java.util.ResourceBundle;

public class GameBoard implements Initializable {

    public ImageView hand_action_5;
    @javafx.fxml.FXML
    private Canvas arena_canvas;


    Pawn[] playerPawns = new Pawn[3];
    Pawn[] enemyPawns = new Pawn[3];
    double scaleX;
    double scaleY;
    double canvasMinX;
    double canvasMinY;
    Pawn selectedEnemyPawn;
    Pawn selectedPlayerPawn;

    public static GraphicsContext gc;
    public static double time;
    @javafx.fxml.FXML
    private TextField p2_mp;
    @javafx.fxml.FXML
    private TextField p1_hp;
    @javafx.fxml.FXML
    private Button p3_card_1;
    @javafx.fxml.FXML
    private TextArea p1_card_power_text;
    @javafx.fxml.FXML
    private Button p3_card_2;
    @javafx.fxml.FXML
    private ImageView hand_ability_1;
    @javafx.fxml.FXML
    private Button p2_card_1;
    @javafx.fxml.FXML
    private ImageView hand_ability_2;
    @javafx.fxml.FXML
    private ImageView hand_ability_3;
    @javafx.fxml.FXML
    private ImageView p2_card_1_img;
    @javafx.fxml.FXML
    private ImageView p2_card_power_img;
    @javafx.fxml.FXML
    private TextField p1_dp;
    @javafx.fxml.FXML
    private TextField p3_status_3;
    @javafx.fxml.FXML
    private TextField p3_status_4;
    @javafx.fxml.FXML
    private TextField p3_status_1;
    @javafx.fxml.FXML
    private Button p1_light_attack;
    @javafx.fxml.FXML
    private TextField p3_status_2;
    @javafx.fxml.FXML
    private ImageView hand_action_6;
    @javafx.fxml.FXML
    private ImageView p2_card_2_img;
    @javafx.fxml.FXML
    private ImageView hand_action_2;
    @javafx.fxml.FXML
    private ImageView hand_action_1;
    @javafx.fxml.FXML
    private ImageView hand_action_4;
    @javafx.fxml.FXML
    private ImageView hand_action_3;
    @javafx.fxml.FXML
    private TextField p3_sp;
    @javafx.fxml.FXML
    private TextArea p1_card_ability_text;
    @javafx.fxml.FXML
    private TextField p1_mp;
    @javafx.fxml.FXML
    private ImageView hand_power_2;
    @javafx.fxml.FXML
    private ImageView hand_power_3;
    @javafx.fxml.FXML
    private ImageView p3_pawn_img;
    @javafx.fxml.FXML
    private TextArea p3_card_power_text;
    @javafx.fxml.FXML
    private ImageView hand_power_1;
    @javafx.fxml.FXML
    private Button p2_heavy_attack;
    @javafx.fxml.FXML
    private TextArea p2_card_ability_text;
    @javafx.fxml.FXML
    private Button p1_heavy_attack;
    @javafx.fxml.FXML
    private Button p3_heavy_attack;
    @javafx.fxml.FXML
    private ImageView p1_card_1_img;
    @javafx.fxml.FXML
    private TextArea p2_card_1_text;
    @javafx.fxml.FXML
    private TextArea p3_card_ability_text;
    @javafx.fxml.FXML
    private TextArea p1_card_1_text;
    @javafx.fxml.FXML
    private Button p2_card_2;
    @javafx.fxml.FXML
    private TextField p2_sp;
    @javafx.fxml.FXML
    private ImageView p2_pawn_img;
    @javafx.fxml.FXML
    private ImageView p1_card_2_img;
    @javafx.fxml.FXML
    private TextField p3_hp;
    @javafx.fxml.FXML
    private ImageView p1_pawn_img;
    @javafx.fxml.FXML
    private ImageView p1_card_ability_img;
    @javafx.fxml.FXML
    private TextField p3_dp;
    @javafx.fxml.FXML
    private TextArea p3_card_1_text;
    @javafx.fxml.FXML
    private TextArea p2_card_power_text;
    @javafx.fxml.FXML
    private ImageView p2_card_ability_img;
    @javafx.fxml.FXML
    private ImageView p3_card_1_img;
    @javafx.fxml.FXML
    private ImageView p3_card_power_img;
    @javafx.fxml.FXML
    private TextField p1_sp;
    @javafx.fxml.FXML
    private TextArea p1_card_2_text;
    @javafx.fxml.FXML
    private TextArea p3_card_2_text;
    @javafx.fxml.FXML
    private TextField p3_mp;
    @javafx.fxml.FXML
    private TextArea p2_card_2_text;
    @javafx.fxml.FXML
    private TextField p2_status_4;
    @javafx.fxml.FXML
    private ImageView p3_card_ability_img;
    @javafx.fxml.FXML
    private Button p2_card_ability;
    @javafx.fxml.FXML
    private TextField p2_status_1;
    @javafx.fxml.FXML
    private Button p1_card_ability;
    @javafx.fxml.FXML
    private TextField p2_status_3;
    @javafx.fxml.FXML
    private TextField p2_hp;
    @javafx.fxml.FXML
    private TextField p2_status_2;
    @javafx.fxml.FXML
    private ImageView p3_card_2_img;
    @javafx.fxml.FXML
    private Button p3_card_ability;
    @javafx.fxml.FXML
    private Button p3_light_attack;
    @javafx.fxml.FXML
    private Button p2_light_attack;
    @javafx.fxml.FXML
    private ImageView p1_card_power_img;
    @javafx.fxml.FXML
    private Button p1_card_1;
    @javafx.fxml.FXML
    private Button p1_card_2;
    @javafx.fxml.FXML
    private TextField p1_status_2;
    @javafx.fxml.FXML
    private ImageView enemy_avatar;
    @javafx.fxml.FXML
    private TextField p1_status_1;
    @javafx.fxml.FXML
    private TextField p1_status_4;
    @javafx.fxml.FXML
    private TextField p1_status_3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        canvasMinX = arena_canvas.getBoundsInParent().getMinX();
        canvasMinY = arena_canvas.getBoundsInParent().getMinY();
        gc = arena_canvas.getGraphicsContext2D();
        arena_canvas.setOnMouseClicked(e-> this.select(e));


        gc.setFill(Color.DIMGRAY);
        gc.setImageSmoothing(false);
        gc.fillRect(0, 0, arena_canvas.getWidth(), arena_canvas.getHeight());

        playerPawns = asset.AssetLoader.initPawns(asset.Character.Warrior.LVL0, asset.Character.Warrior.LVL0,
                asset.Character.Warrior.LVL0, true);

        enemyPawns = asset.AssetLoader.initPawns(asset.Character.Warrior.LVL0, asset.Character.Warrior.LVL0,
                asset.Character.Warrior.LVL0, false);

        gameLoop();
    }

    private void select (MouseEvent e) {
        scaleX = Main.getScale().getX();
        scaleY = Main.getScale().getY();
        double mouseX = e.getSceneX() - (canvasMinX * scaleX);
        double mouseY = e.getSceneY() - (canvasMinY * scaleY);
        for (Pawn p : enemyPawns) {
            if (mouseX > (p.getPosX() * scaleX) && mouseX < (p.getPosX() + p.getWidth()) * scaleX
                    && mouseY > (p.getPosY() * scaleY) && mouseY < (p.getPosY() + p.getHeight()) * scaleY) {

                if (p.isDead()) break;
                if (selectedEnemyPawn != null) selectedEnemyPawn.setSelected(false);
                if (selectedEnemyPawn == p){
                    selectedEnemyPawn.setSelected(false);
                    selectedEnemyPawn = null;
                    break;
                }
                p.setSelected(true);
                selectedEnemyPawn = p;
                playerPawns[1].attack(selectedEnemyPawn);

            }
        }
        for (Pawn p : playerPawns) {
            if (mouseX > (p.getPosX() * scaleX) && mouseX < (p.getPosX() + p.getWidth()) * scaleX
                    && mouseY > (p.getPosY() * scaleY) && mouseY < (p.getPosY() + p.getHeight()) * scaleY) {

                if (p.isDead()) break;
                if (selectedPlayerPawn != null) selectedPlayerPawn.setSelected(false);
                if (selectedPlayerPawn == p){
                    selectedPlayerPawn.setSelected(false);
                    selectedPlayerPawn = null;
                    break;
                }
                p.setSelected(true);
                selectedPlayerPawn = p;
            }
        }
    }


    private void gameLoop () {

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        final long timeStart = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),                // 60 FPS
                new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent ae) {
                        time = (System.currentTimeMillis() - timeStart) / 1000.0;

                        gc.fillRect(0, 0, arena_canvas.getWidth(), arena_canvas.getHeight());

                        for (int i =0; i < 3; i++) {
                            if (!enemyPawns[i].isDead()) enemyPawns[i].draw(time);
                            if (!playerPawns[i].isDead()) playerPawns[i].draw(time);
                        }

                    }
                });
        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
    }



    public static GraphicsContext getGraphicsContext() {
        return gc;
    }
    public static double getTime() {
        return time;
    }

    @javafx.fxml.FXML
    public void p1HeavyAttack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p3Card2(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p3Card1(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p1CardAbility(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p3CardAbility(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p2Card2(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p1LightAttack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p3LightAttack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p2HeavyAttack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p1Card2(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p1Card1(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p2Card1(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p2CardAbility(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p3HeavyAttack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void p2LightAttack(ActionEvent actionEvent) {
    }

    public void screen_full(ActionEvent actionEvent) {
        Main.getStage().setFullScreen(true);
    }

    public void screen_min(ActionEvent actionEvent) {
        Main.getStage().setFullScreen(false);
    }
}
