package com.senne.cifragospel2021.cifras

class LasCifra {


    fun lasdo(v:String): String {
        return v.replace(">C#", "> D#").replace(">Db", "> D#")
            .replace(">D#", "> F").replace(">Eb", "> F")
            .replace(">F#", "> G#").replace(">Gb", "> G#")
            .replace(">G#", "> A#").replace(">Ab", "> A#")
            .replace(">A#", "> C").replace(">Bb", "> C")

            .replace(">D", "> E")
            .replace(">E", "> F#")
            .replace(">F", "> G")
            .replace(">G", "> A")
            .replace(">A", "> B")
            .replace(">B", "> C#")
            .replace(">C", "> D")

            .replace("/C#", " / D#").replace("/Db", " / D#")
            .replace("/D#", " / F").replace("/Eb", " / F")
            .replace("/F#", " / G#").replace("/Gb", " / G#")
            .replace("/G#", " / A#").replace("/Ab", " / A#")
            .replace("/A#", " / C").replace("/Bb", " / C")

            .replace("/D", " / E")
            .replace("/E", " / F#")
            .replace("/F", " / G")
            .replace("/G", " / A")
            .replace("/A", " / B")
            .replace("/B", " / C#")
            .replace("/C", " / D")
            .replace(" / ", "/")
    }

    fun lasdos(v:String): String {
        return v.replace(">C#", "> E").replace(">Db", "> E")
            .replace(">D#", "> F#").replace(">Eb", "> F#")
            .replace(">F#", "> A").replace(">Gb", "> A")
            .replace(">G#", "> B").replace(">Ab", "> B")
            .replace(">A#", "> C#").replace(">Bb", "> C#")

            .replace(">D", "> F")
            .replace(">E", "> G")
            .replace(">F", "> G#")
            .replace(">G", "> A#")
            .replace(">A", "> C")
            .replace(">B", "> D")
            .replace(">C", "> D#")

            .replace("/C#", " / E").replace("/Db", " / E")
            .replace("/D#", " / F#").replace("/Eb", " / F#")
            .replace("/F#", " / A").replace("/Gb", " / A")
            .replace("/G#", " / B").replace("/Ab", " / B")
            .replace("/A#", " / C#").replace("/Bb", " / C#")

            .replace("/D", " / F")
            .replace("/E", " / G")
            .replace("/F", " / G#")
            .replace("/G", " / A#")
            .replace("/A", " / C")
            .replace("/B", " / D")
            .replace("/C", " / D#")
            .replace(" / ", "/")
    }

    fun lasre(v:String): String {
        return v.replace(">C#", "> F").replace(">Db", "> F")
            .replace(">D#", "> G").replace(">Eb", "> G")
            .replace(">F#", "> A#").replace(">Gb", "> A#")
            .replace(">G#", "> C").replace(">Ab", "> C")
            .replace(">A#", "> D").replace(">Bb", "> D")

            .replace(">D", "> F#")
            .replace(">E", "> G#")
            .replace(">F", "> A")
            .replace(">G", "> B")
            .replace(">A", "> C#")
            .replace(">B", "> D#")
            .replace(">C", "> E")

            .replace("/C#", " / F").replace("/Db", " / F")
            .replace("/D#", " / G").replace("/Eb", " / G")
            .replace("/F#", " / A#").replace("/Gb", " / A#")
            .replace("/G#", " / C").replace("/Ab", " / C")
            .replace("/A#", " / D").replace("/Bb", " / D")

            .replace("/D", " / F#")
            .replace("/E", " / G#")
            .replace("/F", " / A")
            .replace("/G", " / B")
            .replace("/A", " / C#")
            .replace("/B", " / D#")
            .replace("/C", " / E")
            .replace(" / ", "/")
    }

    fun lasres(v:String): String {
        return v.replace(">C#", "> F#").replace(">Db", "> F#")
            .replace(">D#", "> G#").replace(">Eb", "> G#")
            .replace(">F#", "> B").replace(">Gb", "> B")
            .replace(">G#", "> C#").replace(">Ab", "> C#")
            .replace(">A#", "> D#").replace(">Bb", "> D#")

            .replace(">D", "> G")
            .replace(">E", "> A")
            .replace(">F", "> A#")
            .replace(">G", "> C")
            .replace(">A", "> D")
            .replace(">B", "> E")
            .replace(">C", "> F")

            .replace("/C#", " / F#").replace("/Db", " / F#")
            .replace("/D#", " / G#").replace("/Eb", " / G#")
            .replace("/F#", " / B").replace("/Gb", " / B")
            .replace("/G#", " / C#").replace("/Ab", " / C#")
            .replace("/A#", " / D#").replace("/Bb", " / D#")

            .replace("/D", " / G")
            .replace("/E", " / A")
            .replace("/F", " / A#")
            .replace("/G", " / C")
            .replace("/A", " / D")
            .replace("/B", " / E")
            .replace("/C", " / F")
            .replace(" / ", "/")
    }

