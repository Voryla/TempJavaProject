package useSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class CustomUI {
    private static JFrame myJframe;
    private static JTextArea jTextArea=null;
    public CustomUI(String title) {
        myJframe = new JFrame("swing");
    }

    public void setSize(int x, int y, int withe, int height) {
        myJframe.setBounds(x, y, withe, height);
        myJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void usePackSize() {
        //pack()方法的使用
        //根据框架中所有的控件来自适应窗体大小
        //myJframe.pack();
        //或者设置pack大小
        myJframe.setPreferredSize(new Dimension(800, 600));
        myJframe.pack();
    }

    public void setVisible(boolean status) {
        myJframe.setVisible(status);
    }
    public void addScrollPane(){
        JScrollPane scrollPane=new JScrollPane();
        jTextArea=new JTextArea();
        scrollPane.setViewportView(jTextArea);
        myJframe.getContentPane().add(scrollPane,BorderLayout.CENTER);
    }
    public void addButton(String text,int width,int height){
        JButton jButton=new JButton(text);
        jButton.setSize(width,height);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //选择文件窗口
                JFileChooser jfc=new JFileChooser();
                jfc.showSaveDialog(myJframe);
                try{
                    File file =jfc.getSelectedFile();
                    String content=readFileString(file);
                    jTextArea.append(content);
                }catch (Exception error){
                    JPanel errorDialog=new JPanel();
                    JOptionPane.showMessageDialog(errorDialog,"没有选中任何文件","提示",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JPanel jPanel=new JPanel();
        jPanel.add(jButton);
        myJframe.getContentPane().add(jPanel,BorderLayout.NORTH);
    }
    private String readFileString(File file){
        StringBuilder stringBuilder=new StringBuilder();
        InputStreamReader inputStreamReader=null;
        try{
            inputStreamReader=new InputStreamReader(new FileInputStream(file),"Unicode");
            char[] chars=new char[2];
            int len=-1;
            while ((len=inputStreamReader.read(chars))!=-1){
                stringBuilder.append(chars,0,len);
            }
            System.out.println(stringBuilder.toString());
        }catch (IOException e){

        }finally {
            if(null!=inputStreamReader){
                try{
                inputStreamReader.close();
                }catch (IOException e){

                }
            }
        }
        return stringBuilder.toString();
    }
}
