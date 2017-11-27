package abdulrahmanjavanrd.com.quizapp_project3.model;

import java.util.ArrayList;

import abdulrahmanjavanrd.com.quizapp_project3.R;

/**
 * @author  Abdulrahman abdullah .
 */
public class ChoiceQue {

    String question ;
    String[] choice ;
    int questionNumber ;

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoice() {
        return choice;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public static ArrayList<ChoiceQue> getData(){
        ArrayList<ChoiceQue> listQuestion = new ArrayList<>();

        String[] allQ = allQuestion() ;
        int[] images = getImages() ;

        for (int i =0 ; i < images.length ;i++){
            ChoiceQue q1 = new ChoiceQue();
            q1.setQuestion(allQ[i]);
            q1.setChoice(allQ);
            q1.setQuestionNumber(images[i]);
            listQuestion.add(q1);
        }
        return listQuestion ;
    }
    private static int[] getImages(){
        int[] img = {R.drawable.ic_one, R.drawable.ic_two, R.drawable.ic_three, R.drawable.ic_four, R.drawable.ic_five
                ,R.drawable.ic_six,R.drawable.ic_seven
        };
        return img ;
    }

    private static String[] allQuestion(){
        String[] allQuestion = {"q1","q2","q3","q4"};
        return  allQuestion ;
    }
}
