package org.storytotell.game.termemu.standard;

import org.storytotell.game.termemu.Command;
import org.storytotell.game.termemu.Context;

/**
 * Created by fusion on 7/15/15.
 */
public class Echo implements Command {
  private static final String NAME = "echo";
  /**
   * @return the name of the executable (echo)
   */
  @Override
  public String getName() {
    return NAME;
  }

  /**
   * Echo the command line arguments.
   */
  @Override
  public int execute(Context ctx, String[] arguments) {
    for (String arg : arguments)
      ctx.getStandardOutput().printf("%s ", arg);

    ctx.getStandardOutput().println();

    return 0;
  }
}
