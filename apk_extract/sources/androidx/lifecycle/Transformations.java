package androidx.lifecycle;

/* loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    public static <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            boolean mFirstTime = true;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x2) {
                T value = mediatorLiveData.getValue();
                if (this.mFirstTime || ((value == 0 && x2 != null) || !(value == 0 || value.equals(x2)))) {
                    this.mFirstTime = false;
                    mediatorLiveData.setValue(x2);
                }
            }
        });
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> map(LiveData<X> liveData, final f.a aVar) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x2) {
                mediatorLiveData.setValue(aVar.apply(x2));
            }
        });
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final f.a aVar) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x2) {
                LiveData<Y> liveData2 = (LiveData) aVar.apply(x2);
                Object obj = this.mSource;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.mSource = liveData2;
                if (liveData2 != 0) {
                    mediatorLiveData.addSource(liveData2, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        @Override // androidx.lifecycle.Observer
                        public void onChanged(Y y2) {
                            mediatorLiveData.setValue(y2);
                        }
                    });
                }
            }
        });
        return mediatorLiveData;
    }
}
