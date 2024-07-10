import javax.swing.SwingUtilities;//Kütüphane çağırıldı.

public class Main {
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() { //GUI arayüzünü gerçekleştirmek için kullanılır.
	            @Override
	            public void run() {
	                new MyFrame().setVisible(true);//MyFrame sınıfından bir nesne oluşturur ve bunu görünür hale getirilir.
	            }
	        });
	    }
}//Son


//Bu kodda base64 metin çevirir.Base64 encoding, sadece 64 farklı karakteri (A-Z, a-z, 0-9 ve '+' ve '/')gibi  kullanır.(?,*,..)
//vb. işaretler geldiği zaman çözümleyemez ve onun yerine = işaretini koyar.