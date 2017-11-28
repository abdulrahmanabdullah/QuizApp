package abdulrahmanjavanrd.com.quizapp_project3.model;

import java.util.ArrayList;
import java.util.HashMap;

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
        String[] allQuestion = {"q1","q2","q3","q4","q5","q6","q7"};
        return  allQuestion ;
    }

   public  static String[] setRadioAnswer(int position){
        HashMap<Integer ,String[] > mapList = new HashMap<>();
        String[] a1 = {"1","b","c","d"};
        String[] a2 = {"2","f","g","h"};
        String[] a3 = {"3","3","3","3"};
        String[] a4 = {"4","4","c","d"};
        String[] a5 = {"5","5","c","d"};
        String[] a6 = {"6","b","c","6"};
        String[] a7 = {"7","7","7","7"};
        mapList.put(0,a1);
        mapList.put(1,a2);
        mapList.put(2,a3);
        mapList.put(3,a4);
        mapList.put(4,a5);
        mapList.put(5,a6);
        mapList.put(6,a7);
        return mapList.get(position);
    }
}
