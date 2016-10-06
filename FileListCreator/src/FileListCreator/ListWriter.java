package FileListCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListWriter {

    public void wirteFileNamesToList(final ArrayList<File> fileList, final String outputLocation) {

        FileWriter fw;
        int counter = 0;

        try {
            new File(outputLocation).delete();
            fw = new FileWriter(outputLocation);
            final BufferedWriter bw = new BufferedWriter(fw);
            for (final File file : fileList) {
                counter++;
                this.writeFileName(file, bw, counter);
            }
            bw.close();
        }
        catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFileName(final File file, final BufferedWriter bw, final int counter) throws IOException {
        final String fileName = file.getName();
        bw.write(
                counter + ". " + file.getName().substring(0, fileName.lastIndexOf(".")) + System.getProperty("line.separator"));
    }
}