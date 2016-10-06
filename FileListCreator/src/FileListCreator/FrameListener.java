package FileListCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import dennis.markmann.MyLibraries.DefaultJobs.File.FileFilter;
import dennis.markmann.MyLibraries.DefaultJobs.File.FileLister;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.PathChooser;

/**
 * Listener for the settings frame. Used to fill the different values and to close the window.
 *
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class FrameListener implements ActionListener {

    private final MainFrame frame;
    private final JTextField inputPathField;
    private final JTextField outputPathField;
    @SuppressWarnings("unused")
    // TODO use
    private final JCheckBox archivingBox;

    public FrameListener(
            final MainFrame frame,
            final JTextField inputPathField,
            final JTextField outputPathField,
            final JCheckBox archivingBox) {

        this.frame = frame;
        this.inputPathField = inputPathField;
        this.outputPathField = outputPathField;
        this.archivingBox = archivingBox;

    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("inputPathButton") == 0) {
            try {
                this.frame.updatePathField(this.inputPathField, new PathChooser().changePath());
            }
            catch (final java.lang.NullPointerException e) {
                e.printStackTrace();
            }

        }
        else if (buttonClicked.getName().compareTo("outputPathButton") == 0) {
            try {
                this.frame.updatePathField(this.outputPathField, new PathChooser().changePath());
            }
            catch (final java.lang.NullPointerException e) {
                e.printStackTrace();
            }

        }
        else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            final Settings settings = new Settings();
            if ((this.inputPathField.getText() != null) && !this.inputPathField.getText().equals("")) {
                settings.setInputPath(this.inputPathField.getText());
            }
            if ((this.outputPathField.getText() != null) && !this.outputPathField.getText().equals("")) {
                settings.setOutputPath(this.outputPathField.getText() + "FileList.txt");
            }

            this.frame.closeWindow();
            this.startApplication(settings);
        }
    }

    @SuppressWarnings("unused")
    // TODO use
    private boolean readCheckBox(final JCheckBox checkBox) {

        if (checkBox.isSelected()) {
            return (true);
        }
        return (false);
    }

    private void startApplication(final Settings settings) {

        ArrayList<File> fileList = new FileLister().listFilesForFolder(new File(settings.getInputPath()), null, true);
        fileList = new FileFilter().addMovies().filter(fileList);
        new ListWriter().wirteFileNamesToList(fileList, settings.getOutputPath());
    }
}