    fun lasmi(v:String): String {
        return v.replace(">C#", "> G").replace(">Db", "> G")
            .replace(">D#", "> A").replace(">Eb", "> A")
            .replace(">F#", "> C").replace(">Gb", "> C")
            .replace(">G#", "> D").replace(">Ab", "> D")
            .replace(">A#", "> E").replace(">Bb", "> E")

            .replace(">D", "> G#")
            .replace(">E", "> A#")
            .replace(">F", "> B")
            .replace(">G", "> C#")
            .replace(">A", "> D#")
            .replace(">B", "> F")
            .replace(">C", "> F#")

            .replace("/C#", " / G").replace("/Db", " / G")
            .replace("/D#", " / A").replace("/Eb", " / A")
            .replace("/F#", " / C").replace("/Gb", " / C")
            .replace("/G#", " / D").replace("/Ab", " / D")
            .replace("/A#", " / E").replace("/Bb", " / E")

            .replace("/D", " / G#")
            .replace("/E", " / A#")
            .replace("/F", " / B")
            .replace("/G", " / C#")
            .replace("/A", " / D#")
            .replace("/B", " / F")
            .replace("/C", " / F#")
            .replace(" / ", "/")
    }

    fun lasfa(v:String): String {
        return v.replace(">C#", "> G#").replace(">Db", "> G#")
            .replace(">D#", "> A#").replace(">Eb", "> A#")
            .replace(">F#", "> C#").replace(">Gb", "> C#")
            .replace(">G#", "> D#").replace(">Ab", "> D#")
            .replace(">A#", "> F").replace(">Bb", "> F")

            .replace(">D", "> A")
            .replace(">E", "> B")
            .replace(">F", "> C")
            .replace(">G", "> D")
            .replace(">A", "> E")
            .replace(">B", "> F#")
            .replace(">C", "> G")

            .replace("/C#", " / G#").replace("/Db", " / G#")
            .replace("/D#", " / A#").replace("/Eb", " / A#")
            .replace("/F#", " / C#").replace("/Gb", " / C#")
            .replace("/G#", " / D#").replace("/Ab", " / D#")
            .replace("/A#", " / F").replace("/Bb", " / F")
            .replace("/D", " / A")
            .replace("/E", " / B")
            .replace("/F", " / C")
            .replace("/G", " / D")
            .replace("/A", " / E")
            .replace("/B", " / F#")
            .replace("/C", " / G")
            .replace(" / ", "/")
    }

    fun lasfas(v:String): String {
        return v.replace(">C#", "> A").replace(">Db", "> A")
            .replace(">D#", "> B").replace(">Eb", "> B")
            .replace(">F#", "> D").replace(">Gb", "> D")
            .replace(">G#", "> E").replace(">Ab", "> E")
            .replace(">A#", "> F#").replace(">Bb", "> F#")

            .replace(">D", "> A#")
            .replace(">E", "> C")
            .replace(">F", "> C#")
            .replace(">G", "> D#")
            .replace(">A", "> F")
            .replace(">B", "> G")
            .replace(">C", "> G#")

            .replace("/C#", " / A").replace("/Db", " / A")
            .replace("/D#", " / B").replace("/Eb", " / B")
            .replace("/F#", " / D").replace("/Gb", " / D")
            .replace("/G#", " / E").replace("/Ab", " / E")
            .replace("/A#", " / F#").replace("/Bb", " / F#")

            .replace("/D", " / A#")
            .replace("/E", " / C")
            .replace("/F", " / C#")
            .replace("/G", " / D#")
            .replace("/A", " / F")
            .replace("/B", " / G")
            .replace("/C", " / G#")
            .replace(" / ", "/")
    }

