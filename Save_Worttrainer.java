import java.io.*;
public class Save_Worttrainer {


    /**
     * speichert Worttrainer
     * @param filename der name der file
     * @param toSave der Worttrainer der gespeichert werden woll
     * @throws IOException falls des IO net geht
     */    
    public static void speichern(String filename, WortTrainer toSave ) throws IOException {
        File f = new File(filename);
        BufferedWriter outputStream = null;
        WortEintrag[] temp = toSave.getTraingingsListe().getEintraege();
        try { 
            outputStream = new BufferedWriter(new FileWriter(f));
            for(int i = 0;i < temp.length; i++){
                outputStream.write("" + temp[i].getWort() + "\n");
                outputStream.write("" + temp[i].getUrl()+ "\n");
            }
        } finally {
            if (outputStream != null){
                outputStream.close();
            }
        }
    }

    /**
     * default methode der anderen Speichern methode
     * @param toSave der Worttrainer der gespeichert werden soll
     * @throws IOException falls des IO net geht
     */
    public static void speichern(WortTrainer toSave) throws IOException {
        speichern("debug.SEW", toSave);
    }

    /**
     * 
     * @param filename
     * @return
     * @throws IOException
     */
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
        char[] j = t.toCharArray();
        WortEintrag[] temp = new WortEintrag[p/2];
        for (int i = 0; i < j.length; i++) {
            if(h == 2){
                temp[c] = new WortEintrag(k, g);
                c++;
                k = "";
                g = "";
                h = 0;
            }
            if(j[i] == '\n'){
                if(h == 0){
                    i++;
                }
                h++;
            }
            if(h == 0){
                k = k + j[i];
            }
            if(h == 1){
                g = g + j[i];
            }
        }
        if(h == 2){
            temp[c] = new WortEintrag(k, g);
            c++;
            k = "";
            g = "";
            h = 0;
        }
        br.close();
        WortTrainer y = new WortTrainer(new WortListe(temp));
        y.toString();
        return y;
    }
    public static WortTrainer load() throws IOException{
        return load("debug.SEW");
    }
}
