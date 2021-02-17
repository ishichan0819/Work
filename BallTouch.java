import javafx.application.Application;
import java.util.Random;

import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class BallTouch extends Application{

    private int clear=0,failure=0,count=0,mode=0; 
    private boolean flag=false;

    public int getClear(){
        return this.clear;
    }

    public void addClear(){
        this.clear += 1;
    }

    public void resetClear(){
        this.clear = 0;
    }

    public int getFailure(){
        return this.failure;
    }

    public void addFailure(){
        this.failure += 1;
    }

    public void resetFailure(){
        this.failure = 0;
    }

    public int getCount(){
        return this.count;
    }

    public void addCount(){
        this.count += 1;
    }

    public void resetCount(){
        this.count = 0;
    }

    public void newGameCount(){
        this.count = 0;
    }

    public int getMode(){
        return this.mode;
    }

    public void setMode(int x){
        this.mode = x;
    }

    public boolean getFlag(){
        return this.flag;
    }

    public void setFlag(boolean f){
        this.flag = f;
    }
    
    @Override
    public void start(Stage stage) throws Exception{
		stage.setTitle("Report4");
        Random r = new Random();
        Button button = new Button("START");
        Button easy = new Button("EASY");
        Button normal = new Button("NORMAL");
        Button hard = new Button("HARD");
        Button back = new Button("BACK");
		Circle circle = new Circle(80,Color.BLUE);
		Circle circle2x = new Circle(40,Color.GREEN);
		Circle circle2y = new Circle(40,Color.GREEN);
		Circle circle3xa = new Circle(20,Color.RED);
		Circle circle3xb = new Circle(20,Color.RED);
		Circle circle3ya = new Circle(20,Color.RED);
		Circle circle3yb = new Circle(20,Color.RED);
        Label clearCount = new Label();
        Label failureCount = new Label();
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		Pane pane = new Pane();
		
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000),circle);
        TranslateTransition tt2x = new TranslateTransition(Duration.millis(2500),circle2x);
        TranslateTransition tt2y = new TranslateTransition(Duration.millis(2500),circle2y);
        TranslateTransition tt3xa = new TranslateTransition(Duration.millis(3000),circle3xa);
        TranslateTransition tt3xb = new TranslateTransition(Duration.millis(3000),circle3xb);
        TranslateTransition tt3ya = new TranslateTransition(Duration.millis(3000),circle3ya);
        TranslateTransition tt3yb = new TranslateTransition(Duration.millis(3000),circle3yb);
        
        clearCount.setPrefSize(70, 10);
        clearCount.setText(" clear : " + String.valueOf(getClear()));
        failureCount.setPrefSize(70, 10);
        failureCount.setText(" failure : " + String.valueOf(getFailure()));
        
        easy.setPrefSize(100, 30);
        normal.setPrefSize(100, 30);
        hard.setPrefSize(100, 30);

        easy.setOnAction(event -> {
            setMode(0);
            tt.setDuration(Duration.millis(2000-getMode()));
            tt2x.setDuration(Duration.millis(2500-getMode()));
            tt2y.setDuration(Duration.millis(2500-getMode()));
            tt3xa.setDuration(Duration.millis(3000-getMode()));
            tt3xb.setDuration(Duration.millis(3000-getMode()));
            tt3ya.setDuration(Duration.millis(3000-getMode()));
            tt3yb.setDuration(Duration.millis(3000-getMode()));
            pane.getChildren().remove(vbox);
            clearCount.setText(" clear : " + String.valueOf(getClear()));
            failureCount.setText(" failure : " + String.valueOf(getFailure()));
            pane.getChildren().addAll(hbox);
            stage.setScene(new Scene(pane));
        	stage.show();
        });

        normal.setOnAction(event -> {
            setMode(500);
            tt.setDuration(Duration.millis(2000-getMode()));
            tt2x.setDuration(Duration.millis(2500-getMode()));
            tt2y.setDuration(Duration.millis(2500-getMode()));
            tt3xa.setDuration(Duration.millis(3000-getMode()));
            tt3xb.setDuration(Duration.millis(3000-getMode()));
            tt3ya.setDuration(Duration.millis(3000-getMode()));
            tt3yb.setDuration(Duration.millis(3000-getMode()));
            pane.getChildren().remove(vbox);
            clearCount.setText(" clear : " + String.valueOf(getClear()));
            failureCount.setText(" failure : " + String.valueOf(getFailure()));
            pane.getChildren().addAll(hbox);
            stage.setScene(new Scene(pane));
        	stage.show();
        });
        hard.setOnAction(event -> {
            setMode(1000);
            tt.setDuration(Duration.millis(2000-getMode()));
            tt2x.setDuration(Duration.millis(2500-getMode()));
            tt2y.setDuration(Duration.millis(2500-getMode()));
            tt3xa.setDuration(Duration.millis(3000-getMode()));
            tt3xb.setDuration(Duration.millis(3000-getMode()));
            tt3ya.setDuration(Duration.millis(3000-getMode()));
            tt3yb.setDuration(Duration.millis(3000-getMode()));
            pane.getChildren().remove(vbox);
            clearCount.setText(" clear : " + String.valueOf(getClear()));
            failureCount.setText(" failure : " + String.valueOf(getFailure()));
            pane.getChildren().addAll(hbox);
            stage.setScene(new Scene(pane));
        	stage.show();
        });

        button.setOnAction(event -> {
            if(getFlag()==false){
                setFlag(true);
                pane.getChildren().add(circle);
                tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                tt.setToX(800); tt.setToY(r.nextInt(600));
                tt.play();
                stage.setScene(new Scene(pane));
                stage.show();	
            }
        });

        back.setOnAction(event -> {
            setFlag(false);
            tt.stop();
            tt2x.stop();
            tt2y.stop();
            tt3xa.stop();
            tt3xb.stop();
            tt3ya.stop();
            tt3yb.stop();
            resetClear();
            resetFailure();
            newGameCount();
            pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
            pane.getChildren().add(vbox);
            stage.setScene(new Scene(pane));
        	stage.show();
        });

        circle.setOnMousePressed(event -> {
			tt.stop();
            pane.getChildren().addAll(circle2x,circle2y);
            
            tt2x.setFromX(event.getSceneX()); tt2x.setFromY(event.getSceneY()+50);
            tt2x.setToX(800); tt2x.setToY(r.nextInt(600));
            tt2y.setFromX(event.getSceneX()); tt2y.setFromY(event.getSceneY()-50);
            tt2y.setToX(800); tt2y.setToY(r.nextInt(600));

			pane.getChildren().remove(circle);
            tt2x.play();
			tt2y.play();
			stage.setScene(new Scene(pane));
        	stage.show();			
		});
		
		circle2x.setOnMousePressed(event -> {
			tt2x.stop();
			pane.getChildren().addAll(circle3xa,circle3xb);
            
            tt3xa.setFromX(event.getSceneX()); tt3xa.setFromY(event.getSceneY()+50);
            tt3xa.setToX(800); tt3xa.setToY(r.nextInt(600));
            tt3xa.play();
            tt3xb.setFromX(event.getSceneX()); tt3xb.setFromY(event.getSceneY()-50);
            tt3xb.setToX(800); tt3xb.setToY(r.nextInt(600));
			tt3xb.play();

			pane.getChildren().remove(circle2x);
			stage.setScene(new Scene(pane));
        	stage.show();
		});

		circle2y.setOnMousePressed(event -> {
			tt2y.stop();
			pane.getChildren().addAll(circle3ya,circle3yb);
            
            tt3ya.setFromX(event.getSceneX()); tt3ya.setFromY(event.getSceneY()+50);
            tt3ya.setToX(800); tt3ya.setToY(r.nextInt(600));
            tt3ya.play();
            tt3yb.setFromX(event.getSceneX()); tt3yb.setFromY(event.getSceneY()-50);
            tt3yb.setToX(800); tt3yb.setToY(r.nextInt(600));
            tt3yb.play();
            
			pane.getChildren().remove(circle2y);
			stage.setScene(new Scene(pane));
        	stage.show();
		});
		
		circle3xa.setOnMousePressed(event -> {
            addClear();

            addCount();
            if(getCount()==4 && getFailure() < 3){
                resetCount();
                pane.getChildren().add(circle);
                tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                tt.setToX(800); tt.setToY(r.nextInt(600));
                tt.play();
            }

            clearCount.setText(" clear : " + String.valueOf(getClear()));
            tt3xa.stop();
            pane.getChildren().remove(circle3xa);
            stage.setScene(new Scene(pane));
        	stage.show();	
		});

		circle3xb.setOnMousePressed(event -> {
            addClear();

            addCount();
            if(getCount()==4 && getFailure() < 3){
                resetCount();
                pane.getChildren().add(circle);
                tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                tt.setToX(800); tt.setToY(r.nextInt(600));
                tt.play();
            }

            clearCount.setText(" clear : " + String.valueOf(getClear()));
            tt3xb.stop();
            pane.getChildren().remove(circle3xb);
            stage.setScene(new Scene(pane));
        	stage.show();	
		});
		
		circle3ya.setOnMousePressed(event -> {
            addClear(); 

            addCount();
            if(getCount()==4 && getFailure() < 3){
                resetCount();
                pane.getChildren().add(circle);
                tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                tt.setToX(800); tt.setToY(r.nextInt(600));
                tt.play();
            }

            clearCount.setText(" clear : " + String.valueOf(getClear()));
            tt3ya.stop();
            pane.getChildren().remove(circle3ya);
            stage.setScene(new Scene(pane));
        	stage.show();	
		});
		
		circle3yb.setOnMousePressed(event -> {
            addClear();

            addCount();
            if(getCount()==4 && getFailure() < 3){
                resetCount();
                pane.getChildren().add(circle);
                tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                tt.setToX(800); tt.setToY(r.nextInt(600));
                tt.play();
            }

            clearCount.setText(" clear : " + String.valueOf(getClear()));
            tt3yb.stop();
            pane.getChildren().remove(circle3yb);
            stage.setScene(new Scene(pane));
        	stage.show();	
        });

        tt.setOnFinished(event -> {
            addFailure();
            if(getFailure()>=3){
                setFlag(false);
                tt.stop();
                tt2x.stop();
                tt2y.stop();
                tt3xa.stop();
                tt3xb.stop();
                tt3ya.stop();
                tt3yb.stop();
                JOptionPane.showMessageDialog(null, "Game Over");
                resetClear();
                resetFailure();
                newGameCount();
                pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
                pane.getChildren().add(vbox);
                stage.setScene(new Scene(pane));
        	    stage.show();
            }else{
                failureCount.setText(" failure : " + String.valueOf(getFailure()));
                pane.getChildren().remove(circle);
    
                for(int i=0; i<4; i++){
                    addCount();
                }
    
                if(getCount()>=4){
                    resetCount();
                    pane.getChildren().add(circle);
                    tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                    tt.setToX(800); tt.setToY(r.nextInt(600));
                    tt.play();
                }
    
                stage.setScene(new Scene(pane));
                stage.show();	
            }
        });
            
		
        tt2x.setOnFinished(event -> {
            addFailure();
            if(getFailure()>=3){
                setFlag(false);
                tt.stop();
                tt2x.stop();
                tt2y.stop();
                tt3xa.stop();
                tt3xb.stop();
                tt3ya.stop();
                tt3yb.stop();
                JOptionPane.showMessageDialog(null, "Game Over");
                resetClear();
                resetFailure();
                newGameCount();
                pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
                pane.getChildren().add(vbox);
                stage.setScene(new Scene(pane));
        	    stage.show();
            }else{
                failureCount.setText(" failure : " + String.valueOf(getFailure()));
                pane.getChildren().remove(circle2x);
    
                addCount();
                addCount();
    
                if(getCount()>=4){
                    resetCount();
                    pane.getChildren().add(circle);
                    tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                    tt.setToX(800); tt.setToY(r.nextInt(600));
                    tt.play();
                }
    
                stage.setScene(new Scene(pane));
                stage.show();
            }	
		});
		
        tt2y.setOnFinished(event -> {
            addFailure();
            if(getFailure()>=3){
                setFlag(false);
                tt.stop();
                tt2x.stop();
                tt2y.stop();
                tt3xa.stop();
                tt3xb.stop();
                tt3ya.stop();
                tt3yb.stop();
                JOptionPane.showMessageDialog(null, "Game Over");
                resetClear();
                resetFailure();
                newGameCount();
                pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
                pane.getChildren().add(vbox);
                stage.setScene(new Scene(pane));
        	    stage.show();
            }else{
                failureCount.setText(" failure : " + String.valueOf(getFailure()));
                pane.getChildren().remove(circle2y);
    
                addCount();
                addCount();
                if(getCount()>=4){
                    resetCount();
                    pane.getChildren().add(circle);
                    tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                    tt.setToX(800); tt.setToY(r.nextInt(600));
                    tt.play();
                }
    
                stage.setScene(new Scene(pane));
                stage.show();
            }	
		});
		
        tt3xa.setOnFinished(event -> {
            addFailure();
            if(getFailure()>=3){
                setFlag(false);
                tt.stop();
                tt2x.stop();
                tt2y.stop();
                tt3xa.stop();
                tt3xb.stop();
                tt3ya.stop();
                tt3yb.stop();
                JOptionPane.showMessageDialog(null, "Game Over");
                resetClear();
                resetFailure();
                newGameCount();
                pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
                pane.getChildren().add(vbox);
                stage.setScene(new Scene(pane));
        	    stage.show();
            }else{
                failureCount.setText(" failure : " + String.valueOf(getFailure()));
                pane.getChildren().remove(circle3xa);
    
                addCount();
                if(getCount()>=4){
                    resetCount();
                    pane.getChildren().add(circle);
                    tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                    tt.setToX(800); tt.setToY(r.nextInt(600));
                    tt.play();
                }
    
                stage.setScene(new Scene(pane));
                stage.show();	
            }
		});

        tt3xb.setOnFinished(event -> {
            addFailure();
            if(getFailure()>=3){
                setFlag(false);
                tt.stop();
                tt2x.stop();
                tt2y.stop();
                tt3xa.stop();
                tt3xb.stop();
                tt3ya.stop();
                tt3yb.stop();
                JOptionPane.showMessageDialog(null, "Game Over");
                resetClear();
                resetFailure();
                newGameCount();
                pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
                pane.getChildren().add(vbox);
                stage.setScene(new Scene(pane));
        	    stage.show();
            }else{
                failureCount.setText(" failure : " + String.valueOf(getFailure()));
                pane.getChildren().remove(circle3xb);
    
                addCount();
                if(getCount()>=4){
                    resetCount();
                    pane.getChildren().add(circle);
                    tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                    tt.setToX(800); tt.setToY(r.nextInt(600));
                    tt.play();
                }
    
                stage.setScene(new Scene(pane));
                stage.show();	
            }
		});
		
        tt3ya.setOnFinished(event -> {
            addFailure();
            if(getFailure()>=3){
                setFlag(false);
                tt.stop();
                tt2x.stop();
                tt2y.stop();
                tt3xa.stop();
                tt3xb.stop();
                tt3ya.stop();
                tt3yb.stop();
                JOptionPane.showMessageDialog(null, "Game Over");
                resetClear();
                resetFailure();
                newGameCount();
                pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
                pane.getChildren().add(vbox);
                stage.setScene(new Scene(pane));
        	    stage.show();
            }else{
                failureCount.setText(" failure : " + String.valueOf(getFailure()));
                pane.getChildren().remove(circle3ya);
    
                addCount();
                if(getCount()>=4){
                    resetCount();
                    pane.getChildren().add(circle);
                    tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                    tt.setToX(800); tt.setToY(r.nextInt(600));
                    tt.play();
                }
    
                stage.setScene(new Scene(pane));
                stage.show();
            }	
		});
		
        tt3yb.setOnFinished(event -> {
            addFailure();
            if(getFailure()>=3){
                setFlag(false);
                tt.stop();
                tt2x.stop();
                tt2y.stop();
                tt3xa.stop();
                tt3xb.stop();
                tt3ya.stop();
                tt3yb.stop();
                JOptionPane.showMessageDialog(null, "Game Over");
                resetClear();
                resetFailure();
                newGameCount();
                pane.getChildren().removeAll(circle,circle2x,circle2y,circle3xa,circle3xb,circle3ya,circle3yb,hbox);
                pane.getChildren().add(vbox);
                stage.setScene(new Scene(pane));
        	    stage.show();
            }else{
                failureCount.setText(" failure : " + String.valueOf(getFailure()));
                pane.getChildren().remove(circle3yb);
    
                addCount();
                if(getCount()>=4){
                    resetCount();
                    pane.getChildren().add(circle);
                    tt.setFromX(-160); tt.setFromY(r.nextInt(550));
                    tt.setToX(800); tt.setToY(r.nextInt(600));
                    tt.play();
                }
    
                stage.setScene(new Scene(pane));
                stage.show();	
            }
        });
        
        hbox.getChildren().addAll(button,back,clearCount,failureCount);
        vbox.getChildren().addAll(easy,normal,hard);

        pane.setPrefWidth(800);
        pane.setPrefHeight(600);
        pane.getChildren().setAll(vbox);


        stage.setScene(new Scene(pane));
        stage.show();
    }
}
