import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> listaLibri = new ArrayList<>();
    private String luogo;
    private String nome;

    public Biblioteca(String luogo, String nome) {
        this.luogo = luogo;
        this.nome = nome;
    }

    public void aggiungiLibro(Libro libro) {
        if (!listaLibri.contains(libro)) {
            listaLibri.add(libro);
        }
    }

    public void prendiInPrestito (Libro libro, Utente utente) {
        if (utente.getNumeriLibriInPrestito() >= 3) {
            throw new IllegalStateException("Non è possibile prendere in prestito più di 3 libri.");
        }

        if (libro.isInPrestito()) {
            throw new IllegalStateException("Il libro non è disponibile.");
        }

        libro.setInPrestito(true);
        libro.setDataRestituzione(LocalDate.now().plusMonths(1));
        utente.prendiInPrestito(libro);
    }

    public void restituisciLibro(Libro libro, Utente utente) {
        if (!libro.isInPrestito()) {
            throw new IllegalStateException("Il libro non è in prestito.");
        }

        libro.setInPrestito(false);
        utente.restituisciLibro(libro);
    }
        public ArrayList<Libro> getLibriInPrestito() {
            ArrayList<Libro> libriInPrestito = new ArrayList<>();
            for (Libro libro: listaLibri) {
                if (libro.isInPrestito()) {
                    libriInPrestito.add(libro);
                }
            }
            return libriInPrestito;
        }

        public ArrayList<Libro> getLibriInPrestito(Utente utente) {
            return getLibriInPrestito();
        }

        public boolean verificaRestituzioneRitardo(Libro libro) {
            if (libro.isInPrestito()) {
                LocalDate oggi = LocalDate.now();
                return oggi.isAfter(libro.getDataRestituzione());
            }
            return false;
        }
    }