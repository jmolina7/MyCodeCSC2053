package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    //the inflater creates the single item layout
    //see it used in onCreateViewHolder below
    private LayoutInflater mInflater;
    private LinkedList<String> mWordList;
    private Context context;

    //the constructor can take any parameters we need
    public WordListAdapter(Context context,
                           LinkedList<String> wordList) {
        //use this to create the layout
        mInflater = LayoutInflater.from(context);
        mWordList = wordList;
        this.context = context;
    }

    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.mWordItem.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //The RecyclerView.ViewHolder class must be an inner class
    //of the adapter class.
    //WordViewHolder is the Java class that represents the wordlist_item.xml layout
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mWordItem;
        private WordListAdapter mAdapter;

        //instantiate any views used in the item layout here
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            mWordItem = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        public void onClick(View v) {
            /*
            int mPosition = getLayoutPosition();
            String word = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked!" + word);
            mAdapter.notifyDataSetChanged();
             */
            Intent intent = new Intent(context, WordClickedActivity.class);
            context.startActivity(intent);
        }

    }
}
