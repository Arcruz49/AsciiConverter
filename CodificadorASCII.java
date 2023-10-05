import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.Scanner;

public class CodificadorASCII {
    public String codificaMensagem(String text){
        String codeText = "";
        try{
            for (int i = 0; i < text.length(); i ++) {
                codeText += String.valueOf((int)text.charAt(i)) + " ";
            }
            copiaAreaTransferencia(codeText);
            System.out.println("Texto copiado para a área de transferência");
            return codeText;
        }
        catch(Exception ex){
            return "Houve um erro ao converter" + ex.getMessage();
        }
    }

    public String descodificaMensagem(String text){
        String decodeText = "";
        try{
            String[] codes = text.split(" ");
            for (String code : codes) {
                int ascii = Integer.parseInt(code);
                char letra  = (char) ascii;
                decodeText += letra;
            }
            copiaAreaTransferencia(decodeText);
            System.out.println("Texto copiado para a área de transferência");
            return decodeText;
        }
        catch(Exception ex){
            return "Não foi possível converter. "+ ex.getMessage();
        }
        
    }

    public void copiaAreaTransferencia(String text){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void imprimeTela(){
        System.out.println("------------Codificador ASCII------------\n\n"+
                            "1) Codificar texto para ASCII\n"+
                            "2) Decodificar texto\n"+
                            "3) Sair\n");
    }

    public final static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CodificadorASCII codificador = new CodificadorASCII();
        int comando = 0;
        while(comando != 3){
            codificador.imprimeTela();
            comando = teclado.nextInt();
            switch(comando){

                case 1 :
                clearConsole();
                System.out.print("Digite: ");
                teclado.nextLine();
                System.out.println(codificador.codificaMensagem(teclado.nextLine()));
                break;

                case 2 :
                clearConsole();
                System.out.print("Digite: ");
                teclado.nextLine();
                System.out.println(codificador.descodificaMensagem(teclado.nextLine()));
                break;
            }
        }
        teclado.close();
    }
}
