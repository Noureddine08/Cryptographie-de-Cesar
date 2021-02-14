import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class Main {

    static final List<Character> alphabets = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K'
            , 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V'
            , 'X', 'Y', 'Z'
    );

    static final String FIN = ".\\in.txt";
    static final String FOUT = ".\\out.txt";

    static char cesarEncryption(char p, int cle) {
        int charPosition = alphabets.indexOf(Character.toUpperCase(p));
        if (charPosition == -1) return p;
        return alphabets.get((charPosition + cle) % 26);
    }

    static char cesarDecrypt(char c, int cle) {
        int charPosition = alphabets.indexOf(Character.toUpperCase(c));
        if (charPosition == -1) return c;
        return alphabets.get((charPosition - cle) % 26);
    }


    public static void main(String[] args) {
        int cle = 2;

        // chiffrement
        try (FileReader fr = new FileReader(new File(FIN));
             FileWriter fw = new FileWriter(new File(FOUT))) {
            int chr;
            fw.append("\n");
            while ((chr = fr.read()) != -1) {
                fw.append(cesarEncryption((char) chr, cle));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // dechiffrement
        try (FileReader fr = new FileReader(new File(FOUT));
             FileWriter fw = new FileWriter(new File(FIN))) {
            int chr;
            fw.append("\n");
            while ((chr = fr.read()) != -1) {
                fw.write(cesarDecrypt((char) chr, cle));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
