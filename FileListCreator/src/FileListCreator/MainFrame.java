package FileListCreator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;

public class MainFrame extends JFrame implements DefaultFrame {

    private static MainFrame instance = null;
    private static final long serialVersionUID = 230542486392426735L;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        else {
            instance.toFront();
        }
        return instance;
    }

    public MainFrame() {

        BUILDER.setDefaultFrameSettings(this, "FileLister");
        this.addWindowListener(new MyWindowAdapter(this));
        this.setSize(555, 370);
        this.setResizable(false);

        final JPanel inputPathPanel = BUILDER
                .createCombiPanel(this, "inputPathButton", "InputPath", "inputPathField", 37, 0, 0);
        final JTextField inputPathField = (JTextField) inputPathPanel.getComponent(0);
        final JButton inputPathButton = (JButton) inputPathPanel.getComponent(1);

        final JPanel outputPathPanel = BUILDER
                .createCombiPanel(this, "outputPathButton", "OutputPath", "outputPathField", 37, 0, 3);
        final JTextField outputPathField = (JTextField) outputPathPanel.getComponent(0);
        final JButton outputPathButton = (JButton) outputPathPanel.getComponent(1);

        final JButton bestaetigenButton = BUILDER.createButton(this, "saveButton", "Okay", 0, 5);

        final FrameListener listener = new FrameListener(this, inputPathField, outputPathField, null);
        inputPathButton.addActionListener(listener);
        outputPathButton.addActionListener(listener);
        bestaetigenButton.addActionListener(listener);

        this.setVisible(true);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }

    @Override
    public void openClosingDialog(WindowCloseDialogOptions request) {
        System.exit(0);
    }

    public void updatePathField(final JTextField pathField, final String path) {
        pathField.setText(path);
    }

}
