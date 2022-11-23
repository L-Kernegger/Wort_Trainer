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
                outputStream.write("\t* " + temp[i].getWort() + "\n");
                outputStream.write("\t! " + temp[i].getUrl()+ "\n");
            }
        } finally {
            if (outputStream != null){
                outputStream.close();
            }
        }
    }

    public static void speichern(WortTrainer toSave) throws IOException {
        speichern("debug.SEW", toSave);
    }

    public static WortTrainer load(String filename) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(filename));
        int r=0,p=0;
        String t = "";
        while((r=br.read())!=-1){
            t = t + (char)r;
            if((char)r == '\n'){
                p++;
            }
        }
        char[] j = t.toCharArray();
        int leng = p/2;
        int inc = 0;
        String h = "", a = "";
        WortEintrag[] temp= new WortEintrag[leng]; 
        for (int i = 0; i < temp.length; i++) {
            for (int f = 0; f < j.length; f++) {
                if(j[f] == '*'){
                    for (int k = 0;j[f] != '\n' ; k++) {
                        h = h + j[f];
                        inc = k;
                    }
                }
                f = f + inc;
                inc = 0;
                if(j[f] == '!'){
                    for (int k = 0;j[f] != '\n' ; k++) {
                        a = a + j[f];
                        inc = k;
                    }
                }
                i = i + inc;
                inc = 0;
                temp[i] = new WortEintrag(h, a);
                h = "";
                a = "";
            }
        }
        WortListe y = new WortListe(temp);
        br.close();
        return new WortTrainer(y);
        
    }
}
