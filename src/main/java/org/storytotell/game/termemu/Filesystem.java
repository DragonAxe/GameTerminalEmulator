package org.storytotell.game.termemu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * A really basic directoryless filesystem.
 */
public interface Filesystem {
  /**
   * @return a list of filenames in the current working directory
   */
  List<String> getFiles();

  /**
   * Read a file from the filesystem by name.
   * @param filename  the filename of a file
   * @return  the contents of the file
   */
  BufferedReader readFile(String filename) throws IOException;
}
