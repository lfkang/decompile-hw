package com.google.android.gms.maps.internal;

/* compiled from: Unknown */
public final class zza {
    public static Boolean zza(byte b) {
        switch (b) {
            case (byte) 0:
                return Boolean.FALSE;
            case (byte) 1:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte zze(Boolean bool) {
        return bool == null ? (byte) -1 : bool.booleanValue() ? (byte) 1 : (byte) 0;
    }
}
