import java.io.*;
import java.nio.*;
public class Save_Worttrainer {
    private String name;
    private String[] eintraege;



    public static void speichern(String filename, WortTrainer toSave ) throws IOException {
        File f = new File(filename);
        BufferedWriter outputStream = null;
        WortEintrag[] temp = toSave.getTraingingsListe().getEintraege();
        try { 
            outputStream = new BufferedWriter(new FileWriter(f));
            for(int i = 0;i < temp.length; i++){
                outputStream.write("START \n");
                outputStream.write("\t" + temp[i].getWort() + "\n");
                outputStream.write("\t" + temp[i].getUrl()+ "\n");
                outputStream.write("END \n");
            }
        } finally {
            if (outputStream != null){
                outputStream.close();
            }
        }
    }
}
