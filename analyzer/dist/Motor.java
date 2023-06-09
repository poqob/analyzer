package odev;

import java.util.UUID;

public class Motor {
    private String motorNo;
    private boolean calisiyor;

    /**
     * Varsayılan kurucu fonksiyon
     */
    public Motor() {
        this.motorNo = UUID.randomUUID().toString();
        /* Başlangıçta false */calisiyor = false;
    }

    /**
     *
     * @param motorNo UUID olarak motor id
     * @return motor instance
     */
    public Motor(String motorNo) {
        /*
         * Varolan bir motor no ile oluşturuluyor.
         * /** cok(javadoc)
         *  
         */
        this.motorNo = motorNo;
        calisiyor = false; // false yapılıyor
    }

    public void calistir() {
        /**
         * calisiyor true yapılıyor //  TEST THIS LINE IS NOT A JAVA SINGLE COMMENT :D
         */
        calisiyor = true;
    }

    /**
     * Motorun durdurulması /* javadoc(cok)
     */
    public void durdur() {
        calisiyor = false;
    }

    public String getMotorNo() {
        // motor no getir /*
        return motorNo;
    }

    @Override
    public String toString() {
        // durum belirlenmesi //
        String durum = calisiyor ? "Motor Çalışıyor." : "Motor Çalışmıyor";
        return durum;
    }
}