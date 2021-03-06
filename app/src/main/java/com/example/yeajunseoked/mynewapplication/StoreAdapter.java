package com.example.yeajunseoked.mynewapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
    Context context;
    ArrayList<StoreItem> items = new ArrayList<StoreItem>();

    //클릭 이벤트는 인터페이스로 만든다.
    public interface MyRecyclerViewClickListener {
        void onItemClicked(int position);
        void onShareButtonClocked(int position);
        void onLearnMoreButtonClicked(int position);
    }
    //이 인터페이스를 내부에서 하나 들고 있어야 한다.
    private MyRecyclerViewClickListener mListener;
    //외부에서
    public void setOnClickListenertttttttt(MyRecyclerViewClickListener listener) {
        mListener=listener;
    }

    /*public static interface OnItemClickListener {
        public void OnItemClick(ViewHolder holder, View view, int position); //내가 누른 아이템의 포지션을 외부에서 알수 있게끔
    }
    OnItemClickListener listener; //인터페이스이기 때문에 있어야 함
    public void setOnItemClickListener(OnItemClickListener listener) { //외부에서 리스트럴 지정할 수 있도록 메소드 만틈.
        this.listener = listener;
    }*/

    public StoreAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //뷰 홀더를 만드는 부분이고 만들어지면
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.store_item,parent,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //이쪽으로 들어온다.
        StoreItem item = items.get(position); //아이템 얻는 방법
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());
        //실제로 클릭이 일어나는 부분
        if (mListener != null){
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
            holder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onShareButtonClocked(pos);
                }
            });
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onLearnMoreButtonClicked(pos);
                }
            });
        }
    }
    public void addItem(StoreItem item) {
        items.add(item);
    }
    public StoreItem getItem(int position) {
        return items.get(position);
    }



    static class ViewHolder extends RecyclerView.ViewHolder { //ViewHolder 클래스 만듬
        TextView title;
        TextView contents;
        Button share;
        Button more;

        public ViewHolder(View itemView) { //생성자에는 전체 root 레이아웃에 해당하는 view가 들어온다.
            super(itemView);
            title = itemView.findViewById(R.id.title_text); //그래서 전체 레이아웃에서 찾는 것 이다.
            contents = itemView.findViewById(R.id.contents_text); //그래서 전체 레이아웃에서 찾는 것 이다.
            share = itemView.findViewById(R.id.share_button);
            more = itemView.findViewById(R.id.more_button);
        }
    }
}
