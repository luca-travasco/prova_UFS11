import java.time.LocalDate;

public class Libro {
    private String titolo;
    private String autore;
    private int pagine;
    private boolean inPrestito;
    private LocalDate dataRestituzione;

    public Libro(String titolo, String autore, int pagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.inPrestito = false;
    }

    public int getPagine() {
        return pagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public boolean isInPrestito() {
        return inPrestito;
    }

    public void setInPrestito(boolean inPrestito) {
        this.inPrestito = inPrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }
}
