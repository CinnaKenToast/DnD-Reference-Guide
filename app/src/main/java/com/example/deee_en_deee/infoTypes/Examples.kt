package com.example.deee_en_deee

import com.example.deee_en_deee.infoTypes.*

val acidArrow = Spell(
    index = "acid-arrow",
    name = "Acid Arrow",
    description = mutableListOf(
        "A shimmering green arrow streaks toward a target within range and bursts in a spray of acid. Make a ranged spell attack against the target. On a hit, the target takes 4d4 acid damage immediately and 2d4 acid damage at the end of its next turn. On a miss, the arrow splashes the target with acid for half as much of the initial damage and no damage at the end of its next turn."
    ),
    highLevel = mutableListOf(
        "When you cast this spell using a spell slot of 3rd level or higher, the damage (both initial and later) increases by 1d4 for each slot level above 2nd."
    ),
    range = "90 feet",
    components = mutableListOf(
        "V", "S", "M"
    ),
    material = "Powdered rhubarb leaf and an adder's stomach.",
    ritual = false,
    duration = "Instantaneous",
    concentration = false,
    castingTime = "1 action",
    level = 2,
    attackType = "ranged",
    damage = Damage(
        damageType = APIReference(
            index = "acid",
            name = "Acid",
            url = "api/damage-types/acid"
        ),
        damageSlotLevel = DamageAtSlotLevel(
            level2 = "4d4",
            level3 = "5d4",
            level4 = "6d4",
            level5 = "7d4",
            level6 = "8d4",
            level7 = "9d4",
            level8 = "10d4",
            level9 = "11d4"
        )
    ),
    school = APIReference(
        index = "evocation",
        name = "Evocation",
        url = "/api/magic-schools/evocation"
    ),
    classTypes = mutableListOf(
        APIReference(
            index = "wizard",
            name = "Wizard",
            url = "api/classes/wizard"
        )
    ),
    subclasses = mutableListOf(
        APIReference(
            index = "lore",
            name = "Lore",
            url = "/api/subclasses/lore"
        ),
        APIReference(
            index = "land",
            name = "Land",
            url = "/api/subclasses/land"
        )
    ),
    url = "/api/spells/acid-arrow"


)

