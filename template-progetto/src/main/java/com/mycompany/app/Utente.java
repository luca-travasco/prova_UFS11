import java.time.LocalDate;
import java.util.ArrayList;

public class Utente {
    private String idUtente;
    private String nome;
    private String cognome;
    private String sesso;
    private String dataNascita;
    private ArrayList<Libro> libriInPrestito = new ArrayList<>();
    private LocalDate dataPrestito;
    private LocalDate dataRestituzione;

    public Utente(String idUtente, String nome, String cognome, String sesso, String dataNascita) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.dataNascita = dataNascita;
        dataPrestito = LocalDate.now();
        dataRestituzione = dataPrestito.plusMonths(1);
    }

    public void prendiInPrestito (Libro libro) {
        this.libriInPrestito.add(libro);
    }

    public void restituisciLibro (Libro libro) {
        this.libriInPrestito.remove(libro);
    }

    public int getNumeriLibriInPrestito() {
        return libriInPrestito.size();
    }

    public ArrayList<Libro> getLibriInPrestito() {
        return libriInPrestito;
    }
}
