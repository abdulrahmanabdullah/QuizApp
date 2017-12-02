package abdulrahmanjavanrd.com.quizapp_project3.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import abdulrahmanjavanrd.com.quizapp_project3.R;
import abdulrahmanjavanrd.com.quizapp_project3.constant.ConstantValues;
import abdulrahmanjavanrd.com.quizapp_project3.model.ChoiceQue;

/**
 * @author by Abdulrahman abdullah
 * @since on 28/11/2017.
 */
public class ChoiceQuestionRecycler extends RecyclerView.Adapter<ChoiceQuestionRecycler.MyViewHolder> {
    private List<ChoiceQue> mData;
    private LayoutInflater mInflater;
    public Context context;
    private int correctAnswer;

    /**
     * @param data List value of ChoiceQue, When i call This  i can pass static arrayList .
     * @param ctx  to declare the LayoutInflater .
     */
    public ChoiceQuestionRecycler(Context ctx, List<ChoiceQue> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(ctx);
        this.context = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("recycler ", " OnCreateViewHolder ");
        View v = mInflater.inflate(R.layout.choice_question_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Log.i("recycler ", " OnBindViewHolder" + position);
        ChoiceQue currentObject = mData.get(position);
        holder.setData(currentObject, position);
    }

    /**
     * @return size of list<ChoiceQue>
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * Inner class Extend RecyclerView.ViewHolder
     * In This class, Set Views elements and compare the answers of correct OR incorrect.
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txvChoiceQ;
        ImageView imgQ;
        RadioGroup rdGroup;
        RadioButton o1, o2, o3, o4;
        int position;
        ChoiceQue choiceQue;

        /**
         * Constructor method .
         *
         * @param v object of View to access all elements in the choice_question_layout.xml file
         */
        public MyViewHolder(View v) {
            super(v);
            imgQ = v.findViewById(R.id.img_choice_q);
            rdGroup = v.findViewById(R.id.rd_group);
            txvChoiceQ = v.findViewById(R.id.txv_choice_q);
            o1 = v.findViewById(R.id.option_1);
            o2 = v.findViewById(R.id.option_2);
            o3 = v.findViewById(R.id.option_3);
            o4 = v.findViewById(R.id.option_4);
            rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int i = getAdapterPosition();
                    setAnswer(i);
                }
            });
        }

        /**
         * @param position select the card on recycler view position .
         */
        public void setAnswer(int position) {
            rdGroup.setId(position);
            switch (rdGroup.getId()) {
                case 0:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(), o4.getId());
                    break;
                case 1:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(), o1.getId());
                    break;
                case 2:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(), o4.getId());
                    break;
                case 3:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(), o2.getId());
                    break;
                case 4:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(), o3.getId());
                    break;
                case 5:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(), o1.getId());
                    break;
                case 6:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(), o3.getId());
                    Toast.makeText(context, "Correct answer = " + correctAnswer, Toast.LENGTH_SHORT).show();
                    sendCorrectAnswer(correctAnswer);
                    break;
            }
        }

        /**
         * @param left  = the radioGroup position .
         * @param right = the RadioButton position .
         * @return if student select the right answer increment the{@link #correctAnswer} and
         * Set {@link #imgQ} right image then  return True .
         * , If student select the incorrect answer  Set {@link #imgQ} cross image and return false .
         */
        public boolean compareAnswer(int left, int right) {
            boolean isCorrect = false;
            if (left == right) {
                imgQ.setImageResource(R.drawable.ic_right);
                correctAnswer++;
                for (int j = 0; j < rdGroup.getChildCount(); j++) {
                    rdGroup.getChildAt(j).setEnabled(false);
                }
                isCorrect = true;
            } else {
                imgQ.setImageResource(R.drawable.ic_cross);
                for (int j = 0; j < rdGroup.getChildCount(); j++) {
                    rdGroup.getChildAt(j).setEnabled(false);
                }
            }
            return isCorrect;
        }

        /**
         * @param currentObject get instance of ChoiceQue.
         * @param position      of the currentObject in recycler view, And pass the question and image
         *                      <p>
         *                      Create One repeating loop, Because i want to access all RadioButton for each card .
         *                      Example  radioArray= {"a","b","c","d"}
         *                      In this loop I can injection data into the  RadioButton .
         */
        public void setData(ChoiceQue currentObject, int position) {
            this.imgQ.setImageResource(currentObject.getQuestionNumber());
            this.txvChoiceQ.setText(currentObject.getQuestion());
            try {
                String[] radioArray = ChoiceQue.setRadioAnswer(position);
                for (int i = 0; i <= 0; i++) {
                    o1.setText(radioArray[i]); // This equal index = 0  in array[position] .
                    o2.setText(radioArray[i + 1]);// This equal index = 1  in array[position] .
                    o3.setText(radioArray[i + 2]);// This equal index = 2  in array[position] .
                    o4.setText(radioArray[i + 3]);// This equal index = 3  in array[position] .
                }
            }
            /**
             * If {@link #radioArray} equal null .
             */ catch (NullPointerException ex) {
                Log.d("debug", "array is null  ");
            }
            this.position = position;
            this.choiceQue = currentObject;
        }

        /**
         * @param s pass the total of {@link #correctAnswer}
         */
        public void sendCorrectAnswer(int s) {
            SharedPreferences mShared = context.getSharedPreferences(context.getPackageName() + ConstantValues.FILE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mShared.edit();
            editor.putInt(ConstantValues.CORRECT_ANSWER_VALUES, s);
            editor.apply();
        }

    }
}
