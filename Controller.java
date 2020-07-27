package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;


public class Controller implements Initializable {

    @FXML
    Button one;
    @FXML
    Button two;
    @FXML
    Button three;
    @FXML
    Button four;
    @FXML
    Button five;
    @FXML
    Button six;
    @FXML
    Button seven;
    @FXML
    Button eight;
    @FXML
    Button nine;
    @FXML
    Button ten;
    @FXML
    Button eleven;
    @FXML
    Button twelve;
    @FXML
    Button thirteen;
    @FXML
    Button fourteen;
    @FXML
    Button fifteen;
    @FXML
    Button sixteen;
    @FXML
    Button seventeen;
    @FXML
    Button eighteen;
    @FXML
    Button nineteen;
    @FXML
    Button twenty;
    @FXML
    Button twentyOne;
    @FXML
    Button twentyTwo;
    @FXML
    Button twentyThree;
    @FXML
    Button twentyFour;
    @FXML
    Button twentyFive;
    @FXML
    Button startButton;
    @FXML
    Button resetButton;
    @FXML
    Button nextLevelButton;
    @FXML
    Label scoreLabel;
    @FXML
    Button scoreButton;
    @FXML
    Label correctButton;
    @FXML
    Label pressNext;
    @FXML
    Label level;
    @FXML
    Button timerButton;

    int score = 0;
    int number;
    int check;
    int max = 0;
    int next = 10;
    int currentLevel = 1;
    int counter;

    String pathClock = "C:\\Users\\Arbaz Wassan\\Desktop\\GreaterNumberGame\\Sound\\ClockSound.mp3";
    Media mediaClock = new Media(new File(pathClock).toURI().toString());
    MediaPlayer mediaPlayerClock = new MediaPlayer(mediaClock);

