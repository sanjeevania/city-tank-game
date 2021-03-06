import objects.*;
import graphics.*;
import utilities.*;
import java.util.Scanner;

public class CityTankGame
{
  public static void main(String[] args)
  {
    //Create a scanner to take user input
    Scanner keyboard = new Scanner(System.in);

    //Create a player tank
    Tank playerTank = new Tank(35, 38);

    //Create a few enemy tanks
    Tank enemyTank1 = new Tank(5, 20, Commands.Direction.DOWN);
    Tank enemyTank2 = new Tank(5, 60, Commands.Direction.RIGHT);

    //Create the main renderer and add player tank
    Renderer mainRenderer = new Renderer(80, 40);
    mainRenderer.addTank(playerTank);
    mainRenderer.addTank(enemyTank1);
    mainRenderer.addTank(enemyTank2);

    //The main game loop
    do
    {
      //Clear the screen
      Commands.clearScreen();

      //Re-render the game screen
      mainRenderer.render();

      //Get user command
      System.out.println("Control your tank by typing a character and press Enter. ");
      System.out.println("W: up, A: left, S: right, Z: down, Q: quit the game.");
      String tempString = keyboard.next();
      char option = Character.toLowerCase(tempString.charAt(0));

      //Quit the game if Q is pressed
      if (option == 'q') break;

      //Control the player tank
      switch (option)
      {
        case 'w':
          playerTank.move(Commands.Direction.UP);
          break;
        case 'z':
          playerTank.move(Commands.Direction.DOWN);
          break;
        case 'a':
          playerTank.move(Commands.Direction.LEFT);
          break;
        case 's':
          playerTank.move(Commands.Direction.RIGHT);
          break;
        default:
          //do nothing
          break;
      }
    }  while (true);
  }
}
