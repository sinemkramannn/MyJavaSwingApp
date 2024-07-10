//Gerekli olan Tüm kütüphaneler eklendi.
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;


public class MyFrame extends JFrame { //MyFrame sınıfı, JFrame sınıfından türetilir extends alır ve GUI bileşenlerini , pencereleri yönetir
	JRadioButton encodeOption;//JRadioButton nesnelerini temsil eder ve metni Base64 formatına kodlamak için işe yarar.
	JRadioButton decodeOption;//JRadioButton nesnelerini temsil eder ve metni Base64 formatına kodlamak için işe yarar.
	JButton convertButton;//JButton nesnelerini temsil eder ve verilen işleri yapmayı sağlar.
	JButton resetButton;//JButton nesnelerini temsil eder ve verilen işleri yapmayı sağlar.
    JButton copyButton;//JButton nesnelerini temsil eder ve verilen işleri yapmayı sağlar.
	JTextArea input; //input ve output çıktılarını almayı sağlar.
	JTextArea output;//input ve output çıktılarını almayı sağlar.
	

	public MyFrame(){ // CreatFonksion metodunu çağırır ve pencereyi oluşturur
		this.CreatFonksion();
		
		this.setTitle("Simple Base64 Encode/Decoder");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		
	 }
	 
	private void CreatFonksion () {
        setLayout(new BorderLayout());
        
            //sol panelin çalışması
      		  JPanel leftPanel = new JPanel();
              leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
              //Sol panel, kullanıcının metin girişi yapabileceği ve çıktıyı görebileceği bileşenleri içerir. JLabel nesneleri, metin alanlarının yanında görünen etiketleri temsil eder.
              JLabel inputLabel = new JLabel("Input");
              input = new JTextArea();
              input.setRows(5);//satır boyutu
              input.setColumns(20); // sütun boyutu ayarlanır.

              JLabel outputLabel = new JLabel("Output");
              output = new JTextArea();
              output.setRows(5);
              output.setColumns(20);
              output.setEditable(false);

              leftPanel.add(inputLabel);
              leftPanel.add(new JScrollPane(this.input));
              leftPanel.add(outputLabel);
              leftPanel.add(new JScrollPane(this.output));

             // this.add(leftPanel, BorderLayout.WEST);
             //sağ taraf
      		JPanel rightPanel = new JPanel();
      		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
      		//Sağ panel, metni Base64 formatına kodlamak veya Base64 formatından çözmek için seçenekler ve işlemler sunar. JRadioButton nesneleri, kullanıcının dönüşüm yöntemini seçmesine olanak sağlar.buttonlar vb.
      		
      		JPanel radioButtonPanel = new JPanel();
            radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.Y_AXIS));
              
      		encodeOption = new JRadioButton("Text > Base64");
      		decodeOption = new JRadioButton("Base64 > Text");
      
      	    //grupladık buradaki sadece tek birine tıklayalım.ButtonGroup nesnesi, encodeOption ve decodeOption seçeneklerini gruplar ve sadece bir seçeneğin seçilebileceğini sağlar.
      	    ButtonGroup mygroup = new ButtonGroup();
      		mygroup.add(encodeOption);
      		mygroup.add(decodeOption);
      		
      		radioButtonPanel.add(encodeOption);
            radioButtonPanel.add(decodeOption);
            
            this.convertButton = new JButton("Encode/Decode");
            this.resetButton = new JButton("Reset");
            this.copyButton = new JButton("Copy result");
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
  
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Boşluk ekleniyor aralara
            buttonPanel.add(convertButton);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Boşluk ekleniyor aralara
            buttonPanel.add(resetButton);

            rightPanel.add(Box.createVerticalGlue()); // Üst kısmı doldurmak için
            rightPanel.add(radioButtonPanel);
            rightPanel.add(buttonPanel);
            rightPanel.add(Box.createVerticalGlue()); // Orta kısmı doldurmak için 
            rightPanel.add(copyButton);
            rightPanel.add(Box.createVerticalGlue()); // Alt kısmı doldurmak için 

              
            this.add(leftPanel, BorderLayout.WEST);//Sol panel kısmını ekler.Bu panel, metin girişi ve çıktısı için kullanılır.
            this.add(rightPanel, BorderLayout.EAST);// Sağ panel kısmını ekler.Sağ paneli pencerenin doğu (sağ) tarafına ekler. Bu panel, dönüştürme seçenekleri ve düğmeleri için kullanılır
      		
            convertButton.setPreferredSize(new Dimension(150, 30));//Encoder,decoder düğmesinin boyutunu ayarladık.

            convertButton.addActionListener(new ActionListener() {//Dönüştürme düğmesine basınca gerçekleşecek işlem belirlendi.
                @Override
                public void actionPerformed(ActionEvent e) {
                    String originalInput = input.getText();// girilen metin alınır
                    if (encodeOption.isSelected()) {// Butona basılı olup olmadığını kontrol eder.
                        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());//Burada Base64 kodlaması yapılır.
                        output.setText(encodedString);//Çıktığı output alanına yazar.
                    } else if (decodeOption.isSelected()) { // "Base64 > Text" için  seçili olup olmadığını kontrol eder.
                        byte[] decodedBytes = Base64.getDecoder().decode(originalInput); // Kullanıcının girdiği metin çözülüe
                        String decodedString = new String(decodedBytes); //Çözülen metin çevirilir.
                        output.setText(decodedString); // output alanına yazılır.
                    }
                }
            });
            resetButton.setPreferredSize(new Dimension(150, 30));// Reset düğmesinin boyutu ayarlanır

            resetButton.addActionListener(new ActionListener() {//Bu düğmeye tıklandığında işlemini gerçekleştir :
                public void actionPerformed(ActionEvent e) {
                	input.setText("");// Metnin giriş alanını temizler.
                    output.setText("");// Metnin çıkış alanını temizler.
                }
            });//Sonu
	}//Son
		
} //Son
		 
	
