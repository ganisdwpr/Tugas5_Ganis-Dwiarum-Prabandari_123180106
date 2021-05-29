package com.ganis.biodataMhs.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.ganis.biodataMhs.Activities.UpdateMhsActivity;
import com.ganis.biodataMhs.Activities.UpdatePlugActivity;
import com.ganis.biodataMhs.Database.Constant;
import com.ganis.biodataMhs.Database.MhsDatabase;
import com.ganis.biodataMhs.Model.MhsModel;
import com.ganis.biodataMhs.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.ViewHolder> {

    private final Context context;
    private final List<MhsModel> mhsModelList;
    private Bundle bundle;
    private String firstName;
    private MhsDatabase mhsDatabase;

    public MhsAdapter(Context context, List<MhsModel> mhsModelList) {
        this.context = context;
        this.mhsModelList = mhsModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mhs, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // memindahkan data yang dipilih ke dalam list
        final MhsModel mhsModel = mhsModelList.get(position);

        // Menampilkan data ke layar
        holder.txtNameSiswa.setText(mhsModel.getNama_siswa());

        // Mengambil huruf pertama
        String nama = mhsModel.getNama_siswa();
        if (!nama.isEmpty()) {
            firstName = nama.substring(0, 1);
        } else {
            firstName = " ";
        }

        ColorGenerator generator = ColorGenerator.MATERIAL;
        // generate random color
        int color = generator.getRandomColor();

        TextDrawable drawable = TextDrawable.builder().buildRound(firstName, color);
        holder.imgView.setImageDrawable(drawable);
        
        // Membuat onclick icon overflow
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                // Buat object database
                mhsDatabase = mhsDatabase.createDatabase(context);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Kamu yakin akan menghapus " + mhsModel.getNama_siswa() + " ?");
                alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // Melakukan operasi delete data
                        mhsDatabase.plugDao().deleteSiswa(mhsModel);

                        // Menghapus data yang telash di hapus pada List
                        mhsModelList.remove(position);

                        // Memberitahu bahwa data sudah hilang
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(0, mhsModelList.size());

                        Toast.makeText(context, "Berhasil dihapus!", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        // Membuat onclick icon overflow
        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // Membuat object bundle
                bundle = new Bundle();

                // Mengisi bundle dengan data
                bundle.putInt(Constant.KEY_ID_MHS, mhsModel.getId_mhs());
                bundle.putString(Constant.KEY_NAMA_MHS, mhsModel.getNama_siswa());
                bundle.putString(Constant.KEY_NIM_MHS, mhsModel.getUmur());
                bundle.putString(Constant.KEY_JK_MHS, mhsModel.getJenis_kelamin());
                bundle.putString(Constant.KEY_ALAMAT_MHS, mhsModel.getAsal());
                bundle.putString(Constant.KEY_EMAIL_MHS, mhsModel.getEmail());

                // Berpindah halaman dengan membawa data
                context.startActivity(new Intent(context, UpdatePlugActivity.class).putExtras(bundle));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mhsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_view)
        ImageView imgView;
        @BindView(R.id.txt_name_siswa)
        TextView txtNameSiswa;
        @BindView(R.id.btnDelete)
        ImageButton btnDelete;
        @BindView(R.id.btnView)
        ImageButton btnView;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
