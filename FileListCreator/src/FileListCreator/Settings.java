package FileListCreator;

public class Settings {

    private String inputPath = "M:\\Movies";
    private String outputPath = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"
            + System.getProperty("file.separator") + "FileList.txt";

    public String getInputPath() {
        return this.inputPath;
    }

    public String getOutputPath() {
        return this.outputPath;
    }

    public void setInputPath(final String inputPath) {
        this.inputPath = inputPath;
    }

    public void setOutputPath(final String outputPath) {
        this.outputPath = outputPath;
    }

}
