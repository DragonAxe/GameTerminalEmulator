package org.storytotell.game.termemu.real;

import org.storytotell.game.termemu.Filesystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wraps the real filesystem.
 */
public class RealFilesystem implements Filesystem {
  /**
   * @return a list of filenames in the current working directory
   */
  @Override
  public List<String> getFiles() {
    List<String> result = new ArrayList<>();
    for (File f : new File(".").listFiles())
      result.add(f.toString());
    return result;
  }

  /**
   * Read a file from the filesystem by name.
   *
   * @param filename the filename of a file
   * @return the contents of the file
   */
  @Override
  public BufferedReader readFile(String filename) throws IOException {
    return new BufferedReader(new FileReader(new File(filename)));
  }
}
