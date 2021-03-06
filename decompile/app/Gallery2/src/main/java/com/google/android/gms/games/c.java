package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: Unknown */
public class c implements Creator<PlayerEntity> {
    static void a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int p = b.p(parcel);
        b.a(parcel, 1, playerEntity.getPlayerId(), false);
        b.c(parcel, 1000, playerEntity.getVersionCode());
        b.a(parcel, 2, playerEntity.getDisplayName(), false);
        b.a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        b.a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        b.a(parcel, 5, playerEntity.getRetrievedTimestamp());
        b.c(parcel, 6, playerEntity.fl());
        b.a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        b.a(parcel, 8, playerEntity.getIconImageUrl(), false);
        b.a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        b.D(parcel, p);
    }

    public PlayerEntity[] aQ(int i) {
        return new PlayerEntity[i];
    }

    public PlayerEntity ak(Parcel parcel) {
        int o = a.o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = a.n(parcel);
            switch (a.S(n)) {
                case 1:
                    str = a.m(parcel, n);
                    break;
                case 2:
                    str2 = a.m(parcel, n);
                    break;
                case 3:
                    uri = (Uri) a.a(parcel, n, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) a.a(parcel, n, Uri.CREATOR);
                    break;
                case 5:
                    j = a.h(parcel, n);
                    break;
                case 6:
                    i2 = a.g(parcel, n);
                    break;
                case 7:
                    j2 = a.h(parcel, n);
                    break;
                case 8:
                    str3 = a.m(parcel, n);
                    break;
                case 9:
                    str4 = a.m(parcel, n);
                    break;
                case 1000:
                    i = a.g(parcel, n);
                    break;
                default:
                    a.b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4);
        }
        throw new a.a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
