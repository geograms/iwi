package k0;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;

/* loaded from: classes.dex */
public final class b extends EntityInsertionAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1965a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1966b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, RoomDatabase roomDatabase, int i2) {
        super(roomDatabase);
        this.f1965a = i2;
        this.f1966b = obj;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(c0.k kVar, Object obj) {
        switch (this.f1965a) {
            case 0:
                a aVar = (a) obj;
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
                return;
            case 1:
                u uVar = (u) obj;
                kVar.bindLong(1, uVar.f2016a);
                String str4 = uVar.f2017b;
                if (str4 == null) {
                    kVar.bindNull(2);
                } else {
                    kVar.bindString(2, str4);
                }
                kVar.bindLong(3, uVar.f2018c ? 1L : 0L);
                return;
            case 2:
                a.a.j(obj);
                throw null;
            case 3:
                m0.a aVar2 = (m0.a) obj;
                kVar.bindLong(1, aVar2.f2090a);
                kVar.bindLong(2, aVar2.f2091b);
                String str5 = aVar2.f2092c;
                if (str5 == null) {
                    kVar.bindNull(3);
                } else {
                    kVar.bindString(3, str5);
                }
                kVar.bindLong(4, aVar2.f2093d);
                String str6 = aVar2.f2094e;
                if (str6 == null) {
                    kVar.bindNull(5);
                } else {
                    kVar.bindString(5, str6);
                }
                kVar.bindLong(6, aVar2.f2095f);
                String str7 = aVar2.f2096g;
                if (str7 == null) {
                    kVar.bindNull(7);
                } else {
                    kVar.bindString(7, str7);
                }
                byte[] bArr = aVar2.f2097h;
                if (bArr == null) {
                    kVar.bindNull(8);
                    return;
                } else {
                    kVar.bindBlob(8, bArr);
                    return;
                }
            default:
                n0.e eVar = (n0.e) obj;
                kVar.bindLong(1, eVar.f2157a);
                kVar.bindLong(2, eVar.f2158b);
                kVar.bindLong(3, eVar.f2159c);
                String str8 = eVar.f2160d;
                if (str8 == null) {
                    kVar.bindNull(4);
                } else {
                    kVar.bindString(4, str8);
                }
                kVar.bindLong(5, eVar.f2161e);
                kVar.bindLong(6, eVar.f2162f);
                String str9 = eVar.f2163g;
                if (str9 == null) {
                    kVar.bindNull(7);
                } else {
                    kVar.bindString(7, str9);
                }
                String str10 = eVar.f2164h;
                if (str10 == null) {
                    kVar.bindNull(8);
                } else {
                    kVar.bindString(8, str10);
                }
                kVar.bindLong(9, eVar.f2165i);
                kVar.bindLong(10, eVar.f2166j);
                kVar.bindLong(11, eVar.f2167k);
                byte[] bArr2 = eVar.f2168l;
                if (bArr2 == null) {
                    kVar.bindNull(12);
                } else {
                    kVar.bindBlob(12, bArr2);
                }
                String str11 = eVar.f2169m;
                if (str11 == null) {
                    kVar.bindNull(13);
                    return;
                } else {
                    kVar.bindString(13, str11);
                    return;
                }
        }
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f1965a) {
            case 0:
                return "INSERT OR ABORT INTO `channels` (`id`,`countryId`,`channelIdInCountry`,`channelName`,`channelType`,`enbale`,`smsType`,`rx_freq`,`tx_freq`,`power`,`pwrsave`,`volume`,`relay`,`localId`,`groupList`,`tx_contact`,`contactType`,`cc`,`inboundSlot`,`outboundSlot`,`channelMode`,`encryptSw`,`encryptKey`,`mic`,`band`,`sq`,`rx_type`,`rx_subcode`,`tx_type`,`tx_subcode`,`monitor`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            case 1:
                return "INSERT OR ABORT INTO `countries` (`id`,`countryCode`,`isSelected`) VALUES (nullif(?, 0),?,?)";
            case 2:
                return "INSERT OR IGNORE INTO `channel_message_table` (`id`,`channelIndex`,`channelName`,`timestamp`,`msgCount`) VALUES (nullif(?, 0),?,?,?,?)";
            case 3:
                return "INSERT OR IGNORE INTO `contacts_table` (`id`,`type`,`name`,`number`,`channel`,`channel_db_id`,`logo`,`avatarData`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `message_table` (`id`,`channelIndex`,`senderId`,`senderName`,`receiverId`,`groupId`,`groupName`,`message`,`timestamp`,`messageType`,`messageDirection`,`avatarData`,`receiverName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }
}
