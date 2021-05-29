package com.ganis.biodataMhs.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.ganis.biodataMhs.Database.MhsDatabase;
import com.ganis.biodataMhs.Model.PlugModel;
import com.ganis.biodataMhs.R;
import com.ganis.biodataMhs.Activities.ListMhsActivity;
import com.ganis.biodataMhs.Activities.UpdatePlugActivity;
import com.ganis.biodataMhs.Database.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlugAdapter extends RecyclerView.Adapter<PlugAdapter.ViewHolder> {

    private final Context context;
    private final List<PlugModel> plugModelList;
    private MhsDatabase mhsDatabase;
    private Bundle bundle;

    public PlugAdapter(Context context, List<PlugModel> plugModelList) {
        this.context = context;
        this.plugModelList = plugModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_plug, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // Memindahkan data di dalam list dengan index position ke dalam PlugModel
        final PlugModel plugModel = plugModelList.get(position);

        // Menampilkan data ke layar
        holder.tvNamaWali.setText(plugModel.getNama_aslab());
        holder.tvNamaKelas.setText(plugModel.getNama_plug());
        holder.tvJadwal.setText(plugModel.getJadwal());

        ColorGenerator generator = ColorGenerator.MATERIAL;

        // generate random color
        int color = generator.getRandomColor();
        holder.cvKelas.setCardBackgroundColor(color);

        // Onlick pada itemview
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();

                bundle.putInt(Constant.KEY_ID_PLUG, plugModel.getId_plug());
                context.startActivity(new Intent(context, ListMhsActivity.class).putExtras(bundle));
            }
        });

        // Membuat onclick icon overflow
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                // Buat object database
                mhsDatabase = mhsDatabase.createDatabase(context);

                // Membuat object popumemu
                PopupMenu popupMenu = new PopupMenu(context, view);

                // Inflate menu ke dalam popupmenu
                popupMenu.inflate(R.menu.popup_menu);

                // Menampilkan menu
                popupMenu.show();

                // Onclick pada salah satu menu pada popupmenu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.delete:

                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder.setMessage("Kamu yakin akan menghapus " + plugModel.getNama_plug() + " ?");
                                alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        // Melakukan operasi delete data
                                        mhsDatabase.plugDao().delete(plugModel);

                                        // Menghapus data yang telah di hapus pada List
                                        plugModelList.remove(position);

                                        // Memberitahu bahwa data sudah hilang
                                        notifyItemRemoved(position);
                                        notifyItemRangeChanged(0, plugModelList.size());

                                        Toast.makeText(context, "Plug berhasil dihapus!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });

                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.show();

                                break;

                            case R.id.edit:

                                // Membuat object bundle
                                bundle = new Bundle();

                                // Mengisi bundle dengan data
                                bundle.putInt(Constant.KEY_ID_PLUG, plugModel.getId_plug());
                                bundle.putString(Constant.KEY_NAMA_PLUG, plugModel.getNama_plug());
                                bundle.putString(Constant.KEY_NAMA_ASLAB, plugModel.getNama_aslab());
                                bundle.putString(Constant.KEY_JUMLAH_SISWA, plugModel.getJumlah_siswa());
                                bundle.putString(Constant.KEY_JADWAL, plugModel.getJadwal());

                                // Berpindah halaman dengan membawa data
                                context.startActivity(new Intent(context, UpdatePlugActivity.class).putExtras(bundle));
                                break;
                        }
                        return true;
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return plugModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNamaKelas)
        TextView tvNamaKelas;
        @BindView(R.id.tvNamaWali)
        TextView tvNamaWali;
        @BindView(R.id.tvJadwal)
        TextView tvJadwal;
        @BindView(R.id.cvKelas)
        CardView cvKelas;
        @BindView(R.id.overflow)
        ImageButton overflow;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
