package abdulrahmanjavanrd.com.quizapp_project3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import abdulrahmanjavanrd.com.quizapp_project3.R;
import abdulrahmanjavanrd.com.quizapp_project3.model.ChoiceQue;
/**
 * @author  by Abdulrahman abdullah
 * @since  on 28/11/2017.
 */
public class ChoiceQuestionRecycler extends RecyclerView.Adapter<ChoiceQuestionRecycler.MyViewHolder> {
    private List<ChoiceQue> mData;
    private LayoutInflater mInflater;

    /**
     * @param data List value of ChoiceQue, When i call This call i can passing static arrayList .
     * @param ctx  to declare the LayoutInflater .
     */
    public ChoiceQuestionRecycler(List<ChoiceQue> data, Context ctx) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(ctx);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("recycler ", " OnCreateViewHolder ");
        View v = mInflater.inflate(R.layout.choice_question_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i("recycler ", " OnBindViewHolder" + position);
        ChoiceQue currentObject = mData.get(position);
        holder.setData(currentObject, position);
    }

    /**
     * @return size of list<ChoiceQue>, In  this app it'll be 6
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txvChoiceQ;
        ImageView imgQ;
        RadioButton o1, o2, o3, o4;
        int position;
        ChoiceQue choiceQue;

        public MyViewHolder(View v) {
            super(v);
            imgQ = v.findViewById(R.id.img_choice_q);
            o1 = v.findViewById(R.id.option_1);
            o2 = v.findViewById(R.id.option_2);
            o3 = v.findViewById(R.id.option_3);
            o4 = v.findViewById(R.id.option_4);
            txvChoiceQ = v.findViewById(R.id.txv_choice_q);
        }

        /**
         * @param currentObject get instance of ChoiceQue
         * @param position      to modify each object
         */
        public void setData(ChoiceQue currentObject, int position) {
            this.imgQ.setImageResource(currentObject.getQuestionNumber());
            this.txvChoiceQ.setText(currentObject.getQuestion());
            try {
                String[] radioArray = ChoiceQue.setRadioAnswer(position);
                Log.i("array", " Now length array = " + radioArray.length);
                /**
                 * One repeating loop, Because i want to access all RadioButton for each card .
                 * Example  radioArray= {"a","b","c","d"}
                 *   In this loop I can retrieve data in RadioButton .
                 */
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
    }
}
