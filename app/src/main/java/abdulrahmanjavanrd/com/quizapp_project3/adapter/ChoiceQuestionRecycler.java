package abdulrahmanjavanrd.com.quizapp_project3.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import abdulrahmanjavanrd.com.quizapp_project3.R;
import abdulrahmanjavanrd.com.quizapp_project3.model.ChoiceQue;

/**
 * Created by nfs05 on 28/11/2017.
 */

public class ChoiceQuestionRecycler extends RecyclerView.Adapter<ChoiceQuestionRecycler.MyViewHolder> {


    private List<ChoiceQue> mData ;
    private LayoutInflater mInflater ;

    public ChoiceQuestionRecycler(List<ChoiceQue> data , Context ctx ){
        this.mData = data ;
        this.mInflater = LayoutInflater.from(ctx);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("recycler " , " OnCreateViewHolder ");
        View v = mInflater.inflate(R.layout.choice_question_layout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i("recycler " , " OnBindViewHolder" + position);
        ChoiceQue currentObjec = mData.get(position);
        holder.setData(currentObjec,position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txvChoiceQ ;
        ImageView imgQ ;
        int position ;
        ChoiceQue choiceQue ;
        public MyViewHolder(View v){
            super(v);
            imgQ = v.findViewById(R.id.img_choice_q);
            txvChoiceQ = v.findViewById(R.id.txv_choice_q);
        }

        public void setData(ChoiceQue currentObjec, int position) {
           this.imgQ.setImageResource(currentObjec.getQuestionNumber());
          this.txvChoiceQ.setText(currentObjec.getQuestion());
            this.position = position ;
            this.choiceQue = currentObjec ;
        }
    }
}
