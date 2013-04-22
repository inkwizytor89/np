package main;

public class Main {

    public static void main(String[] args) {
        String input = null;
        String output = null;
        
        if(args.length > 0) {
            input = args[0];
        }
        
        if(args.length > 1) {
            output = args[1];
        }
        
        new Manager(input, output);
        
    }
}
