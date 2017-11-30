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
        String[] allQuestion = {"What is the default value of LocalVariable?","What is the Size of a char?","Java run on ","What is the correct syntax for java main method ?","Choose the appropriate data type for this values : A ","Result in : int t=6.7 ?" ,"The most common use of an array is to : "};
        return  allQuestion ;
    }

   public  static String[] setRadioAnswer(int position){
        HashMap<Integer ,String[] > mapList = new HashMap<>();
        String[] a1 = {"null","0","depends of data type","no default value for LocalVariable"};// Correct answer is = 3 .
        String[] a2 = {"16bit","8bit","7bit","4bit"};//Correct answer is = 0.
        String[] a3 = {"Windows","Linux","Mac","All OS"};// Correct answer is = 3
        String[] a4 = {"public void main()","public static void main(String[] args)","public static void main()","None of the above"};// correct answer is 1
        String[] a5 = {"int","String","Char","Double"};// Correct answer is = 2
        String[] a6 = {"compilation error","RunTime error","t = 6.7","t = 6"};//correct answer is = 0
        String[] a7 = {"Perform while loop on array","Perform for loop on array","Perform the some operation on all element","Perform different operation one each element in array "};// correct answer is = 2
        mapList.put(0,a1); mapList.put(1,a2);mapList.put(2,a3);mapList.put(3,a4);mapList.put(4,a5);mapList.put(5,a6);mapList.put(6,a7);
        return mapList.get(position);
    }
}
