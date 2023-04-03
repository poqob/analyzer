
import java.util.UUID;

public class Motor {
	private String motorNo;
	private boolean calisiyor;

	/**
	 * Varsay�lan kurucu fonksiyon
	 */
	public Motor() {
		this.motorNo = UUID.randomUUID().toString();
		/* Ba�lang��ta false */calisiyor = false;
	}

	/**
	 *
	 * @param motorNo UUID olarak motor id
	 * @return motor instance
	 */
	public Motor(String motorNo) {
		/*
		 * Varolan bir motor no ile olu�turuluyor.
		 */
		this.motorNo = motorNo;
		calisiyor = false; // false yap�l�yor
	}

	public void calistir() {
		/**
		 * calisiyor true yap�l�yor
		 */
		calisiyor = true;
	}

	/**
	 * Motorun durdurulmas� //
	 */
	public void durdur() {
		calisiyor = false;
	}

	public String getMotorNo() {
// motor no getir
		return motorNo;
	}

	@Override
	public String toString() {
// durum belirlenmesi //
		String durum = calisiyor ? "Motor �al���yor." : "Motor �al��m�yor";
		return durum;
	}
}