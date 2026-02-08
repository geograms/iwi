package i1;

import java.util.NoSuchElementException;
import v0.f;
import x0.g;

/* loaded from: classes.dex */
public abstract class c extends b {
    public static boolean E0(String str, String str2, boolean z2) {
        return K0(str, str2, z2, 2) >= 0;
    }

    public static boolean F0(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final int G0(CharSequence charSequence) {
        g.u(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int H0(int i2, CharSequence charSequence, String str, boolean z2) {
        g.u(charSequence, "<this>");
        g.u(str, "string");
        return (z2 || !(charSequence instanceof String)) ? I0(charSequence, str, i2, charSequence.length(), z2) : ((String) charSequence).indexOf(str, i2);
    }

    public static int I0(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int length = charSequence.length();
        if (i3 > length) {
            i3 = length;
        }
        f1.c cVar = new f1.c(i2, i3, 1);
        boolean z3 = charSequence instanceof String;
        int i4 = cVar.f1764b;
        if (z3 && (charSequence2 instanceof String)) {
            if (i2 <= i4) {
                while (!N0(0, i2, charSequence2.length(), (String) charSequence2, (String) charSequence, z2)) {
                    if (i2 != i4) {
                        i2++;
                    }
                }
                return i2;
            }
        } else if (i2 <= i4) {
            while (true) {
                int length2 = charSequence2.length();
                g.u(charSequence, "other");
                if (i2 >= 0 && charSequence2.length() - length2 >= 0 && i2 <= charSequence.length() - length2) {
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (g.I(charSequence2.charAt(i5), charSequence.charAt(i2 + i5), z2)) {
                        }
                    }
                    return i2;
                }
                if (i2 == i4) {
                    break;
                }
                i2++;
            }
        }
        return -1;
    }

    public static int J0(CharSequence charSequence, char c2) {
        g.u(charSequence, "<this>");
        return !(charSequence instanceof String) ? L0(0, charSequence, false, new char[]{c2}) : ((String) charSequence).indexOf(c2, 0);
    }

    public static /* synthetic */ int K0(CharSequence charSequence, String str, boolean z2, int i2) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return H0(0, charSequence, str, z2);
    }

    public static final int L0(int i2, CharSequence charSequence, boolean z2, char[] cArr) {
        int i3;
        g.u(charSequence, "<this>");
        g.u(cArr, "chars");
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(f.I0(cArr), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = new f1.c(i2, G0(charSequence), 1).f1764b;
        boolean z3 = i2 <= i4;
        if (!z3) {
            i2 = i4;
        }
        while (z3) {
            if (i2 != i4) {
                i3 = i2 + 1;
            } else {
                if (!z3) {
                    throw new NoSuchElementException();
                }
                i3 = i2;
                z3 = false;
            }
            char cCharAt = charSequence.charAt(i2);
            for (char c2 : cArr) {
                if (g.I(c2, cCharAt, z2)) {
                    return i2;
                }
            }
            i2 = i3;
        }
        return -1;
    }

    public static int M0(CharSequence charSequence, char c2) {
        int iG0 = G0(charSequence);
        g.u(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c2, iG0);
        }
        char[] cArr = {c2};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(f.I0(cArr), iG0);
        }
        int iG02 = G0(charSequence);
        if (iG0 > iG02) {
            iG0 = iG02;
        }
        while (-1 < iG0) {
            if (g.I(cArr[0], charSequence.charAt(iG0), false)) {
                return iG0;
            }
            iG0--;
        }
        return -1;
    }

    public static final boolean N0(int i2, int i3, int i4, String str, String str2, boolean z2) {
        g.u(str, "<this>");
        g.u(str2, "other");
        return !z2 ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z2, i2, str2, i3, i4);
    }

    public static boolean O0(String str, String str2) {
        g.u(str, "<this>");
        g.u(str2, "prefix");
        return str.startsWith(str2);
    }

    public static String P0(String str) {
        g.u(str, "<this>");
        g.u(str, "missingDelimiterValue");
        int iM0 = M0(str, '.');
        if (iM0 == -1) {
            return str;
        }
        String strSubstring = str.substring(iM0 + 1, str.length());
        g.t(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static CharSequence Q0(String str) {
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            char cCharAt = str.charAt(!z2 ? i2 : length);
            boolean z3 = Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt);
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return str.subSequence(i2, length + 1);
    }
}
