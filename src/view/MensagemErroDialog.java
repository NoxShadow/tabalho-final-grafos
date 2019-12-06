package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MensagemErroDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextArea MessageTextArea;

    public MensagemErroDialog(String mensagem) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener((event) -> dispose());

        MessageTextArea.setText(mensagem);
    }
}
