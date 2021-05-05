package com.manta.data.datasource.local.delegate

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PreferenceDelegate(
    private val preference : SharedPreferences,
    private val key : String,
    private val default : String
) : ReadWriteProperty<PreferenceModel, String>{

    override operator fun getValue(thisRef: PreferenceModel, property: KProperty<*>) : String{
        return preference.getString(key, default)!!
    }

    override fun setValue(thisRef: PreferenceModel, property: KProperty<*>, value: String) {
        preference.edit().putString(key, value).apply()
    }
}
class StringPref(private val default : String = "") {

    operator fun provideDelegate(
        thisRef : PreferenceModel,
        property : KProperty<*>
    ) : ReadWriteProperty<PreferenceModel, String>{
        return PreferenceDelegate(
            thisRef.context.getSharedPreferences(thisRef.javaClass.simpleName, MODE_PRIVATE),
            property.name,
            default
        )

    }
}