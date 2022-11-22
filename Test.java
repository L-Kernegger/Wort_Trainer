import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;

public class Test {
    public static void main(String[] args) throws MalformedURLException, MalformedInputException{
        WortEintrag x = new WortEintrag("Auto", "https://cdn.motor1.com/images/mgl/EKJ2B/s3/auto-neuheiten-2021-2022.jpg");
        WortEintrag z = new WortEintrag("Fuchs","https://www.br.de/kinder/hoeren/doremikro/fuchs-und-gans-108~_v-img__16__9__xl_-d31c35f8186ebeb80b0cd843a7c267a0e0c81647.jpg?version=ff0a4");
        WortListe y = new WortListe(5);
        y.addEintrag(x);
        for(int i = 0; i < 11; i++){
            y.addEintrag(z);
        }
        System.out.println("Wortliste to String / add check: ");
        System.out.println(y.toString());
        WortTrainer i = new WortTrainer(y);
        i.zufall();
        System.out.println("random check");
        System.out.println(i.wort());
        System.out.println("check check:");
        System.out.println(i.check("Fuchs"));
        System.out.println(i.checkIgnoreCase("FuchS"));
        System.out.println(i.check("FuHchs"));
        y.deleteEintraege("Fuchs");
        System.out.println("Delete Test:");
        System.out.println(y.toString());
        y.assertionTest();
    }
       

}
