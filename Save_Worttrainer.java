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
                outputStream.write("*" + temp[i].getWort() + "\n");
                outputStream.write("!" + temp[i].getUrl()+ "\n");
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
        int r=0,p=0,h=0,c=0;
        String t = "", k = "", g = "";
        while((r=br.read())!=-1){
            t = t + (char)r;
            if((char)r == '\n'){
                p++;
            }
            r++;
        }
        boolean n = false, o = false;
        System.out.println(t);
        char[] j = t.toCharArray();
        WortEintrag[] temp = new WortEintrag[p];
        for (int i = 0; i < j.length; i++) {
            if(h % 2 == 0 && !o){
                System.out.println(k + g);
                temp[c] = new WortEintrag(k, g);
            }
            if(j[i] == '\n'){
                n = true;
                h++;
            }
            if(!n && h % 2 == 0){
                k = k + j[i];
            }
            if(!n && h % 2 == 1){
                g = g + j[i];
            }
            o = true;
        }
        br.close();
        WortTrainer y = new WortTrainer(new WortListe(temp));
        return y;
    }
}
