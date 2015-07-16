package org.storytotell.game.termemu;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Created by fusion on 7/15/15.
 */
public interface Context {
  /**
   * @return Standard Input for the process
   */
  BufferedReader getStandardInput();

  /**
   * @return Standard Output for the process
   */
  PrintWriter getStandardOutput();

  /**
   * @return The filesystem underlying this process
   */
  Filesystem getFilesystem();
}
