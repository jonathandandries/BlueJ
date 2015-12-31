
/**
 * Write a description of class AnswerKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnswerKey
{
    private String question;
    private String answer;
    
    public AnswerKey(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
