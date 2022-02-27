package com.cursoandroid.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void selectRock(View view){
        this.userChoice("rock");
    }

    public void selectPaper(View view){
        this.userChoice("paper");
    }

    public void selectScissors(View view){
        this.userChoice("scissors");
    }

    public void userChoice(String userChoice){

        TextView textResult = findViewById(R.id.textResult);
        ImageView imageResult = findViewById(R.id.imgResult);
        String [] options = {"rock", "paper","scissors"};
        int number = new Random().nextInt(3);
        String appChoice = options[number];

        switch (appChoice){
            case "rock":
                imageResult.setImageResource(R.drawable.pedra);
                break;

            case "paper":
                imageResult.setImageResource(R.drawable.papel);
                break;

            case "scissors":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                        //These are the conditions if the app is the winner.
                        (appChoice.equals("scissors") && userChoice.equals("paper")) ||
                        (appChoice.equals("paper") && userChoice.equals("rock")) ||
                        (appChoice.equals("rock") && userChoice.equals("scissors"))
        )
        {
            textResult.setText("You lost :( ");

        } else if (

                        //These are the conditions if the player is the winner.
                        (userChoice.equals("scissors") && appChoice.equals("paper")) ||
                        (userChoice.equals("paper") && appChoice.equals("rock")) ||
                        (userChoice.equals("rock") && appChoice.equals("scissors"))

        ){

            textResult.setText("You won :) ");

        }else{
                        //These are the conditions if the game ended in a tie.
            textResult.setText("It's a tie :)");
        }




        System.out.println("Selected option: " + appChoice);




    }
}