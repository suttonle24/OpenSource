/**
 * Created by lee on 5/18/16.
 */
public class Application {
    public static void main(String[] args) {
        runner();
    }

    private static Integer MAX_ITERATIONS = 1000;
    private static String  UP_DIRECTION = "up";
    private static String  DOWN_DIRECTION = "down";
    private static String  currentDirection = "";
    private static Integer iteration = 0;
    private static String currentString = "";
    private static Integer motionCounter = 0;
    private static String[] forwardCat = new String[]{
            "_._     _,-'\"\"`-._",
            "(,-.`._,'(       |\\`-/|",
            "    `-.-' \\ )-`( , o o)",
            "          `-    \\`_`\"'-"};
    private static String[] backwardCat = new String[]{
            "  /\\_/\\",
            "  >^.^<.---.",
            " _'-`-'     )\\",
            "(6--\\ |--\\ (`.`-.",
            "    --'  --'  ``-'"};


    // runner
    private static void runner(){
        try{
            checkIteration(iteration);

            checkDirection(currentString);

            printCat();

            iteration++;

            Thread.sleep(50);

            runner();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void checkIteration(Integer iteration){
        if(iteration >= MAX_ITERATIONS){
            System.exit(1);
        }
    }

    private static void checkDirection(String currentString) {
        if(motionCounter <= 0){
            currentDirection = UP_DIRECTION;
        }
        if(motionCounter >= 50){
            currentDirection = DOWN_DIRECTION;
        }
    }

    private static String alterString(String currentString){
        String updatedString = currentString;
        if(currentDirection.equals(UP_DIRECTION)){
            updatedString += "-";
        }
        else {
            updatedString = updatedString.substring(0, updatedString.length() - 1);
        }
        return updatedString;
    }

    private static void printCat(){
        if(currentDirection.equals(UP_DIRECTION)){
            motionCounter++;
            for(String s : forwardCat){
                String output = "";
                output = buildPrepend(motionCounter) + s;
                System.out.println(output);
            }
        }
        else {
            motionCounter--;
            for(String s : backwardCat){
                String output = "";
                output = buildPrepend(motionCounter) + s;
                System.out.println(output);
            }
        }
    }

    private static String buildPrepend(Integer motionCounter){
        String prependedString = "";
        for(int i = 0; i < motionCounter; i++){
            prependedString += " ";
        }
        return  prependedString;
    }
}
