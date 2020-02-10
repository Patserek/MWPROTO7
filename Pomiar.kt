package com.example.mwproto1.ROOM

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pomiar(
    @ColumnInfo(name="Stezenie")
    val Stezenie: String?,
    @ColumnInfo(name="Data")
    val Data: String?,
    @ColumnInfo(name="Zegar")
    val Zegar: String?,
    @ColumnInfo(name="Posilek")
    val Posilek: String?,
    @ColumnInfo(name="Samopoczucie")
    val Samopoczucie: String?,
    @ColumnInfo(name="Stres")
    val Stres: String?,
    @ColumnInfo(name="Hiperglikemia")
    val Hiperglikemia: String?

): Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
        id = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Stezenie)
        parcel.writeString(Data)
        parcel.writeString(Zegar)
        parcel.writeString(Posilek)
        parcel.writeString(Samopoczucie)
        parcel.writeString(Stres)
        parcel.writeString(Hiperglikemia)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pomiar> {
        override fun createFromParcel(parcel: Parcel): Pomiar {
            return Pomiar(parcel)
        }

        override fun newArray(size: Int): Array<Pomiar?> {
            return arrayOfNulls(size)
        }
    }
}