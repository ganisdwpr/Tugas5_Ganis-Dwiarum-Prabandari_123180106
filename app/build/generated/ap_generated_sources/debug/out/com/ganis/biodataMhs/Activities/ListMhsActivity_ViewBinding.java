// Generated code from Butter Knife. Do not modify!
package com.ganis.biodataMhs.Activities;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ganis.biodataMhs.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListMhsActivity_ViewBinding implements Unbinder {
  private ListMhsActivity target;

  private View view7f080083;

  @UiThread
  public ListMhsActivity_ViewBinding(ListMhsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListMhsActivity_ViewBinding(final ListMhsActivity target, View source) {
    this.target = target;

    View view;
    target.rvMhs = Utils.findRequiredViewAsType(source, R.id.rvMhs, "field 'rvMhs'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fab, "field 'fab' and method 'onViewClicked'");
    target.fab = Utils.castView(view, R.id.fab, "field 'fab'", FloatingActionButton.class);
    view7f080083 = view;
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
    ListMhsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvMhs = null;
    target.fab = null;

    view7f080083.setOnClickListener(null);
    view7f080083 = null;
  }
}
