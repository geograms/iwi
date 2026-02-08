package androidx.room;

import androidx.appcompat.widget.ActivityChooserView;
import c1.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.q;
import v0.h;
import v0.i;
import v0.k;

/* loaded from: classes.dex */
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    public static final class Match {
        private final List<Integer> resultIndices;
        private final f1.c resultRange;

        public Match(f1.c cVar, List<Integer> list) {
            x0.g.u(cVar, "resultRange");
            x0.g.u(list, "resultIndices");
            this.resultRange = cVar;
            this.resultIndices = list;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final f1.c getResultRange() {
            return this.resultRange;
        }
    }

    public static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String str, int i2) {
            x0.g.u(str, "name");
            this.name = str;
            this.index = i2;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i3 & 2) != 0) {
                i2 = resultColumn.index;
            }
            return resultColumn.copy(str, i2);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String str, int i2) {
            x0.g.u(str, "name");
            return new ResultColumn(str, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return x0.g.g(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return Integer.hashCode(this.index) + (this.name.hashCode() * 31);
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    public static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(k.f2600a, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final Solution build(List<Match> list) {
                x0.g.u(list, "matches");
                int i2 = 0;
                int size = 0;
                for (Match match : list) {
                    size += ((match.getResultRange().f1764b - match.getResultRange().f1763a) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i3 = ((Match) it.next()).getResultRange().f1763a;
                while (it.hasNext()) {
                    int i4 = ((Match) it.next()).getResultRange().f1763a;
                    if (i3 > i4) {
                        i3 = i4;
                    }
                }
                Iterator<T> it2 = list.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i5 = ((Match) it2.next()).getResultRange().f1764b;
                while (it2.hasNext()) {
                    int i6 = ((Match) it2.next()).getResultRange().f1764b;
                    if (i5 < i6) {
                        i5 = i6;
                    }
                }
                Iterable cVar = new f1.c(i3, i5, 1);
                if (!(cVar instanceof Collection) || !((Collection) cVar).isEmpty()) {
                    Iterator it3 = cVar.iterator();
                    int i7 = 0;
                    while (((f1.b) it3).f1768c) {
                        int iB = ((f1.b) it3).b();
                        Iterator<T> it4 = list.iterator();
                        int i8 = 0;
                        while (true) {
                            if (it4.hasNext()) {
                                f1.c resultRange = ((Match) it4.next()).getResultRange();
                                if (resultRange.f1763a <= iB && iB <= resultRange.f1764b) {
                                    i8++;
                                }
                                if (i8 > 1) {
                                    i7++;
                                    if (i7 < 0) {
                                        throw new ArithmeticException("Count overflow has happened.");
                                    }
                                }
                            }
                        }
                    }
                    i2 = i7;
                }
                return new Solution(list, size, i2);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }
        }

        public Solution(List<Match> list, int i2, int i3) {
            x0.g.u(list, "matches");
            this.matches = list;
            this.coverageOffset = i2;
            this.overlaps = i3;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution solution) {
            x0.g.u(solution, "other");
            int iZ = x0.g.z(this.overlaps, solution.overlaps);
            return iZ != 0 ? iZ : x0.g.z(this.coverageOffset, solution.coverageOffset);
        }
    }

    /* renamed from: androidx.room.AmbiguousColumnResolver$resolve$4, reason: invalid class name */
    public static final class AnonymousClass4 extends j implements l {
        final /* synthetic */ q $bestSolution;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(q qVar) {
            super(1);
            this.$bestSolution = qVar;
        }

        @Override // c1.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<Match>) obj);
            return u0.f.f2595a;
        }

        public final void invoke(List<Match> list) {
            x0.g.u(list, "it");
            Solution solutionBuild = Solution.Companion.build(list);
            if (solutionBuild.compareTo((Solution) this.$bestSolution.f2042a) < 0) {
                this.$bestSolution.f2042a = solutionBuild;
            }
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i2, l lVar) {
        if (i2 == list.size()) {
            lVar.invoke(i.P0(list2));
            return;
        }
        Iterator<T> it = list.get(i2).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i2 + 1, lVar);
            if (list2.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            list2.remove(list2.size() - 1);
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i2, l lVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i2, lVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, c1.q qVar) {
        int i2 = 0;
        int iHashCode = 0;
        for (String str : strArr) {
            iHashCode += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                qVar.invoke(Integer.valueOf(i2), Integer.valueOf(length), list.subList(i2, length));
            }
            int i3 = i2 + 1;
            int i4 = length + 1;
            if (i4 > list.size()) {
                return;
            }
            iHashCode2 = (iHashCode2 - list.get(i2).getName().hashCode()) + list.get(length).getName().hashCode();
            i2 = i3;
            length = i4;
        }
    }

    public static final int[][] resolve(String[] strArr, String[][] strArr2) {
        x0.g.u(strArr, "resultColumns");
        x0.g.u(strArr2, "mappings");
        int length = strArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            String strSubstring = strArr[i3];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                x0.g.t(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale locale = Locale.US;
            x0.g.t(locale, "US");
            String lowerCase = strSubstring.toLowerCase(locale);
            x0.g.t(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            strArr[i3] = lowerCase;
        }
        int length2 = strArr2.length;
        for (int i4 = 0; i4 < length2; i4++) {
            int length3 = strArr2[i4].length;
            for (int i5 = 0; i5 < length3; i5++) {
                String[] strArr3 = strArr2[i4];
                String str = strArr3[i5];
                Locale locale2 = Locale.US;
                x0.g.t(locale2, "US");
                String lowerCase2 = str.toLowerCase(locale2);
                x0.g.t(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr3[i5] = lowerCase2;
            }
        }
        w0.i iVar = new w0.i();
        for (String[] strArr4 : strArr2) {
            h.M0(iVar, strArr4);
        }
        x0.g.l(iVar);
        w0.b bVar = new w0.b();
        int length4 = strArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length4) {
            String str2 = strArr[i6];
            int i8 = i7 + 1;
            if (iVar.f2647a.containsKey(str2)) {
                bVar.add(new ResultColumn(str2, i7));
            }
            i6++;
            i7 = i8;
        }
        x0.g.k(bVar);
        int length5 = strArr2.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i9 = 0; i9 < length5; i9++) {
            arrayList.add(new ArrayList());
        }
        int length6 = strArr2.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length6) {
            String[] strArr5 = strArr2[i10];
            int i12 = i11 + 1;
            INSTANCE.rabinKarpSearch(bVar, strArr5, new AmbiguousColumnResolver$resolve$1$1(strArr5, arrayList, i11));
            if (((List) arrayList.get(i11)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr5.length);
                int length7 = strArr5.length;
                for (int i13 = i2; i13 < length7; i13++) {
                    String str3 = strArr5[i13];
                    w0.b bVar2 = new w0.b();
                    Iterator it = bVar.iterator();
                    while (true) {
                        w0.a aVar = (w0.a) it;
                        if (!aVar.hasNext()) {
                            break;
                        }
                        ResultColumn resultColumn = (ResultColumn) aVar.next();
                        if (x0.g.g(str3, resultColumn.getName())) {
                            bVar2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    x0.g.k(bVar2);
                    if (!(!bVar2.isEmpty())) {
                        throw new IllegalStateException(("Column " + str3 + " not found in result").toString());
                    }
                    arrayList2.add(bVar2);
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i11), 6, null);
            }
            i10++;
            i11 = i12;
            i2 = 0;
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!(!((List) it2.next()).isEmpty())) {
                    throw new IllegalStateException("Failed to find matches for all mappings".toString());
                }
            }
        }
        q qVar = new q();
        qVar.f2042a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new AnonymousClass4(qVar), 6, null);
        List<Match> matches = ((Solution) qVar.f2042a).getMatches();
        ArrayList arrayList3 = new ArrayList(v0.f.E0(matches));
        Iterator<T> it3 = matches.iterator();
        while (it3.hasNext()) {
            arrayList3.add(i.O0(((Match) it3.next()).getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }
}
