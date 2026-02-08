package androidx.lifecycle;

import e.e;
import e.g;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private g mSources = new g();

    public static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion = -1;

        public Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V v2) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v2);
            }
        }

        public void plug() {
            this.mLiveData.observeForever(this);
        }

        public void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    public <S> void addSource(LiveData<S> liveData, Observer<? super S> observer) {
        Source source = new Source(liveData, observer);
        Source source2 = (Source) this.mSources.b(liveData, source);
        if (source2 != null && source2.mObserver != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (source2 == null && hasActiveObservers()) {
            source.plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Iterator it = this.mSources.iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return;
            } else {
                ((Source) ((Map.Entry) eVar.next()).getValue()).plug();
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        Iterator it = this.mSources.iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return;
            } else {
                ((Source) ((Map.Entry) eVar.next()).getValue()).unplug();
            }
        }
    }

    public <S> void removeSource(LiveData<S> liveData) {
        Source source = (Source) this.mSources.c(liveData);
        if (source != null) {
            source.unplug();
        }
    }
}
