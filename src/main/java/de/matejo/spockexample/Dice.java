package de.matejo.spockexample;

// this class will be mocked
public class Dice {
    public int roll() {
        // should return a number between 1 an 6
        // and is currently only mocked
        return -1;
    }
}
