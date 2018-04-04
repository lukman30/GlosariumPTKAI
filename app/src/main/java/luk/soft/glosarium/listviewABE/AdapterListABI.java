package luk.soft.glosarium.listviewABE;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pc_render.glosairumapi.R;

import java.util.List;

import luk.soft.glosarium.isimenu.AcronymandAbbreviationEnglish;
import luk.soft.glosarium.isimenu.AcronymandAbbreviationIndonesia;

public class AdapterListABI extends RecyclerView.Adapter<AdapterListABI.HolderData> {
    private List<Data> mItems;
    private Context context;

    public AdapterListABI(Context context, List<Data> items) {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public AdapterListABI.HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.tampil_listabe, parent, false);
        AdapterListABI.HolderData holderData = new AdapterListABI.HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(AdapterListABI.HolderData holder, int position) {
        Data md = mItems.get(position);
        holder.nama.setText(md.getNama());

        holder.md = md;


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder {
        TextView nama;
        Data md;

        RelativeLayout rel;

        public HolderData(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.istilah);
            rel=(RelativeLayout)view.findViewById(R.id.relativ);



            rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent update = new Intent(context, AcronymandAbbreviationIndonesia.class);
                    update.putExtra("update", 1);
                    update.putExtra("cari", md.getNama());
                    context.startActivity(update);
                }
            });
        }
    }
}
