package Hotel.Objeto;

public class Reserva {
    private String hospede;
    private String checkIn;
    private String checkOut;
    private String tipo;

    public Reserva(String hospede, String checkIn, String checkOut, String tipo) {
        this.hospede = hospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.tipo = tipo;
    }

    public String getHospede() {
        return hospede;
    }

    public void setHospede(String hospede) {
        this.hospede = hospede;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("Reserva [Hóspede=%s, Check-In=%s, Check-Out=%s, Tipo=%s]", hospede, checkIn, checkOut, tipo);
    }
}
