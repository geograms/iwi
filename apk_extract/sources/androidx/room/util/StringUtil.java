package androidx.room.util;

import android.util.Log;
import androidx.room.Room;
import i1.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import x0.g;

/* loaded from: classes.dex */
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder sb, int i2) {
        g.u(sb, "builder");
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("?");
            if (i3 < i2 - 1) {
                sb.append(",");
            }
        }
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i2 = 0;
        for (Object obj : list) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ",");
            }
            g.e(sb, obj, null);
        }
        sb.append((CharSequence) "");
        String string = sb.toString();
        g.t(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        List list;
        Integer numValueOf;
        if (str == null) {
            return null;
        }
        String strValueOf = String.valueOf(',');
        int iH0 = c.H0(0, str, strValueOf, false);
        if (iH0 != -1) {
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iH0).toString());
                length = strValueOf.length() + iH0;
                iH0 = c.H0(length, str, strValueOf, false);
            } while (iH0 != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            list = arrayList;
        } else {
            List listSingletonList = Collections.singletonList(str.toString());
            g.t(listSingletonList, "singletonList(element)");
            list = listSingletonList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException e2) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e2);
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList2.add(numValueOf);
            }
        }
        return arrayList2;
    }
}
