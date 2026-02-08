package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import d.b;
import e.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {
    private int mAddingObserverCounter;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred;
    private e.a mObserverMap;
    private ArrayList<Lifecycle.State> mParentStates;
    private Lifecycle.State mState;

    public static class ObserverWithState {
        LifecycleEventObserver mLifecycleObserver;
        Lifecycle.State mState;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.mState = state;
        }

        public void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.mState = LifecycleRegistry.min(this.mState, targetState);
            this.mLifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.mState = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0013, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void backwardPass(androidx.lifecycle.LifecycleOwner r6) {
        /*
            r5 = this;
            e.a r0 = r5.mObserverMap
            e.b r1 = new e.b
            e.c r2 = r0.f1750b
            e.c r3 = r0.f1749a
            r4 = 1
            r1.<init>(r2, r3, r4)
            java.util.WeakHashMap r0 = r0.f1751c
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.put(r1, r2)
        L13:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L73
            boolean r0 = r5.mNewEventOccurred
            if (r0 != 0) goto L73
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getValue()
            androidx.lifecycle.LifecycleRegistry$ObserverWithState r2 = (androidx.lifecycle.LifecycleRegistry.ObserverWithState) r2
        L29:
            androidx.lifecycle.Lifecycle$State r3 = r2.mState
            androidx.lifecycle.Lifecycle$State r4 = r5.mState
            int r3 = r3.compareTo(r4)
            if (r3 <= 0) goto L13
            boolean r3 = r5.mNewEventOccurred
            if (r3 != 0) goto L13
            e.a r3 = r5.mObserverMap
            java.lang.Object r4 = r0.getKey()
            androidx.lifecycle.LifecycleObserver r4 = (androidx.lifecycle.LifecycleObserver) r4
            java.util.HashMap r3 = r3.f1738e
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L13
            androidx.lifecycle.Lifecycle$State r3 = r2.mState
            androidx.lifecycle.Lifecycle$Event r3 = androidx.lifecycle.Lifecycle.Event.downFrom(r3)
            if (r3 == 0) goto L5d
            androidx.lifecycle.Lifecycle$State r4 = r3.getTargetState()
            r5.pushParentState(r4)
            r2.dispatchEvent(r6, r3)
            r5.popParentState()
            goto L29
        L5d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "no event down from "
            r6.<init>(r0)
            androidx.lifecycle.Lifecycle$State r0 = r2.mState
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.backwardPass(androidx.lifecycle.LifecycleOwner):void");
    }

    private Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        HashMap map = this.mObserverMap.f1738e;
        Lifecycle.State state = null;
        c cVar = map.containsKey(lifecycleObserver) ? ((c) map.get(lifecycleObserver)).f1743d : null;
        Lifecycle.State state2 = cVar != null ? ((ObserverWithState) cVar.f1741b).mState : null;
        if (!this.mParentStates.isEmpty()) {
            state = this.mParentStates.get(r0.size() - 1);
        }
        return min(min(this.mState, state2), state);
    }

    public static LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner) {
        return new LifecycleRegistry(lifecycleOwner, false);
    }

    @SuppressLint({"RestrictedApi"})
    private void enforceMainThreadIfNeeded(String str) {
        if (!this.mEnforceMainThread || b.E0().f1701c.E0()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void forwardPass(androidx.lifecycle.LifecycleOwner r6) {
        /*
            r5 = this;
            e.a r0 = r5.mObserverMap
            r0.getClass()
            e.d r1 = new e.d
            r1.<init>(r0)
            java.util.WeakHashMap r0 = r0.f1751c
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.put(r1, r2)
        L11:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L6f
            boolean r0 = r5.mNewEventOccurred
            if (r0 != 0) goto L6f
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getValue()
            androidx.lifecycle.LifecycleRegistry$ObserverWithState r2 = (androidx.lifecycle.LifecycleRegistry.ObserverWithState) r2
        L27:
            androidx.lifecycle.Lifecycle$State r3 = r2.mState
            androidx.lifecycle.Lifecycle$State r4 = r5.mState
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L11
            boolean r3 = r5.mNewEventOccurred
            if (r3 != 0) goto L11
            e.a r3 = r5.mObserverMap
            java.lang.Object r4 = r0.getKey()
            androidx.lifecycle.LifecycleObserver r4 = (androidx.lifecycle.LifecycleObserver) r4
            java.util.HashMap r3 = r3.f1738e
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L11
            androidx.lifecycle.Lifecycle$State r3 = r2.mState
            r5.pushParentState(r3)
            androidx.lifecycle.Lifecycle$State r3 = r2.mState
            androidx.lifecycle.Lifecycle$Event r3 = androidx.lifecycle.Lifecycle.Event.upFrom(r3)
            if (r3 == 0) goto L59
            r2.dispatchEvent(r6, r3)
            r5.popParentState()
            goto L27
        L59:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "no event up from "
            r6.<init>(r0)
            androidx.lifecycle.Lifecycle$State r0 = r2.mState
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.forwardPass(androidx.lifecycle.LifecycleOwner):void");
    }

    private boolean isSynced() {
        e.a aVar = this.mObserverMap;
        if (aVar.f1752d == 0) {
            return true;
        }
        Lifecycle.State state = ((ObserverWithState) aVar.f1749a.f1741b).mState;
        Lifecycle.State state2 = ((ObserverWithState) aVar.f1750b.f1741b).mState;
        return state == state2 && this.mState == state2;
    }

    public static Lifecycle.State min(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void moveToState(Lifecycle.State state) {
        Lifecycle.State state2 = this.mState;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.mState);
        }
        this.mState = state;
        if (this.mHandlingEvent || this.mAddingObserverCounter != 0) {
            this.mNewEventOccurred = true;
            return;
        }
        this.mHandlingEvent = true;
        sync();
        this.mHandlingEvent = false;
        if (this.mState == Lifecycle.State.DESTROYED) {
            this.mObserverMap = new e.a();
        }
    }

    private void popParentState() {
        this.mParentStates.remove(r1.size() - 1);
    }

    private void pushParentState(Lifecycle.State state) {
        this.mParentStates.add(state);
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!isSynced()) {
            this.mNewEventOccurred = false;
            if (this.mState.compareTo(((ObserverWithState) this.mObserverMap.f1749a.f1741b).mState) < 0) {
                backwardPass(lifecycleOwner);
            }
            c cVar = this.mObserverMap.f1750b;
            if (!this.mNewEventOccurred && cVar != null && this.mState.compareTo(((ObserverWithState) cVar.f1741b).mState) > 0) {
                forwardPass(lifecycleOwner);
            }
        }
        this.mNewEventOccurred = false;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.mState;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (((ObserverWithState) this.mObserverMap.b(lifecycleObserver, observerWithState)) == null && (lifecycleOwner = this.mLifecycleOwner.get()) != null) {
            boolean z2 = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
            Lifecycle.State stateCalculateTargetState = calculateTargetState(lifecycleObserver);
            this.mAddingObserverCounter++;
            while (observerWithState.mState.compareTo(stateCalculateTargetState) < 0 && this.mObserverMap.f1738e.containsKey(lifecycleObserver)) {
                pushParentState(observerWithState.mState);
                Lifecycle.Event eventUpFrom = Lifecycle.Event.upFrom(observerWithState.mState);
                if (eventUpFrom == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.mState);
                }
                observerWithState.dispatchEvent(lifecycleOwner, eventUpFrom);
                popParentState();
                stateCalculateTargetState = calculateTargetState(lifecycleObserver);
            }
            if (!z2) {
                sync();
            }
            this.mAddingObserverCounter--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.f1752d;
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    @Deprecated
    public void markState(Lifecycle.State state) {
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver lifecycleObserver) {
        enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.c(lifecycleObserver);
    }

    public void setCurrentState(Lifecycle.State state) {
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z2) {
        this.mObserverMap = new e.a();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList<>();
        this.mLifecycleOwner = new WeakReference<>(lifecycleOwner);
        this.mState = Lifecycle.State.INITIALIZED;
        this.mEnforceMainThread = z2;
    }
}
