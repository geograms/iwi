package androidx.recyclerview.widget;

import android.view.ViewGroup;
import java.util.List;

/* loaded from: classes.dex */
public abstract class v0 {
    private final w0 mObservable = new w0();
    private boolean mHasStableIds = false;

    public final void bindViewHolder(z1 z1Var, int i2) {
        z1Var.mPosition = i2;
        if (hasStableIds()) {
            z1Var.mItemId = getItemId(i2);
        }
        z1Var.setFlags(1, 519);
        n.e.a("RV OnBindView");
        onBindViewHolder(z1Var, i2, z1Var.getUnmodifiedPayloads());
        z1Var.clearPayload();
        ViewGroup.LayoutParams layoutParams = z1Var.itemView.getLayoutParams();
        if (layoutParams instanceof i1) {
            ((i1) layoutParams).f854c = true;
        }
        n.e.b();
    }

    public final z1 createViewHolder(ViewGroup viewGroup, int i2) {
        try {
            n.e.a("RV CreateView");
            z1 z1VarOnCreateViewHolder = onCreateViewHolder(viewGroup, i2);
            if (z1VarOnCreateViewHolder.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            z1VarOnCreateViewHolder.mItemViewType = i2;
            return z1VarOnCreateViewHolder;
        } finally {
            n.e.b();
        }
    }

    public abstract int getItemCount();

    public long getItemId(int i2) {
        return -1L;
    }

    public int getItemViewType(int i2) {
        return 0;
    }

    public final boolean hasObservers() {
        return this.mObservable.a();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.b();
    }

    public final void notifyItemChanged(int i2, Object obj) {
        this.mObservable.d(i2, 1, obj);
    }

    public final void notifyItemInserted(int i2) {
        this.mObservable.e(i2, 1);
    }

    public final void notifyItemMoved(int i2, int i3) {
        this.mObservable.c(i2, i3);
    }

    public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
        this.mObservable.d(i2, i3, obj);
    }

    public final void notifyItemRangeInserted(int i2, int i3) {
        this.mObservable.e(i2, i3);
    }

    public final void notifyItemRangeRemoved(int i2, int i3) {
        this.mObservable.f(i2, i3);
    }

    public final void notifyItemRemoved(int i2) {
        this.mObservable.f(i2, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(z1 z1Var, int i2);

    public void onBindViewHolder(z1 z1Var, int i2, List<Object> list) {
        onBindViewHolder(z1Var, i2);
    }

    public abstract z1 onCreateViewHolder(ViewGroup viewGroup, int i2);

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(z1 z1Var) {
        return false;
    }

    public void onViewAttachedToWindow(z1 z1Var) {
    }

    public void onViewDetachedFromWindow(z1 z1Var) {
    }

    public void onViewRecycled(z1 z1Var) {
    }

    public void registerAdapterDataObserver(x0 x0Var) {
        this.mObservable.registerObserver(x0Var);
    }

    public void setHasStableIds(boolean z2) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.mHasStableIds = z2;
    }

    public void unregisterAdapterDataObserver(x0 x0Var) {
        this.mObservable.unregisterObserver(x0Var);
    }

    public final void notifyItemChanged(int i2) {
        this.mObservable.d(i2, 1, null);
    }

    public final void notifyItemRangeChanged(int i2, int i3) {
        this.mObservable.d(i2, i3, null);
    }
}
