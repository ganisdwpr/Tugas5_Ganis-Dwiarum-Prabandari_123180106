// Generated code from Butter Knife. Do not modify!
package com.ganis.biodataMhs.Adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ganis.biodataMhs.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlugAdapter$ViewHolder_ViewBinding implements Unbinder {
  private PlugAdapter.ViewHolder target;

  @UiThread
  public PlugAdapter$ViewHolder_ViewBinding(PlugAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvNamaKelas = Utils.findRequiredViewAsType(source, R.id.tvNamaKelas, "field 'tvNamaKelas'", TextView.class);
    target.tvNamaWali = Utils.findRequiredViewAsType(source, R.id.tvNamaWali, "field 'tvNamaWali'", TextView.class);
    target.tvJadwal = Utils.findRequiredViewAsType(source, R.id.tvJadwal, "field 'tvJadwal'", TextView.class);
    target.cvKelas = Utils.findRequiredViewAsType(source, R.id.cvKelas, "field 'cvKelas'", CardView.class);
    target.overflow = Utils.findRequiredViewAsType(source, R.id.overflow, "field 'overflow'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlugAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvNamaKelas = null;
    target.tvNamaWali = null;
    target.tvJadwal = null;
    target.cvKelas = null;
    target.overflow = null;
  }
}