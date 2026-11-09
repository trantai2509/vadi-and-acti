package vn.edu.ute.week08.s23115053122139

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tilten: TextInputLayout
    lateinit var tilqt: TextInputLayout
    lateinit var tilck: TextInputLayout

    lateinit var edtten: TextInputEditText
    lateinit var edtqt: TextInputEditText
    lateinit var edtck: TextInputEditText

    lateinit var btnkiemtra: Button
    lateinit var btnxoa: Button
    lateinit var txtketqua: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tilten = findViewById(R.id.tilten)
        tilqt = findViewById(R.id.tilqt)
        tilck = findViewById(R.id.tilck)

        edtten = findViewById(R.id.edtten)
        edtqt = findViewById(R.id.edtqt)
        edtck = findViewById(R.id.edtck)

        btnkiemtra = findViewById(R.id.btnkiemtra)
        btnxoa = findViewById(R.id.btnxoa)
        txtketqua = findViewById(R.id.txtketqua)

        btnkiemtra.setOnClickListener { xulykiemtra() }
        btnxoa.setOnClickListener { xulyxoa() }
    }
    fun xulykiemtra() {
        val tenraw = edtten.text?.toString() ?: ""
        val qtraw = edtqt.text?.toString() ?: ""
        val ckraw = edtck.text?.toString() ?: ""

        val ten = tenraw.trim()
        val diemqt = HocPhanHelper.docdiem(qtraw)
        val diemck = HocPhanHelper.docdiem(ckraw)

        var hople = true

        if (!HocPhanHelper.kiemtraten(tenraw)) {
            tilten.error = "Tên học phần sau trim phải dài 1..40 kí tự"
            hople = false
        }else {
            tilten.error = null
        }

        if (diemqt == null) {
            tilqt.error = "Điểm QT phải là số thực từ 0 đến 10 (dùng dấu chấm)"
        }else {
            tilqt.error = null
        }

        if (diemck == null) {
            tilck.error ="Điểm CK phải là số thực từ 0 đến 10 (dùng dấu chấm thập phan)"
        }else {
            tilck.error = null
        }
    }
    fun xulyxoa() {

    }
}