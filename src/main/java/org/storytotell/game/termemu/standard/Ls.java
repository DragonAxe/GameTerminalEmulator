package org.storytotell.game.termemu.standard;

import org.storytotell.game.termemu.Command;
import org.storytotell.game.termemu.Context;

/**
 * Created by fusion on 7/15/15.
 */
public class Ls implements Command {
  private static final String NAME = "ls";

  /**
   * @return the name of the executable
   */
  @Override
  public String getName() {
    return NAME;
  }

  /**
   * List files in the current working directory.
   */
  @Override
  public int execute(Context ctx, String[] arguments) {
    for (String filename : ctx.getFilesystem().getFiles())
      ctx.getStandardOutput().println(filename);
    return 0;
  }
}
