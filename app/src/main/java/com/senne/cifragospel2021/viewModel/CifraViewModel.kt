package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.cifras.*
import com.senne.cifragospel2021.model.CifraModel
import kotlin.random.Random

class CifraViewModel : ViewModel() {

    private lateinit var photoBanda: String

    private var mTitulo = MutableLiveData<String>()
    val titulo : LiveData<String> = mTitulo

    private var mBanda = MutableLiveData<String>()
    val banda : LiveData<String> = mBanda

    private var mTom = MutableLiveData<Int>()
    val tom : LiveData<Int> = mTom

    private var mNovoTom = MutableLiveData<String>()
    val novoTom : LiveData<String> = mNovoTom

     var tomInicio : String = ""

    private var mCifra = MutableLiveData<String>()
    var cifra : LiveData<String> = mCifra

    private var mFoto = MutableLiveData<String>()
    val foto : LiveData<String> = mFoto

    val db = FirebaseFirestore.getInstance()

    fun add(key: String, titulo: String, banda: String) {
        val band = HashMap<String, Any>()
        band["titulo"] = "${titulo}"
        band["banda"] = "${banda}"
        band["foto"] = "${photoBanda}"
        db.collection("MyList ${key}").document("${titulo.replace("/","")} ${banda.replace("/","")}").set(band)
    }

    fun load(titulo: String, banda: String) {
        mTitulo.value = titulo
        mBanda.value = banda

        db.collection("$banda").whereEqualTo("titulo", "$titulo").get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val cifra =  document.toObject(CifraModel::class.java)
                    mCifra.value = "${cifra.cifra}"
                    tomInicio = "${cifra.tom}"
                    if(cifra.foto == "https://studiosol-a.akamaihd.net/cc/img/desktop/thumb-art.svg?v=3") {
                        cifra.foto = "https://icon-library.com/images/music-icon/music-icon-2.jpg"
                    }
                    mFoto.value = "${cifra.foto}"
                    photoBanda = "${cifra.foto}"
                }

