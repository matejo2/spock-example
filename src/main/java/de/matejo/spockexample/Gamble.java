package de.matejo.spockexample;

// use dice and gamble
public class Gamble {

    private final Dice dice;

    public Gamble(Dice dice) {
        this.dice = dice;
    }

    public String assignPrice() {
        int result = dice.roll();
        System.out.println("result="+result);
        if(result == -1){
            return "error";
        }

        if (result == 6){
            return "you win";
        }
        return "you loose :(";

    }
}
