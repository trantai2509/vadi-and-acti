package vn.edu.ute.week08.s23115053122139
import java.util.Locale
object HocPhanHelper {
    fun kiemtraten(ten: String): Boolean{
        val t = ten.trim()
        return t.length in 1..40
    }
    fun docdiem(chuoi: String): Double? {
        val s= chuoi.trim()
        if (s.isEmpty()||s.contains(".")) return null
        val diem = s.toDoubleOrNull() ?: return null
        if (!diem.isFinite()||diem<0.0||diem>10.0) return null
        return diem
    }
    fun phanloai(t: Double, ck: Double): String {
        return if (t+ 1e-9>=5.5 && ck + 1e-9 >=3.0) "Đạt" else "chưa đạt"
    }
    fun dinhdang2so(so: Double): String {
        return String.format(Locale.US, "%.2f", so)
    }
}