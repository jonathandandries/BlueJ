
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

/**
 * Write a description of class FlashCards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlashCards
{
    static AnswerKey[] questions = {
            new AnswerKey("arbusto", "bush"),
            new AnswerKey("hierba", "grass"),
            new AnswerKey("rama", "branch"),
            new AnswerKey("gusano", "worm"),
            new AnswerKey("el lirio", "lily"),
            new AnswerKey("la raíz", "root"),
            new AnswerKey("el árbol", "tree"),
            new AnswerKey("el jardín", "garden"),
        };
    static int maxTries = 2;

    public static void main(String[] args) {
        System.out.format("**************** %n* Welcome to my FlashCard application.%n* Good luck!%n**************** %n");
        Scanner scanner = new Scanner(System.in);
        List<AnswerKey> questionsShuffled = Arrays.asList(questions);
        Collections.shuffle(questionsShuffled);
        int correctcount =0;
        for (AnswerKey key : questionsShuffled){
            int tries = 0;
            while (tries < maxTries) {
                System.out.format("What is the English translation of: %s? ", key.getQuestion());
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("idk")) {
                    System.out.format("Wrong answer. The correct answer is: \"%s\"%n%n", key.getAnswer());
                    System.out.println("Skipping to the next question");
                    
                    break;
                }
                if (answer.equalsIgnoreCase(key.getAnswer())) {
                    correctcount++;
                    System.out.format("Correct!%n%n");
                    break;
                } else {
                    tries++;
                    if (tries < maxTries) {
                        System.out.format("Wrong answer. Please try again.%n");
                    } else {
                        System.out.format("Wrong answer. The correct answer is: \"%s\"%n%n", key.getAnswer());
                    }
                }
            }
        }
        System.out.format("--------------------------------%nWe're done here.%n");
        System.out.println("Number of correct answers: "+correctcount+"/"+questions.length);
    }
}
