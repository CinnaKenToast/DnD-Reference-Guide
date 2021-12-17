package com.example.deee_en_deee.services

import android.content.Context
import com.example.deee_en_deee.utils.toJsonString
import java.io.IOException
import java.io.OutputStreamWriter

class FileManager {
    private suspend fun loadFromInternalStorage() {

    }

    inline fun <reified T> saveToInternalStorage(context: Context, fileName: String, list: MutableList<T>): Boolean {
        return try {
            context.openFileOutput("$fileName.dnd", Context.MODE_PRIVATE).use { stream ->
                OutputStreamWriter(stream).use { writer ->
                    list.forEach {
                        writer.write(it.toJsonString())
                    }
//                    when(T::class) {
//                        AbilityScore::class -> {}
//                        AlignmentType::class -> {}
//                        ClassType::class -> {}
//                        Condition::class -> {}
//                        DamageType::class -> {}
//                        EquipmentCategory::class -> {}
//                        Equipment::class -> {}
//                        Feat::class -> {}
//                        Feature::class -> {}
//                        Language::class -> {}
//                        MagicItem::class -> {}
//                        MagicSchool::class -> {}
//                        Monster::class -> {}
//                        Proficiency::class -> {}
//                        Race::class -> {}
//                        Rule::class -> {}
//                        RuleSection::class -> {}
//                        Skill::class -> {}
//                        Spell::class -> {
//                            list.forEach {
//                                writer.write(it.toJsonString())
//                            }
//                        }
//                        Subclass::class -> {}
//                        Subrace::class -> {}
//                        Trait::class -> {}
//                        WeaponProperty::class -> {}
//                    }
                }
            }
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }
}