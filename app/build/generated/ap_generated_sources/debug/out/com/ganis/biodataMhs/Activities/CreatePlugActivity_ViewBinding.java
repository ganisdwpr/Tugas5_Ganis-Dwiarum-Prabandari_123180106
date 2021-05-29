// Generated code from Butter Knife. Do not modify!
package com.ganis.biodataMhs.Activities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ganis.biodataMhs.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CreatePlugActivity_ViewBinding implements Unbinder {
  private CreatePlugActivity target;

  private View view7f08004b;

  @UiThread
  public CreatePlugActivity_ViewBinding(CreatePlugActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CreatePlugActivity_ViewBinding(final CreatePlugActivity target, View source) {
    this.target = target;

    View view;
    target.edtNamaKelas = Utils.findRequiredViewAsType(source, R.id.edtNamaPlug, "field 'edtNamaKelas'", EditText.class);
    target.edtNamaWali = Utils.findRequiredViewAsType(source, R.id.edtNamaAslab, "field 'edtNamaWali'", EditText.class);
    target.edtJumlahMhs = Utils.findRequiredViewAsType(source, R.id.edtJumlahMhs, "field 'edtJumlahMhs'", EditText.class);
    target.edtJadwal = Utils.findRequiredViewAsType(source, R.id.edtJadwal, "field 'edtJadwal'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSimpan, "field 'btnSimpan' and method 'onViewClicked'");
    target.btnSimpan = Utils.castView(view, R.id.btnSimpan, "field 'btnSimpan'", Button.class);
    view7f08004b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CreatePlugActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtNamaKelas = null;
    target.edtNamaWali = null;
    target.edtJumlahMhs = null;
    target.edtJadwal = null;
    target.btnSimpan = null;

    view7f08004b.setOnClickListener(null);
    view7f08004b = null;
  }
}