                when (tomInicio) {
                    // Maiores
                    "C" -> { mTom.value = 0}
                    "C#" -> { mTom.value = 1}
                    "D" -> { mTom.value = 2}
                    "D#" -> { mTom.value = 3}
                    "E" -> { mTom.value = 4}
                    "F" -> { mTom.value = 5}
                    "F#" -> { mTom.value = 6}
                    "G" -> { mTom.value = 7}
                    "G#" -> { mTom.value = 8}
                    "A" -> { mTom.value = 9}
                    "A#" -> { mTom.value = 10}
                    "B" -> { mTom.value = 11}
                    "Bb" -> { mTom.value = 12}
                    "Ab" -> { mTom.value = 13}
                    "Gb" -> { mTom.value = 14}
                    "Eb" -> { mTom.value = 15}
                    "Db" -> { mTom.value = 16}
                    // Menores
                    "Cm" -> { mTom.value = 17}
                    "C#m" -> { mTom.value = 18}
                    "Dm" -> { mTom.value = 19}
                    "D#m" -> { mTom.value = 20}
                    "Em" -> { mTom.value = 21}
                    "Fm" -> { mTom.value = 22}
                    "F#m" -> { mTom.value = 23}
                    "Gm" -> { mTom.value = 24}
                    "G#m" -> { mTom.value = 25}
                    "Am" -> { mTom.value = 26}
                    "A#m" -> { mTom.value = 27}
                    "Bm" -> { mTom.value = 28}
                    "Bbm" -> { mTom.value = 29}
                    "Abm" -> { mTom.value = 30}
                    "Gbm" -> { mTom.value = 31}
                    "Ebm" -> { mTom.value = 32}
                    "Dbm" -> { mTom.value = 33}
                }
    }

    }

    val mDoCifra = DoCifra()
    val mDosCifra = DosCifra()
    val mReCifra = ReCifra()
    val mResCifra = ResCifra()
    val mMiCifra = MiCifra()
    val mFaCifra = FaCifra()
    val mFasCifra = FasCifra()
    val mSolCifra = SolCifra()
    val mSolsCifra = SolsCifra()
    val mLaCifra = LaCifra()
    val mLasCifra = LasCifra()
    val mSiCifra = SiCifra()

    fun mudaTom(tomSpin: String) {

        var cifraTratada: String = mCifra.value.toString()
        if( tomInicio == "C" || tomInicio == "Am") {
                 if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = mCifra.value }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") { mNovoTom.value = "${mDoCifra.dodos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value = "${mDoCifra.dore(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value = "${mDoCifra.dores(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = "${mDoCifra.domi(cifraTratada)}" }
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mDoCifra.dofa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = "${mDoCifra.dofas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = "${mDoCifra.dosol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mDoCifra.dosols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mDoCifra.dola(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mDoCifra.dolas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mDoCifra.dosi(cifraTratada)}" }

        }else if( tomInicio == "C#" || tomInicio == "Bbm" || tomInicio == "Db" || tomInicio == "A#m" )  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mDosCifra.dosdo(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") { mNovoTom.value = mCifra.value }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value = "${mDosCifra.dosre(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value = "${mDosCifra.dosres(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = "${mDosCifra.dosmi(cifraTratada)}" }
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mDosCifra.dosfa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = "${mDosCifra.dosfas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = "${mDosCifra.dossol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mDosCifra.dossols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mDosCifra.dosla(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mDosCifra.doslas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mDosCifra.dossi(cifraTratada)}" }

        }else if( tomInicio == "D" || tomInicio == "Bm")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mReCifra.redo(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mReCifra.redos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  mCifra.value }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value = "${mReCifra.reres(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = "${mReCifra.remi(cifraTratada)}" }
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mReCifra.refa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = "${mReCifra.refas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = "${mReCifra.resol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mReCifra.resols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mReCifra.rela(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mReCifra.relas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mReCifra.resi(cifraTratada)}" }

        }else if( tomInicio == "D#" || tomInicio == "Cm" || tomInicio == "Eb")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mResCifra.resdo(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mResCifra.resdos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mResCifra.resre(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  mCifra.value }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = "${mResCifra.resmi(cifraTratada)}" }
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mResCifra.resfa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = "${mResCifra.resfas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = "${mResCifra.ressol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mResCifra.ressols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mResCifra.resla(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mResCifra.reslas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mResCifra.ressi(cifraTratada)}" }

        }else if( tomInicio == "E" || tomInicio == "C#m" || tomInicio == "Dbm")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mMiCifra.mido(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mMiCifra.midos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mMiCifra.mire(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mMiCifra.mires(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = mCifra.value}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mMiCifra.mifa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = "${mMiCifra.mifas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = "${mMiCifra.misol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mMiCifra.misols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mMiCifra.mila(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mMiCifra.milas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mMiCifra.misi(cifraTratada)}" }

        }else if( tomInicio == "F" || tomInicio == "Dm")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mFaCifra.fado(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mFaCifra.fados(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mFaCifra.fare(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mFaCifra.fares(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = " ${mFaCifra.fami(cifraTratada)}"}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = mCifra.value }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = "${mFaCifra.fafas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = "${mFaCifra.fasol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mFaCifra.fasols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mFaCifra.fala(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mFaCifra.falas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mFaCifra.fasi(cifraTratada)}" }

        }else if( tomInicio == "F#" || tomInicio == "Gb" || tomInicio == "D#m" || tomInicio == "Ebm")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mFasCifra.fasdo(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mFasCifra.fasdos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mFasCifra.fasre(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mFasCifra.fasres(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = " ${mFasCifra.fasmi(cifraTratada)}"}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mFasCifra.fasfa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = mCifra.value }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = "${mFasCifra.fassol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mFasCifra.fassols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mFasCifra.fasla(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mFasCifra.faslas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mFasCifra.fassi(cifraTratada)}" }

        }else if( tomInicio == "G" || tomInicio == "Em")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mSolCifra.soldo(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mSolCifra.soldos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mSolCifra.solre(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mSolCifra.solres(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = " ${mSolCifra.solmi(cifraTratada)}"}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mSolCifra.solfa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = " ${mSolCifra.solfas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value = mCifra.value }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = "${mSolCifra.solsols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mSolCifra.solla(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mSolCifra.sollas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mSolCifra.solsi(cifraTratada)}" }

        }else if( tomInicio == "G#" || tomInicio == "Ab" || tomInicio == "Fm")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mSolsCifra.solsdo(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mSolsCifra.solsdos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mSolsCifra.solsre(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mSolsCifra.solsres(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = " ${mSolsCifra.solsmi(cifraTratada)}"}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mSolsCifra.solsfa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = " ${mSolsCifra.solsfas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value =" ${mSolsCifra.solssol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = mCifra.value }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = "${mSolsCifra.solsla(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mSolsCifra.solslas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mSolsCifra.solssi(cifraTratada)}" }

        }else if( tomInicio == "A" || tomInicio == "F#m" || tomInicio == "Gbm")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mLaCifra.lado(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mLaCifra.lados(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mLaCifra.lare(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mLaCifra.lares(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = " ${mLaCifra.lami(cifraTratada)}"}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mLaCifra.lafa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = " ${mLaCifra.lafas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value =" ${mLaCifra.lasol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = " ${mLaCifra.lasols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = mCifra.value }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = "${mLaCifra.lalas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mLaCifra.lasi(cifraTratada)}" }

        }else if( tomInicio == "A#" || tomInicio == "Bb" || tomInicio == "Gm")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mLasCifra.lasdo(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mLasCifra.lasdos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mLasCifra.lasre(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mLasCifra.lasres(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = " ${mLasCifra.lasmi(cifraTratada)}"}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mLasCifra.lasfa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = " ${mLasCifra.lasfas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value =" ${mLasCifra.lassol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = " ${mLasCifra.lassols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = " ${mLasCifra.lasla(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = mCifra.value }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = "${mLasCifra.lassi(cifraTratada)}" }

        }else if( tomInicio == "B" || tomInicio == "Abm" || tomInicio == "G#m")  {
            if (tomSpin == "C" || tomSpin == "Am") { mNovoTom.value = "${mSiCifra.sido(cifraTratada)}" }
            else if (tomSpin == "C#" || tomSpin == "Db" || tomSpin == "A#m" || tomSpin == "Bbm") {mNovoTom.value = " ${mSiCifra.sidos(cifraTratada)}" }
            else if (tomSpin == "D" || tomSpin == "Bm") { mNovoTom.value =  " ${mSiCifra.sire(cifraTratada)}" }
            else if (tomSpin == "D#" || tomSpin == "Eb" || tomSpin == "Cm") { mNovoTom.value =  " ${mSiCifra.sires(cifraTratada)}" }
            else if (tomSpin == "E" || tomSpin == "C#m"  || tomSpin == "Dbm") { mNovoTom.value = " ${mSiCifra.simi(cifraTratada)}"}
            else if (tomSpin == "F" || tomSpin == "Dm"  ) { mNovoTom.value = "${mSiCifra.sifa(cifraTratada)}" }
            else if (tomSpin == "F#" || tomSpin == "D#m" || tomSpin == "Ebm" || tomSpin == "Gb") { mNovoTom.value = " ${mSiCifra.sifas(cifraTratada)}" }
            else if (tomSpin == "G" || tomSpin == "Em" ) { mNovoTom.value =" ${mSiCifra.sisol(cifraTratada)}" }
            else if (tomSpin == "G#" || tomSpin == "Ab" || tomSpin == "Fm") { mNovoTom.value = " ${mSiCifra.sisols(cifraTratada)}" }
            else if (tomSpin == "A" || tomSpin == "F#m" || tomSpin == "Gbm") { mNovoTom.value = " ${mSiCifra.sila(cifraTratada)}" }
            else if (tomSpin == "A#" || tomSpin == "Bb" || tomSpin == "Gm") { mNovoTom.value = " ${mSiCifra.silas(cifraTratada)}" }
            else if (tomSpin == "B" || tomSpin == "G#m" || tomSpin == "Abm") { mNovoTom.value = mCifra.value }
        }
    }
}