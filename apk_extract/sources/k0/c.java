package k0;

import androidx.room.EntityDeletionOrUpdateAdapter;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class c extends EntityDeletionOrUpdateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1970a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(ChannelDatabase channelDatabase, int i2) {
        super(channelDatabase);
        this.f1970a = i2;
    }

    public final void a(c0.k kVar, a aVar) {
        switch (this.f1970a) {
            case 0:
                kVar.bindLong(1, aVar.f1937a);
                break;
            default:
                kVar.bindLong(1, aVar.f1937a);
                kVar.bindLong(2, aVar.f1938b);
                kVar.bindLong(3, aVar.f1939c);
                String str = aVar.f1940d;
                if (str == null) {
                    kVar.bindNull(4);
                } else {
                    kVar.bindString(4, str);
                }
                kVar.bindLong(5, aVar.f1941e);
                kVar.bindLong(6, aVar.f1942f ? 1L : 0L);
                kVar.bindLong(7, aVar.f1943g);
                kVar.bindLong(8, aVar.f1944h);
                kVar.bindLong(9, aVar.f1945i);
                kVar.bindLong(10, aVar.f1946j);
                kVar.bindLong(11, aVar.f1947k);
                kVar.bindLong(12, aVar.f1948l);
                kVar.bindLong(13, aVar.f1949m);
                kVar.bindLong(14, aVar.f1950n);
                String str2 = aVar.f1951o;
                if (str2 == null) {
                    kVar.bindNull(15);
                } else {
                    kVar.bindString(15, str2);
                }
                kVar.bindLong(16, aVar.f1952p);
                kVar.bindLong(17, aVar.f1953q);
                kVar.bindLong(18, aVar.f1954r);
                kVar.bindLong(19, aVar.f1955s);
                kVar.bindLong(20, aVar.f1956t);
                kVar.bindLong(21, aVar.f1957u);
                kVar.bindLong(22, aVar.f1958v);
                String str3 = aVar.f1959w;
                if (str3 == null) {
                    kVar.bindNull(23);
                } else {
                    kVar.bindString(23, str3);
                }
                kVar.bindLong(24, aVar.f1960x);
                kVar.bindLong(25, aVar.f1961y);
                kVar.bindLong(26, aVar.f1962z);
                kVar.bindLong(27, aVar.A);
                kVar.bindLong(28, aVar.B);
                kVar.bindLong(29, aVar.C);
                kVar.bindLong(30, aVar.D);
                kVar.bindLong(31, aVar.E);
                kVar.bindLong(32, aVar.f1937a);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final /* bridge */ /* synthetic */ void bind(c0.k kVar, Object obj) {
        switch (this.f1970a) {
            case 0:
                a(kVar, (a) obj);
                break;
            default:
                a(kVar, (a) obj);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f1970a) {
            case 0:
                return "DELETE FROM `channels` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `channels` SET `id` = ?,`countryId` = ?,`channelIdInCountry` = ?,`channelName` = ?,`channelType` = ?,`enbale` = ?,`smsType` = ?,`rx_freq` = ?,`tx_freq` = ?,`power` = ?,`pwrsave` = ?,`volume` = ?,`relay` = ?,`localId` = ?,`groupList` = ?,`tx_contact` = ?,`contactType` = ?,`cc` = ?,`inboundSlot` = ?,`outboundSlot` = ?,`channelMode` = ?,`encryptSw` = ?,`encryptKey` = ?,`mic` = ?,`band` = ?,`sq` = ?,`rx_type` = ?,`rx_subcode` = ?,`tx_type` = ?,`tx_subcode` = ?,`monitor` = ? WHERE `id` = ?";
        }
    }
}