    private void setTimer()
    {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int count = 10;
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        timerButton.setText(Integer.toString(count));
                        if (counter == 1)
                        {
                            mediaPlayerClock.stop();
                            timer.cancel();
                            counter = 0;
                        }
                        else if (count == 0)
                        {
                            timer.cancel();
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setHeaderText("Times Up");
                            alert.setContentText("Sorry Times Up try again");
                            alert.show();
                            setZeroToButton();
                        }
                        count--;
                    }
                });
            }
        };

        timer.schedule(timerTask,0,1000);
    }
    private void waitTimer()
    {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int st = 0;
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(st == 4)
                        {
                            setZeroToButton();
                            timer.cancel();
                            backToColor();
                        }
                        st++;
                    }
                });
            }
        };
        timer.schedule(timerTask,0,1000);
    }

    public void setRandomNumber(){

            levelOne();


    }
    private void audioPlay()
    {
        setButtonDisable();
        counter = 1;
        nextLevelButton.setDisable(false);
        String path = "C:\\Users\\Arbaz Wassan\\Desktop\\GreaterNumberGame\\Sound\\BabiAudioCorrect.wav";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    private void clockSound()
    {
        mediaPlayerClock.play();
    }

    private void backToColor()
    {

        //one.setStyle("-fx-background-color: #D7E2D6");
        one.setStyle("-fx-border-color: #241C1D");

        two.setStyle("-fx-background-color: #B4D4B0");
        two.setStyle("-fx-border-color: #241C1D");

        three.setStyle("-fx-background-color: #943F4A");
        three.setStyle("-fx-border-color: #241C1D");

        four.setStyle("-fx-background-color: #F5F7F5");
        four.setStyle("-fx-border-color: #241C1D");

        five.setStyle("-fx-background-color: #F5F7F5");
        five.setStyle("-fx-border-color: #241C1D");

        six.setStyle("-fx-background-color: #F5F7F5");
        six.setStyle("-fx-border-color: #241C1D");

        seven.setStyle("-fx-background-color: #F5F7F5");
        seven.setStyle("-fx-border-color: #241C1D");

        eight.setStyle("-fx-background-color: #F5F7F5");
        eight.setStyle("-fx-border-color: #241C1D");

        nine.setStyle("-fx-background-color: #F5F7F5");
        nine.setStyle("-fx-border-color: #241C1D");

        ten.setStyle("-fx-background-color: #F5F7F5");
        ten.setStyle("-fx-border-color: #241C1D");

        eleven.setStyle("-fx-border-color: #241C1D");

        twelve.setStyle("-fx-border-color: #241C1D");

        thirteen.setStyle("-fx-border-color: #241C1D");

        fourteen.setStyle("-fx-border-color: #241C1D");

        fifteen.setStyle("-fx-border-color: #241C1D");

        sixteen.setStyle("-fx-border-color: #241C1D");

        seventeen.setStyle("-fx-border-color: #241C1D");

        eighteen.setStyle("-fx-border-color: #241C1D");

        nineteen.setStyle("-fx-border-color: #241C1D");

        twenty.setStyle("-fx-border-color: #241C1D");

        twentyOne.setStyle("-fx-border-color: #241C1D");

        twentyTwo.setStyle("-fx-border-color: #241C1D");

        twentyThree.setStyle("-fx-border-color: #241C1D");

        twentyFour.setStyle("-fx-border-color: #241C1D");

        twentyFive.setStyle("-fx-border-color: #241C1D");

    }
    private void showMaximumNumber()
    {
        if(Integer.parseInt(one.getText()) == max)
        {
            one.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(two.getText()) == max)
        {
            two.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(three.getText()) == max)
        {
            three.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(four.getText()) == max)
        {
            four.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(five.getText()) == max)
        {
            five.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(six.getText()) == max)
        {
            six.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(seven.getText()) == max)
        {
            seven.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(eight.getText()) == max)
        {
            eight.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(nine.getText()) == max)
        {
            nine.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(ten.getText()) == max)
        {
            ten.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(eleven.getText()) == max)
        {
            eleven.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(twelve.getText()) == max)
        {
            twelve.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(thirteen.getText()) == max)
        {
            thirteen.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(fourteen.getText()) == max)
        {
            fourteen.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(fifteen.getText()) == max)
        {
            fifteen.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(sixteen.getText()) == max)
        {
            sixteen.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(seventeen.getText()) == max)
        {
            seventeen.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(eighteen.getText()) == max)
        {
            eighteen.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(nineteen.getText()) == max)
        {
            nineteen.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(twenty.getText()) == max)
        {
            twenty.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(twentyOne.getText()) == max)
        {
            twentyOne.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(twentyTwo.getText()) == max)
        {
            twentyTwo.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(twentyThree.getText()) == max)
        {
            twentyThree.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(twentyFour.getText()) == max)
        {
            twentyFour.setStyle("-fx-background-color: #208815");
        }
        else if(Integer.parseInt(twentyFive.getText()) == max)
        {
            twentyFive.setStyle("-fx-background-color: #208815");
        }
    }
    private void printScore()
    {
        one.setOnAction(event -> {

            number = Integer.parseInt(one.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        two.setOnAction(event -> {
            number = Integer.parseInt(two.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        three.setOnAction(event -> {
            number = Integer.parseInt(three.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        four.setOnAction(event -> {
            number = Integer.parseInt(four.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        five.setOnAction(event -> {
            number = Integer.parseInt(five.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        six.setOnAction(event -> {
            number = Integer.parseInt(six.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        seven.setOnAction(event -> {
            number = Integer.parseInt(seven.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        eight.setOnAction(event -> {
            number = Integer.parseInt(eight.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        nine.setOnAction(event -> {
            number = Integer.parseInt(nine.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        ten.setOnAction(event -> {
            number = Integer.parseInt(ten.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        eleven.setOnAction(event -> {
            number = Integer.parseInt(eleven.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        twelve.setOnAction(event -> {
            number = Integer.parseInt(twelve.getText());
            if (number == max)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        thirteen.setOnAction(event -> {
            number = Integer.parseInt(thirteen.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        fourteen.setOnAction(event -> {
            number = Integer.parseInt(fourteen.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        fifteen.setOnAction(event -> {
            number = Integer.parseInt(fifteen.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        sixteen.setOnAction(event -> {
            number = Integer.parseInt(sixteen.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        seventeen.setOnAction(event -> {
            number = Integer.parseInt(seventeen.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        eighteen.setOnAction(event -> {
            number = Integer.parseInt(eighteen.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        nineteen.setOnAction(event -> {
            number = Integer.parseInt(nineteen.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        twenty.setOnAction(event -> {
            number = Integer.parseInt(twenty.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        twentyOne.setOnAction(event -> {
            number = Integer.parseInt(twentyOne.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        twentyTwo.setOnAction(event -> {
            number = Integer.parseInt(twentyTwo.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        twentyThree.setOnAction(event -> {
            number = Integer.parseInt(twentyThree.getText());
            System.out.println(number);
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        twentyFour.setOnAction(event -> {
            number = Integer.parseInt(twentyFour.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });
        twentyFive.setOnAction(event -> {
            number = Integer.parseInt(twentyFive.getText());
            if (max == number)
            {
                audioPlay();
                correctButton.setText("Correct");
                pressNext.setText("Press Next Level Button");
                score = score + 10;
                scoreButton.setText(Integer.toString(score));
            }
            else
            {
                reset();
            }
        });


    }

    private void levelOne()
    {
        nextLevelButton.setDisable(true);
        startButton.setOnAction(event -> {
            counter = 0;
            clockSound();
            setTimer();
            level.setText("Level "+Integer.toString(currentLevel));
            max = 0;
            one.setText(Integer.toString((int)(Math.random() * 10)));
            two.setText(Integer.toString((int)(Math.random() * 10)));
            three.setText(Integer.toString((int)(Math.random() * 10)));
            four.setText(Integer.toString((int)(Math.random() * 10)));
            five.setText(Integer.toString((int)(Math.random() * 10)));
            six.setText(Integer.toString((int)(Math.random() * 10)));
            seven.setText(Integer.toString((int)(Math.random() * 10)));
            eight.setText(Integer.toString((int)(Math.random() * 10)));
            nine.setText(Integer.toString((int)(Math.random() * 10)));
            ten.setText(Integer.toString((int)(Math.random() * 10)));
            eleven.setText(Integer.toString((int)(Math.random() * 10)));
            twelve.setText(Integer.toString((int)(Math.random() * 10)));
            thirteen.setText(Integer.toString((int)(Math.random() * 10)));
            fourteen.setText(Integer.toString((int)(Math.random() * 10)));
            fifteen.setText(Integer.toString((int)(Math.random() * 10)));
            sixteen.setText(Integer.toString((int)(Math.random() * 10)));
            seventeen.setText(Integer.toString((int)(Math.random() * 10)));
            eighteen.setText(Integer.toString((int)(Math.random() * 10)));
            nineteen.setText(Integer.toString((int)(Math.random() * 10)));
            twenty.setText(Integer.toString((int)(Math.random() * 10)));
            twentyOne.setText(Integer.toString((int)(Math.random() * 10)));
            twentyTwo.setText(Integer.toString((int)(Math.random() * 10)));
            twentyThree.setText(Integer.toString((int)(Math.random() * 10)));
            twentyFour.setText(Integer.toString((int)(Math.random() * 10)));
            twentyFive.setText(Integer.toString((int)(Math.random() * 10)));
            getLargestButton();
            printScore();

            startButton.setVisible(false);



        });

        nextLevelButton.setOnAction(event -> {
            nextLevelButton.setDisable(true);
            setButtonEnable();
            clockSound();
            setTimer();
            level.setText("Level "+Integer.toString(++currentLevel));
            max = 0;
            correctButton.setText("");
            pressNext.setText("");
            one.setText(Integer.toString((int)(Math.random() * next)));
            two.setText(Integer.toString((int)(Math.random() * next)));
            three.setText(Integer.toString((int)(Math.random() * next)));
            four.setText(Integer.toString((int)(Math.random() * next)));
            five.setText(Integer.toString((int)(Math.random() * next)));
            six.setText(Integer.toString((int)(Math.random() * next)));
            seven.setText(Integer.toString((int)(Math.random() * next)));
            eight.setText(Integer.toString((int)(Math.random() * next)));
            nine.setText(Integer.toString((int)(Math.random() * next)));
            ten.setText(Integer.toString((int)(Math.random() * next)));
            eleven.setText(Integer.toString((int)(Math.random() * next)));
            twelve.setText(Integer.toString((int)(Math.random() * next)));
            thirteen.setText(Integer.toString((int)(Math.random() * next)));
            fourteen.setText(Integer.toString((int)(Math.random() * next)));
            fifteen.setText(Integer.toString((int)(Math.random() * next)));
            sixteen.setText(Integer.toString((int)(Math.random() * next)));
            seventeen.setText(Integer.toString((int)(Math.random() * next)));
            eighteen.setText(Integer.toString((int)(Math.random() * next)));
            nineteen.setText(Integer.toString((int)(Math.random() * next)));
            twenty.setText(Integer.toString((int)(Math.random() * next)));
            twentyOne.setText(Integer.toString((int)(Math.random() * next)));
            twentyTwo.setText(Integer.toString((int)(Math.random() * next)));
            twentyThree.setText(Integer.toString((int)(Math.random() * next)));
            twentyFour.setText(Integer.toString((int)(Math.random() * next)));
            twentyFive.setText(Integer.toString((int)(Math.random() * next)));
            next = next * 2;

            getLargestButton();
            printScore();

        });

    }

    private void getLargestButton()
    {
            check = Integer.parseInt(one.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(two.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(three.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(four.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(five.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(six.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(seven.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(eight.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(nine.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(ten.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(eleven.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(twelve.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(thirteen.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(fourteen.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(fifteen.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(sixteen.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(seventeen.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(eighteen.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(nineteen.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(twenty.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(twentyOne.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(twentyTwo.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(twentyThree.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(twentyFour.getText());
            if(check >= max)
            {
                max = check;
            }
            check = Integer.parseInt(twentyFive.getText());
            if(check >= max)
            {
                max = check;
            }


    }

    public void resetButton()
    {
        resetButton.setOnAction(event -> {
            setButtonEnable();
            counter = 1;
            startButton.setVisible(true);
            score = 0;
            correctButton.setText("");
            currentLevel = 1;
            next = 10;
            scoreButton.setText(Integer.toString(score));
            String v = "0";
            one.setText(v);
            two.setText(v);
            three.setText(v);
            four.setText(v);
            five.setText(v);
            six.setText(v);
            seven.setText(v);
            eight.setText(v);
            nine.setText(v);
            ten.setText(v);
            eleven.setText(v);
            twelve.setText(v);
            thirteen.setText(v);
            fourteen.setText(v);
            fifteen.setText(v);
            sixteen.setText(v);
            seventeen.setText(v);
            eighteen.setText(v);
            nineteen.setText(v);
            twenty.setText(v);
            twentyOne.setText(v);
            twentyTwo.setText(v);
            twentyThree.setText(v);
            twentyFour.setText(v);
            twentyFive.setText(v);
        });

    }
    private void reset()
    {
        counter = 1;
        String path = "C:\\Users\\Arbaz Wassan\\Desktop\\GreaterNumberGame\\Sound\\WrongSound.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        correctButton.setText("Wrong");

        timerButton.setText("10");
        level.setText("");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        ButtonType playAgain = new ButtonType("Play Again");
        alert.getButtonTypes().add(playAgain);
        alert.setHeaderText("Wrong Try Again!!");
        alert.setContentText("Your Score is : "+Integer.toString(score));
        alert.show();
        startButton.setVisible(true);
        score = 0;
        correctButton.setText("");
        currentLevel = 1;
        next = 10;
        scoreButton.setText(Integer.toString(score));

        showMaximumNumber();
        waitTimer();

    }
    private void setZeroToButton()
    {
        startButton.setVisible(true);
        String v = "0";
        one.setText(v);
        two.setText(v);
        three.setText(v);
        four.setText(v);
        five.setText(v);
        six.setText(v);
        seven.setText(v);
        eight.setText(v);
        nine.setText(v);
        ten.setText(v);
        eleven.setText(v);
        twelve.setText(v);
        thirteen.setText(v);
        fourteen.setText(v);
        fifteen.setText(v);
        sixteen.setText(v);
        seventeen.setText(v);
        eighteen.setText(v);
        nineteen.setText(v);
        twenty.setText(v);
        twentyOne.setText(v);
        twentyTwo.setText(v);
        twentyThree.setText(v);
        twentyFour.setText(v);
        twentyFive.setText(v);
    }
    private void setButtonDisable()
    {
        one.setDisable(true);
        two.setDisable(true);
        three.setDisable(true);
        four.setDisable(true);
        five.setDisable(true);
        six.setDisable(true);
        seven.setDisable(true);
        eight.setDisable(true);
        nine.setDisable(true);
        ten.setDisable(true);
        eleven.setDisable(true);
        twelve.setDisable(true);
        thirteen.setDisable(true);
        fourteen.setDisable(true);
        fifteen.setDisable(true);
        sixteen.setDisable(true);
        seventeen.setDisable(true);
        eighteen.setDisable(true);
        nineteen.setDisable(true);
        twenty.setDisable(true);
        twentyOne.setDisable(true);
        twentyTwo.setDisable(true);
        twentyThree.setDisable(true);
        twentyFour.setDisable(true);
        twentyFive.setDisable(true);
    }
    private void setButtonEnable()
    {
        one.setDisable(false);
        two.setDisable(false);
        three.setDisable(false);
        four.setDisable(false);
        five.setDisable(false);
        six.setDisable(false);
        seven.setDisable(false);
        eight.setDisable(false);
        nine.setDisable(false);
        ten.setDisable(false);
        eleven.setDisable(false);
        twelve.setDisable(false);
        thirteen.setDisable(false);
        fourteen.setDisable(false);
        fifteen.setDisable(false);
        sixteen.setDisable(false);
        seventeen.setDisable(false);
        eighteen.setDisable(false);
        nineteen.setDisable(false);
        twenty.setDisable(false);
        twentyOne.setDisable(false);
        twentyTwo.setDisable(false);
        twentyThree.setDisable(false);
        twentyFour.setDisable(false);
        twentyFive.setDisable(false);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
