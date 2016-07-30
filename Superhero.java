import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Superhero implements Serializable
{
    public static final long serialVersionUID = 1L;

    private String name;
    private Date debut;
    private int numVillainsFought;
    private short numAlterEgos;
    private boolean masked;
    private boolean female;
    private boolean retired;

    public static void main (String... args) {
        Superhero superhero = new Superhero();
        superhero.setName("Superman");
        try {
            Date debut = new SimpleDateFormat("MMMM dd, yyyy").parse("April 18, 1938");
            superhero.setDebut(debut);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        superhero.setNumVillainsFought(Integer.MAX_VALUE);
        superhero.setNumAlterEgos((short)2);
        superhero.setMasked(false);
        superhero.setFemale(false);
        superhero.setRetired(false);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(superhero);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        Superhero superhero2 = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            superhero2 = (Superhero) ois.readObject();
            ois.close();
            bais.close();
            baos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(superhero.equals(superhero2));
    }

    /**
     * Default no-arg constructor used for deserialization
     */
    public Superhero() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getNumVillainsFought() {
        return numVillainsFought;
    }

    public void setNumVillainsFought(int numVillainsFought) {
        this.numVillainsFought = numVillainsFought;
    }

    public short getNumAlterEgos() {
        return numAlterEgos;
    }

    public void setNumAlterEgos(short numAlterEgos) {
        this.numAlterEgos = numAlterEgos;
    }

    public boolean isMasked() {
        return masked;
    }

    public void setMasked(boolean masked) {
        this.masked = masked;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Superhero superhero = (Superhero) o;

        if (female != superhero.female) return false;
        if (masked != superhero.masked) return false;
        if (numAlterEgos != superhero.numAlterEgos) return false;
        if (numVillainsFought != superhero.numVillainsFought) return false;
        if (retired != superhero.retired) return false;
        if (debut != null ? !debut.equals(superhero.debut) : superhero.debut != null) return false;
        if (name != null ? !name.equals(superhero.name) : superhero.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (debut != null ? debut.hashCode() : 0);
        result = 31 * result + numVillainsFought;
        result = 31 * result + (int) numAlterEgos;
        result = 31 * result + (masked ? 1 : 0);
        result = 31 * result + (female ? 1 : 0);
        result = 31 * result + (retired ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "name='" + name + '\'' +
                ", debut=" + debut +
                ", numVillainsFought=" + numVillainsFought +
                ", numAlterEgos=" + numAlterEgos +
                ", masked=" + masked +
                ", female=" + female +
                ", retired=" + retired +
                '}';
    }
}