import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;


class Main
{
    public static void copyDir(Path src, Path dest) throws IOException {
        Files.walk(src)
                .forEach(source -> {
                    try {
                        Files.copy(source, dest.resolve(src.relativize(source)),
                                StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void main(String[] args)
    {
        File from = new File("C:\\Users\\Notlew\\Desktop\\Daqui");
        File to = new File("C:\\Users\\Notlew\\Desktop\\PraQui");

        try {
            copyDir(from.toPath(), to.toPath());
            System.out.println("Copied whole directory successfully.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        Arrays.stream(new File("C:\\Users\\Notlew\\Desktop\\Daqui").listFiles()).forEach(File::delete);
    }
}