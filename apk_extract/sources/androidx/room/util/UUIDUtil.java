package androidx.room.util;

import java.nio.ByteBuffer;
import java.util.UUID;
import x0.g;

/* loaded from: classes.dex */
public final class UUIDUtil {
    public static final UUID convertByteToUUID(byte[] bArr) {
        g.u(bArr, "bytes");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public static final byte[] convertUUIDToByte(UUID uuid) {
        g.u(uuid, "uuid");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16]);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        g.t(bArrArray, "buffer.array()");
        return bArrArray;
    }
}
