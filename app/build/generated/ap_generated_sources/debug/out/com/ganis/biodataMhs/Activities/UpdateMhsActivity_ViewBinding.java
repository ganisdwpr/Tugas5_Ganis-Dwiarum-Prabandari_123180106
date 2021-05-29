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

public class UpdateMhsActivity_ViewBinding implements Unbinder {
  private UpdateMhsActivity target;

  private View view7f08004b;

  @UiThread
  public UpdateMhsActivity_ViewBinding(UpdateMhsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateMhsActivity_ViewBinding(final UpdateMhsActivity target, View source) {
    this.target = target;

    View view;
    target.edtNamaMhs = Utils.findRequiredViewAsType(source, R.id.edtNamaMhs, "field 'edtNamaMhs'", EditText.class);
    target.edtNIM = Utils.findRequiredViewAsType(source, R.id.edtNIM, "field 'edtNIM'", EditText.class);
    target.edtJKMhs = Utils.findRequiredViewAsType(source, R.id.edtJadwal, "field 'edtJKMhs'", EditText.class);
    target.edtAsal = Utils.findRequiredViewAsType(source, R.id.edtAsal, "field 'edtAsal'", EditText.class);
    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.edtEmail, "field 'edtEmail'", EditText.class);
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
    UpdateMhsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtNamaMhs = null;
    target.edtNIM = null;
    target.edtJKMhs = null;
    target.edtAsal = null;
    target.edtEmail = null;
    target.btnSimpan = null;

    view7f08004b.setOnClickListener(null);
    view7f08004b = null;
  }
}
