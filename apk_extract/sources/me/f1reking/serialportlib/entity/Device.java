package me.f1reking.serialportlib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

/* loaded from: classes.dex */
public class Device implements Parcelable {
    public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() { // from class: me.f1reking.serialportlib.entity.Device.1
        @Override // android.os.Parcelable.Creator
        public Device createFromParcel(Parcel parcel) {
            return new Device(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Device[] newArray(int i2) {
            return new Device[i2];
        }
    };
    private File file;
    private String name;
    private String root;

    public Device(String str, String str2, File file) {
        this.name = str;
        this.root = str2;
        this.file = file;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public File getFile() {
        return this.file;
    }

    public String getName() {
        return this.name;
    }

    public String getRoot() {
        return this.root;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRoot(String str) {
        this.root = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.root);
        parcel.writeSerializable(this.file);
    }

    public Device(Parcel parcel) {
        this.name = parcel.readString();
        this.root = parcel.readString();
        this.file = (File) parcel.readSerializable();
    }
}
