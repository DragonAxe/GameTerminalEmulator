package org.storytotell.game.termemu.standard;

import org.apache.commons.io.IOUtils;
import org.storytotell.game.termemu.Command;
import org.storytotell.game.termemu.Context;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.StreamSupport;

/**
 * cat -- concatenate and print files
 */
public class Cat implements Command {
  public static String NAME = "cat";

  /**
   * @return the name of the executable (cat)
   */
  @Override
  public String getName() {
    return NAME;
  }

  /**
   * Dump a bunch of files to standard out.
   */
  @Override
  public int execute(Context ctx, String[] arguments) {
    for (String arg : arguments)
      executeFile(ctx, arg);

    return 0;
  }

  private void executeFile(Context ctx, String e) {
    // try to open the file and copy it to standard output
    try {
      IOUtils.copy(ctx.getFilesystem().readFile(e), ctx.getStandardOutput());
    }
    catch (IOException e1) {
      ctx.getStandardOutput().printf("Unable to read file %s\n", e);
    }
  }
}