    fun lassol(v:String): String {
        return v.replace(">C#", "> A#").replace(">Db", "> A#")
            .replace(">D#", "> C").replace(">Eb", "> C")
            .replace(">F#", "> D#").replace(">Gb", "> D#")
            .replace(">G#", "> F").replace(">Ab", "> F")
            .replace(">A#", "> G").replace(">Bb", "> G")

            .replace(">D", "> B")
            .replace(">E", "> C#")
            .replace(">F", "> D")
            .replace(">G", "> E")
            .replace(">A", "> F#")
            .replace(">B", "> G#")
            .replace(">C", "> A")

            .replace("/C#", " / A#").replace("/Db", " / A#")
            .replace("/D#", " / C").replace("/Eb", " / C")
            .replace("/F#", " / D#").replace("/Gb", " / D#")
            .replace("/G#", " / F").replace("/Ab", " / F")
            .replace("/A#", " / G").replace("/Bb", " / G")

            .replace("/D", " / B")
            .replace("/E", " / C#")
            .replace("/F", " / D")
            .replace("/G", " / E")
            .replace("/A", " / F#")
            .replace("/B", " / G#")
            .replace("/C", " / A")
            .replace(" / ", "/")
    }

    fun lassols(v:String): String {
        return v.replace(">C#", "> B").replace(">Db", "> B")
            .replace(">D#", "> C#").replace(">Eb", "> C#")
            .replace(">F#", "> E").replace(">Gb", "> E")
            .replace(">G#", "> F#").replace(">Ab", "> F#")
            .replace(">A#", "> G#").replace(">Bb", "> G#")

            .replace(">D", "> C")
            .replace(">E", "> D")
            .replace(">F", "> D#")
            .replace(">G", "> F")
            .replace(">A", "> G")
            .replace(">B", "> A")
            .replace(">C", "> A#")

            .replace("/C#", " / B").replace("/Db", " / B")
            .replace("/D#", " / C#").replace("/Eb", " / C#")
            .replace("/F#", " / E").replace("/Gb", " / E")
            .replace("/G#", " / F#").replace("/Ab", " / F#")
            .replace("/A#", " / G#").replace("/Bb", " / G#")

            .replace("/D", " / C")
            .replace("/E", " / D")
            .replace("/F", " / D#")
            .replace("/G", " / F")
            .replace("/A", " / G")
            .replace("/B", " / A")
            .replace("/C", " / A#")
            .replace(" / ", "/")
    }

    fun lasla(v:String): String {
        return v.replace(">C#", "> C").replace(">Db", "> C")
            .replace(">D#", "> D").replace(">Eb", "> D")
            .replace(">F#", "> F").replace(">Gb", "> F")
            .replace(">G#", "> G").replace(">Ab", "> G")
            .replace(">A#", "> A").replace(">Bb", "> A")

            .replace(">D", "> C#")
            .replace(">E", "> D#")
            .replace(">F", "> E")
            .replace(">G", "> F#")
            .replace(">A", "> G#")
            .replace(">B", "> A#")
            .replace(">C", "> B")

            .replace("/C#", " / C").replace("/Db", " / C")
            .replace("/D#", " / D").replace("/Eb", " / D")
            .replace("/F#", " / F").replace("/Gb", " / F")
            .replace("/G#", " / G").replace("/Ab", " / G")
            .replace("/A#", " / A").replace("/Bb", " / A")

            .replace("/D", " / C#")
            .replace("/E", " / D#")
            .replace("/F", " / E")
            .replace("/G", " / F#")
            .replace("/A", " / G#")
            .replace("/B", " / A#")
            .replace("/C", " / B")
            .replace(" / ", "/")
    }

    fun lassi(v:String): String {
        return v.replace(">C#", "> D").replace(">Db", "> D")
            .replace(">D#", "> E").replace(">Eb", "> E")
            .replace(">F#", "> G").replace(">Gb", "> G")
            .replace(">G#", "> A").replace(">Ab", "> A")
            .replace(">A#", "> B").replace(">Bb", "> B")

            .replace(">D", "> D#")
            .replace(">E", "> F")
            .replace(">F", "> F#")
            .replace(">G", "> G#")
            .replace(">A", "> A#")
            .replace(">B", "> C")
            .replace(">C", "> C#")

            .replace("/C#", " / D").replace("/Db", " / D")
            .replace("/D#", " / E").replace("/Eb", " / E")
            .replace("/F#", " / G").replace("/Gb", " / G")
            .replace("/G#", " / A").replace("/Ab", " / A")
            .replace("/A#", " / B").replace("/Bb", " / B")

            .replace("/D", " / D#")
            .replace("/E", " / F")
            .replace("/F", " / F#")
            .replace("/G", " / G#")
            .replace("/A", " / A#")
            .replace("/B", " / C")
            .replace("/C", " / C#")
            .replace(" / ", "/")
    }
}