package dev.tomco.a25b_11345b_l02_03.model

import dev.tomco.a25b_11345b_l02_03.R

class DataManager {
    companion object {
        private val names = arrayOf(
            "Mauritius",
            "Oman",
            "Ethiopia",
            "Tanzania",
            "Nicaragua",
            "Estonia",
            "Italy",
            "Syria",
            "North Korea",
            "China",
            "Micronesia",
            "Mauritania",
            "Benin",
            "Djibouti",
            "Kazakhstan",
            "Jordan",
            "San Marino",
            "Pakistan",
            "Ecuador",
            "Cameroon",
            "Guinea",
            "Afghanistan",
            "Spain",
            "Bosnia And Herzegovina",
            "United Arab Emirates",
            "South Africa",
            "Taiwan",
            "Niger",
            "Lebanon",
            "Libya"
        )

        private val flagImages = arrayOf(
            R.drawable._001_mauritius,
            R.drawable._004_oman,
            R.drawable._005_ethiopia,
            R.drawable._006_tanzania,
            R.drawable._007_nicaragua,
            R.drawable._008_estonia,
            R.drawable._013_italy,
            R.drawable._022_syria,
            R.drawable._030_north_korea,
            R.drawable._034_china,
            R.drawable._046_micronesia,
            R.drawable._050_mauritania,
            R.drawable._060_benin,
            R.drawable._068_djibouti,
            R.drawable._074_kazakhstan,
            R.drawable._077_jordan,
            R.drawable._097_san_marino,
            R.drawable._100_pakistan,
            R.drawable._104_ecuador,
            R.drawable._105_cameroon,
            R.drawable._110_guinea,
            R.drawable._111_afghanistan,
            R.drawable._128_spain,
            R.drawable._132_bosnia_and_herzegovina,
            R.drawable._151_united_arab_emirates,
            R.drawable._200_south_africa,
            R.drawable._202_taiwan,
            R.drawable._222_niger,
            R.drawable._018_lebanon,
            R.drawable._231_libya
        )

        private val canEnter = arrayOf(
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            false,
        )

        fun getAllCountries(): List<Country> {
            val allCountries = mutableListOf<Country>()
            for (i in names.indices) {
                allCountries.add(
                    Country(
                        flagImage = flagImages[i],
                        canEnter = canEnter[i],
                        name = names[i],
                    )
                )
            }
            allCountries.shuffle()
            return allCountries
        }
    }
}