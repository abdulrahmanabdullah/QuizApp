package abdulrahmanjavanrd.com.quizapp_project3.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import abdulrahmanjavanrd.com.quizapp_project3.model.ChoiceQue;
/**
 * @author  by Abdulrahman abdullah
 * @since  on 28/11/2017.
 */
public class ChoiceQuestionRecycler extends RecyclerView.Adapter<ChoiceQuestionRecycler.MyViewHolder> {
    private List<ChoiceQue> mData;
    private LayoutInflater mInflater;
    public Context context ;
    int lastSelection  ;
    int getAllScore ;

    /**
     * @param data List value of ChoiceQue, When i call This call i can passing static arrayList .
     * @param ctx  to declare the LayoutInflater .
     */
    public ChoiceQuestionRecycler(Context ctx , List<ChoiceQue> data ) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(ctx);
        this.context = ctx ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("recycler ", " OnCreateViewHolder ");
        View v = mInflater.inflate(R.layout.choice_question_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final  MyViewHolder holder,final int position) {
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
        RadioGroup rdGroup ;
        RadioButton o1, o2, o3, o4;
        int position;
        ChoiceQue choiceQue;
        public MyViewHolder(View v) {
            super(v);
            imgQ = v.findViewById(R.id.img_choice_q);
            rdGroup = v.findViewById(R.id.rd_group);
            txvChoiceQ = v.findViewById(R.id.txv_choice_q);
            o1 = v.findViewById(R.id.option_1);
//            o1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int i = getAdapterPosition();
//                    if( i ==1 || i == 5 ){
//                        getAllScore++;
////                        o1.setId(i);
////                        o1.setBackgroundColor(Color.GREEN);
//                        imgQ.setImageResource(R.drawable.ic_right);
//                        rdGroup.setId(i);
//                        Toast.makeText(context," total = "+ getAllScore,Toast.LENGTH_SHORT).show();
//                        Toast.makeText(context," RdGroup =  "+ rdGroup.getId(),Toast.LENGTH_SHORT).show();
//
//                        Toast.makeText(context," child  =  "+ o1.getId(),Toast.LENGTH_SHORT).show();
//                    }
//                    else {
////                        o1.setId(i);
//                        o1.setBackgroundColor(Color.RED);
//                        rdGroup.setEnabled(false);
//                        imgQ.setImageResource(R.drawable.ic_cross);
//                    }
//                }
//            });
            o2 = v.findViewById(R.id.option_2);
//            o2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int i = getAdapterPosition();
//                    if (i == 3 ) {
//                        getAllScore++;
//                        imgQ.setImageResource(R.drawable.ic_right);
//                        rdGroup.setId(i);
//                        Toast.makeText(context, " total = " + getAllScore, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(context," RdGroup =  "+ rdGroup.getId(),Toast.LENGTH_SHORT).show();
//                        Toast.makeText(context," child  =  "+ o2.getId(),Toast.LENGTH_SHORT).show();
//                    }else {
////                        o2.setId(i);
//                        o2.setBackgroundColor(Color.RED);
//                        o2.setChecked(false);
//                        imgQ.setImageResource(R.drawable.ic_cross);
//                    }
//                }
//            });
            o3 = v.findViewById(R.id.option_3);
//            o3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int i = getAdapterPosition();
//                    if( i == 4 || i == 6){
//                        getAllScore++;
//                        rdGroup.setId(i);
//                   imgQ.setImageResource(R.drawable.ic_right);
//                    Toast.makeText(context," total = "+ getAllScore,Toast.LENGTH_SHORT).show();
//                        Toast.makeText(context," RdGroup = "+ rdGroup.getId(),Toast.LENGTH_SHORT).show();
//                        Toast.makeText(context," child  =  "+ o3.getId(),Toast.LENGTH_SHORT).show();
//                    }
//                    else {
////                        o3.setId(i);
//                        o3.setBackgroundColor(Color.RED);
//                        rdGroup.setEnabled(false);
//                        imgQ.setImageResource(R.drawable.ic_cross);
//                    }
//                    Toast.makeText(context," total = "+ getAllScore,Toast.LENGTH_SHORT).show();
//
//                }
//            });
            o4 = v.findViewById(R.id.option_4);
            rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int i = getAdapterPosition() ;
                    setAnswer(i);
                    Toast.makeText(context," Here id = "+ rdGroup.getId() ,Toast.LENGTH_SHORT).show();
                }
            });
        }
        public void setAnswer(int position ){
            rdGroup.setId(position);
            switch (rdGroup.getId()){
                case 0:
                    compareAnswer(rdGroup.getCheckedRadioButtonId() ,o4.getId());// true .
                    break;
                case 1 :
                    compareAnswer(rdGroup.getCheckedRadioButtonId(),o1.getId());
                    break;
                case 2 :
                    compareAnswer(rdGroup.getCheckedRadioButtonId() , o4.getId());
                    break;
                case 3 :
                    compareAnswer(rdGroup.getCheckedRadioButtonId(),o2.getId());
                    break;
                case 4 :
                    compareAnswer(rdGroup.getCheckedRadioButtonId(),o3.getId());
                    break;
                case 5 :
                    compareAnswer(rdGroup.getCheckedRadioButtonId(),o1.getId());
                    break;
                case  6:
                    compareAnswer(rdGroup.getCheckedRadioButtonId(),o3.getId());
                    break;
                default:
                    break;
            }
        }

        public boolean compareAnswer(int left ,int right){
            boolean isCorrect = false ;
                if (left == right){
                    imgQ.setImageResource(R.drawable.ic_right);
                    for (int j = 0; j < rdGroup.getChildCount(); j++) {
                        rdGroup.getChildAt(j).setEnabled(false);
                    }
                    isCorrect =true;
                }else {
                    imgQ.setImageResource(R.drawable.ic_cross);
                    for (int j = 0; j < rdGroup.getChildCount(); j++) {
                        rdGroup.getChildAt(j).setEnabled(false);
                    }
                }
            return isCorrect;
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
                 *   In this loop I can injection data in RadioButton .
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
