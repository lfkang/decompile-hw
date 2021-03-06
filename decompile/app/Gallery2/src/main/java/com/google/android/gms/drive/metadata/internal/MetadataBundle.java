package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Unknown */
public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new f();
    final Bundle Ek;
    final int wj;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.wj = versionCode;
        this.Ek = (Bundle) er.f(valueBundle);
        this.Ek.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.Ek.keySet()) {
            if (c.ar(str) == null) {
                arrayList.add(str);
                Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.Ek.remove(str2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.Ek.keySet();
        if (!keySet.equals(metadataBundle.Ek.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!ep.equal(this.Ek.get(str), metadataBundle.Ek.get(str))) {
                return false;
            }
        }
        return true;
    }

    public Set<MetadataField<?>> fi() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String ar : this.Ek.keySet()) {
            hashSet.add(c.ar(ar));
        }
        return hashSet;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.Ek.keySet()) {
            i *= 31;
            i = this.Ek.get(str).hashCode() + i;
        }
        return i;
    }

    public String toString() {
        return "MetadataBundle [values=" + this.Ek + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        f.a(this, dest, flags);
    }
}
