package Hotel.Objeto;

public class Quarto {
    private int num;
    private String tipo;
    private double preco;
    private boolean disp;

    public Quarto(int num, String tipo, double preco, boolean disp) {
        this.num = num;
        this.tipo = tipo;
        this.preco = preco;
        this.disp = disp;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        return String.format("Quarto [Número=%d, Tipo=%s, Preço=%.2f, Disponível=%s]", num, tipo, preco, disp);
    }
}
