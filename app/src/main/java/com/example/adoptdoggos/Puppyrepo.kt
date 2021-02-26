package com.example.adoptdoggos

import androidx.annotation.DrawableRes

data class Puppy(
    @DrawableRes val resId: Int,
    val name: String,
    val description: String
)

object PuppyRepo {
    val puppies = listOf(
        Puppy(R.drawable.pup_1, "Ram Prasad", ""),
        Puppy(R.drawable.pup_2, "Gabbar", ""),
        Puppy(R.drawable.pup_17, "Dhanno", ""),
        Puppy(R.drawable.pup_18, "Max", ""),
        Puppy(R.drawable.pup_19, "GoGo", ""),
        Puppy(R.drawable.pup_20, "Mogambo", ""),
        Puppy(R.drawable.pup_1, "Dhinchak Pooja", ""),
        Puppy(R.drawable.pup_2, "Rakhi Sawant", ""),
        Puppy(R.drawable.pup_17, "Smachii", ""),
        Puppy(R.drawable.pup_18, "Pickle", ""),
        Puppy(R.drawable.pup_20, "Grey", ""),
        Puppy(R.drawable.pup_18, "Goldie", ""),
        Puppy(R.drawable.pup_2, "Flop", ""),
        Puppy(R.drawable.pup_17, "Fooie", ""),
        Puppy(R.drawable.pup_19, "Felix", ""),
        Puppy(R.drawable.pup_1, "Liklik", ""),
        Puppy(R.drawable.pup_17, "Poro", ""),
        Puppy(R.drawable.pup_18, "Soorma Bhopali", ""),
        Puppy(R.drawable.pup_19, "Kamlesh", ""),
        Puppy(R.drawable.pup_20, "Bruno", "")
    )
}