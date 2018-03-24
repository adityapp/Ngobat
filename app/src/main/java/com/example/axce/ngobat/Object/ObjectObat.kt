package com.example.axce.ngobat.Object

import com.example.axce.ngobat.Model.Obat
import com.example.axce.ngobat.R

/**
 * Created by AXCE on 24/03/2018.
 */
class ObjectObat {
    companion object {
        fun objectObat(): ArrayList<Obat> {
            var obat = ArrayList<Obat>()
            obat.add(Obat("Tolak Angin",
                    "PT. Sidomuncul",
                    "3500",
                    arrayListOf("Jahe", "Temulawak"),
                    arrayListOf("Kantuk"),
                    arrayListOf("Pusing",
                            "Flu", "Masuk angin"),
                    R.drawable.tolakangin))

            obat.add(Obat("OBH Combi Batuk Berdahak",
                    "PT. Combiphar",
                    "15000",
                    arrayListOf("Succus Liquiritiae Extract 167 mg",
                            "Ammonium Chloride 50 mg",
                            "Anise Oil 0.99 mg",
                            "Ammonium Liquid 7 mcL",
                            "Menthol Crystal 4.44 mg",
                            "Peppermint Oil 3.16 mg",
                            "Alkohol 2%"),
                    arrayListOf("Mual", "Muntah"),
                    arrayListOf("Keluarnya dahak",
                            "Tenggorokan sakit",
                            "Tenggorokan gatal",
                            "Mata berair",
                            "Hidung berair",
                            "Pusing",
                            "Flu"),
                    R.drawable.obh_combi))

            obat.add(Obat("Woods Peppermint Antitussive",
                    "T. Kalbe Farma Tbk.",
                    "30000",
                    arrayListOf("Dextromethorpan HBr 7.5 mg/5 ml",
                            "Diphenhydramine HCl 12.5 mg/5 ml,"),
                    arrayListOf("Mual","Pusing","Mengantuk","Konstipasi"),
                    arrayListOf("Kerluarnya dahak",
                            "Tenggorokan sakit",
                            "Tenggorokan gatal",
                            "Flu",
                            "Alergi",
                            "Nyeri otot"),
                    R.drawable.woods))

            obat.add(Obat("Procold FLU",
                    "PT. Kalbe Farma, Tbk",
                    "3000",
                    arrayListOf("Parasetamol 500 mg",
                            "Pseudoefedrin HCl 30 mg",
                            "Klorfeniramin Maleat 2 mg"),
                    arrayListOf("Mengantuk",
                            "Gangguan pencernaan",
                            "Insomnia",
                            "tremor",
                            "Takikardi"),
                    arrayListOf("Hidung tersumbat",
                            "Sakit kepala",
                            "Nyeri otot",
                            "Flu"),
                    R.drawable.procol_flu))

            obat.add(Obat("Kalpanax K Cream",
                    "PT. Kalbe Farma",
                    "10000",
                    arrayListOf("Miconazol nitrate 2%"),
                    arrayListOf("Rasa panas",
                            "Gatal",
                            "Pedih",
                            "Rasa seperti terbakar"),
                    arrayListOf("Garis berwarna Putih/Merah",
                            "Gatal Hebat",
                            "Luka"),
                    R.drawable.kalpanax))

            return obat
        }
    }

}